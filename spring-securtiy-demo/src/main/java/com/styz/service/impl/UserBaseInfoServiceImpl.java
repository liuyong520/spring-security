package com.styz.service.impl;

import com.styz.api.mapper.UserBaseInfoMapper;
import com.styz.api.model.UserBaseInfo;
import com.styz.service.UserBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * creat date:2019-07-25 17:47
 * author:xxydliuyss
 * note:
 */
@Service
public class UserBaseInfoServiceImpl implements UserBaseInfoService {
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    @Override
    public UserBaseInfo getUser(String username) {
        return userBaseInfoMapper.findUserByUserName(username);
    }

    @Override
    public List<UserBaseInfo> getUsers() {
        return userBaseInfoMapper.findAllUsers();
    }
}
