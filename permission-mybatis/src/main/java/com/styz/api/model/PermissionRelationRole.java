package com.styz.api.model;

import lombok.Data;

/**
 * Created by Mybatis Generator 2019/07/25
 */
@Data
public class PermissionRelationRole {
    /**
     * ID。[]
     */
    private Long gid;

    /**
     * 用户类型。[enum SubjectType]
     */
    private Integer usertype;

    /**
     * 用户ID。[dataRef subjectType]
     */
    private Long userid;

    /**
     * 角色ID
     */
    private Long roleid;

    /**
     * 权限信息
     */
    private String perms;

    /**
     * 关联状态[enum COMMON_RECORD_STATUS]
     */
    private Integer relationstatus;

    /**
     * 创建时间。[datetime]
     */
    private Long createtime;

    /**
     * 更新时间。[datetime]
     */
    private Long updatetime;

    public PermissionRelationRole() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.styz.api.model.PermissionRelationRole;
    }
}