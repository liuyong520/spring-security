package com.styz.securtiy.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * creat date:2019-07-12 12:20
 * author:xxydliuyss
 * note:
 */
@Slf4j
public class ExecuteTimeFilter implements Filter {
    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("ExecuteTimeFilter doFilter start");
        LocalDateTime start = LocalDateTime.now();
        filterChain.doFilter(servletRequest, servletResponse);
        LocalDateTime end = LocalDateTime.now();
        log.info("ExecuteTimeFilter doFilter end: excuteTime "+ (end.toLocalTime().getNano()-start.toLocalTime().getNano())/ 1000);
    }

    @Override
    public void destroy() {

    }
}
