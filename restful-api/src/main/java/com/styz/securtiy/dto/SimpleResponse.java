package com.styz.securtiy.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * creat date:2019-07-11 21:27
 * author:xxydliuyss
 * note:
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class SimpleResponse {
    private String code="0000";
    private String msg= "success";
    private Object data;

    public SimpleResponse(Object data) {
        this.data = data;
    }
}
