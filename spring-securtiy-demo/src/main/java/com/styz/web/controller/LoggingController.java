package com.styz.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.styz.api.model.PermissionResource;
import com.styz.api.model.UserBaseInfo;
import com.styz.entity.Menu;
import com.styz.security.aop.WebLogger;
import com.styz.security.service.PermessionResourcesService;
import com.styz.security.utils.AuhtenticationUtils;
import com.styz.service.MenuService;
import com.styz.service.UserBaseInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.manager.util.SessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * creat date:2019-07-13 22:09
 * author:xxydliuyss
 * note:
 */
@Controller
@Slf4j
public class LoggingController {

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserBaseInfoService userBaseInfoService;
    @GetMapping(value = {"/index","/"})
    public ModelAndView index(ModelAndView mv, HttpSession session, @AuthenticationPrincipal Authentication authentication){
        User user = AuhtenticationUtils.getUser(authentication);
        if(user==null) throw new UsernameNotFoundException("未找到该用户");
        String username = user.getUsername();
        log.info("用户名:{},密码:{},权限:{}",user.getUsername(),user.getPassword(),user.getAuthorities());
        Map<Long, Menu> treeMenu = menuService.getTreeMenu(user.getUsername());
        //将菜单放入session中
        session.setAttribute("treeMenu",treeMenu);

        session.setAttribute("userName",username);
        UserBaseInfo userInfo = userBaseInfoService.getUser(user.getUsername());
        session.setAttribute("userInfo",userInfo);
        mv.setViewName("index");
        return mv;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public String exceptionHandler(Exception e) {

        return "login";
    }



    @GetMapping(value = {"/login"})
    public String login(){
        log.info("login");
        return "login";
    }
    @GetMapping("/top-menu")
    public String topmenu(){
        return "top-menu";
    }
}
