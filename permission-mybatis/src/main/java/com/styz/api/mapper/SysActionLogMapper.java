package com.styz.api.mapper;

import com.styz.api.model.SysActionLog;

/**
 * Created by Mybatis Generator 2019/07/18
 */
public interface SysActionLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SysActionLog record);

    int insertSelective(SysActionLog record);

    SysActionLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysActionLog record);

    int updateByPrimaryKeyWithBLOBs(SysActionLog record);

    int updateByPrimaryKey(SysActionLog record);
}