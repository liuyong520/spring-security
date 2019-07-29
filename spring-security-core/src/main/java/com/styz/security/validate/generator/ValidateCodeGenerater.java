package com.styz.security.validate.generator;

import com.styz.security.validate.VerifyCode;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;

/**
 * creat date:2019-07-16 00:56
 * author:xxydliuyss
 * note:
 */
public interface ValidateCodeGenerater {

    public VerifyCode generatorCode(ServletWebRequest request);
}
