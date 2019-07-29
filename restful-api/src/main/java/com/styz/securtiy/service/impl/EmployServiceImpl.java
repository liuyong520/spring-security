package com.styz.securtiy.service.impl;

import com.styz.api.mapper.EmployMapper;
import com.styz.api.model.Employ;
import com.styz.securtiy.exception.EmployServiceException;
import com.styz.securtiy.service.Employservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * creat date:2019-07-11 21:04
 * author:xxydliuyss
 * note:
 */
@Service
public class EmployServiceImpl implements Employservice {
    @Autowired
    private EmployMapper employMapper;
    @Override
    public Employ get(Long id) {
        return employMapper.selectByPrimaryKey(id);
    }

    @Override
    public Long update(Employ employ) {
        if(employ.getId()<0) throw new EmployServiceException("修改时Id不能为空");
        int id =  employMapper.updateByPrimaryKeySelective(employ);
        return Long.valueOf(id);
    }

    @Override
    public Boolean save(Employ employ) {
        return employMapper.insertSelective(employ)>0?true:false;
    }

    @Override
    public boolean delete(long id) {
        return employMapper.deleteByPrimaryKey(id)>0?true:false;
    }
}
