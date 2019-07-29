package com.styz.security.validate.processor.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.styz.security.dto.SimpleResponse;
import com.styz.security.validate.code.SmsCode;
import com.styz.security.validate.processor.ValidateCodeBaseProcessor;
import com.styz.security.validate.sms.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletResponse;

/**
 * creat date:2019-07-16 10:30
 * author:xxydliuyss
 * note:
 */
@Component("smsCodeCreateProcessor")
public class SmsCodeCreateProcessor extends ValidateCodeBaseProcessor<SmsCode> {
    @Autowired
    private SmsSender sender;
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void send(ServletWebRequest request, SmsCode smsCode) throws Exception {
        String mobile = ServletRequestUtils.getStringParameter(request.getRequest(), "moblie");
        sender.send(mobile,smsCode.getCode());
        HttpServletResponse response = request.getResponse();
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        ResponseEntity<SimpleResponse> responseEntity = new SimpleResponse("发送成功").warper(SimpleResponse.OK).toResponse();
        response.getWriter().write(objectMapper.writeValueAsString(responseEntity));
    }
}
