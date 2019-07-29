package com.styz.securtiy.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.styz.securtiy.entity.SaveLog;
import com.styz.securtiy.service.SaveLogService;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * creat date:2019-07-12 15:16
 * author:xxydliuyss
 * note:
 */
@Service
public class SavelogServiceImpl implements SaveLogService {
    @Override
    public void saveLog(SaveLog saveLog) {
        try {
            FileUtils.write(new File("log.txt"), JSONObject.toJSONString(saveLog)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
