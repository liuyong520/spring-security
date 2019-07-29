package com.styz.security.aop;

import com.alibaba.fastjson.JSONObject;
import com.styz.api.model.SysActionLog;
import com.styz.security.service.SaveLogService;
import com.styz.security.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * creat date:2019-07-12 15:05
 * author:xxydliuyss
 * note:
 */
@Aspect
@Slf4j
@Component
public class LoggerAspect {
    @Autowired
    private SaveLogService logService;
    /**
     * 这里我们使用注解的形式
     * 当然，我们也可以通过切点表达式直接指定需要拦截的package,需要拦截的class 以及 method
     * 切点表达式:   execution(...)
     */
    @Pointcut("@annotation(com.styz.security.aop.WebLogger)")
    public void logPointCut() {}
    /**
     * 环绕通知 @Around  ， 当然也可以使用 @Before (前置通知)  @After (后置通知)
     * @param point
     * @return
     * @throws Throwable
     */
    @Around("logPointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        long beginTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) point.getSignature();
        String value = signature.getMethod().getAnnotation(WebLogger.class).value();
        log.info("{},开始",value);
        Object result = point.proceed();
        long time = System.currentTimeMillis() - beginTime;
        try {
            saveLog(point, time);
        } catch (Exception e) {
        }
        log.info(value + "结束" );
        return result;
    }
    /**
     * 保存日志
     * @param joinPoint
     * @param time
     */
    private void saveLog(ProceedingJoinPoint joinPoint, long time) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        SysActionLog sysLogBO = new SysActionLog();
        sysLogBO.setExecutetime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLogBO.setCreateDate(new Date().getTime());
        WebLogger sysLog = method.getAnnotation(WebLogger.class);
        if(sysLog != null){
            //注解上的描述
            sysLogBO.setRemark(sysLog.value());
            sysLogBO.setLogtype(sysLog.logtype());
        }
//        User currenctUser = UserUtils.getCurrenctUser();
//        if(currenctUser!=null){
//            sysLogBO.setCreateBy();
//        }
        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBO.setClassname(className);
        sysLogBO.setMethodname(methodName);
        //请求的参数
        Object[] args = joinPoint.getArgs();
        try{
            List<String> list = new ArrayList<String>();
            for (Object o : args) {
                list.add(JSONObject.toJSONString(o));
            }
            sysLogBO.setParams(list.toString());
        }catch (Exception e){ }
        logService.saveLog(sysLogBO);
    }


}
