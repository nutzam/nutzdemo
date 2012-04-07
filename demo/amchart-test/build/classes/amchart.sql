# Host: localhost    Database: amchart

#
# Table structure for table ps_good
#
DROP TABLE IF EXISTS `ps_good`;
CREATE TABLE `ps_good` (
  `Id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `img_url` varchar(100) default NULL,
  `detailed` varchar(255) default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table ps_good
#
INSERT INTO `ps_good` VALUES (1,'美的（Midea）空气加湿器','/imgs/1.jpg','S30U-M1圣诞也疯狂！百元下超强性价比机型！3L升大水箱，双出雾口！经典，实用！');
INSERT INTO `ps_good` VALUES (2,'海尔（haier）液晶电视','/imgs/2.jpg','42英寸全高清流媒体液晶电视L42R3支持高清RM/RMVB视频文件 FULL-HD 1080P全高清画质 平板重低音 活动价 超高性价比！');
INSERT INTO `ps_good` VALUES (3,'美的（Midea)抽油烟机','/imgs/3.jpg','近吸式抽油烟机CXW-220-DJ02A双层错位网孔进风罩+内部滤网结构三重油烟分离，净化更彻底！');
INSERT INTO `ps_good` VALUES (4,'格兰仕2100W德国黑晶面板电磁炉','/imgs/4.jpg','德国黑晶面板电磁炉CH2176D(赠汤锅+炒锅)赠：圣诞帽，圣诞限量300台！包装带汤锅，炒锅！操作简便，大功率2100W');
INSERT INTO `ps_good` VALUES (5,'科龙1匹壁挂式家用冷暖空调','/imgs/5.jpg','挂式家用冷暖空调KFR-23GW/ULJ-3\"京东钜献\"全国地区低价热销.三级能效（最后50套 不含任何补贴）');
INSERT INTO `ps_good` VALUES (6,'飞利浦（PHILIPS）家庭影院','/imgs/6.jpg','飞利浦（PHILIPS）家庭影院 HTS8140（凭京东发票可享受免费上门安装）');


#
# Table structure for table ps_good_back
#
DROP TABLE IF EXISTS `ps_good_back`;
CREATE TABLE `ps_good_back` (
  `Id` int(11) NOT NULL auto_increment,
  `good_id` int(11) NOT NULL default '0',
  `back_date` timestamp NULL default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table ps_good_back
#
INSERT INTO `ps_good_back` VALUES (1,5,'2009-12-25 09:22:54');
INSERT INTO `ps_good_back` VALUES (2,1,'2009-12-25 09:25:25');
INSERT INTO `ps_good_back` VALUES (3,7,'2009-12-25 09:33:14');

#
# Table structure for table ps_good_paid
#
DROP TABLE IF EXISTS `ps_good_paid`;
CREATE TABLE `ps_good_paid` (
  `Id` int(11) NOT NULL auto_increment,
  `good_id` int(11) NOT NULL default '0',
  `paid_date` timestamp NULL default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table ps_good_paid
#
INSERT INTO `ps_good_paid` VALUES (1,5,'2009-12-25 09:22:51');
INSERT INTO `ps_good_paid` VALUES (2,5,'2009-12-25 09:23:13');
INSERT INTO `ps_good_paid` VALUES (3,1,'2009-12-25 09:23:20');
INSERT INTO `ps_good_paid` VALUES (4,1,'2009-12-25 09:25:22');
INSERT INTO `ps_good_paid` VALUES (5,1,'2009-12-25 09:25:27');
INSERT INTO `ps_good_paid` VALUES (6,1,'2009-12-25 09:25:29');
INSERT INTO `ps_good_paid` VALUES (7,4,'2009-12-25 09:28:31');
INSERT INTO `ps_good_paid` VALUES (8,7,'2009-12-25 09:33:10');

#
# Table structure for table ps_good_viewed
#
DROP TABLE IF EXISTS `ps_good_viewed`;
CREATE TABLE `ps_good_viewed` (
  `Id` int(11) NOT NULL auto_increment,
  `good_id` int(11) NOT NULL default '0',
  `viewed_date` timestamp NULL default NULL,
  PRIMARY KEY  (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Dumping data for table ps_good_viewed
#
INSERT INTO `ps_good_viewed` VALUES (1,5,'2009-12-25 09:22:53');
INSERT INTO `ps_good_viewed` VALUES (2,3,'2009-12-25 09:23:17');
INSERT INTO `ps_good_viewed` VALUES (3,2,'2009-12-25 09:24:53');
INSERT INTO `ps_good_viewed` VALUES (4,1,'2009-12-25 09:25:24');
INSERT INTO `ps_good_viewed` VALUES (5,7,'2009-12-25 09:33:12');

#
# View structure for view ps_view_good
#
DROP VIEW IF EXISTS `ps_view_good`;
CREATE ALGORITHM=UNDEFINED SQL SECURITY DEFINER VIEW `ps_view_good` AS select sql_no_cache `good`.`Id` AS `Id`,`good`.`name` AS `name`,`good`.`img_url` AS `img_url`,`good`.`detailed` AS `detailed`,(select sql_no_cache count(0) AS `count(*)` from `ps_good_paid` `gp` where (`gp`.`good_id` = `good`.`Id`)) AS `paid_count`,(select sql_no_cache count(0) AS `count(*)` from `ps_good_viewed` `gv` where (`gv`.`good_id` = `good`.`Id`)) AS `viewed_count`,(select sql_no_cache count(0) AS `count(*)` from `ps_good_back` `gb` where (`gb`.`good_id` = `good`.`Id`)) AS `back_count` from `ps_good` `good`;