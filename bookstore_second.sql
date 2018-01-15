/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.0.67-community-nt : Database - bookstore_0310
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookstore_0310` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookstore_0310`;

/*Table structure for table `bs_books` */

DROP TABLE IF EXISTS `bs_books`;

CREATE TABLE `bs_books` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `author` varchar(50) default NULL,
  `price` double(11,2) default NULL,
  `sale` int(10) default NULL,
  `stock` int(10) default NULL,
  `img_path` varchar(200) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8;

/*Data for the table `bs_books` */

insert  into `bs_books`(`id`,`title`,`author`,`price`,`sale`,`stock`,`img_path`) values (6,'时间简史','霍金',30.00,200,300,'static/img/default.jpg'),(11,'Tomcat与javaWeb开发','孙卫琴',79.50,102,98,'static/img/default.jpg'),(12,'解忧杂货店','东野圭吾',27.20,100,100,'static/img/default.jpg'),(13,'边城','沈从文',23.00,100,100,'static/img/default.jpg'),(14,'中国哲学史','冯友兰',44.50,100,100,'static/img/default.jpg'),(15,'忽然七日',' 劳伦',19.33,100,100,'static/img/default.jpg'),(16,'苏东坡传','林语堂',19.30,100,100,'static/img/default.jpg'),(17,'百年孤独56546','马尔克斯',29.50,100,100,'static/img/default.jpg'),(18,'扶桑','严歌苓',19.80,100,100,'static/img/default.jpg'),(19,'教父','马里奥·普佐',29.00,100,100,'static/img/default.jpg'),(20,'给孩子的诗','北岛',22.20,101,99,'static/img/default.jpg'),(21,'为奴十二年54','所罗门',16.50,101,99,'static/img/default.jpg'),(22,'平凡的世界','路遥',55.00,100,100,'static/img/default.jpg'),(23,'悟空传','今何在',14.00,100,100,'static/img/default.jpg'),(24,'硬派健身','斌卡',31.20,100,100,'static/img/default.jpg'),(25,'从晚清到民国','唐德刚',39.90,101,99,'static/img/default.jpg'),(27,'看见厅','柴静',19.50,101,99,'static/img/default.jpg'),(28,'活着','余华',11.00,101,99,'static/img/default.jpg'),(30,'我们仨','杨绛',11.30,100,100,'static/img/default.jpg'),(31,'生命不息,折腾不止','罗永浩',25.20,100,100,'static/img/default.jpg'),(32,'皮囊','蔡崇达',23.90,100,100,'static/img/default.jpg'),(33,'恰到好处的幸福','毕淑敏',16.40,101,99,'static/img/default.jpg'),(34,'艾伦·图灵传','安德鲁',47.20,101,99,'static/img/default.jpg'),(35,'大数据预测','埃里克',37.20,101,99,'static/img/default.jpg'),(36,'人月神话','布鲁克斯',55.90,101,99,'static/img/default.jpg'),(37,'C语言入门经典','霍尔顿',45.00,101,99,'static/img/default.jpg'),(38,'数学之美','吴军',29.90,105,95,'static/img/default.jpg'),(39,'Java编程思想','埃史尔',70.50,106,94,'static/img/5933be0b88e5478ca95015e1f9597087_月色.jpg'),(40,'设计模式之禅','秦小波',20.20,102,98,'static/img/default.jpg'),(43,'大法师','压顶',456.00,6,4,'static/img/c0cdc7f876914dccaf1c2e3b4d9aeaf2_憧憬.jpg');

/*Table structure for table `bs_order_items` */

DROP TABLE IF EXISTS `bs_order_items`;

CREATE TABLE `bs_order_items` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(50) default NULL,
  `author` varchar(50) default NULL,
  `price` double(11,2) default NULL,
  `img_path` varchar(100) default NULL,
  `count` int(11) default NULL,
  `amount` double(11,2) default NULL,
  `order_id` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  KEY `fk_order_item` (`order_id`),
  CONSTRAINT `fk_order_item` FOREIGN KEY (`order_id`) REFERENCES `bs_orders` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `bs_order_items` */

