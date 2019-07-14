-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: vc
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8mb4 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bill`
--

DROP TABLE IF EXISTS `bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `type` varchar(20) NOT NULL,
  `money` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bill`
--

LOCK TABLES `bill` WRITE;
/*!40000 ALTER TABLE `bill` DISABLE KEYS */;
INSERT INTO `bill` VALUES (1,'2019-06-25 09:09:53','购票',60),(2,'2019-06-26 11:51:25','测试',-12),(3,'2019-06-26 11:59:30','购票',45),(4,'2019-06-26 11:59:35','购票',30),(5,'2019-06-26 12:04:21','退票',-30),(6,'2019-06-26 12:07:23','购票',30),(7,'2019-06-26 12:07:42','退票',-30),(8,'2019-06-26 12:15:50','购票',60),(9,'2019-06-26 12:18:41','购票',60),(10,'2019-06-26 14:59:20','购票',60),(11,'2019-06-27 21:34:35','购票',60),(12,'2019-06-27 22:03:39','购票',60),(13,'2019-06-27 22:03:42','购票',60),(14,'2019-06-28 10:15:35','购票',60),(15,'2019-06-28 10:16:06','购票',60),(16,'2019-06-28 11:11:12','购票',60),(17,'2019-06-28 11:11:21','购票',30),(18,'2019-06-28 11:12:06','退票',-60),(19,'2019-06-28 14:01:25','购票',45),(20,'2019-06-28 14:02:43','购票',60),(21,'2019-06-28 14:02:50','退票',-60),(22,'2019-06-30 21:06:46','购票',60),(23,'2019-06-30 21:10:53','退票',-60),(24,'2019-06-30 21:11:20','购票',60),(25,'2019-07-03 18:08:13','购票',60);
/*!40000 ALTER TABLE `bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `checkin`
--

DROP TABLE IF EXISTS `checkin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `checkin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `time` datetime DEFAULT CURRENT_TIMESTAMP,
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkin`
--

LOCK TABLES `checkin` WRITE;
/*!40000 ALTER TABLE `checkin` DISABLE KEYS */;
INSERT INTO `checkin` VALUES (1,1,'2019-06-26 10:07:52',3),(2,1,'2019-06-26 10:07:55',3),(3,1,'2019-06-26 10:08:02',3),(4,1,'2019-06-26 10:08:13',3),(5,1,'2019-06-26 10:08:43',3),(6,1,'2019-06-26 10:10:06',13),(7,0,'2019-06-26 10:10:06',13),(8,0,'2019-06-26 10:10:17',13),(9,1,'2019-06-26 10:10:25',13);
/*!40000 ALTER TABLE `checkin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `map`
--

DROP TABLE IF EXISTS `map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `map` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `map`
--

LOCK TABLES `map` WRITE;
/*!40000 ALTER TABLE `map` DISABLE KEYS */;
INSERT INTO `map` VALUES (1,'落魄山'),(2,'神秀峰'),(3,'仙草山'),(4,'真珠山'),(5,'彩云峰'),(6,'书简湖'),(7,'宝篆山'),(8,'倒悬山');
/*!40000 ALTER TABLE `map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `near`
--

DROP TABLE IF EXISTS `near`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `near` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id1` int(11) NOT NULL,
  `id2` int(11) NOT NULL,
  `distance` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `near`
--

LOCK TABLES `near` WRITE;
/*!40000 ALTER TABLE `near` DISABLE KEYS */;
INSERT INTO `near` VALUES (1,1,2,700),(2,1,2,700),(3,1,6,500),(4,1,7,900),(5,2,3,500),(6,2,4,700),(7,3,5,300),(8,4,5,400),(9,4,7,400),(10,5,8,700),(11,7,8,800);
/*!40000 ALTER TABLE `near` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rent`
--

DROP TABLE IF EXISTS `rent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `rent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `shopid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rent`
--

