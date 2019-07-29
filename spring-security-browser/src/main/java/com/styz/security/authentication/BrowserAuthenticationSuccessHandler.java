package com.styz.security.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.styz.security.aop.WebLogger;
import com.styz.security.dto.SimpleResponse;
import com.styz.security.entity.SecurityConstant;
import com.styz.security.properties.SecurityProperties;
import com.styz.security.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.AntPathMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * creat date:2019-07-13 21:26
 * author:xxydliuyss
 * note:
 */
@Slf4j
public class BrowserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Autowired
    private SecurityProperties securityProperties;
    @Autowired
    private ObjectMapper objectMapper;
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    public static List<String> loginPageUrls = new ArrayList();
    static {
        loginPageUrls.add(SecurityConstant.LOGIN_PROCESS_MOBILE_PAGE);
        loginPageUrls.add(SecurityConstant.LOGIN_PROCESS_BROWSER_PAGE);
    }
    @Override
    @WebLogger(value = "登录" ,logtype = 2)
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        //缓存起来；
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String requestURI = request.getRequestURI();
        log.info("requestURI:\t" + requestURI);
        ResponseEntity<SimpleResponse> responseEntity = null;
        boolean match = false;
        for(String url:loginPageUrls){
            if(antPathMatcher.match(url,requestURI)){
                match = true;
                break;
            }
        }
        if(match){

            String page = StringUtils.defaultIfBlank(securityProperties.getBrowser().getLoginSuccessPage(),"/");
            responseEntity = new SimpleResponse(page).warper(SimpleResponse.OK, "登录成功").toResponse();
        }else{
            // 登录成功后把authentication返回给前台
            responseEntity = new SimpleResponse("").warper(SimpleResponse.OK, "权限验证通过").toResponse();
        }
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(responseEntity.getBody()));
    }
}
