package com.styz.security.validate.processor;

import com.styz.security.validate.VerifyCode;
import com.styz.security.validate.generator.ValidateCodeGenerater;
import com.styz.security.validate.processor.ValidateCodeCreateProcessor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * creat date:2019-07-16 09:51
 * author:xxydliuyss
 * note:
 */

public abstract class ValidateCodeBaseProcessor<C extends VerifyCode> implements ValidateCodeCreateProcessor {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Autowired
    private Map<String, ValidateCodeGenerater> validateCodeGeneraterMap;


    @Override
    public void createCode(ServletWebRequest request) throws Exception{
        C validateCode = generate(request);
        save(request,validateCode);
        send(request,validateCode);
    }

    private C generate(ServletWebRequest request){
        String type = getProccessType(request);
        ValidateCodeGenerater validateCodeGenerater = validateCodeGeneraterMap.get(type + "CodeGenerator");
        return (C) validateCodeGenerater.generatorCode(request);
    }

    private String getProccessType(ServletWebRequest request) {
        String type = StringUtils.substringAfter(request.getRequest().getRequestURI(),"/code/");
        return type;
    }

    private void save(ServletWebRequest request,C c){
        String type = getProccessType(request);
        sessionStrategy.setAttribute(request,SESSION_KEY_PREFIX + type.toUpperCase(),c);
    }
    public abstract void send(ServletWebRequest request,C c) throws Exception;
}
