package com.styz.security.validate.filter.processor.impl;

import com.styz.security.exception.ValidateCodeException;
import com.styz.security.validate.code.ImageCode;
import com.styz.security.validate.filter.processor.ValidateCodefilterProcessor;
import com.styz.security.validate.processor.ValidateCodeCreateProcessor;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * creat date:2019-07-16 12:23
 * author:xxydliuyss
 * note:
 */
@Component
public class ImageValidateCodefilterProcessor implements ValidateCodefilterProcessor {
    public static final String SESSION_KEY_FOR_IMAGECODE = ValidateCodeCreateProcessor.SESSION_KEY_PREFIX + "IMAGE";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Override
    public void validate(ServletWebRequest request) throws ValidateCodeException, ServletRequestBindingException {
        ImageCode sessionImageCode = (ImageCode) sessionStrategy.getAttribute(request,SESSION_KEY_FOR_IMAGECODE );
        String requestImageCode = ServletRequestUtils.getStringParameter(request.getRequest(), "imageCode");
        if(StringUtils.isEmpty(requestImageCode)){
            throw new ValidateCodeException("图片验证码不能为空");
        }
        if(sessionImageCode==null){
            throw new ValidateCodeException("图片验证码不存在");
        }
        if(sessionImageCode.isExpire()){
            sessionStrategy.removeAttribute(request,SESSION_KEY_FOR_IMAGECODE);
            throw new ValidateCodeException("图片验证码已经过期");
        }
        if(!requestImageCode.toLowerCase().equals(sessionImageCode.getCode().toLowerCase())){
            throw new ValidateCodeException("图片验证码错误");
        }
        sessionStrategy.removeAttribute(request,SESSION_KEY_FOR_IMAGECODE);
    }
}
