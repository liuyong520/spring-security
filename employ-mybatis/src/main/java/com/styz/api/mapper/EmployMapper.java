package com.styz.api.mapper;

import com.styz.api.model.Employ;

/**
* Created by Mybatis Generator 2019/07/11
*/
public interface EmployMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Employ record);

    int insertSelective(Employ record);

    Employ selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Employ record);

    int updateByPrimaryKey(Employ record);
}