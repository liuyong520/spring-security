package com.styz.api.model;

import lombok.Data;

/**
 * Created by Mybatis Generator 2019/07/26
 */
@Data
public class PermissionResource {
    /**
     * ID。[globalId]
     */
    private Long gid;

    /**
     * 直接资源父亲ID
     */
    private Long parentresourceid;

    /**
     * 所有的父ID,多个逗号隔开
     */
    private String parentresourceids;

    /**
     * 资源标识
     */
    private String resourceid;

    /**
     * 资源链接
     */
    private String resourcehref;

    /**
     * 资源样式
     */
    private String resourcecssclass;

    /**
     * 资源图标
     */
    private String resourceicon;

    /**
     * 资源类型。[enum RESOURCE_TYPE]
     */
    private Integer resourcetype;

    /**
     * 资源状态[enum CommonRecordStatus]
     */
    private Integer resourcestatus;

    /**
     * 是否为菜单资源,[enum MENU_TYPE]
     */
    private Integer menutype;

    /**
     * 菜单排序
     */
    private Integer menusort;

    /**
     * 资源名称
     */
    private String resourcename;

    /**
     * 创建时间。[datetime]
     */
    private Long createtime;

    /**
     * 更新时间。[datetime]
     */
    private Long updatetime;

    /**
     * 资源描述
     */
    private String resourcedesc;

    public PermissionResource() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.styz.api.model.PermissionResource;
    }
}