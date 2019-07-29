package com.styz.security.validate.filter.processor;

import com.styz.security.exception.ValidateCodeException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * creat date:2019-07-16 12:22
 * author:xxydliuyss
 * note:
 */
public interface ValidateCodefilterProcessor {
    /**
     * 过滤器验证请求
     * @param request
     * @throws Exception
     */
    void validate(ServletWebRequest request) throws ValidateCodeException, ServletRequestBindingException;

}
