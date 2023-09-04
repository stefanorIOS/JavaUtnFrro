-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: foodtruck
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `bebida`
--

DROP TABLE IF EXISTS `bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebida` (
  `idBebida` int NOT NULL AUTO_INCREMENT,
  `precioBebida` decimal(10,0) NOT NULL,
  `nombreBebida` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `litrosBebida` decimal(10,0) NOT NULL,
  PRIMARY KEY (`idBebida`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebida`
--

LOCK TABLES `bebida` WRITE;
/*!40000 ALTER TABLE `bebida` DISABLE KEYS */;
INSERT INTO `bebida` VALUES (1,700,'Cerveza',1),(2,1000,'Coca cola',2),(3,700,'Agua Mineral',2);
/*!40000 ALTER TABLE `bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `dniCliente` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `direccion` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`dniCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('42011531','Julian alvarez','Cordoba 1245');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `dniEmpleado` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `turno` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `habilitado` tinyint DEFAULT NULL,
  PRIMARY KEY (`dniEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES ('42033727','Pepinia','Noche','qwerty',0),('42950000','Stefano','-','qwert',1),('42950001','asdasd','Tarde','asd',1),('42950002','Gonzalo','Tarde','qwer',1),('42950004','Brenda','Noche','qwerty',1),('52144578','Laureano','-','qwerty',1),('87878787','RubÃ©n Perez','Noche','qwerty',0);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado_rol`
--

DROP TABLE IF EXISTS `empleado_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_rol` (
  `dniEmpleado` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `idRol` int NOT NULL,
  PRIMARY KEY (`dniEmpleado`,`idRol`),
  KEY `rol_empleado_fk_idx` (`idRol`),
  CONSTRAINT `rol_dni_fk` FOREIGN KEY (`dniEmpleado`) REFERENCES `empleado` (`dniEmpleado`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `rol_empleado_fk` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado_rol`
--

LOCK TABLES `empleado_rol` WRITE;
/*!40000 ALTER TABLE `empleado_rol` DISABLE KEYS */;
INSERT INTO `empleado_rol` VALUES ('42950000',1),('52144578',1),('42950004',2),('42950001',3),('87878787',3),('42033727',4),('42950002',4);
/*!40000 ALTER TABLE `empleado_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idpedido` int NOT NULL AUTO_INCREMENT,
  `fechaHoraPedido` datetime NOT NULL,
  `estadoPedido` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipoPedido` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dniEmpleado` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `dniCliente` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idpedido`,`fechaHoraPedido`),
  KEY `idEmpleadoPedido_fk_idx` (`dniEmpleado`),
  KEY `idClientePedido_fk_idx` (`dniCliente`),
  CONSTRAINT `idClientePedido_fk` FOREIGN KEY (`dniCliente`) REFERENCES `cliente` (`dniCliente`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `idEmpleadoPedido_fk` FOREIGN KEY (`dniEmpleado`) REFERENCES `empleado` (`dniEmpleado`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2022-06-30 00:00:00','Entregado','Delivery','52144578','42011531'),(2,'2022-07-30 17:00:00','Entregado','Delivery','52144578','42011531'),(3,'2022-06-30 18:00:00','Entregado','Presencial','52144578',NULL),(8,'2023-09-01 16:49:44','En preparación','Presencial','52144578',NULL);
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_bebida`
--

DROP TABLE IF EXISTS `pedido_bebida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_bebida` (
  `idPedido` int NOT NULL,
  `fechaHoraPedido` datetime NOT NULL,
  `idBebida` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idPedido`,`fechaHoraPedido`,`idBebida`),
  KEY `idBebida_idx` (`idBebida`),
  CONSTRAINT `idBebida` FOREIGN KEY (`idBebida`) REFERENCES `bebida` (`idBebida`),
  CONSTRAINT `idPedido` FOREIGN KEY (`idPedido`) REFERENCES `pedido` (`idpedido`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_bebida`
--

LOCK TABLES `pedido_bebida` WRITE;
/*!40000 ALTER TABLE `pedido_bebida` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedido_bebida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_plato`
--

DROP TABLE IF EXISTS `pedido_plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_plato` (
  `idPedido` int NOT NULL,
  `fechaHoraPedido` datetime NOT NULL,
  `idPlato` int NOT NULL,
  `cantidad` int NOT NULL,
  PRIMARY KEY (`idPedido`,`fechaHoraPedido`,`idPlato`),
  KEY `idpedido_plato_fk_idx` (`idPlato`),
  CONSTRAINT `idPedido_fk` FOREIGN KEY (`idPedido`, `fechaHoraPedido`) REFERENCES `pedido` (`idpedido`, `fechaHoraPedido`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `idpedido_plato_fk` FOREIGN KEY (`idPlato`) REFERENCES `plato` (`idPlato`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_plato`
--

LOCK TABLES `pedido_plato` WRITE;
/*!40000 ALTER TABLE `pedido_plato` DISABLE KEYS */;
INSERT INTO `pedido_plato` VALUES (1,'2022-06-30 00:00:00',1,1),(1,'2022-06-30 00:00:00',2,2),(2,'2022-07-30 17:00:00',1,1);
/*!40000 ALTER TABLE `pedido_plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `plato`
--

DROP TABLE IF EXISTS `plato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `plato` (
  `idPlato` int NOT NULL AUTO_INCREMENT,
  `nombrePlato` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `precioPlato` decimal(10,0) NOT NULL,
  `descripcion` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `imagen` varchar(400) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`idPlato`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `plato`
--

LOCK TABLES `plato` WRITE;
/*!40000 ALTER TABLE `plato` DISABLE KEYS */;
INSERT INTO `plato` VALUES (1,'Milanesa napolitana',1200,'Milanesa con tomate y queso','img/napo.jpg'),(2,'Tarta atun',1500,'Tarta de pescado atun','img/atun.jpg'),(30,'H. Pollo',1500,'Pollo, huevo frito, queso cheddar, queso','img/655hpollo.png'),(31,'H. Cheddar',2000,'Carne, lechuga, tomate, cheddar y panceta','img/550image1.png'),(34,'H. Completa',1900,'Lechuga, tomate, jamon y queso','img/356hcompleta.png'),(35,'papas fritas',150,'papas echas fritas ','img/237pp.jpeg');
/*!40000 ALTER TABLE `plato` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL,
  `rol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Administrador'),(2,'Mozo'),(3,'Delivery'),(4,'Chef');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoempleado`
--

DROP TABLE IF EXISTS `tipoempleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoempleado` (
  `idTipoEmpleado` int NOT NULL,
  `dniEmpleado` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `rol` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`idTipoEmpleado`),
  KEY `dniEmpleado_fk_idx` (`dniEmpleado`),
  CONSTRAINT `dniEmpleado_fk` FOREIGN KEY (`dniEmpleado`) REFERENCES `empleado` (`dniEmpleado`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoempleado`
--

LOCK TABLES `tipoempleado` WRITE;
/*!40000 ALTER TABLE `tipoempleado` DISABLE KEYS */;
INSERT INTO `tipoempleado` VALUES (1,'42033727','Recepcionista'),(2,'52144578','Mesero');
/*!40000 ALTER TABLE `tipoempleado` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-09-04  1:52:31
