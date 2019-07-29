package com.styz.api.mapper;

import com.styz.api.model.PermissionRelationRole;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * Created by Mybatis Generator 2019/07/25
 */
public interface PermissionRelationRoleMapper {
    int deleteByPrimaryKey(Long gid);

    int insert(PermissionRelationRole record);

    int insertSelective(PermissionRelationRole record);

    PermissionRelationRole selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(PermissionRelationRole record);

    int updateByPrimaryKey(PermissionRelationRole record);

    List<PermissionRelationRole> findRelationRoleByUserId(@Param("userId") Long userId);
}