package com.styz.service.impl;

import com.styz.api.mapper.SysActionLogMapper;
import com.styz.api.model.SysActionLog;
import com.styz.service.SyslogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * creat date:2019-07-25 15:11
 * author:xxydliuyss
 * note:
 */
@Service
public class SyslogServiceImpl implements SyslogService {
    @Autowired
    private SysActionLogMapper sysActionLogMapper;
    @Override
    public List<SysActionLog> getSyslogs() {
        return Arrays.asList(sysActionLogMapper.selectByPrimaryKey(1L));
    }
}
