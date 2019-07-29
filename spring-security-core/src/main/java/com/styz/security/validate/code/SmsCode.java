package com.styz.security.validate.code;

import com.styz.security.validate.VerifyCode;
import lombok.Data;

/**
 * creat date:2019-07-16 08:57
 * author:xxydliuyss
 * note:
 */
@Data
public class SmsCode extends VerifyCode {
    public SmsCode(String random, Integer expire) {
        super(random,expire);
    }
}
