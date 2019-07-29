package com.styz.security.service.impl;

import com.styz.api.mapper.PermissionRelationResourceMapper;
import com.styz.api.mapper.PermissionResourceMapper;
import com.styz.api.model.PermissionRelationResource;
import com.styz.api.model.PermissionResource;
import com.styz.security.service.PermessionResourcesService;
import com.styz.security.service.PermissionUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * creat date:2019-07-14 16:03
 * author:xxydliuyss
 * note:
 */
@Service
public class PermessionResourcesServiceImpl implements PermessionResourcesService {
    @Autowired
    private PermissionUserService permissionUserService;
    @Autowired
    private PermissionRelationResourceMapper permissionRelationResourceMapper;
    @Autowired
    private PermissionResourceMapper resourceMapper;
    @Override
    public Set<String> getAllAviableUrlByUserName(String userName) {
        List<PermissionResource> permissionResourceByResoureIds = this.getAllPermissionResourceByUserName(userName);
        HashSet<String> set = new HashSet<>();
        //获取所有的权限验证路径
        for(PermissionResource permissionResource:permissionResourceByResoureIds){
            set.add(permissionResource.getResourceid());
        }
        return set;
    }
    public List<PermissionResource> getAllPermissionResourceByUserName(String username){
        List<Long> resourceIds = getAllResourcesId(username);
        //根据资源ID获取所有的资源
        List<PermissionResource> permissionResources = resourceMapper.findPermissionResourceByResoureIds(resourceIds);
        return permissionResources;
    }

    private List<Long> getAllResourcesId(String username) {
        User userByUserName = permissionUserService.findUserByUserName(username);
        Set<Long> roleIds = new HashSet<>();
        //根据权限获取所有的角色ID
        for (GrantedAuthority grantedAuthority :userByUserName.getAuthorities()){
            String[] split = grantedAuthority.getAuthority().split(",");
            Long roleId = Long.parseLong(split[0]);
            roleIds.add(roleId);
        }
        //根据角色ID,获取该角色下面的所有资源ID
        List<PermissionRelationResource> permissionRelationResourceList = permissionRelationResourceMapper.findPermissionRelationResourceByRoleIds(roleIds);
        List<Long> resourceIds = new ArrayList<>();
        for (PermissionRelationResource permissionRelationResource: permissionRelationResourceList){
            resourceIds.add(permissionRelationResource.getResourceid());
        }
        return resourceIds;
    }

    @Override
    public List<PermissionResource> getMenuResourceByUserName(String username) {
        List<Long> resourceIds = getAllResourcesId(username);

        List<PermissionResource> permissionResources = resourceMapper.findPermissionResourceByResourcetypeAndInResourceid(resourceIds,1);
        return permissionResources;
    }

    @Override
    public List<PermissionResource> getNotMenuResoucesByUserName(String username) {
        List<Long> resourceIds = getAllResourcesId(username);

        List<PermissionResource> permissionResources = resourceMapper.findPermissionResourceByResourcetypeAndInResourceid(resourceIds, 2);
        return permissionResources;
    }
}
