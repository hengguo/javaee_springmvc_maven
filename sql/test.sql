/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50173
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2014-11-10 14:56:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `code`
-- ----------------------------
DROP TABLE IF EXISTS `code`;
CREATE TABLE `code` (
  `code_id` varchar(16) NOT NULL,
  `code_name` varchar(20) NOT NULL,
  `editable` tinyint(1) NOT NULL,
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code
-- ----------------------------
INSERT INTO `code` VALUES ('dg', '测试', '1');

-- ----------------------------
-- Table structure for `code_setting`
-- ----------------------------
DROP TABLE IF EXISTS `code_setting`;
CREATE TABLE `code_setting` (
  `code_id` varchar(16) NOT NULL,
  `code_key` varchar(30) NOT NULL,
  `code_value` varchar(30) NOT NULL,
  PRIMARY KEY (`code_id`,`code_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of code_setting
-- ----------------------------
INSERT INTO `code_setting` VALUES ('dg', '8', '8');
INSERT INTO `code_setting` VALUES ('dg', '9', '9');

-- ----------------------------
-- Table structure for `group_info`
-- ----------------------------
DROP TABLE IF EXISTS `group_info`;
CREATE TABLE `group_info` (
  `g_id` int(11) NOT NULL AUTO_INCREMENT,
  `g_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `g_createdate` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `g_state` int(1) DEFAULT '0' COMMENT '0:可见;1:不可见',
  PRIMARY KEY (`g_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of group_info
-- ----------------------------
INSERT INTO `group_info` VALUES ('2', '22', '2014-08-28 10:01:03', '0');
INSERT INTO `group_info` VALUES ('4', '44', '2014-08-28 10:01:12', '4');
INSERT INTO `group_info` VALUES ('6', '66', '2014-08-28 10:01:17', '0');
INSERT INTO `group_info` VALUES ('8', '88', '2014-08-28 10:01:29', '0');

-- ----------------------------
-- Table structure for `menu`
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` varchar(64) NOT NULL DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `pid` varchar(64) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('001', '菜单01', null, null);
INSERT INTO `menu` VALUES ('00101', '页面1', '001', '/menu01/page1');
INSERT INTO `menu` VALUES ('00102', 'jstl测试页面', '001', '/flights/specials');
INSERT INTO `menu` VALUES ('00103', '可编辑表格行', '001', '/user/editableDatagridView2');
INSERT INTO `menu` VALUES ('002', '菜单02', null, null);
INSERT INTO `menu` VALUES ('00201', '动态生成datagrid列', '002', '/user/dynamicUserView');
INSERT INTO `menu` VALUES ('00202', '页面04', '002', '');
INSERT INTO `menu` VALUES ('00203', '学习例子', '00202', '/flights/specials');
INSERT INTO `menu` VALUES ('00204', '可编辑表格行', '002', '/user/editableDatagridView');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` varchar(32) NOT NULL,
  `s_name` varchar(10) DEFAULT NULL,
  `s_gender` varchar(4) DEFAULT NULL,
  `s_major` varchar(30) DEFAULT NULL,
  `s_grade` varchar(30) DEFAULT NULL,
  `s_supervisor_id` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('23638175452758016', '学生16', '女', '计算机', 'ggggg', '23638175452758017');
INSERT INTO `student` VALUES ('23638175452758017', '李林', '男', '计算机科学与技术', 'ggggg', '23638175452758017');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `t_id` varchar(32) NOT NULL,
  `t_name` varchar(10) DEFAULT NULL,
  `t_gender` varchar(4) DEFAULT NULL,
  `t_research_area` varchar(100) DEFAULT NULL,
  `t_title` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`t_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('23638175452758017', '李顺子', '男', '软件', '讲师');
INSERT INTO `teacher` VALUES ('23638175452758018', '张花', '女', '硬件', '副教授');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_password` varchar(20) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `u_createtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'a', 'adf', '2014-09-18 11:55:15');
INSERT INTO `user` VALUES ('3', '33', '33', '2014-08-28 10:00:45');
INSERT INTO `user` VALUES ('5', '55', '55', '2014-08-28 10:00:53');
INSERT INTO `user` VALUES ('99', 'b', 'b', '2014-11-10 12:42:30');
INSERT INTO `user` VALUES ('100', 'c', 'c', '2014-09-25 10:46:51');
INSERT INTO `user` VALUES ('101', 'd', 'd', '2014-09-25 10:46:51');

-- ----------------------------
-- Table structure for `user_group`
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `ug_u_id` int(11) NOT NULL DEFAULT '0',
  `ug_g_id` int(11) DEFAULT NULL,
  `ug_createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ug_u_id`,`ug_createtime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_group
-- ----------------------------
INSERT INTO `user_group` VALUES ('1', '4', '0000-00-00 00:00:00');
INSERT INTO `user_group` VALUES ('1', '2', '2014-08-28 10:01:59');
INSERT INTO `user_group` VALUES ('3', '6', '0000-00-00 00:00:00');
INSERT INTO `user_group` VALUES ('5', '6', '2014-08-28 10:02:41');
INSERT INTO `user_group` VALUES ('7', '5', '0000-00-00 00:00:00');

-- ----------------------------
-- View structure for `v_code`
-- ----------------------------
DROP VIEW IF EXISTS `v_code`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `v_code` AS select `code_setting`.`code_id` AS `code_id`,`code_setting`.`code_key` AS `code_key`,`code_setting`.`code_value` AS `code_value`,`code`.`code_name` AS `code_name` from (`code_setting` join `code` on((`code`.`code_id` = `code_setting`.`code_id`))) ;
