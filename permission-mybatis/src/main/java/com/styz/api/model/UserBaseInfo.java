package com.styz.api.model;

import lombok.Data;

/**
 * Created by Mybatis Generator 2019/07/25
 */
@Data
public class UserBaseInfo {
    /**
     * 用户ID。[globalId]
     */
    private Long gid;

    /**
     * 用户类型。[enum UserType]
     */
    private Integer usertype;

    /**
     * 用户二级类型，userType下的子类型。[enum UserType PersonUserType|PartnerUserType|StaffUserType|SystemUserType]
     */
    private Integer usersubtype;

    /**
     * 用户名
     */
    private String username;

    /**
     * 加密类型。[enum PasswordType]
     */
    private Integer passwordtype;

    /**
     * 加密后的用户密码
     */
    private String password;

    /**
     * 加密后的支付密码
     */
    private String paypassword;

    /**
     * 加盐随机串变更时间。[datetime]
     */
    private Long saltrandomchangetime;

    /**
     * 支付密码加盐随机串变更时间。[datetime]
     */
    private Long paysaltrandomchangetime;

    /**
     * 登录密码上次变更时间。[datetime]
     */
    private Long loginpasswordlastupdatetime;

    /**
     * 支付密码上次变更时间。[datetime]
     */
    private Long paypasswordlastupdatetime;

    /**
     * Email电子邮箱
     */
    private String email;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 是否设置登录密码
     */
    private Boolean issetpassword;

    /**
     * 是否设置支付密码
     */
    private Boolean issetpaypassword;

    /**
     * Email电子邮箱是否已经验证
     */
    private Boolean emailisverify;

    /**
     * 手机号码是否已经验证
     */
    private Boolean phoneisverify;

    /**
     * 是否已经实名认证
     */
    private Boolean realnameisauthentication;

    /**
     * 用户图片文件标识id
     */
    private Long memberphotosid;

    /**
     * 用户来源渠道的类型。[enum AppType]
     */
    private Integer sourceapptype;

    /**
     * 用户来源的信息。[dataRef sourceType]
     */
    private String sourceappinfo;

    /**
     * 用户来源的渠道ID。
     */
    private Long sourcechannelid;

    /**
     * 邀请者的用户ID
     */
    private Long invitoruserid;

    /**
     * 用户注册方式，例如通过邮箱注册、通过手机验证码注册等。[enum UserRegisterType]
     */
    private Integer registertype;

    /**
     * 会员等级,鼓励用户活跃。[enum MemberLevel]
     */
    private Integer memberlevel;

    /**
     * VIP等级,鼓励用户付费。[enum VipLevel]
     */
    private Integer viplevel;

    /**
     * 异常行为等级。[enum ErrorActionLevel]
     */
    private Integer erroractionlevel;

    /**
     * 是否已经激活
     */
    private Boolean isactivated;

    /**
     * 是否被禁止使用。如果被禁止使用，则不允许登录。
     */
    private Boolean isdisabled;

    /**
     * 是否被锁定。如果被锁定，则多种正常将受到限制。
     */
    private Boolean islocked;

    /**
     * 创建时间。[datetime]
     */
    private Long createtime;

    /**
     * 更新时间。[datetime]
     */
    private Long updatetime;

    /**
     * 激活时间。[datetime]
     */
    private Long activatetime;

    /**
     * 加盐随机串
     */
    private String saltrandom;

    /**
     * 支付密码加盐随机串
     */
    private String paysaltrandom;

    public UserBaseInfo() {
    }

    protected boolean canEqual(Object other) {
        return other instanceof com.styz.api.model.UserBaseInfo;
    }
}