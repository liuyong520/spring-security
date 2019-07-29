package com.styz.security.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * creat date:2019-07-12 15:00
 * author:xxydliuyss
 * note:
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebLogger {
    String value();

    String logMsgPrefix() default "";

    int logtype() default 0;
}
