package com.styz.api.model;

import lombok.Data;

/**
 * Created by Mybatis Generator 2019/07/25
 */
@Data
public class PermissionRelationResource {
    /**
     * ID。[globalId]
     */
    private Long gid;

    /**
     * 角色主体类型。[enum ROLE_TYPE]
     */
    private Integer roletype;

    /**
     * 角色ID。角色表中的gid[dataRef subjectType]
     */
    private Long roleid;

    /**
     * 关联资源类型。[enum RESOURCE_TYPE]
     */
    private Integer relationresourcetype;

    /**
     * 资源标识ID,即资源表中的gid
     */
    private Long resourceid;

    /**
     * 是否黑名单，即禁止访问
     */
    private Boolean isforbidden;

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

    /**
     * 资源信息。例如如果resourceType为客服退款审核时，可以用来记录：允许审核的目标代理商编号。[dataRef resourceType]
     */
    private String resourceinfo;

    public PermissionRelationResource() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.styz.api.model.PermissionRelationResource;
    }
}