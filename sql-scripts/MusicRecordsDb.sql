CREATE DATABASE  IF NOT EXISTS `MusicDb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `MusicDb`;
-- MySQL dump 10.13  Distrib 8.0.13, for macos10.14 (x86_64)
--
-- Host: localhost    Database: MusicDb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `musicTbl`
--

DROP TABLE IF EXISTS `musicTbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `musicTbl` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `albumTitle` varchar(255) NOT NULL,
  `albumArtist` varchar(255) NOT NULL,
  `numberOfSongs` int(11) NOT NULL,
  `songTitle` varchar(255) NOT NULL,
  `songNumber` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `musicTbl`
--

LOCK TABLES `musicTbl` WRITE;
/*!40000 ALTER TABLE `musicTbl` DISABLE KEYS */;
INSERT INTO `musicTbl` VALUES (3,'Motivation','Mavado',9,'SuperHuman',0),(4,'Spring Dale','Rihana',12,'unlucky',0),(5,'Tremmors','T-Pain',3,'Church',0),(6,'Thriller','Michael Jackson',18,'Moon Walker',0),(7,'Rocky me','Pink',5,'Stronger',0),(8,'Level up','Avicii',10,'Sometimes',0),(9,'Changes','R kelly',5,'Storm is over now',0),(11,'All of me','John legend',5,'All of me',4),(12,'Am alive','Celine deon',6,'Coming back to me',0),(13,'incredible','Neyo',7,'Miss indipedent',0),(14,'Oceans will part','Hillsong',12,'Emmanuel',0),(15,'Women of faith','Wonerful merciful savior',8,'Trading my sorrows',9),(16,'Don moen','He never sleeps',14,'Our father',0),(17,'Casting crowns','Jesus friend of sinners',13,'From East to west',0),(18,'Mariah carey','Together',12,'Beautiful',0),(19,'Westlife','Grow old with you',17,'Coast to coast',7),(20,'Brandy','Piano man',10,'Long distance',0),(21,'King Of Lords','Jehova',20,'Above Everything',4),(22,'King Of Kings','Jehova',20,'Above Everything',4),(23,'Java ','Fredrick ',10,'Design Pattern',2);
/*!40000 ALTER TABLE `musicTbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `Users` (
  `Users_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Users_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'MusicDb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-04  2:20:34
