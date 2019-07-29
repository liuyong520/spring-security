package com.styz.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.styz.security.dto.SimpleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * creat date:2019-07-13 21:27
 * author:xxydliuyss
 * note:
 */
@Slf4j
public class BrowserAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) throws IOException, ServletException {
        log.info("登录失败");
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        ResponseEntity<SimpleResponse> responseEntity = new SimpleResponse(e.getMessage()).warper(SimpleResponse.FAIL).toResponse();
        response.getWriter().write(objectMapper.writeValueAsString(responseEntity.getBody()));
    }
}
