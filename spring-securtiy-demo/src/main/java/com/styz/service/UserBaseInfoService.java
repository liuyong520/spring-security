package com.styz.service;

import com.styz.api.model.UserBaseInfo;

import java.util.List;

/**
 * creat date:2019-07-25 17:47
 * author:xxydliuyss
 * note:
 */
public interface UserBaseInfoService {
    /**
     * 获取指定用户名的用户
     * @param username
     * @return
     */
    public UserBaseInfo getUser(String username);

    /**
     * 获取指定所有用户
     * @return
     */
    public List<UserBaseInfo> getUsers();
}
