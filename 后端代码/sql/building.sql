/*
SQLyog Professional v13.1.1 (64 bit)
MySQL - 5.7.34 : Database - building
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`building` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `building`;

/*Table structure for table `t_construction` */

DROP TABLE IF EXISTS `t_construction`;

CREATE TABLE `t_construction` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `construction_id` int(11) NOT NULL COMMENT '工地id',
  `construction_number` varchar(20) NOT NULL COMMENT '工地编号',
  `construction_name` varchar(20) NOT NULL COMMENT '工地名称',
  `construction_longitude` float DEFAULT NULL COMMENT '工地经度',
  `construction_latitude` float DEFAULT NULL COMMENT '工地纬度',
  `head_name` varchar(20) DEFAULT NULL COMMENT '负责人名字',
  `head_phone` varchar(11) DEFAULT NULL COMMENT '负责人电话',
  `construction_people` int(11) DEFAULT NULL COMMENT '工地人数',
  `construction_address` varchar(30) DEFAULT NULL COMMENT '工地地址',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `t_construction` */

insert  into `t_construction`(`id`,`construction_id`,`construction_number`,`construction_name`,`construction_longitude`,`construction_latitude`,`head_name`,`head_phone`,`construction_people`,`construction_address`,`update_time`,`create_time`) values 
(2,1,'J-1','江西理工工地',12345,66,'刘六','12345678911',11,'1','2021-06-25 00:47:52','2021-06-17 03:10:56'),
(9,3,'G-1','赣南科技',11,1,'李华','12345678911',1,'1','2021-06-25 00:47:54','2021-06-16 06:28:20'),
(11,5,'G-2','应科院',123.123,123.123,'张三','12345678911',11,'11','2021-06-25 00:47:55','2021-06-17 03:15:21'),
(15,11,'A-1','一号工地',99,88,'李四','12345678911',1,'1231231','2021-06-25 00:47:58','2021-06-16 08:45:34'),
(17,156,'177','赣南科技学院',16,15,'张三三','123456789',18,'1','2021-07-12 07:50:15','2021-07-12 07:50:15');

/*Table structure for table `t_department` */

DROP TABLE IF EXISTS `t_department`;

