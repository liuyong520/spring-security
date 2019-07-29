package com.styz.security.validate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * creat date:2019-07-15 22:42
 * author:xxydliuyss
 * note:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)

public class VerifyCode {
    private String code;
    private LocalDateTime expireTime;

    public VerifyCode(String code, int expireIn) {
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }
    public boolean isExpire(){
        return !expireTime.isAfter(LocalDateTime.now());
    }
}
