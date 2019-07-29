package com.styz.security.config;

import com.styz.security.properties.SecurityProperties;
import com.styz.security.validate.generator.SmsCodeGeneratorImpl;
import com.styz.security.validate.generator.ValidateCodeGenerater;
import com.styz.security.validate.generator.ImageCodeGeneratorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * creat date:2019-07-16 01:03
 * author:xxydliuyss
 * note:
 */
@Configuration
public class ValidateCodeConfig {
    @Autowired
    private SecurityProperties securityProperties;
    @Bean
    @ConditionalOnMissingBean(name = "imageCodeGenerator")
    public ValidateCodeGenerater imageCodeGenerator(){
        ImageCodeGeneratorImpl imageCodeGenerator = new ImageCodeGeneratorImpl();
        imageCodeGenerator.setSecurityProperties(securityProperties);
        return imageCodeGenerator;
    }
    @Bean
    @ConditionalOnMissingBean(name = "smsCodeGenerator")
    public ValidateCodeGenerater smsCodeGenerator(){
        SmsCodeGeneratorImpl smsCodeGenerator = new SmsCodeGeneratorImpl();
        smsCodeGenerator.setSecurityProperties(securityProperties);
        return smsCodeGenerator;
    }
}
