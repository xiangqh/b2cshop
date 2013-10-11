/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : b2c_shop

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2013-10-11 19:26:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b2c_admin`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_admin`;
CREATE TABLE `b2c_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `create_ime` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `last_ip` varchar(255) DEFAULT NULL,
  `last_time` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `role_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK28D892638D066E6` (`role_id`),
  CONSTRAINT `FK28D892638D066E6` FOREIGN KEY (`role_id`) REFERENCES `b2c_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_admin
-- ----------------------------

-- ----------------------------
-- Table structure for `b2c_menu`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_menu`;
CREATE TABLE `b2c_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `level` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC78853CB3223171B` (`parent_id`),
  CONSTRAINT `FKC78853CB3223171B` FOREIGN KEY (`parent_id`) REFERENCES `b2c_menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_menu
-- ----------------------------
INSERT INTO `b2c_menu` VALUES ('0', '0', 'root', 'url', null);
INSERT INTO `b2c_menu` VALUES ('1', '1', '系统管理', 'url', '0');
INSERT INTO `b2c_menu` VALUES ('2', '1', '内容管理', 'url', '0');
INSERT INTO `b2c_menu` VALUES ('3', '1', '商品管理', 'url', '0');
INSERT INTO `b2c_menu` VALUES ('4', '1', '促销管理', 'url', '0');
INSERT INTO `b2c_menu` VALUES ('5', '1', '会员管理', 'url', '0');
INSERT INTO `b2c_menu` VALUES ('6', '1', '运营统计', null, '0');

-- ----------------------------
-- Table structure for `b2c_role`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_role`;
CREATE TABLE `b2c_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `rights` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_role
-- ----------------------------
