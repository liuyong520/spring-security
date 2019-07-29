package com.styz.security.service.impl;

import com.styz.security.service.PermessionResourcesService;
import com.styz.security.service.RbacPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

/**
 * creat date:2019-07-14 15:56
 * author:xxydliuyss
 * note:
 */
@Service("rbacPermission")
public class RbacPermissionServiceImpl implements RbacPermissionService {
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    @Autowired
    private PermessionResourcesService permessionResourcesService;
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();
        boolean hasPermission = false;
        if(principal instanceof UserDetails) {
            String username = ((UserDetails) principal).getUsername();
            // 读取用户所拥有的权限url，这里应该从数据库获取
            Set<String> urls = permessionResourcesService.getAllAviableUrlByUserName(username);
            for (String url : urls) {
                // 判断当前url是否有权限
                String requestURI = request.getRequestURI();
                if(antPathMatcher.match(url,requestURI )) {
                    hasPermission = true;
                    break;
                }
            }
        }
        return hasPermission;
    }
}
