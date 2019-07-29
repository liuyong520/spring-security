package com.styz.security.validate.filter.processor.impl;

import com.styz.security.exception.ValidateCodeException;
import com.styz.security.validate.code.SmsCode;
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
 * creat date:2019-07-16 12:25
 * author:xxydliuyss
 * note:
 */
@Component
public class SmsValidateCodefilterProcessor implements ValidateCodefilterProcessor {
    public static final String SESSION_KEY_FOR_SMSCODE = ValidateCodeCreateProcessor.SESSION_KEY_PREFIX + "SMS";
    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();
    @Override
    public void validate(ServletWebRequest request) throws ValidateCodeException, ServletRequestBindingException {
        SmsCode sessionSmsCode = (SmsCode) sessionStrategy.getAttribute(request, SESSION_KEY_FOR_SMSCODE);
        String requestImageCode = ServletRequestUtils.getStringParameter(request.getRequest(), "smsCode");
        if(StringUtils.isEmpty(requestImageCode)){
            throw new ValidateCodeException("短信验证码不能为空");
        }
        if(sessionSmsCode==null){
            throw new ValidateCodeException("短信验证码不存在");
        }
        if(sessionSmsCode.isExpire()){
            sessionStrategy.removeAttribute(request,SESSION_KEY_FOR_SMSCODE);
            throw new ValidateCodeException("短信验证码已经过期");
        }
        if(!requestImageCode.toLowerCase().equals(sessionSmsCode.getCode().toLowerCase())){
            throw new ValidateCodeException("短信验证码错误");
        }
        sessionStrategy.removeAttribute(request,SESSION_KEY_FOR_SMSCODE);
    }
}
