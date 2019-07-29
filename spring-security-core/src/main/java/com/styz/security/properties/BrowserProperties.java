package com.styz.security.properties;

import com.styz.security.entity.SecurityConstant;
import lombok.Data;

/**
 * creat date:2019-07-13 21:19
 * author:xxydliuyss
 * note:
 */
@Data
public class BrowserProperties {

    private String loginPage = SecurityConstant.DEFAULT_LOGIN_PAGE;
    private String loginSuccessPage;
    private int rememberMeSeconds = 841600;
    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String getLoginSuccessPage() {
        return loginSuccessPage;
    }

    public void setLoginSuccessPage(String loginSuccessPage) {
        this.loginSuccessPage = loginSuccessPage;
    }
}
