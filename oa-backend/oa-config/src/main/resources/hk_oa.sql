/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50724
 Source Host           : localhost:3306
 Source Schema         : hk_oa

 Target Server Type    : MySQL
 Target Server Version : 50724
 File Encoding         : 65001

 Date: 29/08/2019 17:50:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth_department
-- ----------------------------
DROP TABLE IF EXISTS `auth_department`;
CREATE TABLE `auth_department` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `name` varchar(255) DEFAULT '' COMMENT '名称',
  `parent_id` bigint(20) DEFAULT '0' COMMENT '父ID',
  `sort_value` int(11) DEFAULT '1' COMMENT '排序',
  `status` bit(1) DEFAULT b'1' COMMENT '状态',
  `describe_` varchar(255) DEFAULT '' COMMENT '描述',
  `create_time` datetime DEFAULT NULL,
  `create_user` int(11) DEFAULT NULL,
  `leader` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='部门';

-- ----------------------------
-- Table structure for auth_menu
-- ----------------------------
DROP TABLE IF EXISTS `auth_menu`;
CREATE TABLE `auth_menu` (
  `id` int(11) NOT NULL COMMENT '主键',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '菜单名称',
  `describe` varchar(200) DEFAULT '' COMMENT '功能描述',
  `code` varchar(255) DEFAULT '' COMMENT '资源编码',
  `is_public` bit(1) DEFAULT b'0' COMMENT '是否公开菜单\r\n就是无需分配就可以访问的。所有人可见',
  `href` varchar(255) DEFAULT '' COMMENT '资源路径',
  `target` varchar(9) DEFAULT 'SELF' COMMENT '打开方式\r\n#TargetType{SELF:_self,相同框架;TOP:_top,当前页;BLANK:_blank,新建窗口;PAREN:_parent,父窗口}',
  `is_enable` bit(1) DEFAULT b'1' COMMENT '是否启用',
  `sort_value` int(11) DEFAULT '1' COMMENT '排序',
  `icon` varchar(255) DEFAULT '' COMMENT '菜单图标',
  `parent_id` int(11) DEFAULT '0' COMMENT '父级菜单id',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` int(11) DEFAULT NULL COMMENT '更新人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UN_CODE` (`code`) USING BTREE COMMENT '编码唯一'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='菜单';

-- ----------------------------
-- Table structure for auth_role
-- ----------------------------
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role` (
  `id` int(11) NOT NULL,
  `name` varchar(30) DEFAULT '' COMMENT '角色名称',
  `code` varchar(20) DEFAULT '' COMMENT '角色编码',
  `describe` varchar(100) DEFAULT '' COMMENT '功能描述',
  `is_enable` bit(1) DEFAULT b'1' COMMENT '是否启用',
  `ds_type` int(11) DEFAULT '5' COMMENT '数据权限类型{1,全部;2,本级;3,本级以及子级;4,自定义;5,个人;}',
  `create_user` int(11) DEFAULT '0' COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` int(11) DEFAULT '0' COMMENT '更新人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UN_CODE` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='角色';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(30) NOT NULL COMMENT '账号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `department_id` int(11) NOT NULL COMMENT '部门ID\n#c_core_org',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `mobile` varchar(20) DEFAULT '' COMMENT '手机',
  `sex` varchar(1) DEFAULT 'M' COMMENT '性别\n#Sex{W:女;M:男}',
  `is_can_login` bit(1) DEFAULT b'1' COMMENT '是否可登陆',
  `is_delete` bit(1) DEFAULT b'0' COMMENT '删除标记',
  `photo` varchar(255) DEFAULT '' COMMENT '照片',
  `work_describe` varchar(255) DEFAULT '' COMMENT '工作描述\r\n比如：  市长、管理员、局长等等   用于登陆展示',
  `continuation_error_day` date DEFAULT NULL COMMENT '输入密码错误的日期\r\n比如20190102  与error_count合力实现一天输入密码错误次数限制',
  `continuation_error_count` int(11) DEFAULT '0' COMMENT '一天连续输错密码次数',
  `password` varchar(64) NOT NULL DEFAULT '' COMMENT '密码',
  `create_user` bigint(20) DEFAULT '0' COMMENT '创建人id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_user` bigint(20) DEFAULT '0' COMMENT '更新人id',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `UN_ACCOUNT` (`account`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'admin', 'admin', 1, 1, '13344459494', 'M', b'1', b'0', '', '', NULL, 0, '$2a$12$Lm.iJEskM0YQnQfcLTq7dOTrqN0etzK2zCHXi..AscKmZ1PFGHFDu', 0, NULL, 0, NULL, NULL);
INSERT INTO `user` VALUES (5, 'qqq', '里斯', 0, 0, '', '', b'1', b'1', '', '', NULL, 0, '', 0, '2019-08-28 21:44:08', 0, NULL, '');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
