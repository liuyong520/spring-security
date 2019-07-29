package com.styz.security.utils;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * creat date:2019-07-18 17:41
 * author:xxydliuyss
 * note:
 */
public class UserUtils {
    public static User getCurrenctUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            return (User)principal;
        }
        return null;
    }
}
