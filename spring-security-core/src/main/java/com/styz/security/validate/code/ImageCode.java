package com.styz.security.validate.code;

import com.styz.security.validate.VerifyCode;
import lombok.Data;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * creat date:2019-07-15 22:44
 * author:xxydliuyss
 * note:
 */
@Data
public class ImageCode extends VerifyCode {
    private BufferedImage bufferedImage;


    public ImageCode(BufferedImage bufferedImage, String code, LocalDateTime expireTime) {
        super(code,expireTime);
        this.bufferedImage = bufferedImage;
    }
    public ImageCode(BufferedImage bufferedImage, String code, int expireIn) {
        super(code,expireIn);
        this.bufferedImage = bufferedImage;
    }
}
