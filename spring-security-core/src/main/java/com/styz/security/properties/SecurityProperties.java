package com.styz.security.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * creat date:2019-07-13 21:11
 * author:xxydliuyss
 * note:
 */
@Component
@ConfigurationProperties(prefix = "styz")
@Data
public class SecurityProperties {
    private BrowserProperties browser;

    private ValidateProperties validate = new ValidateProperties();

    public BrowserProperties getBrowser() {
        return browser;
    }

    public void setBrowser(BrowserProperties browser) {
        this.browser = browser;
    }
}
