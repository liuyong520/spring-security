package com.styz.security.validate.filter;

import com.styz.security.entity.SecurityConstant;
import com.styz.security.utils.UserUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * creat date:2019-07-24 15:07
 * author:xxydliuyss
 * note:
 */
@Slf4j
//@Component("loginFilter")
public class LoginFilter implements Filter {
    RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        User currenctUser = UserUtils.getCurrenctUser();
        if(currenctUser == null){
            redirectStrategy.sendRedirect((HttpServletRequest) request,(HttpServletResponse) response, SecurityConstant.LOGIN_PATGE);
            return;
        }
        filterChain.doFilter(request, response);
    }



    @Override
    public void destroy() {

    }
}
