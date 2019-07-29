package com.styz.security.config;

import com.styz.security.entity.SecurityConstant;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * creat date:2019-07-16 13:16
 * author:xxydliuyss
 * note:
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    protected AuthenticationFailureHandler authenticationFailureHandler;
    @Autowired
    protected AuthenticationSuccessHandler authenticationSuccessHandler;

    public void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
        http.formLogin()
                .loginPage(SecurityConstant.LOGIN_PATGE) //  自定义登录页面URL
                .loginProcessingUrl(SecurityConstant.LOGIN_PROCESS_BROWSER_PAGE) // 处理登录请求的URL
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
    }
}
