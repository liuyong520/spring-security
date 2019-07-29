package com.styz.security.validate.controller;

import com.styz.security.validate.generator.ValidateCodeGenerater;
import com.styz.security.validate.VerifyCode;
import com.styz.security.validate.code.SmsCode;
import com.styz.security.validate.processor.ValidateCodeCreateProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * creat date:2019-07-15 22:50
 * author:xxydliuyss
 * note:
 */
@RestController
public class ValidateCodeController {
    @Autowired
    private Map<String, ValidateCodeCreateProcessor> validateCodeCreateProcessorMap;

    @RequestMapping("/code/{type}")
    public void createCode(@PathVariable("type")String type, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ValidateCodeCreateProcessor validateCodeCreateProcessor = validateCodeCreateProcessorMap.get(type+"CodeCreateProcessor");
        validateCodeCreateProcessor.createCode(new ServletWebRequest(request,response));
    }


}
