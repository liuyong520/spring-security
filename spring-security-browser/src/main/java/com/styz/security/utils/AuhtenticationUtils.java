package com.styz.security.utils;

import com.styz.security.authentication.mobile.SmsCodeAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * creat date:2019-07-18 16:44
 * author:xxydliuyss
 * note:
 */
@Slf4j
public class AuhtenticationUtils {

    public static User getUser(Authentication authentication) {
        User currenctUser = UserUtils.getCurrenctUser();
        if(currenctUser!=null) return currenctUser;

        if (authentication instanceof UsernamePasswordAuthenticationToken) {
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = (UsernamePasswordAuthenticationToken) authentication;
            return (User) usernamePasswordAuthenticationToken.getPrincipal();

        }
        if (authentication instanceof RememberMeAuthenticationToken) {
            RememberMeAuthenticationToken rememberMeAuthenticationToken = (RememberMeAuthenticationToken) authentication;
            return (User) rememberMeAuthenticationToken.getPrincipal();
        }
        if(authentication instanceof SmsCodeAuthenticationToken){
            SmsCodeAuthenticationToken smsCodeAuthenticationToken = (SmsCodeAuthenticationToken) authentication;
            String moblie = (String) smsCodeAuthenticationToken.getPrincipal();
            UserDetails build = User.builder()
                    .username(moblie).build();
            return (User) build;
        }

        return null;
    }
}