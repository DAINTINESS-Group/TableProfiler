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
-- Table structure for table `countries`
--

DROP TABLE IF EXISTS `countries`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `countries` (
  `country_id` int NOT NULL AUTO_INCREMENT,
  `country_code` varchar(2) DEFAULT NULL,
  `country_name` varchar(50) DEFAULT NULL,
  `country_area` float DEFAULT NULL,
  PRIMARY KEY (`country_id`)
) ENGINE=InnoDB AUTO_INCREMENT=229 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `countries`
--

LOCK TABLES `countries` WRITE;
/*!40000 ALTER TABLE `countries` DISABLE KEYS */;
INSERT INTO `countries` VALUES (1,'AF','Afghanistan',652230),(2,'AL','Albania',27398),(3,'AG','Algeria',2381740),(4,'AQ','American Samoa',199),(5,'AN','Andorra',468),(6,'AO','Angola',1246700),(7,'AV','Anguilla',91),(8,'AC','Antigua and Barbuda',442.6),(9,'AR','Argentina',2736690),(10,'AM','Armenia',28203),(11,'AA','Aruba',180),(12,'AS','Australia',7682300),(13,'AU','Austria',82445),(14,'AJ','Azerbaijan',82629),(15,'BF','Bahamas The',10010),(16,'BA','Bahrain',760),(17,'BG','Bangladesh',130170),(18,'BB','Barbados',430),(19,'BO','Belarus',202900),(20,'BE','Belgium',30278),(21,'BH','Belize',22806),(22,'BN','Benin',110622),(23,'BD','Bermuda',54),(24,'BT','Bhutan',38394),(25,'BL','Bolivia',1083300),(26,'BK','Bosnia and Herzegovina',51187),(27,'BC','Botswana',566730),(28,'BR','Brazil',8358140),(29,'BX','Brunei',5265),(30,'BU','Bulgaria',108489),(31,'UV','Burkina Faso',273800),(32,'BM','Burma',653508),(33,'BY','Burundi',25680),(34,'CV','Cabo Verde',4033),(35,'CB','Cambodia',176515),(36,'CM','Cameroon',472710),(37,'CA','Canada',9093510),(38,'CJ','Cayman Islands',264),(39,'CT','Central African Republic',622984),(40,'CD','Chad',1259200),(41,'CI','Chile',743812),(42,'CH','China',9326410),(43,'CO','Colombia',1038700),(44,'CN','Comoros',2235),(45,'CF','Congo (Brazzaville)',341500),(46,'CG','Congo (Kinshasa)',2267050),(47,'CW','Cook Islands',236),(48,'CS','Costa Rica',51060),(49,'IV','Cote d\'Ivoire',318003),(50,'HR','Croatia',55974),(51,'CU','Cuba',109820),(52,'UC','Curacao',444),(53,'CY','Cyprus',9241),(54,'EZ','Czechia',77247),(55,'DA','Denmark',42434),(56,'DJ','Djibouti',23180),(57,'DO','Dominica',751),(58,'DR','Dominican Republic',48320),(59,'EC','Ecuador',276841),(60,'EG','Egypt',995450),(61,'ES','El Salvador',20721),(62,'EK','Equatorial Guinea',28051),(63,'ER','Eritrea',101000),(64,'EN','Estonia',42388),(65,'ET','Ethiopia',1000000),(66,'FO','Faroe Islands',1393),(67,'FJ','Fiji',18274),(68,'FI','Finland',303815),(69,'FR','France',640427),(70,'FP','French Polynesia',3827),(71,'GB','Gabon',257667),(72,'GA','Gambia The',10120),(73,'GZ','Gaza Strip',360),(74,'GG','Georgia',69700),(75,'GM','Germany',348672),(76,'GH','Ghana',227533),(77,'GI','Gibraltar',6.5),(78,'GR','Greece',130647),(79,'GL','Greenland',2166090),(80,'GJ','Grenada',344),(81,'GQ','Guam',544),(82,'GT','Guatemala',107159),(83,'GK','Guernsey',78),(84,'GV','Guinea',245717),(85,'PU','Guinea-Bissau',28120),(86,'GY','Guyana',196849),(87,'HA','Haiti',27560),(88,'HO','Honduras',111890),(89,'HK','Hong Kong',1073),(90,'HU','Hungary',89608),(91,'IC','Iceland',100250),(92,'IN','India',2973190),(93,'ID','Indonesia',1811570),(94,'IR','Iran',1531600),(95,'IZ','Iraq',437367),(96,'EI','Ireland',68883),(97,'IM','Isle of Man',572),(98,'IS','Israel',20330),(99,'IT','Italy',294140),(100,'JM','Jamaica',10831),(101,'JA','Japan',364485),(102,'JE','Jersey',116),(103,'JO','Jordan',88802),(104,'KZ','Kazakhstan',2699700),(105,'KE','Kenya',569140),(106,'KR','Kiribati',811),(107,'KN','Korea North',120408),(108,'KS','Korea South',96920),(109,'KV','Kosovo',10887),(110,'KU','Kuwait',17818),(111,'KG','Kyrgyzstan',191801),(112,'LA','Laos',230800),(113,'LG','Latvia',62249),(114,'LE','Lebanon',10230),(115,'LT','Lesotho',30355),(116,'LI','Liberia',96320),(117,'LY','Libya',1759540),(118,'LS','Liechtenstein',160),(119,'LH','Lithuania',62680),(120,'LU','Luxembourg',2586),(121,'MC','Macau',28.2),(122,'MK','Macedonia',25433),(123,'MA','Madagascar',581540),(124,'MI','Malawi',94080),(125,'MY','Malaysia',328657),(126,'MV','Maldives',298),(127,'ML','Mali',1220190),(128,'MT','Malta',316),(129,'RM','Marshall Islands',181),(130,'MR','Mauritania',1030700),(131,'MP','Mauritius',2030),(132,'MX','Mexico',1943940),(133,'FM','Micronesia Federated States of',702),(134,'MD','Moldova',32891),(135,'MN','Monaco',2),(136,'MG','Mongolia',1553560),(137,'MJ','Montenegro',13452),(138,'MH','Montserrat',102),(139,'MO','Morocco',446300),(140,'MZ','Mozambique',786380),(141,'WA','Namibia',823290),(142,'NR','Nauru',21),(143,'NP','Nepal',143351),(144,'NL','Netherlands',33893),(145,'NC','New Caledonia',18275),(146,'NZ','New Zealand',264537),(147,'NU','Nicaragua',119990),(148,'NG','Niger',1266700),(149,'NI','Nigeria',910768),(150,'CQ','Northern Mariana Islands',464),(151,'NO','Norway',304282),(152,'MU','Oman',309500),(153,'PK','Pakistan',770875),(154,'PS','Palau',459),(155,'PM','Panama',74340),(156,'PP','Papua New Guinea',452860),(157,'PA','Paraguay',397302),(158,'PE','Peru',1280000),(159,'RP','Philippines',298170),(160,'PL','Poland',304255),(161,'PO','Portugal',91470),(162,'RQ','Puerto Rico',8870),(163,'QA','Qatar',11586),(164,'RO','Romania',229891),(165,'RS','Russia',16377700),(166,'RW','Rwanda',24668),(167,'TB','Saint Barthelemy',25),(168,'SH','Saint Helena',308),(169,'SC','Saint Kitts and Nevis',261),(170,'ST','Saint Lucia',606),(171,'RN','Saint Martin',54.4),(172,'SB','Saint Pierre and Miquelon',242),(173,'VC','Saint Vincent and the Grenadines',389),(174,'WS','Samoa',2821),(175,'SM','San Marino',61),(176,'TP','Sao Tome and Principe',964),(177,'SA','Saudi Arabia',2149690),(178,'SG','Senegal',192530),(179,'RI','Serbia',77474),(180,'SE','Seychelles',455),(181,'SL','Sierra Leone',71620),(182,'SN','Singapore',687),(183,'NN','Sint Maarten',34),(184,'LO','Slovakia',48105),(185,'SI','Slovenia',20151),(186,'BP','Solomon Islands',27986),(187,'SO','Somalia',627337),(188,'SF','South Africa',1214470),(189,'OD','South Sudan',644329),(190,'SP','Spain',498980),(191,'CE','Sri Lanka',64630),(192,'SU','Sudan',1861480),(193,'NS','Suriname',156000),(194,'WZ','Swaziland',17204),(195,'SW','Sweden',410335),(196,'SZ','Switzerland',39997),(197,'SY','Syria',183630),(198,'TW','Taiwan',32260),(199,'TI','Tajikistan',141510),(200,'TZ','Tanzania',885800),(201,'TH','Thailand',510890),(202,'TT','Timor-Leste',14874),(203,'TO','Togo',54385),(204,'TN','Tonga',717),(205,'TD','Trinidad and Tobago',5128),(206,'TS','Tunisia',155360),(207,'TU','Turkey',769632),(208,'TX','Turkmenistan',469930),(209,'TK','Turks and Caicos Islands',948),(210,'TV','Tuvalu',26),(211,'UG','Uganda',197100),(212,'UP','Ukraine',579330),(213,'AE','United Arab Emirates',83600),(214,'UK','United Kingdom',241930),(215,'US','United States',9147590),(216,'UY','Uruguay',175015),(217,'UZ','Uzbekistan',425400),(218,'NH','Vanuatu',12189),(219,'VE','Venezuela',882050),(220,'VM','Vietnam',310070),(221,'VI','Virgin Islands British',151),(222,'VQ','Virgin Islands U.S.',346),(223,'WF','Wallis and Futuna',142),(224,'WE','West Bank',5640),(225,'WI','Western Sahara',266000),(226,'YM','Yemen',527968),(227,'ZA','Zambia',743398),(228,'ZI','Zimbabwe',386847);
/*!40000 ALTER TABLE `countries` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-28 20:22:46
