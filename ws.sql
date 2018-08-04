/*
Navicat MySQL Data Transfer

Source Server         : localhost@3306
Source Server Version : 50639
Source Host           : localhost:3306
Source Database       : ws

Target Server Type    : MYSQL
Target Server Version : 50639
File Encoding         : 65001

Date: 2018-04-12 15:08:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_collection`
-- ----------------------------
DROP TABLE IF EXISTS `t_collection`;
CREATE TABLE `t_collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `god_id` int(11) DEFAULT NULL,
  `collector_id` int(11) DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5592F3494A9B7034` (`god_id`),
  KEY `FK5592F3495EF9891E` (`collector_id`),
  CONSTRAINT `FK5592F3494A9B7034` FOREIGN KEY (`god_id`) REFERENCES `t_gods` (`id`),
  CONSTRAINT `FK5592F3495EF9891E` FOREIGN KEY (`collector_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_collection
-- ----------------------------
INSERT INTO `t_collection` VALUES ('2', '18', '3', '2018-03-05 03-48-46');
INSERT INTO `t_collection` VALUES ('4', '17', '4', '2018-03-05 08-58-39');
INSERT INTO `t_collection` VALUES ('6', '16', '3', '2018-03-07 06-13-24');
INSERT INTO `t_collection` VALUES ('8', '15', '3', '2018-03-07 06-28-01');
INSERT INTO `t_collection` VALUES ('9', '21', '3', '2018-03-09 03-32-50');

-- ----------------------------
-- Table structure for `t_comments`
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comter_id` int(11) DEFAULT NULL,
  `god_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK92C4515F4A9B7034` (`god_id`),
  KEY `FK92C4515FAFF699CB` (`comter_id`),
  CONSTRAINT `FK92C4515F4A9B7034` FOREIGN KEY (`god_id`) REFERENCES `t_gods` (`id`),
  CONSTRAINT `FK92C4515FAFF699CB` FOREIGN KEY (`comter_id`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_comments
-- ----------------------------
INSERT INTO `t_comments` VALUES ('1', '这手机有啥问题没?', '2018-03-05 09-05-27', '4', '19');
INSERT INTO `t_comments` VALUES ('2', '12324324', '2018-03-07 06-34-49', '3', '16');
INSERT INTO `t_comments` VALUES ('3', '有发票没>?', '2018-03-09 03-29-53', '3', '21');
INSERT INTO `t_comments` VALUES ('4', '去你吗的评论', '2018-03-16 03:35:29', '77', '21');

-- ----------------------------
-- Table structure for `t_gods`
-- ----------------------------
DROP TABLE IF EXISTS `t_gods`;
CREATE TABLE `t_gods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `disc` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img1` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img2` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img3` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `img4` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` double DEFAULT NULL,
  `state` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `clickTime` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKCB5D6062FD20FC9C` (`pid`),
  CONSTRAINT `FKCB5D6062FD20FC9C` FOREIGN KEY (`pid`) REFERENCES `t_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_gods
-- ----------------------------
INSERT INTO `t_gods` VALUES ('15', '2018-03-04', 'fff', '8(PNGV)W}ZLO5G5N}@3IV_F.jpg', 'LB@D]ZFUVMXZV~R8{%WZPOG.jpg', 'login_background.png', 'Y@U[2$[CFOIJ0W)V9[ATRRA.jpg', 'fff', '123', '0', '3', '其他', '2');
INSERT INTO `t_gods` VALUES ('16', '2018-03-05', '香甜可口的红富士', '123.jpg', 'baidu.jpg', 'detail.jpg', '下载.jpg', '苹果', '2.5', '2', '3', '生活用品', '0');
INSERT INTO `t_gods` VALUES ('17', '2018-03-05', '香甜可口的菠萝', '312.jpg', '324.jpg', '334.jpg', '342.jpg', '菠萝', '3.5', '2', '4', '生活用品', '0');
INSERT INTO `t_gods` VALUES ('18', '2018-03-05', '只穿过一次,', '6555.jpg', 'baidu (2).jpg', '656.jpg', 'detail (2).jpg', '9成新衣服', '50', '0', '4', '文体用品', '11');
INSERT INTO `t_gods` VALUES ('19', '2018-03-05', '买了iphoneX之前的手机用了一年.留着没用了', '321c.jpg', '123123 (2).jpg', 'baidu (3).jpg', 'tt1.jpg', 'iphone6s', '4000', '0', '5', '数码电子', '5');
INSERT INTO `t_gods` VALUES ('20', '2018-03-05', '各种品牌的牙膏', '767.jpg', '123123.jpg', '323232.jpg', 'detail (3).jpg', '牙膏', '15', '1', '5', '生活用品', '0');
INSERT INTO `t_gods` VALUES ('21', '2018-03-09', '用了一年,没时间用', 'bvcb.jpg', 'dvd.jpg', '312312.jpg', 'vcbvc.jpg', '佳能照相机', '12000', '0', '6', '数码电子', '51');

-- ----------------------------
-- Table structure for `t_notice`
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `filename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '草拟吗的第一条 新闻', '2018-03-14 03:02:39', '', '第一条新闻');
INSERT INTO `t_notice` VALUES ('2', '应该不会出问题了吧', '2018-03-14 03:09:44', 'myeclipse.exe', '第二条新闻');
INSERT INTO `t_notice` VALUES ('3', '路径出问题了?', '2018-03-14 03:13:33', 'QQLive.exe', '第三条新闻');
INSERT INTO `t_notice` VALUES ('4', '测试你吗了个臭逼', '2018-03-14 03:51:32', 'SogouExplorer.exe', '第四条');
INSERT INTO `t_notice` VALUES ('5', '去你吗的二级缓存', '2018-03-15 10:17:09', '缓存机制.docx', '二级缓存');
INSERT INTO `t_notice` VALUES ('6', '去你吗的安装包', '2018-03-15 10:23:10', 'SteamSetup.exe', 'steam安装包');
INSERT INTO `t_notice` VALUES ('7', 'da', '2018-03-16 05:33:10', '', 'dad');
INSERT INTO `t_notice` VALUES ('8', '下午6点准时来我宿舍叫我去吃饭', '2018-03-17 03:40:30', '王帅个人简历.pdf', '张衡通知你下午请我吃饭');

-- ----------------------------
-- Table structure for `t_person`
-- ----------------------------
DROP TABLE IF EXISTS `t_person`;
CREATE TABLE `t_person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `gender` int(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_person
-- ----------------------------
INSERT INTO `t_person` VALUES ('1', '123', '123', '1');
INSERT INTO `t_person` VALUES ('2', '123', 'ws', '1');
INSERT INTO `t_person` VALUES ('3', '123', 'zh', '1');
INSERT INTO `t_person` VALUES ('4', '123', 'xm', '0');
INSERT INTO `t_person` VALUES ('5', '123', 'cnm', '5');
INSERT INTO `t_person` VALUES ('6', '123', 'mlq', null);

-- ----------------------------
-- Table structure for `t_replies`
-- ----------------------------
DROP TABLE IF EXISTS `t_replies`;
CREATE TABLE `t_replies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `comt_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFCCEC43D96B60720` (`comt_id`),
  CONSTRAINT `FKFCCEC43D96B60720` FOREIGN KEY (`comt_id`) REFERENCES `t_comments` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_replies
-- ----------------------------
INSERT INTO `t_replies` VALUES ('3', '不好意思,找不见了', '2018-03-09 05-30-55', '3');
INSERT INTO `t_replies` VALUES ('4', '不好意思,找不见了', '2018-03-09 05-32-11', '3');
INSERT INTO `t_replies` VALUES ('5', '丢了', '2018-03-09 05-32-22', '3');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `role` int(11) NOT NULL,
  `date` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=88 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('2', 'null晋中市介休市', '849307440@qq.com', 'MTIzNDU2', '18503469313', '王帅', '1', null);
INSERT INTO `t_user` VALUES ('3', '北京市市辖区西城区', '123@123.com', 'MTIz', '123', '123', '1', null);
INSERT INTO `t_user` VALUES ('4', '山西省太原市尖草坪区', '111@111.com', 'MTIz', '18503461111', '111', '1', null);
INSERT INTO `t_user` VALUES ('5', '山西省太原市尖草坪区', '849307440@qq.com', 'MTIz', '18503469313', '8493', '1', null);
INSERT INTO `t_user` VALUES ('6', '天津市市辖区西城区', '123@ws.com', 'MTIz', '18503469313', 'ws123', '1', null);
INSERT INTO `t_user` VALUES ('77', null, null, '888', null, '888', '2', '2018-03-18 08:45:58');
INSERT INTO `t_user` VALUES ('79', null, null, '202cb962ac59075b964b07152d234b70', null, 'wsa123', '2', null);
INSERT INTO `t_user` VALUES ('86', '请选择省请选择市请选择县', '123', 'MTIz', '11111111111', '123', '1', '2018-03-16 07:55:04');
INSERT INTO `t_user` VALUES ('87', '请选择省请选择市请选择县', '123123123', 'MTIzMTIz', '12312312312', '123', '1', '2018-03-16 08:02:42');
