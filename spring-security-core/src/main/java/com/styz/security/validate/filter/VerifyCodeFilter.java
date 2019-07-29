package com.styz.security.validate.filter;

import com.styz.security.entity.SecurityConstant;
import com.styz.security.exception.ValidateCodeException;
import com.styz.security.properties.SecurityProperties;
import com.styz.security.validate.filter.processor.ValidateCodeFilterProceessorHolder;
import com.styz.security.validate.filter.processor.ValidateCodeType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * creat date:2019-07-16 11:17
 * author:xxydliuyss
 * note:
 */
@Slf4j
@Component("verifyCodeFilter")
public  class VerifyCodeFilter extends OncePerRequestFilter implements InitializingBean {
    /**
     * url 对应的过滤器类型
     */
    private Map<String, ValidateCodeType> urlMaps = new HashMap<>(512);
    /**
     * 路径匹配
     */
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * 验证失败处理器
     */
    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;
    /**
     * 配置文件
     */
    @Autowired
    private SecurityProperties securityProperties;
    /**
     * 工厂方法
     */
    @Autowired
    private ValidateCodeFilterProceessorHolder validateCodeFilterProceessorHolder;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        ValidateCodeType type = getValidateCodeType(request);
        if(type!=null){
           log.info("校验请求（" +request.getRequestURI()+")中的验证码，验证码类型：" + type);
            try {
                validateCodeFilterProceessorHolder.findValidate(type).validate(new ServletWebRequest(request,response));
                log.info("校验请求{},中的验证码,校验结果：成功",request.getRequestURI());
            }catch (ValidateCodeException ex){
                authenticationFailureHandler.onAuthenticationFailure(request, response, ex);
                log.info("校验请求{},中的验证码,校验结果：失败\t 原因:{}",request.getRequestURI(),ex.getMessage());
                return;
            }
        }
        filterChain.doFilter(request, response);
    }

    private ValidateCodeType getValidateCodeType(HttpServletRequest request){
        for(Map.Entry<String,ValidateCodeType> entry : urlMaps.entrySet()){
            if(antPathMatcher.match(entry.getKey(),request.getRequestURI())){
                return entry.getValue();
            }
        }
        return null;
    }


    @Override
    public void afterPropertiesSet() throws ServletException {
        super.afterPropertiesSet();
        String imageUrls = securityProperties.getValidate().getImageCode().getIncludeUrls();
        urlMaps.put(SecurityConstant.LOGIN_PROCESS_BROWSER_PAGE,ValidateCodeType.IMAGE);
        addUrlToMap(imageUrls,ValidateCodeType.IMAGE);
        urlMaps.put(SecurityConstant.LOGIN_PROCESS_MOBILE_PAGE,ValidateCodeType.SMS);
        String smsUrls = securityProperties.getValidate().getSmsCode().getIncludeUrls();
        addUrlToMap(smsUrls,ValidateCodeType.SMS);
    }

    protected void addUrlToMap(String imageUrls, ValidateCodeType image){
        if(StringUtils.isNotBlank(imageUrls)){
            for (String url : imageUrls.split(",")) {
                urlMaps.put(url,image);
            }
        }
    }
}
