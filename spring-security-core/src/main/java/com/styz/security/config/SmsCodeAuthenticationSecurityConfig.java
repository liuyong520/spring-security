package com.styz.security.config;

import com.styz.security.authentication.mobile.SmsCodeAuthenticationProvider;
import com.styz.security.validate.filter.SmsAutheticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * creat date:2019-07-16 11:41
 * author:xxydliuyss
 * note:
 */
@Component
public class SmsCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    private AuthenticationSuccessHandler successHandler;
    @Autowired
    private AuthenticationFailureHandler failureHandler;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        SmsAutheticationTokenFilter smsAutheticationTokenFilter = new SmsAutheticationTokenFilter();
        smsAutheticationTokenFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        smsAutheticationTokenFilter.setAuthenticationFailureHandler(failureHandler);
        smsAutheticationTokenFilter.setAuthenticationSuccessHandler(successHandler);

        SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
        smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

        http.authenticationProvider(smsCodeAuthenticationProvider)
                .addFilterAfter(smsAutheticationTokenFilter, UsernamePasswordAuthenticationFilter.class);

    }
}
