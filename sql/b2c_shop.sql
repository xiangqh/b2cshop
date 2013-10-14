/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 40122
Source Host           : localhost:3306
Source Database       : b2c_shop

Target Server Type    : MYSQL
Target Server Version : 40122
File Encoding         : 65001

Date: 2013-10-15 00:08:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b2c_mall`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_mall`;
CREATE TABLE `b2c_mall` (
  `id` bigint(20) NOT NULL auto_increment,
  `address` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `goods_no_pre` varchar(255) default NULL,
  `index_seo_description` varchar(255) default NULL,
  `index_seo_keywords` varchar(255) default NULL,
  `logo` varchar(255) default NULL,
  `master` varchar(255) default NULL,
  `mobile` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `phone` varchar(255) default NULL,
  `qq` varchar(255) default NULL,
  `url` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_mall
-- ----------------------------
INSERT INTO `b2c_mall` VALUES ('1', '123', '123@126.com', '123', '123', '123', null, '123', '123', '123', '123', '123', 'http://127.0.0.1:9998/b2cshop');

-- ----------------------------
-- Table structure for `b2c_mall_setting`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_mall_setting`;
CREATE TABLE `b2c_mall_setting` (
  `id` bigint(20) NOT NULL auto_increment,
  `mall_id` int(11) default NULL,
  `setting_key` varchar(255) default NULL,
  `setting_value` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_mall_setting
-- ----------------------------

-- ----------------------------
-- Table structure for `b2c_menu`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_menu`;
CREATE TABLE `b2c_menu` (
  `id` bigint(20) NOT NULL auto_increment,
  `level` int(11) default NULL,
  `name` varchar(255) default NULL,
  `parent_id` bigint(20) default NULL,
  `url` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKC78853CB3223171B` (`parent_id`),
  CONSTRAINT `FKC78853CB3223171B` FOREIGN KEY (`parent_id`) REFERENCES `b2c_menu` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_menu
-- ----------------------------
INSERT INTO `b2c_menu` VALUES ('1', '1', '系统管理', null, 'b2cshop/showWorkers');
INSERT INTO `b2c_menu` VALUES ('2', '1', '内容管理', null, null);
INSERT INTO `b2c_menu` VALUES ('3', '1', '商品管理', null, null);
INSERT INTO `b2c_menu` VALUES ('4', '1', '促销管理', null, null);
INSERT INTO `b2c_menu` VALUES ('5', '1', '会员管理', null, null);
INSERT INTO `b2c_menu` VALUES ('6', '1', '运营统计', null, null);
INSERT INTO `b2c_menu` VALUES ('7', '2', '权限设置', '1', 'b2cshop/showWorkers');
INSERT INTO `b2c_menu` VALUES ('8', '2', '基础设置', '1', 'b2cshop/showMallInfo');
INSERT INTO `b2c_menu` VALUES ('9', '3', '基本信息设置', '8', 'b2cshop/showMallInfo');
INSERT INTO `b2c_menu` VALUES ('10', '3', '图片设置', '8', '1');
INSERT INTO `b2c_menu` VALUES ('11', '3', '商品设置', '8', '1');
INSERT INTO `b2c_menu` VALUES ('12', '3', '支付设置', '8', '1');
INSERT INTO `b2c_menu` VALUES ('13', '3', '邮件设置', '8', '1');
INSERT INTO `b2c_menu` VALUES ('14', '3', '配送设置', '8', '1');

-- ----------------------------
-- Table structure for `b2c_role`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_role`;
CREATE TABLE `b2c_role` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `rights` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_role
-- ----------------------------
INSERT INTO `b2c_role` VALUES ('1', '超级管理员', '1,2,3,4,5,6');
INSERT INTO `b2c_role` VALUES ('2', '测试组我', '1,2,3,4,5,6');

-- ----------------------------
-- Table structure for `b2c_worker`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_worker`;
CREATE TABLE `b2c_worker` (
  `id` bigint(20) NOT NULL auto_increment,
  `create_ime` datetime default NULL,
  `email` varchar(255) default NULL,
  `last_ip` varchar(255) default NULL,
  `last_time` varchar(255) default NULL,
  `password` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `role_id` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK1861A6EA8D066E6` (`role_id`),
  CONSTRAINT `FK1861A6EA8D066E6` FOREIGN KEY (`role_id`) REFERENCES `b2c_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_worker
-- ----------------------------
INSERT INTO `b2c_worker` VALUES ('6', '2013-10-14 18:08:06', '111@126.com', null, null, '111111', '111111', '1');
INSERT INTO `b2c_worker` VALUES ('9', '2013-10-14 18:13:43', '111@126.com', null, null, '111111', '222222', '1');
INSERT INTO `b2c_worker` VALUES ('10', '2013-10-14 18:25:49', '111@126.com', null, null, '123456', '333333', '2');
