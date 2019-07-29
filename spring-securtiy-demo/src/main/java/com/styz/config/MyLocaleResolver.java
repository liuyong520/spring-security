package com.styz.config;

import org.apache.commons.lang3.StringUtils;
import org.apache.tomcat.util.descriptor.LocalResolver;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * creat date:2019-07-23 08:27
 * author:xxydliuyss
 * note:
 */
public class MyLocaleResolver implements LocaleResolver {


    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String locale = ServletRequestUtils.getStringParameter(request, "l", null);
        if(StringUtils.isBlank(locale)){
            AcceptHeaderLocaleResolver headerLocaleResolver = new AcceptHeaderLocaleResolver();
            return headerLocaleResolver.resolveLocale(request);
        }else{
            String[] contents = locale.split("_");
            Locale locales = new Locale(contents[0], contents[1]);
            return locales;
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