CREATE TABLE `t_department` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `construction_id` int(11) NOT NULL COMMENT '工地id',
  `department_id` int(11) NOT NULL COMMENT '部门id',
  `department_name` varchar(20) NOT NULL COMMENT '部门名称',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_department` */

insert  into `t_department`(`id`,`construction_id`,`department_id`,`department_name`,`update_time`,`create_time`) values 
(4,1,1,'工地部','2021-06-12 07:48:12','2021-06-06 11:22:51'),
(5,1,2,'安全部','2021-06-16 01:17:41','2021-06-16 01:07:16'),
(6,1,3,'部','2021-06-16 01:17:45','2021-06-16 01:09:12');

/*Table structure for table `t_document` */

DROP TABLE IF EXISTS `t_document`;

CREATE TABLE `t_document` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `attribute` int(11) NOT NULL COMMENT '属性',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  `document_name` varchar(20) NOT NULL COMMENT '文件名',
  `document_time` int(11) DEFAULT NULL COMMENT '视频时间为多少秒',
  `document_path` varchar(100) DEFAULT NULL COMMENT '文件路径',
  `document_score` int(11) DEFAULT NULL COMMENT '查看后获得的分数',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `t_document` */

insert  into `t_document`(`id`,`attribute`,`document_id`,`document_name`,`document_time`,`document_path`,`document_score`,`update_time`,`create_time`) values 
(1,1,1,'工地中的安全要点',NULL,'http://10.168.200.65:8082/zlx/statudy/01.html',13,'2021-07-03 02:38:10','2021-06-17 07:33:33'),
(3,2,1,'安全教育',12,'a',6,'2021-07-03 00:32:48','2021-06-17 07:33:37'),
(6,2,3,'安全',12,'a/a',10,'2021-06-17 07:33:44','2021-06-17 07:33:39'),
(11,1,4,'工地带安全帽足以事项',0,'',1,'2021-07-03 00:32:01','2021-06-17 07:33:43'),
(12,1,3,'工地禁止进入危险地',0,'',1,'2021-07-03 00:32:20','2021-06-17 23:52:16'),
(14,1,2,'工人安全',NULL,'b',1,'2021-07-03 00:32:27','2021-06-17 07:33:36'),
(17,2,2,'安全知识',3,'b',1,'2021-07-03 00:32:34','2021-06-17 07:33:41'),
(22,3,1,'考试',NULL,'b',6,'2021-07-03 00:32:38','2021-06-18 01:32:03');

/*Table structure for table `t_environment` */

DROP TABLE IF EXISTS `t_environment`;

CREATE TABLE `t_environment` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `environment_number` int(11) NOT NULL COMMENT '数据编号',
  `dust_one` float NOT NULL COMMENT '粉尘1',
  `dust_two` float DEFAULT NULL COMMENT '粉尘2',
  `noise` float NOT NULL COMMENT '噪音',
  `speed` float NOT NULL COMMENT '风速',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

/*Data for the table `t_environment` */

insert  into `t_environment`(`id`,`environment_number`,`dust_one`,`dust_two`,`noise`,`speed`,`update_time`,`create_time`) values 
(4,1,12,12,12,12,'2021-06-18 09:12:01','2021-06-18 09:12:01'),
(5,7897968,23,23,3,18,'2021-07-09 08:17:50','2021-07-09 08:17:50'),
(6,235234,23,23,3,18,'2021-07-09 08:24:19','2021-07-09 08:24:19'),
(7,343746,30,30,5,17,'2021-07-11 11:28:01','2021-07-11 11:28:01'),
(8,345079,1,1,5,19,'2021-07-11 11:28:01','2021-07-11 11:28:01'),
(9,346602,4,4,5,15,'2021-07-11 11:28:01','2021-07-11 11:28:01'),
(10,347934,26,26,5,25,'2021-07-11 11:28:02','2021-07-11 11:28:02'),
(11,349458,6,6,5,15,'2021-07-11 11:28:02','2021-07-11 11:28:02'),
(12,355562,10,10,10,0,'2021-07-11 12:03:28','2021-07-11 12:03:28'),
(13,360765,8,8,12,15,'2021-07-11 12:05:44','2021-07-11 12:05:44'),
(14,362528,14,14,11,19,'2021-07-11 12:06:18','2021-07-11 12:06:18'),
(15,364292,23,23,11,11,'2021-07-11 12:06:52','2021-07-11 12:06:52'),
(16,366056,19,19,11,11,'2021-07-11 12:07:27','2021-07-11 12:07:27'),
(17,367820,17,17,10,18,'2021-07-11 12:08:01','2021-07-11 12:08:01'),
(18,369387,17,17,10,15,'2021-07-11 12:08:36','2021-07-11 12:08:36'),
(19,371289,23,23,11,11,'2021-07-11 12:42:14','2021-07-11 12:42:14'),
(20,372612,25,25,10,14,'2021-07-12 00:53:13','2021-07-12 00:53:13'),
(21,14324,23,23,3,18,'2021-07-12 01:38:03','2021-07-12 01:38:03'),
(22,447924,0,0,0,0,'2021-07-13 00:29:50','2021-07-13 00:29:50'),
(23,448671,15,15,15,15,'2021-07-13 00:30:51','2021-07-13 00:30:51'),
(24,450376,0,0,0,0,'2021-07-13 00:33:07','2021-07-13 00:33:07'),
(25,450943,0,0,0,0,'2021-07-13 00:33:36','2021-07-13 00:33:36');

/*Table structure for table `t_hardware` */

DROP TABLE IF EXISTS `t_hardware`;

CREATE TABLE `t_hardware` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `tardward_id` int(11) NOT NULL COMMENT '数据编号',
  `vibration_one` float NOT NULL COMMENT '吊塔震动',
  `acceleration_x_one` float NOT NULL COMMENT '吊塔三轴加速度x',
  `acceleration_y_one` float NOT NULL COMMENT '吊塔三轴加速度y',
  `acceleration_z_one` float NOT NULL COMMENT '吊塔三轴加速度z',
  `vibration_two` float NOT NULL COMMENT '高支模震动',
  `acceleration_x_two` float NOT NULL COMMENT '高支模三轴加速度x',
  `acceleration_y_two` float NOT NULL COMMENT '高支模三轴加速度y',
  `acceleration_z_two` float NOT NULL COMMENT '高支模三轴加速度z',
  `detection_one` int(11) NOT NULL COMMENT '人体检测1',
  `detection_two` int(11) DEFAULT NULL COMMENT '人体检测2',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_hardware` */

