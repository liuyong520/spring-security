package com.styz.security.authentication;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * creat date:2019-07-16 14:24
 * author:xxydliuyss
 * note:
 */
public interface AuthorizeConfigProvider {
    /**
     * 配置表达式config
     * @param config
     */
    void config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config);
}
