package com.styz.api.model;

import lombok.Data;

/**
 * Created by Mybatis Generator 2019/07/18
 */
@Data
public class SysActionLog {
    /**
     * 主键ID
     */
    private Long id;

    /**
     * 类名
     */
    private String classname;

    /**
     * 方法名
     */
    private String methodname;

    /**
     * 参数类表
     */
    private String params;

    /**
     * 日志类型
     */
    private Integer logtype;

    /**
     * 执行时间
     */
    private Long executetime;

    /**
     * 创建时间
     */
    private Long createDate;

    /**
     * 执行用户
     */
    private Long createBy;

    /**
     * 操作说明
     */
    private String remark;

    public SysActionLog() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.styz.api.model.SysActionLog;
    }
}