/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : b2c_shop

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2013-10-14 18:32:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b2c_menu`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_menu`;
CREATE TABLE `b2c_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC78853CB3223171B` (`parent_id`),
  CONSTRAINT `FKC78853CB3223171B` FOREIGN KEY (`parent_id`) REFERENCES `b2c_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

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
INSERT INTO `b2c_menu` VALUES ('8', '2', '基础设置', '1', null);

-- ----------------------------
-- Table structure for `b2c_role`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_role`;
CREATE TABLE `b2c_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `rights` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_ime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  `last_time` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1861A6EA8D066E6` (`role_id`),
  CONSTRAINT `FK1861A6EA8D066E6` FOREIGN KEY (`role_id`) REFERENCES `b2c_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_worker
-- ----------------------------
INSERT INTO `b2c_worker` VALUES ('6', '2013-10-14 18:08:06', '111@126.com', null, null, '111111', '111111', '1');
INSERT INTO `b2c_worker` VALUES ('9', '2013-10-14 18:13:43', '111@126.com', null, null, '111111', '222222', '1');
INSERT INTO `b2c_worker` VALUES ('10', '2013-10-14 18:25:49', '111@126.com', null, null, '123456', '333333', '2');
