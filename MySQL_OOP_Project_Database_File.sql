-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- Database for the OOP_Project

-- Authors : 
--      Nilessh P.
--      Yomal I. M.
--      Bandara K. M. D. I.

-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --
-- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- -- --

-- SQL script

CREATE DATABASE  IF NOT EXISTS `oop_project` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `oop_project`;
-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: oop_project
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `classroom`
--

DROP TABLE IF EXISTS `classroom`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `classroom` (
  `class_id` varchar(8) NOT NULL,
  `teacher_id` varchar(8) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `capacity` int DEFAULT NULL,
  PRIMARY KEY (`class_id`),
  KEY `fk90` (`teacher_id`),
  CONSTRAINT `fk90` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `cl3_id_ch` CHECK (regexp_like(`class_id`,_utf8mb4'^C[0-9]{7}$')),
  CONSTRAINT `teach4_id_ch` CHECK (regexp_like(`teacher_id`,_utf8mb4'^T[0-9]{7}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classroom`
--

LOCK TABLES `classroom` WRITE;
/*!40000 ALTER TABLE `classroom` DISABLE KEYS */;
INSERT INTO `classroom` VALUES ('C0000001','T0000002','3rd floor main building',40),('C0000002','T0000003','6th floor main Building',53),('C0000003','T0000001','2nd floor old Building',42),('C0000004','T0000005','Basement  new Building',71),('C0000005','T0000004','7th floor new building',20);
/*!40000 ALTER TABLE `classroom` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `examination`
--

DROP TABLE IF EXISTS `examination`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `examination` (
  `exam_id` varchar(8) NOT NULL,
  `sub_id` varchar(8) DEFAULT NULL,
  `exam_type` varchar(15) DEFAULT NULL,
  `duration` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`exam_id`),
  KEY `fk93` (`sub_id`),
  CONSTRAINT `fk93` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`),
  CONSTRAINT `exam2_id_ch` CHECK (regexp_like(`exam_id`,_utf8mb4'^EXAM[0-9]{4}$')),
  CONSTRAINT `sub6_id_ch` CHECK (regexp_like(`sub_id`,_utf8mb4'^SUB[0-9]{5}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `examination`
--

LOCK TABLES `examination` WRITE;
/*!40000 ALTER TABLE `examination` DISABLE KEYS */;
INSERT INTO `examination` VALUES ('EXAM0001','SUB00021','Written','2h'),('EXAM0002','SUB00024','Written','1h and 30 min'),('EXAM0003','SUB00025','Computer Based','2h'),('EXAM0004','SUB00022','Computer Based','1h'),('EXAM0005','SUB00026','Written','3h');
/*!40000 ALTER TABLE `examination` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratory`
--

DROP TABLE IF EXISTS `laboratory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratory` (
  `lab_id` varchar(8) NOT NULL,
  `purpose` varchar(30) DEFAULT NULL,
  `location` varchar(50) DEFAULT NULL,
  `teacher_id` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`lab_id`),
  KEY `fk9` (`teacher_id`),
  CONSTRAINT `fk9` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`),
  CONSTRAINT `lab_id_ch` CHECK (regexp_like(`lab_id`,_utf8mb4'^L[0-9]{7}$')),
  CONSTRAINT `teach7_id_ch` CHECK (regexp_like(`teacher_id`,_utf8mb4'^T[0-9]{7}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `laboratory`
--

LOCK TABLES `laboratory` WRITE;
/*!40000 ALTER TABLE `laboratory` DISABLE KEYS */;
INSERT INTO `laboratory` VALUES ('L0000010','scientific','Basement main bulding','T0000001'),('L0000020','mathamatical','next to auditorium','T0000002'),('L0000030','scientific','8 th floor new building','T0000004'),('L0000040','scientific','8 th floor new building','T0000003'),('L0000050','scientific','11 th floor new building','T0000005');
/*!40000 ALTER TABLE `laboratory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `principal`
--

DROP TABLE IF EXISTS `principal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `principal` (
  `principal_id` varchar(8) NOT NULL,
  `principal_f_name` varchar(50) NOT NULL,
  `principal_l_name` varchar(50) NOT NULL,
  `p_email` varchar(50) DEFAULT NULL,
  `p_contact` varchar(10) DEFAULT NULL,
  `position` varchar(50) DEFAULT NULL,
  `p_address` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`principal_id`),
  CONSTRAINT `g3_ch` CHECK (regexp_like(`gender`,_utf8mb4'^(M|F)$')),
  CONSTRAINT `p_em` CHECK (regexp_like(`p_email`,_utf8mb4'.*@.*')),
  CONSTRAINT `pon_ch` CHECK (regexp_like(`p_contact`,_utf8mb4'^[0-9]{10}$')),
  CONSTRAINT `prin_id_ch` CHECK (regexp_like(`principal_id`,_utf8mb4'^P[0-9]{7}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `principal`
--

LOCK TABLES `principal` WRITE;
/*!40000 ALTER TABLE `principal` DISABLE KEYS */;
INSERT INTO `principal` VALUES ('P0000001','Senara','Bandara','senara@gmail.com','0729000000','Vice Principal','no25 main road matara','F'),('P0000002','Kamal','Gunaratane','Kamal@yahoo.com','0719997709','Deputy Principal','no22 lake road Colombo','M'),('P0000003','Gayanuka','Weerasekara','gayanuka@gmail.com','0749998795','Deputy Principal','No 84 wall street Colombo','M'),('P0000004','Induwara','Muthugala','muthugala@yahoo.com','0769997874','Vice Principal','No 99 Ruhunu road Colombo','M'),('P0000005','Sachin','Muthumal','muthumala@gmail.com','0789997900','Principal','No 67 nittambuwa Colombo','M');
/*!40000 ALTER TABLE `principal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` varchar(8) NOT NULL,
  `student_f_name` varchar(50) NOT NULL,
  `student_l_name` varchar(50) NOT NULL,
  `s_address` varchar(100) DEFAULT NULL,
  `s_contact` varchar(10) DEFAULT NULL,
  `s_email` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `class_id` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `fk1` (`class_id`),
  CONSTRAINT `fk1` FOREIGN KEY (`class_id`) REFERENCES `classroom` (`class_id`),
  CONSTRAINT `cl_id_ch` CHECK (regexp_like(`class_id`,_utf8mb4'^C[0-9]{7}$')),
  CONSTRAINT `g_ch` CHECK (regexp_like(`gender`,_utf8mb4'^(M|F)$')),
  CONSTRAINT `pon_ch6` CHECK (regexp_like(`s_contact`,_utf8mb4'^[0-9]{10}$')),
  CONSTRAINT `s_em` CHECK (regexp_like(`s_email`,_utf8mb4'.*@.*')),
  CONSTRAINT `s_id_ch` CHECK (regexp_like(`student_id`,_utf8mb4'^S[0-9]{7}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES ('S0000001','Nimal','Rathnayake','no05 main road Colombo','0759595685','nimal@gmail.com','M','C0000001'),('S0000002','Kuasl','Perara','no20 cross road Colombo','0728887794','kusal@yahoo.com','M','C0000002'),('S0000003','Lasith','Malinga','no10 Dias road Colombo','0721111111','malinga@gmail.com','M','C0000003'),('S0000004','Dharmasena','Kumar','no17 ceresent drive Colombo','0729990000','kumar@yahoo.com','M','C0000004'),('S0000005','Janith','Mlashan','no12 kinsey place Colombo','0729991111','janith@gmail.com','M','C0000001');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `sub_id` varchar(8) NOT NULL,
  `sub_name` varchar(40) NOT NULL,
  `no_of_modules` int DEFAULT NULL,
  PRIMARY KEY (`sub_id`),
  CONSTRAINT `sub3_id_ch` CHECK (regexp_like(`sub_id`,_utf8mb4'^SUB[0-9]{5}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES ('SUB00021','Science',7),('SUB00022','Mathamatics',9),('SUB00024','Sinhala',6),('SUB00025','History',7),('SUB00026','English',4);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacher_id` varchar(8) NOT NULL,
  `teacher_f_name` varchar(50) NOT NULL,
  `teacher_l_name` varchar(50) NOT NULL,
  `sub_id` varchar(8) DEFAULT NULL,
  `t_email` varchar(50) DEFAULT NULL,
  `t_contact` varchar(10) DEFAULT NULL,
  `qualification` varchar(200) DEFAULT NULL,
  `t_address` varchar(100) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk6` (`sub_id`),
  CONSTRAINT `fk6` FOREIGN KEY (`sub_id`) REFERENCES `subject` (`sub_id`),
  CONSTRAINT `g1_ch` CHECK (regexp_like(`gender`,_utf8mb4'^(M|F)$')),
  CONSTRAINT `pon2_ch` CHECK (regexp_like(`t_contact`,_utf8mb4'^[0-9]{10}$')),
  CONSTRAINT `sub2_id_ch` CHECK (regexp_like(`sub_id`,_utf8mb4'^SUB[0-9]{5}$')),
  CONSTRAINT `t_em` CHECK (regexp_like(`t_email`,_utf8mb4'.*@.*')),
  CONSTRAINT `teach2_id_ch` CHECK (regexp_like(`teacher_id`,_utf8mb4'^T[0-9]{7}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES ('T0000001','Kumara','Lalith','SUB00021','lk@gmail.com','0729997794','BSC','no10 olcoat mawatha Colombo','M'),('T0000002','Isuru','Udana','SUB00021','isuru@yahoo.com','0719997701','BSC','no20 vihara mawatha Colombo','M'),('T0000003','Lahiru','Thirumane',NULL,'thirumana@gmail.com','0749998801','MSC','No 10 kaduwela Colombo','M'),('T0000004','Silva','Dhananjaya','SUB00026','silva@yahoo.com','0769997709','MSC','No 30 malabe Colombo','M'),('T0000005','Miler','David','SUB00024','Miler@gmail.com','0789997701','PHD','No 1 bangalawatha road kothalawa Colombo','M');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` varchar(4) NOT NULL,
  `user_name` varchar(30) NOT NULL,
  `account_type` varchar(30) DEFAULT NULL,
  `u_email` varchar(50) DEFAULT NULL,
  `u_contact` char(10) DEFAULT NULL,
  `u_address` varchar(80) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `u_password` varchar(25) NOT NULL,
  PRIMARY KEY (`user_id`),
  CONSTRAINT `g9_ch` CHECK (regexp_like(`gender`,_utf8mb4'^(M|F)$')),
  CONSTRAINT `pon_ch78` CHECK (regexp_like(`u_contact`,_utf8mb4'^[0-9]{10}$')),
  CONSTRAINT `u_email` CHECK (regexp_like(`u_email`,_utf8mb4'.*@.*')),
  CONSTRAINT `u_id` CHECK (regexp_like(`user_id`,_utf8mb4'^U[0-9]{3}$'))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('U001','Malith','Admin','malith@gmail.com','0728212347','no 111 Galle road matara','M','admin@123'),('U002','Yomal','Staff','yomal@yahoo.com','0719900009','no27 garden road Colombo','M','western123'),('U003','Akinthu','Staff','ak@gmail.com','0749998405','No 104 monkey street Colombo','M','aks&123'),('U004','Induwara','Vice Principal','muthugala@yahoo.com','0769997874','No 99 Ruhunu road Colombo','M','muth123'),('U005','Sachin','Principal','muthumala@gmail.com','0789997900','No 67 nittambuwa Colombo','M','apple123'),('U006','Damith','Admin','d123@gmail.com','0701454289','101, kottawa, colombo','M','d123');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-10-22 16:34:23
