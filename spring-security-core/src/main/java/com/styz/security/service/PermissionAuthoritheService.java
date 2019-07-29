package com.styz.security.service;

import com.styz.security.entity.UserRoleRelations;
import org.springframework.security.core.GrantedAuthority;

import java.util.List;

/**
 * creat date:2019-07-14 13:43
 * author:xxydliuyss
 * note:
 */
public interface PermissionAuthoritheService<K extends UserRoleRelations,T extends GrantedAuthority> {

    List<T> getAuthorithes(K roleRelations);

}
