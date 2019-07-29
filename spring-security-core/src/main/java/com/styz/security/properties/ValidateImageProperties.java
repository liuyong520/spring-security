package com.styz.security.properties;

import lombok.Data;

/**
 * creat date:2019-07-16 00:19
 * author:xxydliuyss
 * note:
 */
@Data
public class ValidateImageProperties {
    private Integer length=80;
    private Integer width = 30;
    private Integer count = 4;
    private Integer linecount = 5;
    private String includeUrls;
    private Integer expire=60;
}
