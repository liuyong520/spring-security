package com.styz.api.mapper;

import com.styz.api.model.PermissionResource;import org.apache.ibatis.annotations.Param;import java.util.List;

/**
 * Created by Mybatis Generator 2019/07/26
 */
public interface PermissionResourceMapper {
    int deleteByPrimaryKey(Long gid);

    int insert(PermissionResource record);

    int insertSelective(PermissionResource record);

    PermissionResource selectByPrimaryKey(Long gid);

    int updateByPrimaryKeySelective(PermissionResource record);

    int updateByPrimaryKeyWithBLOBs(PermissionResource record);

    int updateByPrimaryKey(PermissionResource record);

    List<PermissionResource> findPermissionResourceByResoureIds(@Param("resourceIds") List<Long> resourceIds);

    List<PermissionResource> findPermissionResourceByResourcetypeAndInResourceid(@Param("resourceIds") List<Long> resourceIds, @Param("resourceType") Integer resourceType);
}