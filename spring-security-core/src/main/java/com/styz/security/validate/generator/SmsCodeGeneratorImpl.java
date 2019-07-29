package com.styz.security.validate.generator;

import com.styz.security.properties.SecurityProperties;
import com.styz.security.validate.VerifyCode;
import com.styz.security.validate.code.SmsCode;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import java.util.Random;

/**
 * creat date:2019-07-16 09:03
 * author:xxydliuyss
 * note:
 */
public class SmsCodeGeneratorImpl implements ValidateCodeGenerater {
    public static final String DEFAUT_RANDOM_STRING="1234567890abcdefghijklmnopqrstuvwxyz";
    private SecurityProperties securityProperties;
    @Override
    public VerifyCode generatorCode(ServletWebRequest request) {
        Integer count = ServletRequestUtils.getIntParameter(request.getRequest(), "count",securityProperties.getValidate().getSmsCode().getCount());
        SmsCode smsCode = new SmsCode(RandomStringUtils.random(4,DEFAUT_RANDOM_STRING), securityProperties.getValidate().getSmsCode().getExpire());
        return smsCode;
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
