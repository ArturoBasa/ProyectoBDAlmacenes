CREATE DATABASE  IF NOT EXISTS "ProyectoBD2" /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ProyectoBD2`;
-- MySQL dump 10.13  Distrib 8.0.43, for Win64 (x86_64)
--
-- Host: mysql-endric-endric-toledo-bd.a.aivencloud.com    Database: ProyectoBD2
-- ------------------------------------------------------
-- Server version	8.4.8

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '4548842c-518c-11f1-9214-6a8b449bf1c5:1-333,
d565136b-5462-11f1-83cb-8e14e0c72622:1-60';

--
-- Table structure for table `alertaStockMaximo`
--

DROP TABLE IF EXISTS `alertaStockMaximo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alertaStockMaximo` (
  `idalertaStockMaximo` int NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL,
  `mensaje` varchar(255) COLLATE utf8mb4_bin NOT NULL,
  `idItem` int NOT NULL,
  PRIMARY KEY (`idalertaStockMaximo`),
  KEY `fk_alertaStockMaximo_item_idx` (`idItem`),
  CONSTRAINT `fk_alertaStockMaximo_item` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alertaStockMaximo`
--

LOCK TABLES `alertaStockMaximo` WRITE;
/*!40000 ALTER TABLE `alertaStockMaximo` DISABLE KEYS */;
/*!40000 ALTER TABLE `alertaStockMaximo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `bajasRegistradas`
--

DROP TABLE IF EXISTS `bajasRegistradas`;
/*!50001 DROP VIEW IF EXISTS `bajasRegistradas`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `bajasRegistradas` AS SELECT 
 1 AS `fecha`,
 1 AS `nombreItem`,
 1 AS `razonBaja`,
 1 AS `cantidadSobrante`,
 1 AS `idSucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `bitacoraoperacionesbajas`
--

DROP TABLE IF EXISTS `bitacoraoperacionesbajas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacoraoperacionesbajas` (
  `idBitacoraOperacionesBajas` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `razonBaja` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `descripcion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `cantidadSobrante` int NOT NULL,
  `Item_idItem` int NOT NULL,
  PRIMARY KEY (`idBitacoraOperacionesBajas`),
  KEY `fk_BitacoraOperacionesBajas_Item1_idx` (`Item_idItem`),
  CONSTRAINT `fk_BitacoraOperacionesBajas_Item1` FOREIGN KEY (`Item_idItem`) REFERENCES `item` (`idItem`)
) ENGINE=InnoDB AUTO_INCREMENT=30004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacoraoperacionesbajas`
--

LOCK TABLES `bitacoraoperacionesbajas` WRITE;
/*!40000 ALTER TABLE `bitacoraoperacionesbajas` DISABLE KEYS */;
INSERT INTO `bitacoraoperacionesbajas` VALUES (1,'2025-09-01','Caducidad ','Tinta seca ',0,2),(2,'2025-09-05','Daño ','Hojas manchadas ',10,1),(3,'2025-09-10','Obsoleto ','Impresora dada de baja ',2,3);
/*!40000 ALTER TABLE `bitacoraoperacionesbajas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bitacorapedidos`
--

DROP TABLE IF EXISTS `bitacorapedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bitacorapedidos` (
  `idBitacoraPedidos` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `cantidadPedir` int NOT NULL,
  `Item_idItem` int NOT NULL,
  PRIMARY KEY (`idBitacoraPedidos`),
  KEY `fk_BitacoraPedidos_Item1_idx` (`Item_idItem`),
  CONSTRAINT `fk_BitacoraPedidos_Item1` FOREIGN KEY (`Item_idItem`) REFERENCES `item` (`idItem`)
) ENGINE=InnoDB AUTO_INCREMENT=30004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bitacorapedidos`
--

LOCK TABLES `bitacorapedidos` WRITE;
/*!40000 ALTER TABLE `bitacorapedidos` DISABLE KEYS */;
INSERT INTO `bitacorapedidos` VALUES (2,'2025-08-16',10,2),(3,'2025-08-17',100,3);
/*!40000 ALTER TABLE `bitacorapedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `idDepartamento` int NOT NULL AUTO_INCREMENT,
  `nombreDepartamento` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `Sucursal_idSucursal` int NOT NULL,
  PRIMARY KEY (`idDepartamento`),
  KEY `fk_Departamento_Sucursal1_idx` (`Sucursal_idSucursal`),
  CONSTRAINT `fk_Departamento_Sucursal1` FOREIGN KEY (`Sucursal_idSucursal`) REFERENCES `sucursal` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=60006 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Recursos Humanos ',1),(2,'Contabilidad ',1),(3,'Soporte de TI ',1),(4,'Almacen',1),(5,'Gerencia',1),(30006,'Recursos Humanos',30004),(30007,'Contabilidad',30005),(30008,'Soporte TI',30006),(30009,'Ventas Norte',30007),(30010,'Atención a Clientes',30008),(30011,'Logística',30009),(30012,'Legal',30010),(30013,'Marketing',30011),(30014,'Operaciones',30012),(30015,'Dirección General',30013);
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_factura`
--

DROP TABLE IF EXISTS `detalle_factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_factura` (
  `Item_idItem` int NOT NULL,
  `Factura_idFactura` int NOT NULL,
  `cantidad` int NOT NULL,
  `costo` double NOT NULL,
  `Factura_folioFactura` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`Item_idItem`,`Factura_idFactura`),
  KEY `fk_Item_has_Factura_Factura1_idx` (`Factura_idFactura`),
  KEY `fk_Item_has_Factura_Item1_idx` (`Item_idItem`),
  KEY `fk_detalle_factura_Folio_idx` (`Factura_folioFactura`),
  CONSTRAINT `fk_detalle_factura_factura` FOREIGN KEY (`Factura_idFactura`) REFERENCES `factura` (`idFactura`),
  CONSTRAINT `fk_Item_has_Factura_Item1` FOREIGN KEY (`Item_idItem`) REFERENCES `item` (`idItem`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_factura`
--

LOCK TABLES `detalle_factura` WRITE;
/*!40000 ALTER TABLE `detalle_factura` DISABLE KEYS */;
INSERT INTO `detalle_factura` VALUES (1,1,50,45.599998474121094,''),(1,2,100,45.599998474121094,''),(1,60004,20,50,'A0070'),(2,3,50,50,''),(3,30005,2,850,''),(30026,30006,100,5,''),(30027,30007,5,40,''),(30028,30008,2,1500,''),(30029,30009,10,250,''),(30030,30013,2,300,''),(30031,30010,30,35,''),(30032,30011,5,90,''),(30038,30012,50,2.5,'');
/*!40000 ALTER TABLE `detalle_factura` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'REAL_AS_FLOAT,PIPES_AS_CONCAT,ANSI_QUOTES,IGNORE_SPACE,ONLY_FULL_GROUP_BY,ANSI,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`avnadmin`@`%`*/ /*!50003 TRIGGER `detalle_factura_AFTER_INSERT` AFTER INSERT ON `detalle_factura` FOR EACH ROW BEGIN
    	UPDATE item 
	SET existencias = existencias + NEW.cantidad 
	WHERE idItem = NEW.Item_idItem;
   
	INSERT INTO kardex (costo, fecha, Item_idItem, Factura_idFactura, costoPromedio)
	VALUES (NEW.costo, CURDATE(), NEW.Item_idItem, NEW.Factura_idFactura, 0);

	CALL paCalcularPromedioExacto(NEW.Item_idItem, NEW.Factura_idFactura);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `detalle_salida`
--

DROP TABLE IF EXISTS `detalle_salida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_salida` (
  `Item_idItem` int NOT NULL,
  `PeticionSalida_idPeticionSalida` int NOT NULL,
  `cantidad` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`Item_idItem`,`PeticionSalida_idPeticionSalida`),
  KEY `fk_Item_has_PeticionSalida_PeticionSalida1_idx` (`PeticionSalida_idPeticionSalida`),
  KEY `fk_Item_has_PeticionSalida_Item1_idx` (`Item_idItem`),
  CONSTRAINT `fk_Item_has_PeticionSalida_Item1` FOREIGN KEY (`Item_idItem`) REFERENCES `item` (`idItem`),
  CONSTRAINT `fk_Item_has_PeticionSalida_PeticionSalida1` FOREIGN KEY (`PeticionSalida_idPeticionSalida`) REFERENCES `peticionsalida` (`idPeticionSalida`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_salida`
--

LOCK TABLES `detalle_salida` WRITE;
/*!40000 ALTER TABLE `detalle_salida` DISABLE KEYS */;
INSERT INTO `detalle_salida` VALUES (2,1,'5');
/*!40000 ALTER TABLE `detalle_salida` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'REAL_AS_FLOAT,PIPES_AS_CONCAT,ANSI_QUOTES,IGNORE_SPACE,ONLY_FULL_GROUP_BY,ANSI,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`avnadmin`@`%`*/ /*!50003 TRIGGER `detalle_salida_AFTER_INSERT` AFTER INSERT ON `detalle_salida` FOR EACH ROW BEGIN
    UPDATE item 
    SET existencias = existencias - NEW.cantidad 
    WHERE idItem = NEW.Item_idItem;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `idEmpleado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `apellidos` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `correoElectronico` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `telefonoFijo` varchar(10) COLLATE utf8mb3_bin DEFAULT NULL,
  `telefonoCelular` varchar(10) COLLATE utf8mb3_bin NOT NULL,
  `fechaRegistro` date NOT NULL,
  `contrasenia` varchar(64) COLLATE utf8mb3_bin NOT NULL,
  `idDepartamentoEncargado` int DEFAULT NULL,
  `idRol` int NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  KEY `fk_empleado_departamento_idx` (`idDepartamentoEncargado`),
  KEY `fk_empleado_rol_idx` (`idRol`),
  CONSTRAINT `fk_empleado_departamento` FOREIGN KEY (`idDepartamentoEncargado`) REFERENCES `departamento` (`idDepartamento`),
  CONSTRAINT `fk_empledao_rol` FOREIGN KEY (`idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=60007 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'Juan ','Perez Garcia ','jperez@globalfinance.com ','2281234567','2289876543','2025-01-10','7dd2beecfea75dcff4e312da0128572e43a16c323d160804e23de44d16545fe5',1,3),(2,'Maria ','Lopez Hernandez ','mlopez@globalfinance.com ',NULL,'2282345678','2025-02-15','8eeac91997a8aeda95bd6624174d3ace7afbd795056b55ace2688355b0875c6b',2,30004),(3,'Carlos ','Ramirez Soto ','cramirez@globalfinance.com ','2293456789','2297654321','2025-03-20','ef8ca855a04880164ba87fe3367ea2d3551b0025d5394f9244376b9856f92e3a',3,30004),(4,'Arturo','Baez Sanchez','arturo@gmail.com','','2285023917','2026-04-26','1d11a32e646a95fa4e87c346a32a6580d221515c86a39c4d0cf044066c7b4540',4,2),(5,'Endric','Vera Toledo','endrictoledo@gmail.com',NULL,'9931760055','2026-04-26','deaa5f94dc5d48afa2c0f4c19967b47de6634b7615d81d19afc89cd01a603cb6',5,2),(6,'Laurencio','Lopez ','laulopez@gmail.com',NULL,'2731611305','2026-04-26','e29b184f37899c25171840a13ad30bbdf6f5507b20bebc54b5b6c41f343b9a25',30006,1),(30007,'Juan','Pérez García','jperez@globalfinance.com','2281110000','2289870001','2026-01-10','hash001',30007,30004),(30008,'María','López Hernández','mlopez@globalfinance.com','2282220000','2289870002','2026-02-15','hash002',30008,30004),(30009,'Carlos','Ramírez Soto','cramirez@globalfinance.com','2283330000','2289870003','2026-03-20','hash003',30009,30004),(30010,'Ana','Martínez','amartinez@globalfinance.com','2284440000','2289870004','2026-04-01','hash004',30010,30004),(30011,'Luis','Hernández','lhernandez@globalfinance.com','2285550000','2289870005','2026-04-10','hash005',30011,30004),(30012,'Elena','Gómez','egomez@globalfinance.com','2286660000','2289870006','2026-05-12','hash006',30010,30004),(30013,'Pedro','Díaz','pdiaz@globalfinance.com','2287770000','2289870007','2026-06-08','hash007',30013,30004),(30014,'Laura','Torres','ltorres@globalfinance.com','2288880000','2289870008','2026-07-22','hash008',30014,30004),(30015,'Jorge','Flores','jflores@globalfinance.com','2289990000','2289870009','2026-08-30','hash009',30015,30004);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `entradasView`
--

DROP TABLE IF EXISTS `entradasView`;
/*!50001 DROP VIEW IF EXISTS `entradasView`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `entradasView` AS SELECT 
 1 AS `folio`,
 1 AS `fechaFactura`,
 1 AS `proveedor`,
 1 AS `rfc`,
 1 AS `total`,
 1 AS `sucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `estadoPeticion`
--

DROP TABLE IF EXISTS `estadoPeticion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estadoPeticion` (
  `idestadoPeticion` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb4_bin NOT NULL,
  PRIMARY KEY (`idestadoPeticion`)
) ENGINE=InnoDB AUTO_INCREMENT=30001 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estadoPeticion`
--

LOCK TABLES `estadoPeticion` WRITE;
/*!40000 ALTER TABLE `estadoPeticion` DISABLE KEYS */;
INSERT INTO `estadoPeticion` VALUES (1,'ACEPTADA'),(2,'EN ESPERA'),(3,'DENEGADA');
/*!40000 ALTER TABLE `estadoPeticion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `factura`
--

DROP TABLE IF EXISTS `factura`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `factura` (
  `idFactura` int NOT NULL AUTO_INCREMENT,
  `folioFactura` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `fechaFactura` date NOT NULL,
  `precioTotal` double NOT NULL,
  `Proveedor_idProveedor` int NOT NULL,
  PRIMARY KEY (`idFactura`),
  KEY `fk_Factura_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_Factura_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=60005 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `factura`
--

LOCK TABLES `factura` WRITE;
/*!40000 ALTER TABLE `factura` DISABLE KEYS */;
INSERT INTO `factura` VALUES (1,'A0054 ','2025-02-23',2280,1),(2,'A0055','2025-04-05',4560,1),(3,'A0056 ','2025-07-07',2500,2),(30004,'A0057','2026-01-10',2280,1),(30005,'A0058','2026-01-15',1700,3),(30006,'A0059','2026-02-01',500,1),(30007,'A0060','2026-02-10',200,30004),(30008,'A0061','2026-03-05',3000,30005),(30009,'A0062','2026-03-20',2500,30006),(30010,'A0063','2026-04-12',1050,30007),(30011,'A0067','2026-04-25',450,30009),(30012,'A0068','2026-05-02',125,1),(30013,'A0069','2026-05-10',600,30006),(60004,'A0070','2026-05-30',500,1);
/*!40000 ALTER TABLE `factura` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `idItem` int NOT NULL AUTO_INCREMENT,
  `existencias` int NOT NULL DEFAULT '0',
  `stockMinimo` int NOT NULL,
  `stockMaximo` int NOT NULL,
  `nombreItem` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `precioUnitario` double NOT NULL,
  `estado` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `descripcionUso` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `PartidaPresupuestal_idPartidaPresupuestal` int NOT NULL,
  `Sucursal_idSucursal` int NOT NULL,
  PRIMARY KEY (`idItem`),
  KEY `fk_Item_PartidaPresupuestal1_idx` (`PartidaPresupuestal_idPartidaPresupuestal`),
  KEY `fk_Item_Sucursal1_idx` (`Sucursal_idSucursal`),
  CONSTRAINT `fk_Item_PartidaPresupuestal1` FOREIGN KEY (`PartidaPresupuestal_idPartidaPresupuestal`) REFERENCES `partidapresupuestal` (`idPartidaPresupuestal`),
  CONSTRAINT `fk_Item_Sucursal1` FOREIGN KEY (`Sucursal_idSucursal`) REFERENCES `sucursal` (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=60004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,70,10,100,'Paquete de 50 hojas bond carta  ',46.11764571245979,'ACTIVO','Impresión de  documentos ',1,1),(2,100,20,200,'Cajas de 10 lapiceros  50',50,'ACTIVO','Escritura en general ',1,1),(3,5,2,15,'Toner de impresora ',850,'ACTIVO','Reemplazo de tinta ',1,1),(30014,50,10,100,'Hojas Blancas',45.6,'ACTIVO','Paquete 500 hojas bond',1,1),(30024,20,5,50,'Tóner Impresora',850,'ACTIVO','Cartucho negro',2,1),(30025,20,5,50,'Tóner Impresora',850,'ACTIVO','Cartucho negro',2,1),(30026,100,20,200,'Bolígrafos',5,'ACTIVO','Caja 10 pzas negras',1,1),(30027,5,2,10,'Escobas',40,'ACTIVO','Escoba de cepillo',3,1),(30028,2,1,5,'Silla Ejecutiva',1500,'ACTIVO','Silla ergonómica',30007,1),(30029,10,2,15,'Mouse Inalámbrico',250,'ACTIVO','Mouse USB óptico',30008,1),(30030,10,2,15,'Mouse Inalámbrico',250,'ACTIVO','Mouse USB óptico',30008,1),(30031,30,5,50,'Focos LED',35,'ACTIVO','Foco 10W blanco',30009,2),(30032,15,3,30,'Café Soluble',90,'ACTIVO','Frasco 200g',30011,1),(30038,50,10,100,'Folders',2.5,'ACTIVO','Folder tamaño carta',1,1),(30039,3,1,5,'Teclado',300,'INACTIVO','Teclado en español',30008,30004);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'REAL_AS_FLOAT,PIPES_AS_CONCAT,ANSI_QUOTES,IGNORE_SPACE,ONLY_FULL_GROUP_BY,ANSI,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`avnadmin`@`%`*/ /*!50003 TRIGGER `item_AFTER_UPDATE` AFTER UPDATE ON `item` FOR EACH ROW BEGIN
    
    IF OLD.existencias <> NEW.existencias THEN
        IF NEW.existencias < NEW.stockMinimo AND OLD.existencias >= NEW.stockMinimo THEN
            INSERT INTO bitacorapedidos (fecha, cantidadPedir, Item_idItem)
            VALUES (NOW(), (NEW.stockMaximo - NEW.existencias), NEW.idItem);
        END IF;

        IF NEW.existencias > NEW.stockMaximo AND OLD.existencias <= NEW.stockMaximo THEN
            INSERT INTO alertaStockMaximo (fecha, mensaje, idItem)
            VALUES (NOW(), CONCAT('Exceso: ', NEW.existencias - NEW.stockMaximo), NEW.idItem);
        END IF;

        IF NEW.existencias >= NEW.stockMinimo THEN
            DELETE FROM bitacorapedidos WHERE Item_idItem = NEW.idItem;
        END IF;

        IF NEW.existencias <= NEW.stockMaximo THEN
            DELETE FROM alertaStockMaximo WHERE idItem = NEW.idItem;
        END IF;
	END IF;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `itemPorDepartamento`
--

DROP TABLE IF EXISTS `itemPorDepartamento`;
/*!50001 DROP VIEW IF EXISTS `itemPorDepartamento`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `itemPorDepartamento` AS SELECT 
 1 AS `departamento`,
 1 AS `item`,
 1 AS `cantidad`,
 1 AS `sucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `itemPorFactura`
--

DROP TABLE IF EXISTS `itemPorFactura`;
/*!50001 DROP VIEW IF EXISTS `itemPorFactura`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `itemPorFactura` AS SELECT 
 1 AS `folio`,
 1 AS `item`,
 1 AS `cantidad`,
 1 AS `sucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `itemsStockMaximoPorSucursal`
--

DROP TABLE IF EXISTS `itemsStockMaximoPorSucursal`;
/*!50001 DROP VIEW IF EXISTS `itemsStockMaximoPorSucursal`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `itemsStockMaximoPorSucursal` AS SELECT 
 1 AS `nombreItem`,
 1 AS `existencias`,
 1 AS `stockMaximo`,
 1 AS `excedente`,
 1 AS `idSucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `itemsStockMinimoPorSucursal`
--

DROP TABLE IF EXISTS `itemsStockMinimoPorSucursal`;
/*!50001 DROP VIEW IF EXISTS `itemsStockMinimoPorSucursal`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `itemsStockMinimoPorSucursal` AS SELECT 
 1 AS `nombreItem`,
 1 AS `existencias`,
 1 AS `stockMinimo`,
 1 AS `diferencia`,
 1 AS `idSucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `kardex`
--

DROP TABLE IF EXISTS `kardex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kardex` (
  `idKardex` int NOT NULL AUTO_INCREMENT,
  `costo` double NOT NULL,
  `fecha` date NOT NULL,
  `costoPromedio` double NOT NULL,
  `Item_idItem` int NOT NULL,
  `Factura_idFactura` int NOT NULL,
  PRIMARY KEY (`idKardex`),
  KEY `fk_Kardex_Item1_idx` (`Item_idItem`),
  KEY `fk_Kardex_Factura1_idx` (`Factura_idFactura`),
  CONSTRAINT `fk_Kardex_Factura1` FOREIGN KEY (`Factura_idFactura`) REFERENCES `factura` (`idFactura`),
  CONSTRAINT `fk_Kardex_Item1` FOREIGN KEY (`Item_idItem`) REFERENCES `item` (`idItem`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kardex`
--

LOCK TABLES `kardex` WRITE;
/*!40000 ALTER TABLE `kardex` DISABLE KEYS */;
INSERT INTO `kardex` VALUES (1,50,'2026-05-21',46.11764571245979,1,60004);
/*!40000 ALTER TABLE `kardex` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `partidapresupuestal`
--

DROP TABLE IF EXISTS `partidapresupuestal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `partidapresupuestal` (
  `idPartidaPresupuestal` int NOT NULL AUTO_INCREMENT,
  `nombrePartida` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `presupuesto` double NOT NULL,
  PRIMARY KEY (`idPartidaPresupuestal`)
) ENGINE=InnoDB AUTO_INCREMENT=60004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `partidapresupuestal`
--

LOCK TABLES `partidapresupuestal` WRITE;
/*!40000 ALTER TABLE `partidapresupuestal` DISABLE KEYS */;
INSERT INTO `partidapresupuestal` VALUES (1,'Papeleria y utiles de oficina ',50000),(2,'Consumibles de computo ',75000),(3,'Material de limpieza ',20000),(30005,'Consumibles de cómputo',75000),(30006,'Material de limpieza',20000),(30007,'Mobiliario de oficina',100000),(30008,'Equipo de cómputo',200000),(30009,'Material eléctrico',15000),(30010,'Herramientas menores',10000),(30011,'Artículos de cafetería',8000),(30012,'Material impreso',12000),(30013,'Refacciones y accesorios',25000);
/*!40000 ALTER TABLE `partidapresupuestal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `peticionsalida`
--

DROP TABLE IF EXISTS `peticionsalida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `peticionsalida` (
  `idPeticionSalida` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `idEmpleadoAlmacen` int NOT NULL,
  `idEstadoPeticion` int NOT NULL,
  PRIMARY KEY (`idPeticionSalida`),
  KEY `fk_PeticionSalida_Empleado2_idx` (`idEmpleadoAlmacen`),
  KEY `fk_peticionSalida_estadoPeticion_idx` (`idEstadoPeticion`),
  CONSTRAINT `fk_PeticionSalida_Empleado2` FOREIGN KEY (`idEmpleadoAlmacen`) REFERENCES `empleado` (`idEmpleado`)
) ENGINE=InnoDB AUTO_INCREMENT=30002 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `peticionsalida`
--

LOCK TABLES `peticionsalida` WRITE;
/*!40000 ALTER TABLE `peticionsalida` DISABLE KEYS */;
INSERT INTO `peticionsalida` VALUES (1,'2025-08-01',1,1);
/*!40000 ALTER TABLE `peticionsalida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL AUTO_INCREMENT,
  `razonSocial` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `RFCProveedor` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `domicilioFiscal` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `telefono` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=60004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Papelería Tony SA de CV ','PTO980101XYZ ','Av. 20 de Noviembre 10 ','2281112233 '),(2,'Office Depot de México ','ODM950423ABC ','Carr. Xalapa-Veracruz Km 2 ','2282223344 '),(3,'Distribuidora de Tóner del Golfo ','DTG100515QWE ','Calle Revolución 50 ','2283334455 '),(30004,'Papelería Tony','PTO980101XYZ','Av. 20 de Noviembre 10','2281112233'),(30005,'Office Depot','ODM950423ABC','Carr. Xalapa Km 2','2282223344'),(30006,'Distribuidora de Tóner','DTG100515QWE','Calle Revolución 50','2283334455'),(30007,'Limpieza Total S.A.','LTO120808RTY','Av. Américas 100','2284445566'),(30008,'Muebles de Oficina M','MOM150909UIO','Blvd. Europa 200','2285556677'),(30009,'Tech Computación','TCO110202PAS','Plaza Crystal L5','2286667788'),(30010,'Eléctrica del Golfo','EGO160303DFG','Av. Lázaro Cárdenas 300','2287778899'),(30011,'Ferretería La Llave','FLL140505HJK','Calle Lucio 20','2288889900'),(30012,'Café y Más','CYM130404LZX','Av. Murillo Vidal 45','2289990011'),(30013,'Imprenta Rápida','IRA170606CVB','Calle Clavijero 15','2280001122');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB AUTO_INCREMENT=60004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Usuario central'),(2,'Usuario sucursal'),(3,'Usuario salidas'),(30004,'Usuario departamento');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `salidasView`
--

DROP TABLE IF EXISTS `salidasView`;
/*!50001 DROP VIEW IF EXISTS `salidasView`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `salidasView` AS SELECT 
 1 AS `fecha`,
 1 AS `departamento`,
 1 AS `encargado`,
 1 AS `descripcion`,
 1 AS `idSucursal`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursal` (
  `idSucursal` int NOT NULL AUTO_INCREMENT,
  `nombreSucursal` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `ciudad` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  `direccion` varchar(45) COLLATE utf8mb3_bin NOT NULL,
  PRIMARY KEY (`idSucursal`)
) ENGINE=InnoDB AUTO_INCREMENT=60004 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sucursal`
--

LOCK TABLES `sucursal` WRITE;
/*!40000 ALTER TABLE `sucursal` DISABLE KEYS */;
INSERT INTO `sucursal` VALUES (1,'Sede centrar ','Xalapa ','Av. Xalapa 123 '),(2,'Sucursal norte ','Veracruz ','Blvd. Ruiz Cortines 456 '),(3,'Sucursal sur  ','Boca del Rio ','calle 5 de Mayo 789 '),(30004,'Sede Central','Xalapa','Av. Enríquez 123'),(30005,'Sucursal Norte','Veracruz','Blvd. Ruiz Cortines 456'),(30006,'Sucursal Sur','Boca del Río','Plaza Américas L-10'),(30007,'Sucursal Córdoba','Córdoba','Calle 11 No 102'),(30008,'Sucursal Orizaba','Orizaba','Oriente 6 No 333'),(30009,'Sucursal Poza Rica','Poza Rica','Blvd. Lázaro Cárdenas 12'),(30010,'Sucursal Coatzacoalcos','Coatzacoalcos','Malecón Costero 89'),(30011,'Sucursal Minatitlán','Minatitlán','Av. Hidalgo 45'),(30012,'Sucursal Tuxpan','Tuxpan','Av. Juárez 90'),(30013,'Sucursal Martínez','Martínez de la Torre','Av. Ávila Camacho 50');
/*!40000 ALTER TABLE `sucursal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ProyectoBD2'
--

--
-- Dumping routines for database 'ProyectoBD2'
--
/*!50003 DROP PROCEDURE IF EXISTS `paCalcularPromedioExacto` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'REAL_AS_FLOAT,PIPES_AS_CONCAT,ANSI_QUOTES,IGNORE_SPACE,ONLY_FULL_GROUP_BY,ANSI,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER="avnadmin"@"%" PROCEDURE "paCalcularPromedioExacto"(IN pIdItem INT, IN pIdFactura INT)
BEGIN

    DECLARE vPromedio DOUBLE DEFAULT 0;
    SELECT SUM(cantidad * costo) / SUM(cantidad) INTO vPromedio
    FROM detalle_factura
    WHERE Item_idItem = pIdItem;

    UPDATE kardex 
    SET costoPromedio = vPromedio
    WHERE Factura_idFactura = pIdFactura AND Item_idItem = pIdItem;

    UPDATE item 
    SET precioUnitario = vPromedio 
    WHERE idItem = pIdItem;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `paDarDeBajaItem` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'REAL_AS_FLOAT,PIPES_AS_CONCAT,ANSI_QUOTES,IGNORE_SPACE,ONLY_FULL_GROUP_BY,ANSI,STRICT_ALL_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER="avnadmin"@"%" PROCEDURE "paDarDeBajaItem"(IN pIdItem INT, IN pRazon VARCHAR(45), IN pDesc VARCHAR(45))
BEGIN
    DECLARE vCantidadFinal INT;
    
    
    SELECT existencias INTO vCantidadFinal 
    FROM item 
    WHERE idItem = pIdItem;

    UPDATE item 
    SET estado = 'INACTIVO' 
    WHERE idItem = pIdItem;

    INSERT INTO bitacoraoperacionesbajas (fecha, razonBaja, descripcion, cantidadSobrante, Item_idItem)
    VALUES (CURDATE(), pRazon, pDesc, vCantidadFinal, pIdItem);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `bajasRegistradas`
--

/*!50001 DROP VIEW IF EXISTS `bajasRegistradas`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `bajasRegistradas` AS select `bob`.`fecha` AS `fecha`,`i`.`nombreItem` AS `nombreItem`,`bob`.`razonBaja` AS `razonBaja`,`bob`.`cantidadSobrante` AS `cantidadSobrante`,`s`.`idSucursal` AS `idSucursal` from ((`bitacoraoperacionesbajas` `bob` join `item` `i` on((`bob`.`Item_idItem` = `i`.`idItem`))) join `sucursal` `s` on((`i`.`Sucursal_idSucursal` = `s`.`idSucursal`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `entradasView`
--

/*!50001 DROP VIEW IF EXISTS `entradasView`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `entradasView` (`folio`,`fechaFactura`,`proveedor`,`rfc`,`total`,`sucursal`) AS select `f`.`folioFactura` AS `folio`,`f`.`fechaFactura` AS `fechaFactura`,`p`.`razonSocial` AS `proveedor`,`p`.`RFCProveedor` AS `rfc`,`f`.`precioTotal` AS `total`,`s`.`idSucursal` AS `idSucursal` from ((((`factura` `f` join `proveedor` `p` on((`f`.`Proveedor_idProveedor` = `p`.`idProveedor`))) join `detalle_factura` `df` on((`f`.`idFactura` = `df`.`Factura_idFactura`))) join `item` `i` on((`df`.`Item_idItem` = `i`.`idItem`))) join `sucursal` `s` on((`i`.`Sucursal_idSucursal` = `s`.`idSucursal`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `itemPorDepartamento`
--

/*!50001 DROP VIEW IF EXISTS `itemPorDepartamento`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `itemPorDepartamento` (`departamento`,`item`,`cantidad`,`sucursal`) AS select `d`.`nombreDepartamento` AS `departamento`,`i`.`nombreItem` AS `nombreItem`,`ds`.`cantidad` AS `cantidad`,`s`.`nombreSucursal` AS `nombreSucursal` from (((((`departamento` `d` join `sucursal` `s` on((`d`.`Sucursal_idSucursal` = `s`.`idSucursal`))) join `empleado` `e` on((`e`.`idDepartamentoEncargado` = `d`.`idDepartamento`))) join `peticionsalida` `ps` on((`ps`.`idEmpleadoAlmacen` = `e`.`idEmpleado`))) join `detalle_salida` `ds` on((`ds`.`PeticionSalida_idPeticionSalida` = `ps`.`idPeticionSalida`))) join `item` `i` on((`i`.`idItem` = `ds`.`Item_idItem`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `itemPorFactura`
--

/*!50001 DROP VIEW IF EXISTS `itemPorFactura`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `itemPorFactura` (`folio`,`item`,`cantidad`,`sucursal`) AS select `f`.`folioFactura` AS `folio`,`i`.`nombreItem` AS `item`,`df`.`cantidad` AS `cantidad`,`s`.`nombreSucursal` AS `sucursal` from (((`detalle_factura` `df` join `item` `i` on((`i`.`idItem` = `df`.`Item_idItem`))) join `factura` `f` on((`f`.`idFactura` = `df`.`Factura_idFactura`))) join `sucursal` `s` on((`i`.`Sucursal_idSucursal` = `s`.`idSucursal`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `itemsStockMaximoPorSucursal`
--

/*!50001 DROP VIEW IF EXISTS `itemsStockMaximoPorSucursal`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `itemsStockMaximoPorSucursal` AS select `i`.`nombreItem` AS `nombreItem`,`i`.`existencias` AS `existencias`,`i`.`stockMaximo` AS `stockMaximo`,(`i`.`existencias` - `i`.`stockMaximo`) AS `excedente`,`s`.`idSucursal` AS `idSucursal` from ((`alertaStockMaximo` `asm` join `item` `i` on((`asm`.`idItem` = `i`.`idItem`))) join `sucursal` `s` on((`i`.`Sucursal_idSucursal` = `s`.`idSucursal`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `itemsStockMinimoPorSucursal`
--

/*!50001 DROP VIEW IF EXISTS `itemsStockMinimoPorSucursal`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `itemsStockMinimoPorSucursal` AS select `i`.`nombreItem` AS `nombreItem`,`i`.`existencias` AS `existencias`,`i`.`stockMinimo` AS `stockMinimo`,(`i`.`existencias` - `i`.`stockMinimo`) AS `diferencia`,`s`.`idSucursal` AS `idSucursal` from ((`bitacorapedidos` `bp` join `item` `i` on((`bp`.`Item_idItem` = `i`.`idItem`))) join `sucursal` `s` on((`i`.`Sucursal_idSucursal` = `s`.`idSucursal`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `salidasView`
--

/*!50001 DROP VIEW IF EXISTS `salidasView`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`avnadmin`@`%` SQL SECURITY DEFINER */
/*!50001 VIEW `salidasView` (`fecha`,`departamento`,`encargado`,`descripcion`,`idSucursal`) AS select `ps`.`fecha` AS `fecha`,`d`.`nombreDepartamento` AS `departamento`,`e`.`nombre` AS `encargado`,`ep`.`descripcion` AS `descripcion`,`s`.`idSucursal` AS `idSucursal` from ((((`peticionsalida` `ps` join `empleado` `e` on((`ps`.`idEmpleadoAlmacen` = `e`.`idEmpleado`))) join `departamento` `d` on((`d`.`idDepartamento` = `e`.`idDepartamentoEncargado`))) join `estadoPeticion` `ep` on((`ep`.`idestadoPeticion` = `ps`.`idEstadoPeticion`))) join `sucursal` `s` on((`d`.`Sucursal_idSucursal` = `s`.`idSucursal`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-29 11:12:43
