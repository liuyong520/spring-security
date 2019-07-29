package com.styz.security.service.impl;

import com.styz.api.model.PermissionRelationRole;
import com.styz.security.entity.UserRoleRelations;
import com.styz.security.service.PermissionAuthoritheService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * creat date:2019-07-14 13:45
 * author:xxydliuyss
 * note:
 */
@Service
public class DefaultPermissionAuthoritheService implements PermissionAuthoritheService<UserRoleRelations, GrantedAuthority> {
    @Override
    public List<GrantedAuthority> getAuthorithes(UserRoleRelations roleRelations) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        List<PermissionRelationRole> permissionRelationRoles = (List<PermissionRelationRole>) roleRelations.getRoleRelation();
        for (PermissionRelationRole userRoleRelations : permissionRelationRoles){
            String authority = userRoleRelations.getRoleid() + "," + userRoleRelations.getPerms();
            authorities.add(new SimpleGrantedAuthority(authority));
        }
        return authorities;
    }
}
