package com.styz.security.service;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * creat date:2019-07-14 15:55
 * author:xxydliuyss
 * note:
 */
public interface RbacPermissionService {
    /**
     * 严重是否有权限访问
     * @param request
     * @param authentication
     * @return
     */
    boolean hasPermission(HttpServletRequest request, Authentication authentication);
}
