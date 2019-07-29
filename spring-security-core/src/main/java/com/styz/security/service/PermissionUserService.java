package com.styz.security.service;

import com.styz.security.entity.BaseUserInfo;
import org.springframework.security.core.userdetails.User;

/**
 * creat date:2019-07-14 11:46
 * author:xxydliuyss
 * note:
 */
public interface PermissionUserService {

    User findUserByUserName(String username);

}
