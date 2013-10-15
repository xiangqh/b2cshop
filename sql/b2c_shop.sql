/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50524
Source Host           : localhost:3306
Source Database       : b2c_shop

Target Server Type    : MYSQL
Target Server Version : 50524
File Encoding         : 65001

Date: 2013-10-15 18:30:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b2c_mall`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_mall`;
CREATE TABLE `b2c_mall` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `goods_no_pre` varchar(255) DEFAULT NULL,
  `index_seo_description` varchar(255) DEFAULT NULL,
  `index_seo_keywords` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `master` varchar(255) DEFAULT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_mall
-- ----------------------------
INSERT INTO `b2c_mall` VALUES ('1', '123', '123@126.com', '123', '123', '123', null, '123', '123', '123', '123', '123', 'http://127.0.0.1:9998/b2cshop');

-- ----------------------------
-- Table structure for `b2c_mall_setting`
-- ----------------------------
DROP TABLE IF EXISTS `b2c_mall_setting`;
CREATE TABLE `b2c_mall_setting` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `mall_id` int(11) DEFAULT NULL,
  `setting_key` varchar(255) DEFAULT NULL,
  `setting_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b2c_mall_setting
-- ----------------------------
INSERT INTO `b2c_mall_setting` VALUES ('1', '1', 'ship_setting', '{\"fastPost\":10,\"slowPost\":10,\"ems\":10}');
INSERT INTO `b2c_mall_setting` VALUES ('2', '1', 'image_setting', '{\"img1\":{\"height\":940,\"width\":940},\"img2\":{\"height\":470,\"width\":470},\"img3\":{\"height\":20,\"width\":20},\"img4\":{\"height\":160,\"width\":160},\"img5\":{\"height\":100,\"width\":100}}');
INSERT INTO `b2c_mall_setting` VALUES ('3', '1', 'goods_setting', '{\"can_shelves\":1,\"shelves_on\":0,\"stock0_buy\":1}');
INSERT INTO `b2c_mall_setting` VALUES ('4', '1', 'mail_setting', '{\"email\":\"1234@shop.com\",\"smtpServer\":\"smtp.163.com\",\"pwd\":\"123\",\"isCheck\":1}');
INSERT INTO `b2c_mall_setting` VALUES ('5', '1', 'pay_setting', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

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
INSERT INTO `b2c_menu` VALUES ('10', '3', '图片设置', '8', 'b2cshop/showImageSetting');
INSERT INTO `b2c_menu` VALUES ('11', '3', '商品设置', '8', 'b2cshop/showGoodsSetting');
INSERT INTO `b2c_menu` VALUES ('12', '3', '支付设置', '8', 'b2cshop/showPaySetting');
INSERT INTO `b2c_menu` VALUES ('13', '3', '邮件设置', '8', 'b2cshop/showMailSetting');
INSERT INTO `b2c_menu` VALUES ('14', '3', '配送设置', '8', 'b2cshop/showShipSetting');

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
