-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: delivery4
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `addresses`
--

DROP TABLE IF EXISTS `addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `addresses` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `apartment` varchar(255) DEFAULT NULL,
  `city` varchar(255) NOT NULL,
  `house` varchar(255) NOT NULL,
  `street` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=128 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `addresses`
--

LOCK TABLES `addresses` WRITE;
/*!40000 ALTER TABLE `addresses` DISABLE KEYS */;
INSERT INTO `addresses` VALUES (2,'23','Kyiv','23','Sty'),(3,'23','Lviv','45','Str'),(4,'22','Kyiv','11','Bulvar Shevchenka'),(5,'44','Lviv','33','Leva'),(6,'44','Odesa','33','Bulvar Prymorsky'),(7,'44','Odesa','33','Parkova'),(8,'','Kyiv','11','Sadova'),(9,'','Odesa','12','Parkova'),(10,'','Odesa','13','Parkova'),(11,'22','Lviv','11','Soborna'),(12,'44','Dnipro','33','Metalurgiv'),(13,'','Odesa','33','Parkova'),(14,'','Odesa','22','Parkova'),(15,'','Kyiv','11','Bulvar Shevchenka'),(16,'','Lviv','22','Soborna'),(17,'','Kyiv','99','Sadova'),(18,'','Dnipro','88','RichPort'),(19,'','Dnipro','22','Metalurgiv'),(20,'22','Kyiv','11','Bulvar Shevchenka'),(21,'44','Odesa','33','Derybasivska'),(22,'22','Dnipro','11','Poltavska'),(23,'22','Lviv','11','Svobody'),(24,'','Kyiv','99','Sadova'),(25,'','Odesa','88','Parkova'),(26,'','Kyiv','99','Sadova'),(27,'','Odesa','88','Parkova'),(28,'','Kyiv','11','Sadova'),(29,'','Odesa','22','Parkova'),(30,'11','Київ','22','Бульвар Шевченка'),(31,'','Одеса','22','Дерибасівська'),(32,'22','Kyiv','11','Bulvar Shevchenka'),(33,'','Odesa','88','Parkova'),(34,'22','Kyiv','11','Bulvar Shevchenka'),(35,'44','Odesa','33','Derybasivska'),(36,'22','Kyiv','11','Bulvar Shevchenka'),(37,'44','Odesa','33','Parkova'),(38,'22','Kyiv','11','Bulvar Shevchenka'),(39,'','Kyiv','11','Sadova'),(40,'','Odesa','11','Bulvar Prymorsky'),(41,'','Odesa','99','Parkova'),(42,'','Kyiv','22','Sadova'),(43,'21','Kyiv','43','Myru'),(44,'','Kyiv','1','Bulvar'),(45,'','Kyiv','2','Vylytsya'),(46,'33','Kyiv','22','Bulvar Shevchenka'),(47,'55','Kyiv','44','Sadova'),(48,'22','Kyiv','11','Sadova'),(49,'','Kyiv','11','Tolstogo'),(50,'','Kyiv','22','Tolstogo'),(51,'','Kyiv','11','Nauky'),(52,'','Kyiv','22','Nauky'),(53,'44','Kyiv','33','Parkova'),(54,'','Dnipro','22','Zaporizhska'),(55,'','Lviv','1','Zamkova'),(56,'','Lviv','2','Ternopilska'),(57,'','Kyiv','33','Sadova'),(58,'','Kyiv','5','Franko'),(59,'','Lviv','6','Svobody'),(60,'','Dnipro','33','Metalurgiv'),(61,'88','Lviv','99','Soborna'),(62,'66','Dnipro','77','Metalurgiv'),(63,'','Kyiv','22','Svobody'),(64,'44','Kyiv','33','Leva'),(84,'','Kyiv','1','Po'),(85,'','Kyiv','2','Ni'),(88,'','Kyiv','1','Parkova'),(89,'','Kyiv','2','Parkova'),(90,'','Odesa','12','Parkova'),(91,'22','Lviv','11','Soborna'),(92,'22','Kyiv','12','Parkova'),(93,'','Kyiv','22','Bulvar Shevchenka'),(94,'','Львів','1','Соборна'),(95,'','Київ','2','Бульвар Шевченка'),(96,'','Київ','2','Миру'),(97,'','Київ','3','Миру'),(98,'','Київ','8','Миру'),(99,'','Київ','1','Бульвар Шевченка'),(100,'','Київ','1','Миру'),(101,'22','Дніпро','2','Металургів'),(102,'','Київ','23','Миру'),(103,'','Київ','2','Бульвар Шевченка'),(104,'','Київ','2','Миру'),(105,'','Київ','3','Бульвар Шевченка'),(106,'','Київ','1','Миру'),(107,'','Київ','2','Бульвар Шевченка'),(108,'','Київ','1','Паркова'),(109,'','Київ','2','Бульвар Шевченка'),(110,'','Київ','1','Бульвар Шевченка'),(111,'','Київ','2','Садова'),(112,'','Дніпро','12','Металургів'),(113,'','Львів','1','Соборна'),(114,'','Dnipro','12','Металургів'),(115,'2','Kyiv','1','Бульвар Шевченко'),(116,'','Dnipro','2','Metalurgiv'),(117,'','Lviv','3','Svobody'),(118,'','Kyiv','1','Bulvar Shevchenka'),(119,'','Kyiv','12','Sadova'),(120,'','Lviv','1','Soborna'),(121,'3','Kyiv','1','Bulvar Shevchenka'),(122,'','Lviv','3','Soborna'),(123,'','Odesa','2','Parkova'),(124,'','Lviv','3','Soborna'),(125,'','Odesa','2','Parkova'),(126,'','Lviv','12','Svobody'),(127,'12','Kyiv','8','Antonovycha');
/*!40000 ALTER TABLE `addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `invoices`
--

