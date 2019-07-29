package com.styz.security.entity;

/**
 * creat date:2019-07-12 15:18
 * author:xxydliuyss
 * note:
 */
public class SaveLog {

    private String createDate;
    private long executeTime;
    private String remark;
    private String className;
    private String methodName;
    private String params;

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setExecuteTime(long executeTime) {
        this.executeTime = executeTime;
    }

    public long getExecuteTime() {
        return executeTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassName() {
        return className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getParams() {
        return params;
    }
}
