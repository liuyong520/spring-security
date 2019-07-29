package com.styz.security.config;

import com.styz.security.authentication.BrowserAuthenticationFailureHandler;
import com.styz.security.authentication.BrowserAuthenticationSuccessHandler;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * creat date:2019-07-16 14:47
 * author:xxydliuyss
 * note:
 */
@Configuration
public class BrowserSecrityBeanConfig {
    @Bean
    @ConditionalOnMissingBean(AuthenticationFailureHandler.class)
    public AuthenticationFailureHandler authenticationFailureHandler(){
        BrowserAuthenticationFailureHandler browserAuthenticationFailureHandler = new BrowserAuthenticationFailureHandler();
        return browserAuthenticationFailureHandler;
    }
    @Bean
    @ConditionalOnMissingBean(AuthenticationSuccessHandler.class)
    public AuthenticationSuccessHandler authenticationSuccessHandler(){
        return new BrowserAuthenticationSuccessHandler();
    }

    @Bean
    @ConditionalOnMissingBean(PasswordEncoder.class)
    PasswordEncoder passwordEncoder(){
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return String.valueOf(charSequence) ;
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return String.valueOf(charSequence).equals(s);
            }
        };
    }
}