LOCK TABLES `rent` WRITE;
/*!40000 ALTER TABLE `rent` DISABLE KEYS */;
INSERT INTO `rent` VALUES (1,1,14,NULL),(2,5,21,NULL),(3,6,5,NULL);
/*!40000 ALTER TABLE `rent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shop`
--

DROP TABLE IF EXISTS `shop`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shop` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `place` varchar(20) NOT NULL,
  `state` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shop`
--

LOCK TABLES `shop` WRITE;
/*!40000 ALTER TABLE `shop` DISABLE KEYS */;
INSERT INTO `shop` VALUES (1,'售票大厅','1A',0),(2,'第一停车场','1B',0),(3,'游乐场1','1C',0),(4,'厕所1','1D',0),(5,'戴磊厕所','2A',1),(6,'新商铺','2B',0),(7,'空闲','2C',1),(8,'空闲','2D',1),(9,'第一餐厅','3A',0),(10,'空闲','3B',1),(11,'空闲','3C',1),(12,'空闲','3D',1),(13,'超市1','4A',0),(14,'厕所2','4B',0),(15,'空闲','4C',1),(16,'空闲','4D',1),(17,'第二售票处','5A',0),(18,'第二停车场','5B',0),(19,'超市2','5C',0),(20,'空闲','5D',1),(21,'第二餐厅','6A',0),(22,'空闲','6B',1),(23,'空闲','6C',1),(24,'空闲','6D',1),(25,'游乐场2','7A',0),(26,'空闲','7B',1),(27,'空闲','7C',1),(28,'空闲','7D',1),(29,'厕所3','8A',0),(30,'空闲','8B',1),(31,'空闲','8C',1),(32,'空闲','8D',1);
/*!40000 ALTER TABLE `shop` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `type` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'manage1','pass1','管理'),(2,'manage2','pass2','管理'),(3,'worker1','pass1','员工'),(4,'worker2','pass2','员工'),(5,'busine1','pass1','商户'),(6,'busine2','pass2','商户'),(7,'duanyihao','123123','管理'),(8,'cuiyuming','131231','员工'),(9,'cym123','123456','管理'),(10,'user4','pass1','员工'),(11,'yuangong1','pass1','员工'),(12,'root','password','管理'),(13,'worker','password','员工'),(14,'business','password','商户'),(15,'manage3','pass3','管理'),(16,'user5','pass5','管理'),(17,'worker3','pass3','员工'),(18,'duanyihao1111','pass1','员工'),(19,'user111','oass111','员工'),(20,'cuiyuming111','pass1','员工'),(21,'daibaba','123','商户'),(22,'worker123','123123','员工');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitor`
--

DROP TABLE IF EXISTS `visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `visitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buy_time` datetime DEFAULT CURRENT_TIMESTAMP,
  `in_time` datetime DEFAULT NULL,
  `out_time` datetime DEFAULT NULL,
  `state` int(11) DEFAULT '0',
  `price` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitor`
--

LOCK TABLES `visitor` WRITE;
/*!40000 ALTER TABLE `visitor` DISABLE KEYS */;
INSERT INTO `visitor` VALUES (1,'2019-06-24 12:51:31','2019-06-24 13:41:22','2019-06-24 13:41:53',2,40),(2,'2019-06-24 12:53:37',NULL,'2019-06-24 13:51:35',4,40),(3,'2019-06-24 12:55:16',NULL,'2019-06-24 13:44:21',4,40),(4,'2019-06-24 12:55:51',NULL,'2019-06-24 13:51:35',4,40),(5,'2019-06-24 13:05:11',NULL,'2019-06-24 13:51:35',4,40),(6,'2019-06-24 13:05:45',NULL,'2019-06-24 13:43:56',4,40),(7,'2019-06-24 13:12:01','2019-06-24 13:36:58','2019-06-24 13:41:54',2,40),(8,'2019-06-24 13:17:31','2019-06-24 13:42:36','2019-06-24 13:43:22',2,40),(9,'2019-06-24 16:54:51',NULL,NULL,3,60),(10,'2019-06-24 16:55:38',NULL,NULL,3,60),(11,'2019-06-24 16:58:00',NULL,NULL,3,60),(12,'2019-06-24 16:58:58','2019-06-24 17:01:53','2019-06-24 17:01:53',2,60),(13,'2019-06-24 16:59:34','2019-06-24 17:01:53','2019-06-24 17:01:53',2,60),(14,'2019-06-25 02:14:36','2019-06-25 02:48:25','2019-06-25 02:50:08',2,60),(15,'2019-06-25 09:09:53',NULL,'2019-06-26 03:26:37',3,60),(16,'2019-06-26 02:43:29','2019-06-26 03:17:46','2019-06-26 03:27:04',2,80),(17,'2019-06-26 02:43:53',NULL,'2019-06-26 03:26:37',3,80),(20,'2019-06-26 12:07:23',NULL,'2019-06-26 12:07:42',4,30),(21,'2019-06-26 12:09:50','2019-06-28 10:58:33',NULL,1,30),(22,'2019-06-26 12:10:24',NULL,NULL,0,30),(23,'2019-06-26 12:11:20','2019-06-26 12:15:30','2019-06-26 12:15:37',2,30),(24,'2019-06-26 12:15:50','2019-06-26 12:16:02','2019-06-26 12:16:14',2,60),(25,'2019-06-26 12:18:41','2019-06-26 12:18:54','2019-06-26 12:18:58',2,60),(26,'2019-06-26 14:59:20','2019-06-26 15:00:35',NULL,1,60),(27,'2019-06-27 21:34:35',NULL,NULL,0,60),(28,'2019-06-27 22:03:39',NULL,NULL,0,60),(29,'2019-06-27 22:03:42',NULL,NULL,0,60),(30,'2019-06-28 10:15:35','2019-06-28 10:41:16','2019-06-28 10:41:22',2,60),(31,'2019-06-28 10:16:06',NULL,NULL,0,60),(32,'2019-06-28 11:11:12',NULL,'2019-06-28 11:12:06',4,60),(33,'2019-06-28 11:11:21',NULL,NULL,0,30),(34,'2019-06-28 14:01:25','2019-06-28 14:02:22','2019-06-28 14:02:31',2,45),(35,'2019-06-28 14:02:43',NULL,'2019-06-28 14:02:50',4,60),(36,'2019-06-30 21:06:46',NULL,'2019-06-30 21:10:53',4,60),(37,'2019-06-30 21:11:20','2019-06-30 21:11:28','2019-06-30 21:12:00',2,60),(38,'2019-07-03 18:08:12','2019-07-03 18:08:43',NULL,1,60);
/*!40000 ALTER TABLE `visitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `worker`
--

DROP TABLE IF EXISTS `worker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `worker` (
  `id` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `salary` float NOT NULL,
  `work` varchar(20) NOT NULL,
  `state` int(11) DEFAULT '1',
  `starttime` datetime DEFAULT CURRENT_TIMESTAMP,
  `endtime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `worker`
--

LOCK TABLES `worker` WRITE;
/*!40000 ALTER TABLE `worker` DISABLE KEYS */;
INSERT INTO `worker` VALUES (3,'cym',1200,'扫地',4,'2019-06-24 19:24:38','2019-06-24 19:44:13'),(4,'cym',1400,'拖地',1,'2019-06-24 19:24:38',NULL),(5,'cym',1600,'洗碗',1,'2019-06-24 19:24:38',NULL),(11,'段义浩',20,'扫地',1,'2019-06-25 08:51:26',NULL),(13,'员工1',1200.11,'扫地',0,'2019-06-26 00:55:30',NULL),(20,'崔雨鸣',800000,'扫地',1,'2019-06-28 09:10:17',NULL),(22,'戴磊111',12123,'扫地',1,'2019-06-28 14:07:33',NULL);
/*!40000 ALTER TABLE `worker` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-07-14 13:46:41
