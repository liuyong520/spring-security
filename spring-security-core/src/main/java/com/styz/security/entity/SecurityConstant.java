package com.styz.security.entity;

/**
 * creat date:2019-07-13 21:37
 * author:xxydliuyss
 * note:
 */
public class SecurityConstant {

    public static final String DEFAULT_LOGIN_PAGE = "/authentication/require";
    /**
     * 用户名密码登录页面
     */
    public static final String LOGIN_PROCESS_BROWSER_PAGE = "/authentication/form";
    /**
     * 手机👌号验证码登录
     */
    public static final String LOGIN_PROCESS_MOBILE_PAGE = "/authentication/mobile";
    /**
     * 登录页面
     */
    public static final String LOGIN_PATGE="/authentication/require";
    /**
     * 短信
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_SMS = "SMS";
    /**
     * 图片验证码
     */
    public static final String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "IMAGE";
    /**
     * 验证码连接
     */
    public static final String VERIFIYCODE_PREFIX = "/code/";

    public static final String Index_PAGE ="/index/**";

    public static final String LOGIN_INDEX = "/login/**";



}