insert  into `bs_order_items`(`id`,`title`,`author`,`price`,`img_path`,`count`,`amount`,`order_id`) values (1,'Tomcat与javaweb开发','孙卫琴',70.00,'static/img/default.jpg',10,700.00,'14900085937401'),(2,'Tomcat与JavaWeb开发','孙卫琴',79.50,'static/img/default.jpg',2,159.00,'14900125521051'),(3,'Java编程思想','埃史尔',70.50,'static/img/default.jpg',1,70.50,'14900168337074'),(4,'数学之美','吴军',29.90,'static/img/default.jpg',1,29.90,'14900168337074'),(5,'设计模式之禅','秦小波',20.20,'static/img/default.jpg',1,20.20,'14900168337074'),(8,'设计模式之禅','秦小波',20.20,'static/img/default.jpg',1,20.20,'14900833548574'),(9,'Java编程思想','埃史尔',70.50,'static/img/default.jpg',1,70.50,'14900833548574'),(10,'数学之美','吴军',29.90,'static/img/default.jpg',1,29.90,'14900833548574'),(11,'为奴十二年54','所罗门',16.50,'static/img/default.jpg',1,16.50,'14900874553614'),(12,'给孩子的诗','北岛',22.20,'static/img/default.jpg',1,22.20,'14900874553614'),(13,'Java编程思想','埃史尔',70.50,'static/img/default.jpg',1,70.50,'14900874553614'),(14,'数学之美','吴军',29.90,'static/img/default.jpg',1,29.90,'14900874553614'),(15,'从晚清到民国','唐德刚',39.90,'static/img/default.jpg',1,39.90,'14900874761164'),(16,'看见厅','柴静',19.50,'static/img/default.jpg',1,19.50,'14900874761164'),(17,'活着','余华',11.00,'static/img/default.jpg',1,11.00,'14900874761164'),(18,'Java编程思想','埃史尔',70.50,'static/img/default.jpg',1,70.50,'14911894956893'),(19,'数学之美','吴军',29.90,'static/img/default.jpg',1,29.90,'14911894956893'),(20,'恰到好处的幸福','毕淑敏',16.40,'static/img/default.jpg',1,16.40,'14912239723483');

/*Table structure for table `bs_orders` */

DROP TABLE IF EXISTS `bs_orders`;

CREATE TABLE `bs_orders` (
  `id` varchar(100) NOT NULL,
  `create_date` datetime default NULL,
  `state` int(2) default NULL,
  `total_count` int(11) default NULL,
  `total_amount` double(11,2) default NULL,
  `user_id` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `bs_orders_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `bs_users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `bs_orders` */

insert  into `bs_orders`(`id`,`create_date`,`state`,`total_count`,`total_amount`,`user_id`) values ('14900085937401','2017-03-20 00:00:00',1,10,200.00,1),('14900125521051','2017-03-20 00:00:00',1,2,159.00,1),('14900168337074','2017-03-20 00:00:00',2,3,120.60,4),('14900833548574','2017-03-21 00:00:00',2,3,120.60,4),('14900874553614','2017-03-21 00:00:00',0,4,139.10,4),('14900874761164','2017-03-21 00:00:00',0,3,70.40,4),('14911894956893','2017-04-03 00:00:00',0,2,100.40,3),('14912239723483','2017-04-03 20:52:52',0,1,16.40,3);

/*Table structure for table `bs_users` */

DROP TABLE IF EXISTS `bs_users`;

CREATE TABLE `bs_users` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `username_2` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `bs_users` */

insert  into `bs_users`(`id`,`username`,`password`,`email`) values (1,'刘在石','123123','liuzaishi@163.com'),(2,'宋智孝','123123','songzhixiao@163.com'),(3,'admin','123123','admin@142.com'),(4,'李光洙','123123','liguangzhu@163.com'),(5,'jinzhongguo','123123','jinzhongguo@163.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
