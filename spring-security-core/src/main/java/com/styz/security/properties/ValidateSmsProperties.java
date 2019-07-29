package com.styz.security.properties;

import lombok.Data;

/**
 * creat date:2019-07-16 09:05
 * author:xxydliuyss
 * note:
 */
@Data
public class ValidateSmsProperties {
    private Integer count=4;
    private String includeUrls;
    private Integer expire=60;
}
