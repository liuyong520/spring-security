package com.styz.api.mapper;

import com.styz.api.model.PermissionRole;

/**
 * Created by Mybatis Generator 2019/07/25
 */
public interface PermissionRoleMapper {
    int deleteByPrimaryKey(Long gid);

    int insert(PermissionRole record);

    int insertSelective(PermissionRole record);

    PermissionRole selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(PermissionRole record);

    int updateByPrimaryKeyWithBLOBs(PermissionRole record);

    int updateByPrimaryKey(PermissionRole record);
}