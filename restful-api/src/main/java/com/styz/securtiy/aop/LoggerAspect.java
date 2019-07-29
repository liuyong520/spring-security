package com.styz.securtiy.aop;

import com.alibaba.fastjson.JSONObject;
import com.styz.securtiy.entity.SaveLog;
import com.styz.securtiy.service.SaveLogService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Pointcut("@annotation(com.styz.securtiy.aop.WebLogger)")
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

        log.info(value + "开始\t,参数" + JSONObject.toJSONString(point.getArgs()) );
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
        SaveLog sysLogBO = new SaveLog();
        sysLogBO.setExecuteTime(time);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        sysLogBO.setCreateDate(dateFormat.format(new Date()));
        WebLogger sysLog = method.getAnnotation(WebLogger.class);
        if(sysLog != null){
            //注解上的描述
            sysLogBO.setRemark(sysLog.value());
        }
        //请求的 类名、方法名
        String className = joinPoint.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLogBO.setClassName(className);
        sysLogBO.setMethodName(methodName);
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
