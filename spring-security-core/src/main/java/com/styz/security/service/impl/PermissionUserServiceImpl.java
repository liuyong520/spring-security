package com.styz.security.service.impl;

import com.styz.api.mapper.PermissionRelationRoleMapper;
import com.styz.api.mapper.UserBaseInfoMapper;
import com.styz.api.model.PermissionRelationRole;
import com.styz.api.model.UserBaseInfo;
import com.styz.security.entity.UserRoleRelations;
import com.styz.security.service.PermissionUserService;
import com.styz.security.service.PermissionAuthoritheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * creat date:2019-07-14 11:53
 * author:xxydliuyss
 * note:
 */
@Repository
public class PermissionUserServiceImpl implements PermissionUserService {
    @Autowired
    private UserBaseInfoMapper userBaseInfoMapper;
    @Autowired
    private PermissionRelationRoleMapper permissionRelationRoleMapper;
    @Autowired
    private PermissionAuthoritheService permissionAuthoritheService;

    @Override
    public User findUserByUserName(String username) {
        //获取用户信息
        UserBaseInfo userBaseInfo =  userBaseInfoMapper.findUserByUserName(username);
        if(userBaseInfo == null){
            return null;
        }
        // 获取用户关联角色
        List<PermissionRelationRole> relationRoles = permissionRelationRoleMapper.findRelationRoleByUserId(userBaseInfo.getGid());

        if(relationRoles.isEmpty() || relationRoles==null) throw new AuthorizationServiceException("该用户无任何权限");

        // 根据角色获取所有的权限
        List authorithes = permissionAuthoritheService.getAuthorithes(new UserRoleRelations(relationRoles));

        return new User(username,userBaseInfo.getPassword(),authorithes);

    }
}
