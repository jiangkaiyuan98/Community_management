/*
 Navicat Premium Data Transfer

 Source Server         : abc
 Source Server Type    : MySQL
 Source Server Version : 50726
 Source Host           : localhost
 Source Database       : Community_management

 Target Server Type    : MySQL
 Target Server Version : 50726
 File Encoding         : utf-8

 Date: 12/30/2019 13:35:14 PM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `activate`
-- ----------------------------
DROP TABLE IF EXISTS `activate`;
CREATE TABLE `activate` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `comId` int(10) DEFAULT NULL,
  `state` int(10) NOT NULL DEFAULT '0' COMMENT '活动审批状态，0未审批，1通过',
  `description` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `com_id` (`comId`),
  CONSTRAINT `activate_ibfk_1` FOREIGN KEY (`comId`) REFERENCES `community` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `activate`
-- ----------------------------
BEGIN;
INSERT INTO `activate` VALUES ('1', '滑', '5', '1', '这个滑是轮滑'), ('4', '斗地主', '1', '1', '2=1'), ('5', '三国杀', '1', '1', '7=1'), ('19', '唱歌', '5', '0', '唱歌'), ('25', '合唱', '5', '0', '54青年节'), ('30', 'qui', '21', '0', '123'), ('31', 'aa', '5', '0', 'bbb'), ('32', 'abc', '5', '0', 'ccc'), ('33', 'abcaa', '5', '0', 'ccc');
COMMIT;

-- ----------------------------
--  Table structure for `activity_members`
-- ----------------------------
DROP TABLE IF EXISTS `activity_members`;
CREATE TABLE `activity_members` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `activateId` int(10) DEFAULT NULL,
  `stuId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `activateId` (`activateId`),
  KEY `stuId` (`stuId`),
  CONSTRAINT `activity_members_ibfk_1` FOREIGN KEY (`activateId`) REFERENCES `activate` (`id`),
  CONSTRAINT `activity_members_ibfk_2` FOREIGN KEY (`stuId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `activity_members`
-- ----------------------------
BEGIN;
INSERT INTO `activity_members` VALUES ('1', '1', '7');
COMMIT;

-- ----------------------------
--  Table structure for `community`
-- ----------------------------
DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `presidentId` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `president_id` (`presidentId`),
  CONSTRAINT `community_ibfk_1` FOREIGN KEY (`presidentId`) REFERENCES `student` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `community`
-- ----------------------------
BEGIN;
INSERT INTO `community` VALUES ('1', '桌游社', '4'), ('5', '轮滑社', '1'), ('21', '篮球社', '6');
COMMIT;

-- ----------------------------
--  Table structure for `community_members`
-- ----------------------------
DROP TABLE IF EXISTS `community_members`;
CREATE TABLE `community_members` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `comId` int(10) NOT NULL,
  `stuId` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `com_id` (`comId`),
  KEY `stu_id` (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `community_members`
-- ----------------------------
BEGIN;
INSERT INTO `community_members` VALUES ('1', '5', '1'), ('5', '1', '1'), ('6', '1', '7'), ('7', '1', '4'), ('9', '18', '6'), ('10', '18', '1'), ('13', '21', '6');
COMMIT;

-- ----------------------------
--  Table structure for `join_activity_members`
-- ----------------------------
DROP TABLE IF EXISTS `join_activity_members`;
CREATE TABLE `join_activity_members` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `activateId` int(10) NOT NULL,
  `stuId` int(10) NOT NULL,
  `state` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `activate_id` (`activateId`),
  KEY `stu_id` (`stuId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `join_activity_members`
-- ----------------------------
BEGIN;
INSERT INTO `join_activity_members` VALUES ('2', '1', '1', '1'), ('4', '4', '4', '1'), ('5', '5', '1', '0'), ('6', '4', '1', '0'), ('7', '1', '7', '1');
COMMIT;

-- ----------------------------
--  Table structure for `join_community`
-- ----------------------------
DROP TABLE IF EXISTS `join_community`;
CREATE TABLE `join_community` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `stuId` int(10) NOT NULL,
  `comId` int(10) NOT NULL,
  `state` int(10) NOT NULL DEFAULT '0' COMMENT '0,1',
  PRIMARY KEY (`id`),
  KEY `stu_id` (`stuId`),
  KEY `com_id` (`comId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `join_community`
-- ----------------------------
BEGIN;
INSERT INTO `join_community` VALUES ('6', '4', '1', '1'), ('8', '1', '1', '1'), ('10', '7', '1', '1'), ('13', '7', '5', '1'), ('15', '6', '5', '2'), ('16', '7', '21', '0'), ('17', '1', '21', '0');
COMMIT;

-- ----------------------------
--  Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `username` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `password` varchar(20) CHARACTER SET utf8 NOT NULL DEFAULT '0',
  `identity` int(11) NOT NULL DEFAULT '2' COMMENT '身份表0代表管理员，1代表社长，2代表普通成员(待定)',
  `description` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `identity` (`identity`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
--  Records of `student`
-- ----------------------------
BEGIN;
INSERT INTO `student` VALUES ('1', '刘雨', '20166004', '0', '1', '这是一只刘雨'), ('2', '姜凯元', '20166007', '0', '0', '这是管理员'), ('3', '李泽林', '20166015', '0', '2', '这是'), ('4', '王宇婷', '20166006', '0', '1', '这是一个组员'), ('5', '关宪帅', '20166041', '0', '2', '903501组员'), ('6', '秦朋', '1', '0', '1', 'asdf'), ('7', '杨权', '0', '0', '2', 'safg');
COMMIT;

-- ----------------------------
--  Table structure for `student_fuction`
-- ----------------------------
DROP TABLE IF EXISTS `student_fuction`;
CREATE TABLE `student_fuction` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `roleId` int(10) DEFAULT NULL,
  `functionHref` varchar(40) DEFAULT NULL,
  `function_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`roleId`),
  CONSTRAINT `student_fuction_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `student` (`identity`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
