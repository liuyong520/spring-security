package com.styz.security.validate.processor;

import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * creat date:2019-07-16 10:01
 * author:xxydliuyss
 * note:
 */
public interface ValidateCodeCreateProcessor {
    /**
     * 验证码key
     */
    String SESSION_KEY_PREFIX ="SESSION_KEY_FOR_CODE_";
    /**
     * 处理器
     */
    void createCode(ServletWebRequest servletWebRequest) throws Exception;
}
