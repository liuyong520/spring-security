package com.styz.security.authentication;

import com.styz.security.service.PermissionUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * creat date:2019-07-14 11:45
 * author:xxydliuyss
 * note:
 */
@Component("myuserDetailService")
@Slf4j
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private PermissionUserService permissionUserService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("用户登录:\t" + username);
        if(StringUtils.isBlank(username)) throw new UsernameNotFoundException("用户名为空");
        User baseUserInfo = permissionUserService.findUserByUserName(username);
        if(baseUserInfo == null) throw new UsernameNotFoundException("用户不存在");
        return baseUserInfo;
    }
}
