package com.styz.security.service;

import com.styz.api.model.PermissionResource;

import java.util.List;
import java.util.Set;

/**
 * creat date:2019-07-14 15:59
 * author:xxydliuyss
 * note:
 */
public interface PermessionResourcesService {
    /**
     * 获取所有有权限的url
     * @param userName
     * @return
     */
    Set<String> getAllAviableUrlByUserName(String userName);

    /**
     * 获取用户所有的资源
     * @param username
     * @return
     */
    List<PermissionResource> getAllPermissionResourceByUserName(String username);

    /**
     * 获取用户所有的菜单资源
     */
    List<PermissionResource> getMenuResourceByUserName(String username);

    /**
     * 获取用户下所有的非菜单资源
     */
    List<PermissionResource> getNotMenuResoucesByUserName(String username);

}
