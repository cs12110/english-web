/*
Navicat MySQL Data Transfer

Source Server         : 10.10.2.233
Source Server Version : 50717
Source Host           : 10.10.2.233:3306
Source Database       : english_web

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-08-21 16:51:54
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for content_t
-- ----------------------------
DROP TABLE IF EXISTS `content_t`;
CREATE TABLE `content_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(256) DEFAULT NULL COMMENT 'name',
  `summary` varchar(256) DEFAULT NULL COMMENT 'summary',
  `content` varchar(1024) DEFAULT NULL COMMENT 'content',
  `create_time` varchar(32) DEFAULT NULL COMMENT 'create time',
  `update_time` varchar(32) DEFAULT NULL COMMENT 'update time',
  `order_num` int(11) DEFAULT NULL COMMENT 'order num',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of content_t
-- ----------------------------

-- ----------------------------
-- Table structure for customer_t
-- ----------------------------
DROP TABLE IF EXISTS `customer_t`;
CREATE TABLE `customer_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `code` varchar(255) DEFAULT NULL COMMENT '学号',
  `cet4` int(11) DEFAULT NULL COMMENT '四级成绩',
  `cet6` varchar(255) DEFAULT NULL COMMENT '六级成绩',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `eng_age` int(11) DEFAULT NULL COMMENT '学习英语成绩',
  `major` varchar(255) DEFAULT NULL COMMENT '四级专业',
  `gender` int(1) DEFAULT NULL COMMENT '性别,0:男,1:女',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) DEFAULT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统用户_角色关联表';

-- ----------------------------
-- Records of map_user_role
-- ----------------------------
INSERT INTO `map_user_role` VALUES ('1', '1', '1');

-- ----------------------------
-- Table structure for progress_t
-- ----------------------------
DROP TABLE IF EXISTS `progress_t`;
CREATE TABLE `progress_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paper` int(2) NOT NULL COMMENT '试卷类型',
  `name` varchar(32) NOT NULL,
  `open` int(2) DEFAULT NULL COMMENT '是否打开测试,0:否,1:是',
  `op_time` varchar(32) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of progress_t
-- ----------------------------
INSERT INTO `progress_t` VALUES ('1', '1', '前测', '1', '2018-08-21 16:42:49');
INSERT INTO `progress_t` VALUES ('2', '2', '学习1', '0', '2018-08-21 16:42:36');
INSERT INTO `progress_t` VALUES ('3', '3', '学习2', '0', '2018-08-21 16:09:11');
INSERT INTO `progress_t` VALUES ('4', '4', '后测', '0', '2018-08-21 16:09:11');
INSERT INTO `progress_t` VALUES ('5', '5', '追踪', '0', '2018-08-21 16:09:11');

-- ----------------------------
-- Table structure for score_t
-- ----------------------------
DROP TABLE IF EXISTS `score_t`;
CREATE TABLE `score_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cus_id` int(11) NOT NULL,
  `sub_id` int(11) NOT NULL,
  `correct` int(11) DEFAULT NULL,
  `stopwatch` text COMMENT '每个单词的查看时间',
  `paper` int(2) DEFAULT NULL COMMENT '试卷类型',
  `sub_type` int(5) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `customerIndex` (`cus_id`),
  KEY `subjectIndex` (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score_t
-- ----------------------------
INSERT INTO `score_t` VALUES ('1', '11', '10', '1', 'at#217,accent.#274,laughs#215,Everybody#255,my#223,', null, null);
INSERT INTO `score_t` VALUES ('2', '11', '12', '1', 'The#215,situation#248,calls#842,for#550,prompt#2456,action.#2368', null, null);
INSERT INTO `score_t` VALUES ('3', '11', '1948', '1', 'Susan#207,always#185,finish#208,her#190,work#209,slowly.#191', null, null);
INSERT INTO `score_t` VALUES ('4', '11', '1951', '0', 'This#584,text#271,illuminate#329,the#536,philosopher\'s#255,early#224,thinking.#608', null, null);

-- ----------------------------
-- Table structure for subject_t
-- ----------------------------
DROP TABLE IF EXISTS `subject_t`;
CREATE TABLE `subject_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sentence` varchar(1024) DEFAULT NULL COMMENT '句子',
  `keyword` varchar(512) DEFAULT NULL COMMENT '关键字',
  `type` int(3) DEFAULT NULL COMMENT '类型',
  `question` varchar(255) DEFAULT NULL COMMENT '问题',
  `answer` varchar(5) DEFAULT NULL COMMENT '答案',
  `paper` int(2) DEFAULT NULL COMMENT '1:前测,2:学习1,3:学习2,4:后测,5:追踪',
  `origin` varchar(1024) DEFAULT NULL COMMENT '原句子',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(64) DEFAULT NULL COMMENT '角色编码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='系统角色表';

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('1', 'admin', 'ROLE_ADMIN');

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(128) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '登录密码',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='系统用户表';

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('1', '3306', 'e10adc3949ba59abbe56e057f20f883e');
INSERT INTO `sys_user` VALUES ('2', 'admin', '21232f297a57a5a743894a0e4a801fc3');
