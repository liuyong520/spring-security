package com.styz.api.model;

import lombok.Data;

/**
 * Created by Mybatis Generator 2019/07/25
 */
@Data
public class PermissionRole {
    /**
     * ID。[globalId]
     */
    private Long gid;

    /**
     * 权限信息
     */
    private String perms;

    /**
     * 角色类型，例如超级管理员、系统定义角色、自定义角色。[enum ROLE_TYPE]
     */
    private Integer roletype;

    /**
     * 角色状态[enum COMMON_RECORD_STATUS]
     */
    private Integer rolestatus;

    /**
     * 角色名称
     */
    private String rolename;

    /**
     * 角色使用的优先级，当角色的权限有冲突时，使用该优先级
     */
    private Integer priority;

    /**
     * 创建时间。[datetime]
     */
    private Long createtime;

    /**
     * 更新时间。[datetime]
     */
    private Long updatetime;

    /**
     * 角色描述
     */
    private String roledesc;

    public PermissionRole() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.styz.api.model.PermissionRole;
    }
}