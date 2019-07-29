package com.styz.security.validate.sms;

/**
 * creat date:2019-07-16 09:55
 * author:xxydliuyss
 * note:
 */
public interface SmsSender {

    void send(String moblie, String msg);
}
