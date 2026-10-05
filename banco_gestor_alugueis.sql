-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: gestor_alugueis_db
-- ------------------------------------------------------
-- Server version	8.0.46

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
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `id_contrato` int NOT NULL AUTO_INCREMENT,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `valor_mensal` decimal(10,2) DEFAULT NULL,
  `status_contrato` varchar(25) DEFAULT NULL,
  `usuario_id_usuario` int DEFAULT NULL,
  `imovel_id_imovel` int DEFAULT NULL,
  `locatario_id_locatario` int DEFAULT NULL,
  PRIMARY KEY (`id_contrato`),
  KEY `usuario_id_usuario` (`usuario_id_usuario`),
  KEY `imovel_id_imovel` (`imovel_id_imovel`),
  KEY `locatario_id_locatario` (`locatario_id_locatario`),
  CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`imovel_id_imovel`) REFERENCES `imovel` (`id_imovel`),
  CONSTRAINT `contrato_ibfk_3` FOREIGN KEY (`locatario_id_locatario`) REFERENCES `locatario` (`id_locatario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `contrato`
--

LOCK TABLES `contrato` WRITE;
/*!40000 ALTER TABLE `contrato` DISABLE KEYS */;
INSERT INTO `contrato` VALUES (1,'2025-01-01','2025-12-31',1200.00,'Encerrado',1,1,1),(2,'2025-02-01','2025-12-31',1500.00,'Ativo',2,3,2),(3,'2025-03-01','2025-12-31',1800.00,'Ativo',3,4,3),(4,'2025-04-01','2025-12-31',1300.00,'Encerrado',4,2,4);
/*!40000 ALTER TABLE `contrato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imovel`
--

DROP TABLE IF EXISTS `imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imovel` (
  `id_imovel` int NOT NULL AUTO_INCREMENT,
  `vila_id_vila` int DEFAULT NULL,
  `numero_apartamento` int DEFAULT NULL,
  `valor_aluguel` decimal(10,2) DEFAULT NULL,
  `status` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_imovel`),
  KEY `vila_id_vila` (`vila_id_vila`),
  CONSTRAINT `imovel_ibfk_1` FOREIGN KEY (`vila_id_vila`) REFERENCES `vila` (`id_vila`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imovel`
--

LOCK TABLES `imovel` WRITE;
/*!40000 ALTER TABLE `imovel` DISABLE KEYS */;
INSERT INTO `imovel` VALUES (1,1,101,1200.00,'Ocupado'),(2,1,102,1300.00,'Ocupado'),(3,2,201,1500.00,'Ocupado'),(4,3,301,1800.00,'Disponivel');
/*!40000 ALTER TABLE `imovel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locatario`
--

DROP TABLE IF EXISTS `locatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locatario` (
  `id_locatario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) DEFAULT NULL,
  `cpf` varchar(11) DEFAULT NULL,
  `telefone` varchar(15) DEFAULT NULL,
  `email` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id_locatario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locatario`
--

LOCK TABLES `locatario` WRITE;
/*!40000 ALTER TABLE `locatario` DISABLE KEYS */;
INSERT INTO `locatario` VALUES (1,'Carlos Silva','11111111111','11911111111','carlos@email.com'),(2,'Ana Souza','22222222222','11988888888','ana@email.com'),(3,'Pedro Lima','33333333333','11977777777','pedro@email.com'),(4,'Mariana Costa','44444444444','11966666666','mariana@email.com'),(6,'Teste','00000000000','69999999901',NULL),(7,'Priscila','12345678901','9999999999',NULL);
/*!40000 ALTER TABLE `locatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pagamento`
--

DROP TABLE IF EXISTS `pagamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pagamento` (
  `id_pagamento` int NOT NULL AUTO_INCREMENT,
  `data_pagamento` date DEFAULT NULL,
  `valor_pago` decimal(10,2) DEFAULT NULL,
  `status_pagamento` varchar(25) DEFAULT NULL,
  `usuario_id_usuario` int DEFAULT NULL,
  `contrato_id_contrato` int DEFAULT NULL,
  PRIMARY KEY (`id_pagamento`),
  KEY `usuario_id_usuario` (`usuario_id_usuario`),
  KEY `contrato_id_contrato` (`contrato_id_contrato`),
  CONSTRAINT `pagamento_ibfk_1` FOREIGN KEY (`usuario_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  CONSTRAINT `pagamento_ibfk_2` FOREIGN KEY (`contrato_id_contrato`) REFERENCES `contrato` (`id_contrato`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pagamento`
--

LOCK TABLES `pagamento` WRITE;
/*!40000 ALTER TABLE `pagamento` DISABLE KEYS */;
INSERT INTO `pagamento` VALUES (1,'2025-01-05',1200.00,'Pago',1,1),(2,'2025-02-05',1500.00,'Pago',2,2),(3,'2025-03-05',1800.00,'Pago',3,3),(4,'2025-04-05',1300.00,'Pago',4,4),(6,'2026-09-20',500.00,'Pago',1,1),(7,'2026-09-20',5000.00,'Pago',1,3);
/*!40000 ALTER TABLE `pagamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(150) DEFAULT NULL,
  `login` varchar(30) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  `perfil` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Administrador','admin','123456','ADMIN'),(2,'João','joao','123456','FUNCIONARIO'),(3,'Maria','maria','123456','FUNCIONARIO'),(4,'Paulo','paulo','123456','FUNCIONARIO');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vila`
--

DROP TABLE IF EXISTS `vila`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vila` (
  `id_vila` int NOT NULL AUTO_INCREMENT,
  `endereco` varchar(150) DEFAULT NULL,
  `bairro` varchar(100) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `cep` varchar(8) DEFAULT NULL,
  PRIMARY KEY (`id_vila`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vila`
--

LOCK TABLES `vila` WRITE;
/*!40000 ALTER TABLE `vila` DISABLE KEYS */;
INSERT INTO `vila` VALUES (1,'Rua das Flores, 100','Centro','São Paulo','SP','01001000'),(2,'Av. Brasil, 200','Jardins','São Paulo','SP','01400000'),(3,'Rua A, 300','Copacabana','Rio de Janeiro','RJ','22000000'),(4,'Rua B, 400','Savassi','Belo Horizonte','MG','30100000'),(5,'Rua C, 500','Boa Viagem','Recife','PE','51000000');
/*!40000 ALTER TABLE `vila` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-09-19 14:10:20
