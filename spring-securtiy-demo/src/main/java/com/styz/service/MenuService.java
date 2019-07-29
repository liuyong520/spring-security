package com.styz.service;

import com.styz.api.model.PermissionResource;
import com.styz.entity.Menu;

import java.util.Map;

/**
 * creat date:2019-07-25 13:24
 * author:xxydliuyss
 * note:
 */
public interface MenuService {
    /**
     * 根据用户获取菜单树
     * @param username
     * @return
     */
    Map<Long, Menu> getTreeMenu(String username);
}
