package com.styz.security.service.impl;

import com.styz.api.mapper.SysActionLogMapper;
import com.styz.api.model.SysActionLog;
import com.styz.security.service.SaveLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * creat date:2019-07-12 15:16
 * author:xxydliuyss
 * note:
 */
@Service
public class SavelogServiceImpl implements SaveLogService {
    @Autowired
    SysActionLogMapper sysActionLogMapper;
    @Override
    public void saveLog(SysActionLog saveLog) {
        sysActionLogMapper.insert(saveLog);
    }
}
