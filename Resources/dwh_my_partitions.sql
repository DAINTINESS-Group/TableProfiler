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
-- Table structure for table `my_partitions`
--

DROP TABLE IF EXISTS `my_partitions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `my_partitions` (
  `TABLE_CATALOG` varchar(64) DEFAULT NULL,
  `TABLE_SCHEMA` varchar(64) DEFAULT NULL,
  `TABLE_NAME` varchar(64) NOT NULL,
  `PARTITION_NAME` varchar(64) DEFAULT NULL,
  `SUBPARTITION_NAME` varchar(64) DEFAULT NULL,
  `PARTITION_ORDINAL_POSITION` int unsigned DEFAULT NULL,
  `SUBPARTITION_ORDINAL_POSITION` int unsigned DEFAULT NULL,
  `PARTITION_METHOD` varchar(13) DEFAULT NULL,
  `SUBPARTITION_METHOD` varchar(13) DEFAULT NULL,
  `PARTITION_EXPRESSION` varchar(2048) DEFAULT NULL,
  `SUBPARTITION_EXPRESSION` varchar(2048) DEFAULT NULL,
  `PARTITION_DESCRIPTION` text,
  `TABLE_ROWS` bigint unsigned DEFAULT NULL,
  `AVG_ROW_LENGTH` bigint unsigned DEFAULT NULL,
  `DATA_LENGTH` bigint unsigned DEFAULT NULL,
  `MAX_DATA_LENGTH` bigint unsigned DEFAULT NULL,
  `INDEX_LENGTH` bigint unsigned DEFAULT NULL,
  `DATA_FREE` bigint unsigned DEFAULT NULL,
  `CREATE_TIME` timestamp NOT NULL,
  `UPDATE_TIME` datetime DEFAULT NULL,
  `CHECK_TIME` datetime DEFAULT NULL,
  `CHECKSUM` bigint DEFAULT NULL,
  `PARTITION_COMMENT` text NOT NULL,
  `NODEGROUP` varchar(256) DEFAULT NULL,
  `TABLESPACE_NAME` varchar(268) DEFAULT NULL,
  UNIQUE KEY `UK_partitions` (`TABLE_CATALOG`,`TABLE_SCHEMA`,`TABLE_NAME`),
  CONSTRAINT `FK_partitions` FOREIGN KEY (`TABLE_CATALOG`, `TABLE_SCHEMA`, `TABLE_NAME`) REFERENCES `my_sample_tables` (`TABLE_CATALOG`, `TABLE_SCHEMA`, `TABLE_NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `my_partitions`
--

LOCK TABLES `my_partitions` WRITE;
/*!40000 ALTER TABLE `my_partitions` DISABLE KEYS */;
/*!40000 ALTER TABLE `my_partitions` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 20:22:44