insert  into `t_hardware`(`id`,`tardward_id`,`vibration_one`,`acceleration_x_one`,`acceleration_y_one`,`acceleration_z_one`,`vibration_two`,`acceleration_x_two`,`acceleration_y_two`,`acceleration_z_two`,`detection_one`,`detection_two`,`update_time`,`create_time`) values 
(4,1,0,2,4,1,1,1,1,1,1,1,'2021-06-24 09:10:29','2021-06-18 09:12:19'),
(5,14324,0,1,1,1,0,1.2,1,1,0,0,'2021-07-12 01:42:15','2021-07-12 01:42:15'),
(6,14324,0,1,1,1,0,1.2,1,1,0,0,'2021-07-12 01:43:43','2021-07-12 01:43:43'),
(7,14324,0,1,1,1,0,1.2,1,1,0,0,'2021-07-12 01:44:37','2021-07-12 01:44:37');

/*Table structure for table `t_limit` */

DROP TABLE IF EXISTS `t_limit`;

CREATE TABLE `t_limit` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `device_id` int(11) NOT NULL COMMENT '设备id',
  `device_number` varchar(20) NOT NULL COMMENT '设备编号',
  `device_name` varchar(20) NOT NULL COMMENT '设备名',
  `min_value` float DEFAULT NULL COMMENT '最小值',
  `max_value` float DEFAULT NULL COMMENT '最大值',
  `unit` varchar(10) NOT NULL COMMENT '单位',
  `accuracy` int(11) NOT NULL COMMENT '精度',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_limit` */

insert  into `t_limit`(`id`,`device_id`,`device_number`,`device_name`,`min_value`,`max_value`,`unit`,`accuracy`,`update_time`,`create_time`) values 
(1,4,'1','粉尘1号',8,30,'ug/m³',0,'2021-07-09 08:21:02','2021-06-13 08:54:57'),
(4,5,'23','粉尘2号',8,30,'ug/m³',0,'2021-07-09 08:21:05','2021-06-17 11:22:45'),
(5,1,'12','吊塔x轴加速度',0,10,'g',2,'2021-07-13 00:49:40','2021-06-17 11:23:11'),
(6,2,'1','吊塔y轴加速度',0,16.9,'g',2,'2021-07-12 01:43:18','2021-06-17 11:23:41'),
(7,3,'1','吊塔z轴加速度',0,7.62,'g',2,'2021-07-12 01:43:26','2021-06-17 11:23:55'),
(8,9,'1','噪音',56.6,66.6,'dB',1,'2021-06-19 00:05:35','2021-06-17 11:24:32'),
(9,6,'1','高支模x轴加速度',0,6.66,'g',2,'2021-07-12 01:43:28','2021-06-17 11:24:51'),
(10,7,'1','高支模y轴加速度',0,8.88,'g',2,'2021-07-12 01:43:31','2021-06-17 11:25:02'),
(11,8,'1','高支模z轴加速度',0,9.99,'g',2,'2021-07-12 01:43:36','2021-06-17 11:25:12');

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `role_id` int(11) NOT NULL COMMENT '权限id',
  `role_name` varchar(20) NOT NULL COMMENT '权限名称',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`id`,`role_id`,`role_name`,`update_time`,`create_time`) values 
(4,1,'工人','2021-06-06 11:23:47','2021-06-06 11:23:47'),
(5,2,'管理员','2021-06-06 11:23:55','2021-06-06 11:23:55');

/*Table structure for table `t_score` */

DROP TABLE IF EXISTS `t_score`;

CREATE TABLE `t_score` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `attribute` int(11) NOT NULL COMMENT '属性',
  `document_id` int(11) NOT NULL COMMENT '文件id',
  `document_score` int(11) NOT NULL COMMENT '查看后获得的分数',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

/*Data for the table `t_score` */

insert  into `t_score`(`id`,`user_id`,`attribute`,`document_id`,`document_score`,`update_time`,`create_time`) values 
(1,1,1,1,13,'2021-06-11 07:17:19','2021-06-11 07:17:19'),
(2,1,1,2,5,'2021-06-11 07:17:19','2021-06-11 07:17:19'),
(12,2,1,2,5,'2021-06-11 07:17:19','2021-06-11 07:17:19'),
(13,1,2,1,6,'2021-06-11 09:20:46','2021-06-11 09:20:46'),
(14,1,2,3,10,'2021-06-24 10:59:39','2021-06-24 10:59:39'),
(16,2,1,1,13,'2021-06-25 01:47:46','2021-06-25 01:47:46'),
(18,1,1,0,1,'2021-06-25 09:16:07','2021-06-25 09:16:07'),
(19,1,1,4,1,'2021-07-03 00:23:36','2021-07-03 00:23:36');

/*Table structure for table `t_sign` */

DROP TABLE IF EXISTS `t_sign`;

CREATE TABLE `t_sign` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `sign_time` varchar(20) NOT NULL COMMENT '签到时间',
  `construction_id` int(11) NOT NULL COMMENT '签到位置/工地',
  `status` int(11) NOT NULL COMMENT '状态 进/出',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `t_sign` */

insert  into `t_sign`(`id`,`user_id`,`sign_time`,`construction_id`,`status`,`update_time`,`create_time`) values 
(4,1,'2021-6-9',1,1,'2021-06-19 03:23:14','2021-06-09 11:45:18'),
(5,1234,'2021-6-9 19:45',1,0,'2021-06-19 03:24:32','2021-06-09 11:45:42'),
(6,1,'2021-6-10 20:25',2,1,'2021-06-19 03:24:17','2021-06-10 12:25:06'),
(7,1,'2021-6-10 ',2,0,'2021-06-19 03:24:20','2021-06-10 12:30:46'),
(8,1,'2021-6-10 20:35',2,1,'2021-06-19 03:24:21','2021-06-10 12:35:12'),
(9,1,'2021-5-10 8:35',1,1,'2021-06-19 03:24:23','2021-05-10 01:06:54'),
(10,1234,'2021-6-1 8:35',1,1,'2021-06-19 03:24:34','2021-06-01 01:21:13'),
(11,1234,'2021-6-1 8:35',1,1,'2021-06-19 03:24:38','2021-06-19 02:34:52'),
(12,1,'202106-1 8:35',1,1,'2021-06-19 03:24:24','2021-06-19 02:35:08'),
(13,1,'2021-5-10 8:35',1,0,'2021-06-19 03:24:26','2021-06-19 02:35:16'),
(14,1,'2021-5-10 8:35',1,0,'2021-06-19 03:21:15','2021-06-19 02:35:26'),
(15,2,'2021-5-10 8:35',1,1,'2021-06-19 03:22:04','2021-06-19 02:37:11'),
(16,1234,'1',1,1,'2021-06-19 02:37:18','2021-06-19 02:37:18');

/*Table structure for table `t_switch` */

DROP TABLE IF EXISTS `t_switch`;

CREATE TABLE `t_switch` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `switch_id` int(11) NOT NULL COMMENT '开关id',
  `switch_number` varchar(20) NOT NULL COMMENT '开关编号',
  `switch_name` varchar(20) NOT NULL COMMENT '开关名称',
  `switch_state` int(11) NOT NULL COMMENT '开关状态',
  `note` varchar(50) DEFAULT NULL COMMENT '备注',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `t_switch` */

insert  into `t_switch`(`id`,`switch_id`,`switch_number`,`switch_name`,`switch_state`,`note`,`update_time`,`create_time`) values 
(1,1,'1','吊塔震动报警器',1,'1','2021-07-12 07:53:10','2021-06-12 02:43:53'),
(2,2,'3','高支模震动报警器',0,'cheng','2021-06-30 07:50:25','2021-06-12 02:46:44'),
(3,3,'788','噪音报警器',0,'1','2021-07-03 07:38:32','2021-06-15 01:25:34'),
(4,4,'12','吊塔三轴报警器',1,'5','2021-07-12 01:42:16','2021-06-13 00:59:20'),
(5,5,'1','高支模三轴报警器',1,'1','2021-07-12 01:42:18','2021-06-13 00:59:45'),
(6,6,'1231','人体检测报警器',0,'0','2021-06-19 01:21:04','2021-06-19 01:20:33'),
(7,7,'132','粉尘报警器',1,'0','2021-07-09 08:17:51','2021-06-19 01:21:00'),
(8,8,'1234','喷淋',0,'1','2021-07-03 07:38:35','2021-06-19 01:21:35');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(20) NOT NULL COMMENT '工号',
  `construction_id` int(11) NOT NULL COMMENT '工地id',
  `department_id` int(11) NOT NULL COMMENT '部门id',
  `role_id` int(11) NOT NULL COMMENT '权限id',
  `user_name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(2) NOT NULL COMMENT '性别',
  `password` varchar(32) NOT NULL COMMENT '密码',
  `phone` varchar(11) NOT NULL COMMENT '电话',
  `id_card` varchar(18) NOT NULL COMMENT '身份证号',
  `address` varchar(30) DEFAULT NULL COMMENT '家庭住址',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`user_id`,`construction_id`,`department_id`,`role_id`,`user_name`,`sex`,`password`,`phone`,`id_card`,`address`,`update_time`,`create_time`) values 
