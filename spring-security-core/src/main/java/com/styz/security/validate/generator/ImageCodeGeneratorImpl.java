package com.styz.security.validate.generator;

import com.styz.security.properties.SecurityProperties;
import com.styz.security.utils.VerifyImageCodeUtil;
import com.styz.security.validate.VerifyCode;
import com.styz.security.validate.code.ImageCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * creat date:2019-07-16 00:58
 * author:xxydliuyss
 * note:
 */
public class ImageCodeGeneratorImpl implements ValidateCodeGenerater {
    private SecurityProperties securityProperties;
    @Override
    public VerifyCode generatorCode(ServletWebRequest request) {
        Integer width = ServletRequestUtils.getIntParameter(request.getRequest(), "width",securityProperties.getValidate().getImageCode().getWidth());
        Integer length = ServletRequestUtils.getIntParameter(request.getRequest(), "length",securityProperties.getValidate().getImageCode().getLength());

        VerifyImageCodeUtil codeUtil = new VerifyImageCodeUtil(length,width,securityProperties.getValidate().getImageCode().getCount(),securityProperties.getValidate().getImageCode().getLinecount());
        return new ImageCode(codeUtil.getBuffImg(),codeUtil.getCode(),securityProperties.getValidate().getImageCode().getExpire());
    }

    public SecurityProperties getSecurityProperties() {
        return securityProperties;
    }

    public void setSecurityProperties(SecurityProperties securityProperties) {
        this.securityProperties = securityProperties;
    }
}
