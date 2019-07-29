package com.styz.security.validate.sms;

import com.styz.security.validate.code.SmsCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * creat date:2019-07-16 09:56
 * author:xxydliuyss
 * note:
 */
@Component
@Slf4j
public class SmsSenderImpl implements SmsSender {
    @Override
    public void send(String moblie, String msg) {
        log.info("发送验证码：\t{}\t到手机号为:\t{}\t的用户手机上",msg,moblie);
    }
}
