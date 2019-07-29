package com.styz.security.authentication;

import com.styz.security.entity.SecurityConstant;
import com.styz.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * creat date:2019-07-16 13:50
 * author:xxydliuyss
 * note:
 */
@Component
@Order(Integer.MIN_VALUE)

public class MyAuthorizeConfigProvider implements AuthorizeConfigProvider {
    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
        List<String> list = new ArrayList<>();
        list.add(SecurityConstant.LOGIN_PROCESS_BROWSER_PAGE);
        list.add( SecurityConstant.LOGIN_PROCESS_MOBILE_PAGE);
        list.add(SecurityConstant.DEFAULT_LOGIN_PAGE);
        list.add(SecurityConstant.Index_PAGE);
        list.add(SecurityConstant.LOGIN_INDEX);
        list.add(securityProperties.getBrowser().getLoginPage());
        list.add(SecurityConstant.VERIFIYCODE_PREFIX+"/*");
        list.add("/assets/**");
        list.add("/resources/**");

//        for (ResourceResolver resource:resourceResolvers){
//            try {
//                list.add(resource..getPath());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        String[] arrays = new String[list.size()];
        list.toArray(arrays);
        config.antMatchers(arrays)
                .permitAll()
                .anyRequest() // 任何请求
                .access("@rbacPermission.hasPermission(request,authentication)");
    }
}
