USE db2;
SET STORAGE_ENGINE = InnoDB;

DROP TABLE IF EXISTS `sys_action_log`;
CREATE TABLE `sys_action_log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `className` varchar(255) DEFAULT NULL COMMENT '类名',
  `methodName` varchar(255) DEFAULT NULL COMMENT '方法名',
  `params` varchar(255) DEFAULT NULL COMMENT '参数类表',
  `logtype` int NOT NULL DEFAULT 0 COMMENT '日志类型',
  `remark` text DEFAULT NULL COMMENT '操作说明',
  `executeTime` bigint(20) DEFAULT NULL COMMENT '执行时间',
  `create_date` bigint DEFAULT NULL COMMENT '创建时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '执行用户',
  PRIMARY KEY (`id`),
  INDEX `create_by` (`create_by`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8


DROP TABLE IF EXISTS sys_dict;
CREATE TABLE `sys_dict` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `title` varchar(255) DEFAULT NULL COMMENT '字典名称',
  `name` varchar(255) DEFAULT NULL COMMENT '字典键名',
  `type` tinyint(4) DEFAULT NULL COMMENT '字典类型',
  `value` text COMMENT '字典键值',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `create_by` bigint(20) DEFAULT NULL COMMENT '创建用户',
  `update_by` bigint(20) DEFAULT NULL COMMENT '更新用户',
  `status` tinyint(4) DEFAULT NULL COMMENT '状态（1:正常,2:冻结,3:删除）',
  PRIMARY KEY (`id`),
  INDEX `create_by` (`create_by`),
  INDEX `update_by` (`update_by`),
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS permission_role;
CREATE TABLE permission_role (
	`gid` BIGINT NOT NULL COMMENT 'ID。[globalId]',
	`roleId` VARCHAR(128) NOT NULL COMMENT '角色标识',
	`roleType` INT NOT NULL COMMENT '角色类型，例如超级管理员、系统定义角色、自定义角色。[enum ROLE_TYPE]',
	`roleStatus` INT NOT NULL COMMENT '角色状态[enum COMMON_RECORD_STATUS]',
	`roleName` VARCHAR(128) NOT NULL COMMENT '角色名称',
	`roleDesc` TEXT NOT NULL COMMENT '角色描述',
	`priority` INT NOT NULL COMMENT '角色使用的优先级，当角色的权限有冲突时，使用该优先级',
	`createTime` BIGINT NOT NULL COMMENT '创建时间。[datetime]',
	`updateTime` BIGINT NOT NULL COMMENT '更新时间。[datetime]',
	PRIMARY KEY (`gid`),
	INDEX `index_roleId` (`roleId`)
)DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci
COMMENT = '用户权限模块的角色表';



DROP TABLE IF EXISTS permission_resource;
CREATE TABLE permission_resource (
	`gid` BIGINT NOT NULL COMMENT 'ID。[globalId]',
	`parentResourceId` BIGINT NOT NULL DEFAULT 0 COMMENT '直接资源父亲ID',
	`parentResourceIds` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '所有的父ID,多个逗号隔开',
	`resourceId` VARCHAR(255) NOT NULL COMMENT '资源标识',
	`resourceHref` VARCHAR(255) NOT NULL COMMENT '资源链接',
	`resourceType` INT NOT NULL COMMENT '资源类型。[enum RESOURCE_TYPE]',
	`resourceStatus` INT NOT NULL COMMENT '资源状态[enum CommonRecordStatus]',
	`menuType` INT NOT NULL DEFAULT 0 COMMENT '是否为菜单资源,[enum MENU_TYPE]',
	`resourceName` VARCHAR(255) NOT NULL COMMENT '资源名称',
	`resourceDesc` TEXT NOT NULL COMMENT '资源描述',
	`createTime` BIGINT NOT NULL COMMENT '创建时间。[datetime]',
	`updateTime` BIGINT NOT NULL COMMENT '更新时间。[datetime]',
	PRIMARY KEY (`gid`),
	INDEX `index_resourceId` (`resourceId`)
)DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
COMMENT = '用户权限模块的资源表';



DROP TABLE IF EXISTS permission_relation_resource;
CREATE TABLE permission_relation_resource (
	`gid` BIGINT NOT NULL COMMENT 'ID。[globalId]',
	`roleType` INT NOT NULL COMMENT '角色主体类型。[enum ROLE_TYPE]',
	`roleId` BIGINT NOT NULL COMMENT '角色ID。角色表中的gid[dataRef subjectType]',
	`relationResourceType` INT NOT NULL COMMENT '关联资源类型。[enum RESOURCE_TYPE]',
	`resourceId` BIGINT NOT NULL COMMENT '资源标识ID,即资源表中的gid',
	`resourceInfo` TEXT DEFAULT NULL COMMENT '资源信息。例如如果resourceType为客服退款审核时，可以用来记录：允许审核的目标代理商编号。[dataRef resourceType]',
	`isForbidden` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否黑名单，即禁止访问',
	`relationStatus` INT NOT NULL COMMENT '关联状态[enum COMMON_RECORD_STATUS]',
	`createTime` BIGINT NOT NULL COMMENT '创建时间。[datetime]',
	`updateTime` BIGINT NOT NULL COMMENT '更新时间。[datetime]',
	PRIMARY KEY (`gid`),
	INDEX `index_resourceId` (`resourceId`),
	INDEX `index_resourceType` (`relationResourceType`)
)DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
COMMENT = '角色和资源的对应表，一个角色可以拥有多个资源';

DROP TABLE IF EXISTS permission_relation_role;
CREATE TABLE permission_relation_role (
	`gid` BIGINT NOT NULL COMMENT 'ID。[]',
	`userType` INT NOT NULL COMMENT '用户类型。[enum SubjectType]',
	`userId` BIGINT NOT NULL COMMENT '用户ID。[dataRef subjectType]',
	`roleId` BIGINT NOT NULL COMMENT '角色ID',
	`relationStatus` INT NOT NULL COMMENT '关联状态[enum COMMON_RECORD_STATUS]',
	`createTime` BIGINT NOT NULL COMMENT '创建时间。[datetime]',
	`updateTime` BIGINT NOT NULL COMMENT '更新时间。[datetime]',
	PRIMARY KEY (`gid`),
	INDEX `index_roleId` (`roleId`),
	INDEX `index_userId` (`userId`),
	INDEX `index_userType` (`userType`)
)DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
COMMENT = '用户和角色的对应表，一个用户可以拥有多个角色';


DROP TABLE IF EXISTS user_baseInfo;
CREATE TABLE user_baseInfo (
	`gid` BIGINT NOT NULL AUTO_INCREMENT COMMENT '用户ID。[globalId]',
	`userType` INT NOT NULL DEFAULT 0 COMMENT '用户类型。[enum UserType]',
	`userSubType` INT NOT NULL DEFAULT 0 COMMENT '用户二级类型，userType下的子类型。[enum UserType PersonUserType|PartnerUserType|StaffUserType|SystemUserType]',
	`userName` VARCHAR(32) DEFAULT NULL COMMENT '用户名',
	`passwordType` INT NOT NULL DEFAULT 0 COMMENT '加密类型。[enum PasswordType]',
	`password` VARCHAR(64) DEFAULT NULL COMMENT '加密后的用户密码',
	`payPassword` VARCHAR(64) DEFAULT NULL COMMENT '加密后的支付密码',
	`saltRandom` TEXT DEFAULT NULL COMMENT '加盐随机串',
	`saltRandomChangeTime` BIGINT DEFAULT NULL COMMENT '加盐随机串变更时间。[datetime]',
	`paySaltRandom` TEXT DEFAULT NULL COMMENT '支付密码加盐随机串',
	`paySaltRandomChangeTime` BIGINT DEFAULT NULL COMMENT '支付密码加盐随机串变更时间。[datetime]',
	`loginPasswordLastUpdateTime` BIGINT DEFAULT NULL COMMENT '登录密码上次变更时间。[datetime]',
	`payPasswordLastUpdateTime` BIGINT DEFAULT NULL COMMENT '支付密码上次变更时间。[datetime]',
	`email` VARCHAR(64) DEFAULT NULL COMMENT 'Email电子邮箱',
	`phone` VARCHAR(24) DEFAULT NULL COMMENT '手机号码',

	`isSetPassword` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否设置登录密码',
	`isSetPayPassword` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否设置支付密码',
	`emailIsVerify` TINYINT(1) NOT NULL DEFAULT 0 COMMENT 'Email电子邮箱是否已经验证',
	`phoneIsVerify` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '手机号码是否已经验证',
	`realNameIsAuthentication` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否已经实名认证',

	-- 普通个人用户的信息
	`memberPhotosId` BIGINT NOT NULL DEFAULT 0 COMMENT '用户图片文件标识id',

	-- 用户来源信息
	`sourceAppType` INT NOT NULL DEFAULT 0 COMMENT '用户来源渠道的类型。[enum AppType]',
	`sourceAppInfo` VARCHAR(128) DEFAULT NULL COMMENT '用户来源的信息。[dataRef sourceType]',
	`sourceChannelId` BIGINT NOT NULL DEFAULT 0 COMMENT '用户来源的渠道ID。',
	`invitorUserId` BIGINT DEFAULT NULL COMMENT '邀请者的用户ID',
	`registerType` INT NOT NULL DEFAULT 0 COMMENT '用户注册方式，例如通过邮箱注册、通过手机验证码注册等。[enum UserRegisterType]',

	-- 会员相关
	`memberLevel` INT NOT NULL DEFAULT 0 COMMENT '会员等级,鼓励用户活跃。[enum MemberLevel]',
	`vipLevel` INT NOT NULL DEFAULT 0 COMMENT 'VIP等级,鼓励用户付费。[enum VipLevel]',
	`errorActionLevel` INT NOT NULL DEFAULT 0 COMMENT '异常行为等级。[enum ErrorActionLevel]',

	`isActivated` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否已经激活',
	`isDisabled` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否被禁止使用。如果被禁止使用，则不允许登录。',
	`isLocked` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否被锁定。如果被锁定，则多种正常将受到限制。',
	`createTime` BIGINT NOT NULL DEFAULT 0 COMMENT '创建时间。[datetime]',
	`updateTime` BIGINT NOT NULL DEFAULT 0 COMMENT '更新时间。[datetime]',
	`activateTime` BIGINT NOT NULL DEFAULT 0 COMMENT '激活时间。[datetime]',
	PRIMARY KEY (`gid`),
	INDEX `index_userName` (`userName`),
	INDEX `index_phone` (`phone`),
	INDEX `index_email` (`email`),
	INDEX `index_invitorUserId` (`invitorUserId`),
	INDEX `index_createTime` (`createTime`),
	INDEX `index_updateTime` (`updateTime`)
)DEFAULT CHARACTER SET utf8
  DEFAULT COLLATE utf8_general_ci
COMMENT = '用户基本信息。所有用户的基本数据，包括网站用户、后台人员、代理商、管理员等等';


-- 创建角色信息
INSERT INTO `permission_role`(`gid`, `roleId`, `roleType`, `roleStatus`, `roleName`, `roleDesc`, `priority`, `createTime`, `updateTime`)
VALUES
(1, 'ROLE_ADMIM',1 , 1, '超级管理员', '拥有所有资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(2, 'ROLE_VIP',2 , 1, 'VIP用户', '拥有部分资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(3, 'ROLE_COMMEN',3 , 1, '普通用户', '拥有部分资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(4, 'ROLE_JS',3 , 1, '技术部员工', '拥有技术部资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(5, 'ROLE_CG',3 , 1, '采购部员工', '拥有采购部资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(6, 'ROLE_SC',3 , 1, '市场部员工', '拥有市场部资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(7, 'ROLE_YY',3 , 1, '运营部员工', '拥有运营部资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(8, 'ROLE_XS',3 , 1, '销售部员工', '拥有销售部资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP()),
(9, 'ROLE_SJ',3 , 1, '数据部员工', '拥有数据部资源权限', 1, UNIX_TIMESTAMP() , UNIX_TIMESTAMP());
-- 添加资源
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (1, 0, '0', '/system/*', '/system/index', 1, 1, 1, 2, '系统管理', '系统管理菜单', 1562800933, 1562800933);

INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (2, 1, '0,1', '/user/*', '/user/index', 1, 1, 2, 1, '用户管理', '用户管理主菜单', 1562799905, 1562799905);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (3, 2, '0,1,2', '/user/*', '/user/add', 2, 1, 3, 0, '添加', '用户添加按钮', 1562800039, 1562800039);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (4, 2, '0,1,2', '/user/*', '/user/detail', 2, 1, 3, 0, '详情', '用户详情按钮', 1562800248, 1562800248);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (5, 2, '0,1,2', '/user/*', '/user/edit', 2, 1, 3, 0, '编辑', '用户编辑按钮', 1562801140, 1562801140);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (6, 2, '0,1,2', '/use/*', '/user/del', 2, 1, 3, 0, '删除', '用户删除按钮', 1562801261, 1562801261);

INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (7, 1, '0,1', '/menu/*', '/menu/index', 1, 1, 2, 2, '菜单管理', '菜单管理主菜单', 1562799905, 1562799905);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (8, 7, '0,1,7', '/menu/*', '/menu/add', 2, 1, 3, 0, '添加', '菜单添加按钮', 1562800039, 1562800039);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (9, 7, '0,1,7', '/menu/*', '/menu/detail', 2, 1, 3, 0, '详情', '菜单详情按钮', 1562800248, 1562800248);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (10, 7, '0,1,7', '/menu/*', '/menu/edit', 2, 1, 3, 0, '编辑', '菜单编辑按钮', 1562801140, 1562801140);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (11, 7, '0,1,7', '/menu/*', '/menu/del', 2, 1, 3, 0, '删除', '菜单删除按钮', 1562801261, 1562801261);

INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (12, 1, '0,1', '/role/*', '/role/index', 1, 1, 2, 3, '角色管理', '角色管理主菜单', 1562799905, 1562799905);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (13, 12, '0,1,12', '/role/*', '/role/add', 2, 1, 3, 0, '添加', '角色添加按钮', 1562800039, 1562800039);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (14, 12, '0,1,12', '/role/*', '/role/detail', 2, 1, 3, 0, '详情', '角色详情按钮', 1562800248, 1562800248);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (15, 12, '0,1,12', '/role/*', '/role/edit', 2, 1, 3, 0, '编辑', '角色编辑按钮', 1562801140, 1562801140);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (16, 12, '0,1,12', '/role/*', '/role/del', 2, 1, 3, 0, '删除', '角色删除按钮', 1562801261, 1562801261);

INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (17, 1, '0,1', '/syslog/*', '/syslog/index', 1, 1, 2, 5, '日志管理', '日志管理主菜单', 1562799905, 1562799905);

INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (18, 1, '0,1', '/dict/*', '/dict/index', 1, 1, 2, 4, '字典管理', '字典管理主菜单', 1562799905, 1562799905);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (19, 18, '0,1,18', '/dict/*', '/dict/add', 2, 1, 3, 0, '添加', '字典添加按钮', 1562800039, 1562800039);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (20, 18, '0,1,18', '/dict/*', '/dict/detail', 2, 1, 3, 0, '详情', '字典详情按钮', 1562800248, 1562800248);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (21, 18, '0,1,18', '/dict/*', '/dict/edit', 2, 1, 3, 0, '编辑', '字典编辑按钮', 1562801140, 1562801140);
INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (22, 18, '0,1,18', '/dict/*', '/dict/del', 2, 1, 3, 0, '删除', '字典删除按钮', 1562801261, 1562801261);

INSERT INTO `permission_resource`(`gid`, `parentResourceId`, `parentResourceIds`, `resourceId`, `resourceHref`, `resourceType`, `resourceStatus`, `menuType`, `menuSort`, `resourceName`, `resourceDesc`, `createTime`, `updateTime`) VALUES (23, 1, '0', '/index', '/index', 1, 1, 1, 1, '主页', '主页主菜单', 1562799905, 1562799905);
--

-- 创建自增函数
DROP FUNCTION IF EXISTS increaseSeq ;
DELIMITER //
CREATE FUNCTION increaseSeq()
RETURNS INTEGER
DETERMINISTIC

BEGIN
set @peng:=IFNULL(@peng,0)+1;
RETURN  @peng ;
END//
DELIMITER ;

-- 创建资源角色关联信息 全部关联，所有角色拥有所有资源
INSERT INTO `permission_relation_resource`(`gid`, `roleType`, `roleId`, `relationResourceType`, `resourceId`, `resourceInfo`, `isForbidden`, `relationStatus`, `createTime`, `updateTime`)
select increaseSeq() as `gid`, a.roleType,a.gid,b.resourceType,b.gid,b.resourceName,0,1,UNIX_TIMESTAMP(),UNIX_TIMESTAMP()
from permission_role a LEFT JOIN permission_resource b on a.roleStatus=b.resourceStatus;


