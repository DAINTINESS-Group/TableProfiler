-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: dwh
-- ------------------------------------------------------
-- Server version	8.0.34

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `my_columns`
--

DROP TABLE IF EXISTS `my_columns`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_columns` (
  `TABLE_CATALOG` varchar(64) DEFAULT NULL,
  `TABLE_SCHEMA` varchar(64) DEFAULT NULL,
  `TABLE_NAME` varchar(64) DEFAULT NULL,
  `COLUMN_NAME` varchar(64) DEFAULT NULL,
  `ORDINAL_POSITION` int unsigned NOT NULL,
  `COLUMN_DEFAULT` text,
  `IS_NULLABLE` varchar(3) NOT NULL,
  `DATA_TYPE` longtext,
  `CHARACTER_MAXIMUM_LENGTH` bigint DEFAULT NULL,
  `CHARACTER_OCTET_LENGTH` bigint DEFAULT NULL,
  `NUMERIC_PRECISION` bigint unsigned DEFAULT NULL,
  `NUMERIC_SCALE` bigint unsigned DEFAULT NULL,
  `DATETIME_PRECISION` int unsigned DEFAULT NULL,
  `CHARACTER_SET_NAME` varchar(64) DEFAULT NULL,
  `COLLATION_NAME` varchar(64) DEFAULT NULL,
  `COLUMN_TYPE` mediumtext NOT NULL,
  `COLUMN_KEY` enum('','PRI','UNI','MUL') NOT NULL,
  `EXTRA` varchar(256) DEFAULT NULL,
  `PRIVILEGES` varchar(154) DEFAULT NULL,
  `COLUMN_COMMENT` text NOT NULL,
  `GENERATION_EXPRESSION` longtext NOT NULL,
  `SRS_ID` int unsigned DEFAULT NULL,
  UNIQUE KEY `UK_columns` (`TABLE_CATALOG`,`TABLE_SCHEMA`,`TABLE_NAME`),
  CONSTRAINT `FK_columns` FOREIGN KEY (`TABLE_CATALOG`, `TABLE_SCHEMA`, `TABLE_NAME`) REFERENCES `my_sample_tables` (`TABLE_CATALOG`, `TABLE_SCHEMA`, `TABLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_columns`
--

LOCK TABLES `my_columns` WRITE;
/*!40000 ALTER TABLE `my_columns` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_columns` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 20:22:45
