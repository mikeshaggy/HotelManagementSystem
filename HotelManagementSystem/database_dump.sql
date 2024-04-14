-- MySQL dump 10.13  Distrib 8.3.0, for macos14.2 (arm64)
--
-- Host: localhost    Database: hotel_management
-- ------------------------------------------------------
-- Server version	8.3.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `address` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `street_name` varchar(100) DEFAULT NULL,
  `street_number` varchar(20) DEFAULT NULL,
  `apt_number` varchar(20) DEFAULT NULL,
  `post_code` varchar(20) DEFAULT NULL,
  `city` varchar(100) DEFAULT NULL,
  `country` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking`
--

DROP TABLE IF EXISTS `booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `people` int DEFAULT NULL,
  `total_price` decimal(10,2) DEFAULT NULL,
  `booking_status_id` int DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `guest_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `guest_id` (`guest_id`),
  KEY `booking_status_id` (`booking_status_id`),
  KEY `room_id` (`room_id`),
  CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`guest_id`) REFERENCES `guest` (`id`),
  CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`booking_status_id`) REFERENCES `booking_status` (`id`),
  CONSTRAINT `booking_ibfk_3` FOREIGN KEY (`room_id`) REFERENCES `room` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking`
--

LOCK TABLES `booking` WRITE;
/*!40000 ALTER TABLE `booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `booking_status`
--

DROP TABLE IF EXISTS `booking_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `booking_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `booking_status`
--

LOCK TABLES `booking_status` WRITE;
/*!40000 ALTER TABLE `booking_status` DISABLE KEYS */;
INSERT INTO `booking_status` VALUES (1,'PENDING'),(2,'CONFIRMED'),(3,'CANCELLED'),(4,'CHECKED_IN'),(5,'CHECKED_OUT'),(6,'NO_SHOW');
/*!40000 ALTER TABLE `booking_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_service`
--

DROP TABLE IF EXISTS `extra_service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `price_per_person` tinyint(1) DEFAULT NULL,
  `extra_service_category_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `extra_service_category_id` (`extra_service_category_id`),
  CONSTRAINT `extra_service_ibfk_1` FOREIGN KEY (`extra_service_category_id`) REFERENCES `extra_service_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_service`
--

LOCK TABLES `extra_service` WRITE;
/*!40000 ALTER TABLE `extra_service` DISABLE KEYS */;
INSERT INTO `extra_service` VALUES (1,'Private Dining Experience',150.00,1,1),(2,'Gourmet Picnic Basket',80.00,0,1),(3,'Room Service',10.00,0,1),(4,'Aromatherapy Massage',120.00,1,2),(5,'Hot Stone Massage',150.00,1,2),(6,'Wellness Workshop',30.00,1,2),(7,'Bicycle Rental',20.00,1,3),(8,'Guided Hiking Tour',50.00,1,3),(9,'Art Workshop',40.00,1,3),(10,'Personalized City Tour',100.00,1,4),(11,'Airport Transfer',20.00,0,4),(12,'In-Room Champagne & Flowers',100.00,0,4),(13,'Pet-Friendly Amentities',25.00,0,5);
/*!40000 ALTER TABLE `extra_service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_service_booking`
--

DROP TABLE IF EXISTS `extra_service_booking`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_service_booking` (
  `extra_service_id` int NOT NULL,
  `booking_id` bigint NOT NULL,
  PRIMARY KEY (`extra_service_id`,`booking_id`),
  KEY `booking_id` (`booking_id`),
  CONSTRAINT `extra_service_booking_ibfk_1` FOREIGN KEY (`extra_service_id`) REFERENCES `extra_service` (`id`),
  CONSTRAINT `extra_service_booking_ibfk_2` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_service_booking`
--

LOCK TABLES `extra_service_booking` WRITE;
/*!40000 ALTER TABLE `extra_service_booking` DISABLE KEYS */;
/*!40000 ALTER TABLE `extra_service_booking` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extra_service_category`
--

DROP TABLE IF EXISTS `extra_service_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `extra_service_category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extra_service_category`
--

LOCK TABLES `extra_service_category` WRITE;
/*!40000 ALTER TABLE `extra_service_category` DISABLE KEYS */;
INSERT INTO `extra_service_category` VALUES (1,'FOOD_AND_BEVERAGE'),(2,'SPA_WELLNESS'),(3,'RECREATIONAL'),(4,'CONCIERGE'),(5,'OTHER');
/*!40000 ALTER TABLE `extra_service_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest`
--

DROP TABLE IF EXISTS `guest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `guest` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  `id_card_number` varchar(50) DEFAULT NULL,
  `address_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `address_id` (`address_id`),
  CONSTRAINT `guest_ibfk_1` FOREIGN KEY (`address_id`) REFERENCES `address` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest`
--

LOCK TABLES `guest` WRITE;
/*!40000 ALTER TABLE `guest` DISABLE KEYS */;
/*!40000 ALTER TABLE `guest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room` (
  `id` int NOT NULL AUTO_INCREMENT,
  `room_number` varchar(5) DEFAULT NULL,
  `base_price` decimal(5,2) DEFAULT NULL,
  `room_type_id` int DEFAULT NULL,
  `room_status_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `room_type_id` (`room_type_id`),
  KEY `room_status_id` (`room_status_id`),
  CONSTRAINT `room_ibfk_1` FOREIGN KEY (`room_type_id`) REFERENCES `room_type` (`id`),
  CONSTRAINT `room_ibfk_2` FOREIGN KEY (`room_status_id`) REFERENCES `room_status` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (1,'104',100.00,1,1),(2,'105',100.00,1,1),(3,'106',100.00,1,1),(4,'107',100.00,1,1),(5,'108',100.00,1,1),(6,'109',100.00,1,1),(7,'110',100.00,1,1),(8,'111',100.00,1,1),(9,'112',100.00,1,1),(10,'113',100.00,1,1),(11,'114',100.00,2,1),(12,'115',100.00,2,1),(13,'116',100.00,2,1),(14,'117',100.00,2,1),(15,'118',100.00,2,1),(16,'119',100.00,2,1),(17,'120',100.00,2,1),(18,'121',100.00,2,1),(19,'122',100.00,2,1),(20,'123',100.00,2,1),(21,'124',100.00,2,1),(22,'125',100.00,2,1),(23,'126',100.00,2,1),(24,'127',100.00,2,1),(25,'128',100.00,2,1),(26,'129',100.00,2,1),(27,'130',100.00,3,1),(28,'131',100.00,3,1),(29,'132',100.00,3,1),(30,'133',100.00,3,1),(31,'134',100.00,3,1),(32,'135',100.00,3,1),(33,'136',100.00,3,1),(34,'137',100.00,3,1),(35,'138',100.00,3,1),(36,'139',100.00,3,1),(37,'140',100.00,3,1),(38,'141',100.00,3,1),(39,'142',100.00,3,1),(40,'143',100.00,3,1),(41,'144',100.00,3,1),(42,'145',100.00,3,1),(43,'146',150.00,4,1),(44,'148',150.00,4,1),(45,'150',150.00,4,1),(46,'152',150.00,4,1),(47,'154',150.00,4,1),(48,'156',150.00,4,1),(49,'158',200.00,6,1),(50,'160',200.00,6,1),(51,'162',200.00,6,1),(52,'147',150.00,5,1),(53,'149',150.00,5,1),(54,'151',150.00,5,1),(55,'153',150.00,5,1),(56,'155',150.00,5,1),(57,'157',150.00,5,1),(58,'159',250.00,7,1),(59,'161',250.00,7,1),(60,'163',250.00,7,1);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_status`
--

DROP TABLE IF EXISTS `room_status`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_status` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_status`
--

LOCK TABLES `room_status` WRITE;
/*!40000 ALTER TABLE `room_status` DISABLE KEYS */;
INSERT INTO `room_status` VALUES (1,'CLEAN'),(2,'DIRTY'),(3,'UNDER_MAINTENANCE'),(4,'OUT_OF_ORDER');
/*!40000 ALTER TABLE `room_status` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room_type`
--

DROP TABLE IF EXISTS `room_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `room_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room_type`
--

LOCK TABLES `room_type` WRITE;
/*!40000 ALTER TABLE `room_type` DISABLE KEYS */;
INSERT INTO `room_type` VALUES (1,'CLASSIC_SINGLE'),(2,'CLASSIC_DOUBLE'),(3,'CLASSIC_TWIN'),(4,'DELUXE_DOUBLE'),(5,'DELUXE_TWIN'),(6,'SUITE'),(7,'EXECUTIVE_SUITE');
/*!40000 ALTER TABLE `room_type` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-14 15:15:20
