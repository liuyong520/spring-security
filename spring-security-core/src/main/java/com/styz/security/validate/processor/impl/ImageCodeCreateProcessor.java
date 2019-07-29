package com.styz.security.validate.processor.impl;

import com.styz.security.validate.code.ImageCode;
import com.styz.security.validate.processor.ValidateCodeBaseProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import java.io.IOException;

/**
 * creat date:2019-07-16 10:27
 * author:xxydliuyss
 * note:
 */
@Component("imageCodeCreateProcessor")
public class ImageCodeCreateProcessor extends ValidateCodeBaseProcessor<ImageCode> {
    @Override
    public void send(ServletWebRequest request, ImageCode imageCode) throws Exception {
        ImageIO.write(imageCode.getBufferedImage(),"JPEG",request.getResponse().getOutputStream());
    }
}
