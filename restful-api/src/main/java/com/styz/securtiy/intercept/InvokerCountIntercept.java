package com.styz.securtiy.intercept;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * creat date:2019-07-12 14:18
 * author:xxydliuyss
 * note:
 */
@Slf4j
public class InvokerCountIntercept implements HandlerInterceptor {
    private Map countMap = new ConcurrentHashMap(512);
    private long starttime;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        starttime = LocalDateTime.now().getNano();
        log.error("InvokerCountIntercept start" );
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.error("InvokerCountIntercept end" );
        long end =  LocalDateTime.now().getNano();
        log.error("InvokerCountIntercept exe time:"+ (end-starttime)/1000);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.error("InvokerCountIntercept completion" );
        long end =  LocalDateTime.now().getNano();
        if(ex==null){
            if(handler instanceof HandlerMethod){
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                Method method = handlerMethod.getMethod();
                Annotation[] annotations = method.getAnnotations();
                for(Annotation annotation: annotations){
                    if(annotation instanceof GetMapping || annotation instanceof RequestMapping || annotation instanceof PostMapping){
                        if(countMap.containsKey(method.getName())){
                            long cout = (long) countMap.get(method.getName());
                            log.error(method.getName()+" invoke times:\t"+ cout);
                            countMap.put(method.getName(),++cout);

                        }else {
                            countMap.put(method.getName(),1L);
                            log.error(method.getName()+" invoke times:\t"+ 1);
                        }
                    }
                }
            }
        }else {
            ex.printStackTrace();
        }


        log.error("InvokerCountIntercept exe time:"+ (end-starttime)/1000);
    }
}
