package com.styz.security.config;

import com.styz.security.validate.filter.VerifyCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.Filter;

/**
 * creat date:2019-07-24 15:20
 * author:xxydliuyss
 * note:
 */
//@Component("loginSecurityConfig")
public class LoginSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    @Autowired
    Filter loginFilter;
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore(loginFilter, VerifyCodeFilter.class);
    }
}
