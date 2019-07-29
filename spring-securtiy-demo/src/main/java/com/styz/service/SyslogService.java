package com.styz.service;

import com.styz.api.model.SysActionLog;

import java.util.List;

/**
 * creat date:2019-07-25 15:10
 * author:xxydliuyss
 * note:
 */
public interface SyslogService {

    public List<SysActionLog> getSyslogs();
}
