/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 80012
 Source Host           : localhost:3306
 Source Schema         : filemanagement

 Target Server Type    : MySQL
 Target Server Version : 80012
 File Encoding         : 65001

 Date: 29/10/2019 09:56:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_dept
-- ----------------------------
DROP TABLE IF EXISTS `t_dept`;
CREATE TABLE `t_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_dept
-- ----------------------------
BEGIN;
INSERT INTO `t_dept` VALUES (1, '南昌市', 1);
INSERT INTO `t_dept` VALUES (2, '南昌市图书馆', 1);
INSERT INTO `t_dept` VALUES (3, '新建区图书馆', 1);
INSERT INTO `t_dept` VALUES (100, '当代江西', NULL);
COMMIT;

-- ----------------------------
-- Table structure for t_fileaddress
-- ----------------------------
DROP TABLE IF EXISTS `t_fileaddress`;
CREATE TABLE `t_fileaddress` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `url` varchar(500) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `is_delete` int(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_fileaddress
-- ----------------------------
BEGIN;
INSERT INTO `t_fileaddress` VALUES (1, '测试书籍', 'http://iii31.cn/O2Q3S1', '书籍', 0, '2019-10-24 16:21:16', 1);
INSERT INTO `t_fileaddress` VALUES (2, '测试书籍2', 'http://iii31.cn/O2Q3S1', '书籍', 0, '2019-10-25 08:37:27', 100);
COMMIT;

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
BEGIN;
INSERT INTO `t_permission` VALUES (1, 'back/file/addFile;file:add;file:delete;file:addFile', 1);
INSERT INTO `t_permission` VALUES (2, '*', 100);
COMMIT;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `insert_time` datetime DEFAULT NULL,
  `is_delete` int(255) DEFAULT NULL,
  `dept_id` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
BEGIN;
INSERT INTO `t_user` VALUES (1, 'admin', 'AB2385DD1F310B9C2995687B10162B73', '2019-10-23 16:00:01', 0, 1, '1206966083@qq.com');
INSERT INTO `t_user` VALUES (2, 'chaoxing', 'AB2385DD1F310B9C2995687B10162B73', '2019-10-25 08:33:09', 0, 100, '1206966083@163.com');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
