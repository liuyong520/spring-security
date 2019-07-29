package com.styz.security.properties;

import lombok.Data;

/**
 * creat date:2019-07-16 00:23
 * author:xxydliuyss
 * note:
 */
@Data
public class ValidateProperties {

    private ValidateImageProperties imageCode = new ValidateImageProperties();
    private ValidateSmsProperties smsCode = new ValidateSmsProperties();
}