(74,1,1,1,2,'胡雨圣','男','e10adc3949ba59abbe56e057f20f883e','12345678911','362330200011106375','江西理工大学','2021-06-16 08:35:31','2021-06-16 06:46:53'),
(75,4,1,1,1,'李诚','男','e10adc3949ba59abbe56e057f20f883e','2131','123123','123213213','2021-06-16 08:35:28','2021-06-16 07:32:19'),
(77,1234,1,1,1,'zhang','男','123','12345678912','1','1','2021-07-13 01:10:59','2021-06-18 00:12:58'),
(78,12,1,1,1,'1','男','e10adc3949ba59abbe56e057f20f883e','21','12','21','2021-06-21 13:26:23','2021-06-21 13:26:23'),
(79,13,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:14','2021-06-21 13:27:14'),
(80,14,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:18','2021-06-21 13:27:18'),
(81,15,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:22','2021-06-21 13:27:22'),
(82,16,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:26','2021-06-21 13:27:26'),
(83,17,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:29','2021-06-21 13:27:29'),
(84,18,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:33','2021-06-21 13:27:33'),
(85,19,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:36','2021-06-21 13:27:36'),
(86,20,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:27:41','2021-06-21 13:27:41'),
(87,21,1,1,1,'李','1','e10adc3949ba59abbe56e057f20f883e','12','123','a','2021-06-21 13:28:04','2021-06-21 13:28:04'),
(88,2,1,1,1,'za','1','e10adc3949ba59abbe56e057f20f883e','12','12','1','2021-07-06 01:57:22','2021-07-06 01:57:15');

/*Table structure for table `t_warningrecord` */

DROP TABLE IF EXISTS `t_warningrecord`;

CREATE TABLE `t_warningrecord` (
  `id` int(2) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `warning_id` int(11) NOT NULL COMMENT '警告id',
  `warning_number` varchar(20) NOT NULL COMMENT '警告编号',
  `warning_name` varchar(20) NOT NULL COMMENT '警告名称',
  `warning_why` varchar(20) DEFAULT NULL COMMENT '警告原因',
  `warning_time` varchar(20) DEFAULT NULL COMMENT '警告时间',
  `shutdown_time` varchar(20) DEFAULT NULL COMMENT '关闭时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `t_warningrecord` */

insert  into `t_warningrecord`(`id`,`warning_id`,`warning_number`,`warning_name`,`warning_why`,`warning_time`,`shutdown_time`,`update_time`,`create_time`) values 
(4,2,'3','哈哈哈哈','你猜','2021-06-13','','2021-06-29 07:44:38','2021-06-13 08:15:56'),
(5,3,'3','j','wu','2021-7-9',NULL,'2021-07-12 01:36:32','2021-07-12 01:36:32'),
(6,4,'14324','胡雨圣','吊塔三轴报警器','2021-07-12 09:42:14',NULL,'2021-07-12 01:42:16','2021-07-12 01:42:16'),
(7,4,'14324','胡雨圣','吊塔三轴报警器','2021-07-12 09:42:15',NULL,'2021-07-12 01:42:17','2021-07-12 01:42:17'),
(8,4,'14324','胡雨圣','吊塔三轴报警器','2021-07-12 09:42:15',NULL,'2021-07-12 01:42:17','2021-07-12 01:42:17'),
(9,5,'14324','胡雨圣','高支模三轴报警器','2021-07-12 09:42:16',NULL,'2021-07-12 01:42:18','2021-07-12 01:42:18'),
(10,5,'14324','胡雨圣','高支模三轴报警器','2021-07-12 09:42:16',NULL,'2021-07-12 01:42:18','2021-07-12 01:42:18'),
(11,5,'14324','胡雨圣','高支模三轴报警器','2021-07-12 09:42:17',NULL,'2021-07-12 01:42:19','2021-07-12 01:42:19');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
