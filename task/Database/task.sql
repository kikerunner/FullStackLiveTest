-- MySQL dump 10.13  Distrib 5.7.25, for Linux (x86_64)
--
-- Host: localhost    Database: Task
-- ------------------------------------------------------
-- Server version	5.7.25-0ubuntu0.18.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Priorities`
--

DROP TABLE IF EXISTS `Priorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Priorities` (
  `IdPriority` int(11) NOT NULL AUTO_INCREMENT,
  `PriorityName` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`IdPriority`),
  UNIQUE KEY `IdPriority_UNIQUE` (`IdPriority`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Priorities`
--

LOCK TABLES `Priorities` WRITE;
/*!40000 ALTER TABLE `Priorities` DISABLE KEYS */;
INSERT INTO `Priorities` VALUES (1,'NonUrgent'),(2,'Urgent'),(3,'Optional'),(6,'Exceptional'),(7,'Mandatory');
/*!40000 ALTER TABLE `Priorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Status`
--

DROP TABLE IF EXISTS `Status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Status` (
  `idStatus` int(11) NOT NULL AUTO_INCREMENT,
  `statusName` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idStatus`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Status`
--

LOCK TABLES `Status` WRITE;
/*!40000 ALTER TABLE `Status` DISABLE KEYS */;
INSERT INTO `Status` VALUES (1,'toDo'),(2,'inProgress'),(3,'Done');
/*!40000 ALTER TABLE `Status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Tasks`
--

DROP TABLE IF EXISTS `Tasks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Tasks` (
  `idTask` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `Description` varchar(45) COLLATE utf8_spanish_ci DEFAULT NULL,
  `DeadLine` date DEFAULT NULL,
  `IdPriority` int(11) NOT NULL,
  `idStatus` int(11) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`idTask`),
  UNIQUE KEY `idTask_UNIQUE` (`idTask`),
  KEY `fk_Tasks_1_idx` (`IdPriority`),
  KEY `fk_Tasks_2_idx` (`idStatus`),
  KEY `fk_Tasks_3_idx` (`idUser`),
  KEY `fk_Tasks_4_idx` (`idUser`),
  CONSTRAINT `fk_Tasks_1` FOREIGN KEY (`IdPriority`) REFERENCES `Priorities` (`IdPriority`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tasks_2` FOREIGN KEY (`idStatus`) REFERENCES `Status` (`idStatus`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Tasks_3` FOREIGN KEY (`idUser`) REFERENCES `Users` (`idUser`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Tasks`
--

LOCK TABLES `Tasks` WRITE;
/*!40000 ALTER TABLE `Tasks` DISABLE KEYS */;
INSERT INTO `Tasks` VALUES (1,'Buy Flowers','Buy the best flowers','1997-05-20',1,1,1),(2,'Sell Flowers','Sell the best flowers','1998-04-10',2,2,1),(3,'Test','test','1998-04-10',1,1,2),(4,'Flowers','uy moer flow','2020-05-05',1,2,1),(5,'Ejemplo1','Ejemplo creación1','2020-05-06',2,2,2),(6,'Ejemplo','Ejemplo con Maria','2020-05-05',1,1,2),(7,'Buy Flowers','Buy the best flowers2','1997-05-20',2,2,1),(8,'Buy Water','I need to buy water for the sunday race.','2020-05-08',1,2,1),(11,'One More time','One more task','2020-05-22',1,1,1);
/*!40000 ALTER TABLE `Tasks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Users`
--

DROP TABLE IF EXISTS `Users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Users` (
  `idUser` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `surname` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`idUser`),
  UNIQUE KEY `idUser_UNIQUE` (`idUser`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Users`
--

LOCK TABLES `Users` WRITE;
/*!40000 ALTER TABLE `Users` DISABLE KEYS */;
INSERT INTO `Users` VALUES (1,'Enrique','Garcia','123'),(2,'Maria','Garcia','123');
/*!40000 ALTER TABLE `Users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-30 16:01:16
