package com.styz.api.mapper;

import com.styz.api.model.PermissionRelationResource;import org.apache.ibatis.annotations.Param;import java.util.List;import java.util.Set;

/**
 * Created by Mybatis Generator 2019/07/25
 */
public interface PermissionRelationResourceMapper {
    int deleteByPrimaryKey(Long gid);

    int insert(PermissionRelationResource record);

    int insertSelective(PermissionRelationResource record);

    PermissionRelationResource selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(PermissionRelationResource record);

    int updateByPrimaryKeyWithBLOBs(PermissionRelationResource record);

    int updateByPrimaryKey(PermissionRelationResource record);

    List<PermissionRelationResource> findPermissionRelationResourceByRoleIds(@Param("roleIds") Set<Long> roleIds);
}