DROP TABLE IF EXISTS `invoices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `invoices` (
  `invoice_number` bigint(20) NOT NULL AUTO_INCREMENT,
  `is_paid` bit(1) NOT NULL,
  `order_number` bigint(20) NOT NULL,
  PRIMARY KEY (`invoice_number`),
  UNIQUE KEY `uniqueOrderNumberConstraint` (`order_number`),
  CONSTRAINT `FK7atj9p1bj7x11pp31g449c8po` FOREIGN KEY (`order_number`) REFERENCES `orders` (`order_number`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `invoices`
--

LOCK TABLES `invoices` WRITE;
/*!40000 ALTER TABLE `invoices` DISABLE KEYS */;
INSERT INTO `invoices` VALUES (1,_binary '',1),(2,_binary '',2),(3,_binary '',3),(4,_binary '',10),(5,_binary '',15),(6,_binary '',20),(7,_binary '',21),(8,_binary '',22),(9,_binary '\0',33),(10,_binary '',13),(11,_binary '',30),(12,_binary '',31),(13,_binary '',34),(14,_binary '',4),(15,_binary '',11),(16,_binary '',5),(17,_binary '',6),(18,_binary '',7),(19,_binary '',14),(20,_binary '\0',61),(21,_binary '',32),(22,_binary '\0',23),(23,_binary '\0',24),(24,_binary '\0',25),(25,_binary '',58),(26,_binary '',8),(27,_binary '',9),(28,_binary '',12),(29,_binary '',16),(30,_binary '\0',19),(31,_binary '\0',18),(32,_binary '\0',26),(33,_binary '',35),(34,_binary '',70),(35,_binary '\0',71),(36,_binary '\0',29),(37,_binary '',62),(38,_binary '',72),(39,_binary '\0',56);
/*!40000 ALTER TABLE `invoices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `order_number` bigint(20) NOT NULL AUTO_INCREMENT,
  `cargo_type` varchar(255) NOT NULL,
  `delivery_date` datetime NOT NULL,
  `order_status` varchar(255) NOT NULL,
  `sum` decimal(19,2) NOT NULL,
  `weight` decimal(4,2) NOT NULL,
  `delivery_address_id` bigint(20) NOT NULL,
  `dispatch_address_id` bigint(20) NOT NULL,
  `route_id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  PRIMARY KEY (`order_number`),
  KEY `FK3s2t83m5ddty3rgomn94d4ht6` (`delivery_address_id`),
  KEY `FKbipxbfwqkouochl0px3uc0iha` (`dispatch_address_id`),
  KEY `FK6wuyx1giqf3cs3yu9cc3oaiun` (`route_id`),
  KEY `FK32ql8ubntj5uh44ph9659tiih` (`user_id`),
  CONSTRAINT `FK32ql8ubntj5uh44ph9659tiih` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `FK3s2t83m5ddty3rgomn94d4ht6` FOREIGN KEY (`delivery_address_id`) REFERENCES `addresses` (`id`),
  CONSTRAINT `FK6wuyx1giqf3cs3yu9cc3oaiun` FOREIGN KEY (`route_id`) REFERENCES `routes` (`id`),
  CONSTRAINT `FKbipxbfwqkouochl0px3uc0iha` FOREIGN KEY (`dispatch_address_id`) REFERENCES `addresses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',360.00,12.00,3,2,1,1),(2,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',360.00,12.00,5,4,1,1),(3,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',300.00,10.00,5,4,1,1),(4,'FRAGILE','2020-10-12 00:00:00','READY_FOR_DISPATCH',105.00,3.00,6,4,2,1),(5,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',360.00,12.00,5,4,1,1),(6,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',175.00,5.00,6,4,2,1),(7,'FRAGILE','2020-10-12 00:00:00','READY_FOR_DISPATCH',70.00,2.00,6,4,2,1),(8,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',350.00,10.00,6,4,2,1),(9,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',300.00,10.00,5,4,1,1),(10,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',350.00,10.00,7,4,2,1),(11,'FRAGILE','2020-10-12 00:00:00','READY_FOR_DISPATCH',350.00,10.00,7,4,2,1),(12,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',300.00,10.00,5,4,1,1),(13,'REGULAR','2020-10-12 00:00:00','READY_FOR_DISPATCH',42.00,10.00,7,7,2,1),(14,'FRAGILE','2020-10-12 00:00:00','READY_FOR_DISPATCH',42.00,10.00,4,7,2,1),(15,'REGULAR','2020-05-12 00:00:00','READY_FOR_DISPATCH',35.00,3.00,9,8,2,1),(16,'REGULAR','2020-05-12 00:00:00','READY_FOR_DISPATCH',42.00,10.00,8,9,2,1),(17,'REGULAR','2020-05-12 00:00:00','OPEN',35.00,5.00,8,9,2,1),(18,'FRAGILE','2020-05-12 00:00:00','INVOICED',36.00,10.00,5,4,1,1),(19,'REGULAR','2020-05-12 00:00:00','INVOICED',42.00,10.00,10,4,2,1),(20,'REGULAR','2020-12-10 00:00:00','READY_FOR_DISPATCH',42.00,10.00,6,4,2,1),(21,'REGULAR','2020-12-10 00:00:00','READY_FOR_DISPATCH',42.00,10.00,6,4,2,1),(22,'REGULAR','2020-12-22 00:00:00','READY_FOR_DISPATCH',42.00,10.00,8,9,2,1),(23,'REGULAR','2020-12-22 00:00:00','INVOICED',35.00,3.00,6,4,2,1),(24,'REGULAR','2020-12-10 00:00:00','INVOICED',48.00,7.00,12,11,4,1),(25,'REGULAR','2019-12-11 00:00:00','INVOICED',42.00,10.00,13,4,2,1),(26,'REGULAR','2020-12-10 00:00:00','INVOICED',35.00,3.70,14,8,2,1),(27,'REGULAR','2020-12-12 00:00:00','OPEN',36.00,10.00,16,15,1,1),(28,'REGULAR','2020-03-01 00:00:00','OPEN',52.50,12.20,13,8,2,1),(29,'REGULAR','2020-05-12 00:00:00','INVOICED',42.00,10.00,14,15,2,1),(30,'REGULAR','2020-05-12 00:00:00','READY_FOR_DISPATCH',42.00,5.00,14,11,5,3),(31,'REGULAR','2020-05-12 00:00:00','READY_FOR_DISPATCH',45.60,10.00,12,4,3,3),(32,'REGULAR','2020-06-01 00:00:00','READY_FOR_DISPATCH',38.00,5.00,18,17,3,3),(33,'REGULAR','2020-05-13 00:00:00','INVOICED',57.00,14.00,19,8,3,1),(34,'REGULAR','2020-12-12 00:00:00','READY_FOR_DISPATCH',45.00,20.00,16,8,1,6),(35,'FRAGILE','2020-12-31 00:00:00','READY_FOR_DISPATCH',42.00,8.00,25,17,2,1),(36,'FRAGILE','2020-12-31 00:00:00','OPEN',42.00,8.00,25,17,2,1),(37,'REGULAR','2020-05-12 00:00:00','OPEN',35.00,5.00,14,8,2,1),(38,'FRAGILE','2020-05-12 00:00:00','OPEN',42.00,10.00,31,30,2,1),(39,'REGULAR','2020-05-12 00:00:00','OPEN',35.00,5.00,25,4,2,1),(40,'REGULAR','2020-05-12 00:00:00','OPEN',52.50,12.00,21,4,2,1),(41,'REGULAR','2020-12-12 00:00:00','OPEN',35.00,4.60,7,4,2,1),(42,'REGULAR','2020-10-12 00:00:00','OPEN',20.00,5.00,8,4,7,1),(43,'REGULAR','2020-05-12 00:00:00','OPEN',42.00,10.00,13,15,2,1),(44,'REGULAR','2020-05-12 00:00:00','OPEN',22.80,10.00,41,40,9,1),(45,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,3.00,8,4,7,1),(49,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,3.00,47,46,7,1),(51,'REGULAR','2020-08-08 00:00:00','OPEN',20.00,5.00,48,47,7,1),(53,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,3.00,52,51,7,1),(54,'REGULAR','2020-05-12 00:00:00','OPEN',30.00,20.00,53,4,7,1),(55,'REGULAR','2020-12-10 00:00:00','OPEN',40.00,5.00,23,12,4,1),(56,'REGULAR','2020-05-12 00:00:00','INVOICED',20.00,5.00,8,4,7,3),(57,'REGULAR','2020-05-12 00:00:00','OPEN',38.00,5.00,54,8,3,3),(58,'REGULAR','2020-05-12 00:00:00','READY_FOR_DISPATCH',18.00,3.00,56,55,8,3),(59,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,5.00,57,4,7,1),(60,'REGULAR','2020-12-12 00:00:00','OPEN',30.00,5.00,59,58,1,1),(61,'REGULAR','2020-05-12 00:00:00','INVOICED',38.00,5.00,60,4,3,1),(62,'REGULAR','2020-08-08 00:00:00','READY_FOR_DISPATCH',60.00,19.00,62,61,4,3),(63,'REGULAR','2020-10-12 00:00:00','OPEN',30.00,11.00,64,63,7,1),(68,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,3.00,85,84,7,1),(69,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,5.00,89,88,7,1),(70,'FRAGILE','2020-05-12 00:00:00','READY_FOR_DISPATCH',42.00,3.00,91,90,5,1),(71,'FRAGILE','2020-05-12 00:00:00','INVOICED',30.00,12.00,93,92,7,1),(72,'REGULAR','2020-05-12 00:00:00','READY_FOR_DISPATCH',30.00,5.00,95,94,1,3),(73,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,3.00,97,96,7,1),(74,'FRAGILE','2020-05-12 00:00:00','OPEN',30.00,12.00,99,98,7,1),(75,'FRAGILE','2020-05-12 00:00:00','OPEN',38.00,5.00,101,100,3,1),(76,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,3.00,103,102,7,1),(77,'REGULAR','2020-05-12 00:00:00','OPEN',30.00,12.00,105,104,7,1),(78,'REGULAR','2020-05-12 00:00:00','OPEN',20.00,5.00,107,106,7,1),(79,'REGULAR','2020-05-12 00:00:00','OPEN',24.00,8.00,109,108,7,1),(80,'REGULAR','2020-05-12 00:00:00','OPEN',24.00,8.00,111,110,7,3),(81,'REGULAR','2020-05-12 00:00:00','OPEN',48.00,8.00,113,112,4,1),(82,'REGULAR','2020-05-12 00:00:00','OPEN',57.00,20.00,115,114,3,1),(83,'FRAGILE','2020-05-12 00:00:00','OPEN',48.00,10.00,117,116,4,3),(84,'REGULAR','2020-05-12 00:00:00','OPEN',24.00,10.00,119,118,7,3),(85,'REGULAR','2020-05-12 00:00:00','OPEN',36.00,10.00,121,120,1,6),(86,'REGULAR','2020-05-12 00:00:00','OPEN',50.40,10.00,123,122,5,3),(87,'REGULAR','2020-05-12 00:00:00','OPEN',50.40,10.00,125,124,5,3),(88,'REGULAR','2020-05-12 00:00:00','OPEN',36.00,10.00,127,126,1,3);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `routes`
--

DROP TABLE IF EXISTS `routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `routes` (
  `id` bigint(20) NOT NULL,
  `basic_rate` decimal(19,2) NOT NULL,
  `point_one` varchar(255) DEFAULT NULL,
  `point_one_ua` varchar(255) NOT NULL,
  `point_two` varchar(255) NOT NULL,
  `point_two_ua` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `routes`
--

LOCK TABLES `routes` WRITE;
/*!40000 ALTER TABLE `routes` DISABLE KEYS */;
INSERT INTO `routes` VALUES (1,30.00,'Kyiv','Київ','Lviv','Львів'),(2,35.00,'Kyiv','Київ','Odesa','Одеса'),(3,38.00,'Kyiv','Київ','Dnipro','Дніпро'),(4,40.00,'Lviv','Львів','Dnipro','Дніпро'),(5,42.00,'Lviv','Львів','Odesa','Одеса'),(6,27.00,'Dnipro','Дніпро','Odesa','Одеса'),(7,20.00,'Kyiv','Київ','Kyiv','Київ'),(8,18.00,'Lviv','Львів','Lviv','Львів'),(9,19.00,'Odesa','Одеса','Odesa','Одеса'),(10,19.00,'Dnipro','Дніпро','Dnipro','Дніпро');
/*!40000 ALTER TABLE `routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) DEFAULT NULL,
  `surname` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'ivan_b@gmail.com','Ivan','$2a$10$B9YWNsOSUN.KMBTiFpxNSOSIjo3/sfV5gv.VcItUWETxr1Ap1Zskq','USER','Bilous'),(2,'yoz@ukr.net','Mari','$2a$10$qH1ONzTaU/LoyYic1M27B.2Uta.B5K2M/bktGXQPQ44cDhPeixXLK','ADMIN','Bilous'),(3,'rosa_nb@kiev.papir.ua','Розалія','$2a$10$VK8B6xaE922wCTg3rqaz7.7NJxiKRec6aELL8.2Et66qtN9rI139a','USER','Білоус'),(4,'avin@gmail.com','Anna','$2a$10$HsXPv8MjRer4uW17KG3bnu6j2mzu.HlsusD.BAHu7GFEwNQaiCtJC','USER','Vin'),(5,'rv@ukr.net','Рон','$2a$10$aZxzQmlU0VP4qusCZPH6x.RC8yLsxTGpRPGDnZLT7.wtYZ9X9ux66','USER','Віняр'),(6,'boss@ukr.net','Vova','$2a$10$ggkZKag6ZElvGUqZUT/8HuOszI7QZasc5Rb3yzvPgX4NTcD3aA4v2','ADMIN','Boss'),(9,'mari@ukr.net','Mari','$2a$10$fl5uGh124D.rXRCiWUgZGuMJ9hoz6/nJy5IrHYs3tspTL.yx5pzhC','USER','Bil'),(10,'vin@ukr.net','Vika','$2a$10$q5sG0eUoiAwEeQzEs6AFt.P9b2Vb6zmPh.W2WFxuf1uhQxJuK5ReC','USER','Vin'),(14,'tim@ukr.net','Tim','$2a$10$orbOHvi9fQ7JwWb.qtJXo.9uNoi7GZerRAqM0N33.ZReFNDiN74d6','USER','Bex'),(17,'myro@ukr.net','Myro','$2a$10$o1Xpt3O9xRh7QUjk7FkSOetNWgTMRY0wGExB9MJgTpsg8dnxo0WDG','USER','Zhuk'),(19,'oli@ukr.net','Mari','$2a$10$JVDbzV7JjbhQHK8QdtThT.KJur9OqSievJcRImiB.FcqtesSaaJgu','USER','Oliynyk'),(20,'iva@ukr.net','Ivanna','$2a$10$pd1CEgqWq9/CP1rFepcAg.BiJeRcmIy8eoswDVLyB2caAoP9QWU3y','USER','Mihnevych'),(24,'s101@gmail.com','Світлана','$2a$10$8Hlf7nBLJkNoSIezv.QHcuTZx67xF5hqQJl/96nHLmjkUexSvRirq','USER','Білоус'),(25,'y@ukr.net','Peter','$2a$10$y/uB0pSVaWoaukpM7xB3ye7oWVBBgESWZRfwP9wWUUjJjOaV1VLZK','USER','Pen'),(26,'roa_nb@kiev.papir.ua','Віктор','$2a$10$YtfVPZ1petd7Rx26oaeaQuLO.2r3Yv097PoSUUkPxyREA1sUUlpve','USER','Валь'),(29,'eva_b@gmail.com','Eva','$2a$10$tmEKfLSfwhZ1lIWdSxaOq.1cfVPUABPIVoiM/uQElp1slX2s4Hod6','USER','Block');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-25 11:42:32
