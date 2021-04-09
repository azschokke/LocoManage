-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.5.8-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             11.1.0.6116
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for locomanage
CREATE DATABASE IF NOT EXISTS `locomanage` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `locomanage`;

-- Dumping structure for table locomanage.chain
CREATE TABLE IF NOT EXISTS `chain` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  `LOCATION_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_CHAIN_LOCATION_ID` (`LOCATION_ID`),
  CONSTRAINT `FK_CHAIN_LOCATION_ID` FOREIGN KEY (`LOCATION_ID`) REFERENCES `location` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.chain_rollingstock
CREATE TABLE IF NOT EXISTS `chain_rollingstock` (
  `Chain_ID` int(11) NOT NULL,
  `cars_ID` int(11) NOT NULL,
  PRIMARY KEY (`Chain_ID`,`cars_ID`),
  KEY `FK_CHAIN_ROLLINGSTOCK_cars_ID` (`cars_ID`),
  CONSTRAINT `FK_CHAIN_ROLLINGSTOCK_Chain_ID` FOREIGN KEY (`Chain_ID`) REFERENCES `chain` (`ID`),
  CONSTRAINT `FK_CHAIN_ROLLINGSTOCK_cars_ID` FOREIGN KEY (`cars_ID`) REFERENCES `rollingstock` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.classification
CREATE TABLE IF NOT EXISTS `classification` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.location
CREATE TABLE IF NOT EXISTS `location` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `ISTRACK` tinyint(1) DEFAULT 0,
  `NAME` varchar(255) DEFAULT NULL,
  `parentId` int(11) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.location_location
CREATE TABLE IF NOT EXISTS `location_location` (
  `Location_ID` int(11) NOT NULL,
  `children_ID` int(11) NOT NULL,
  PRIMARY KEY (`Location_ID`,`children_ID`),
  KEY `FK_LOCATION_LOCATION_children_ID` (`children_ID`),
  CONSTRAINT `FK_LOCATION_LOCATION_Location_ID` FOREIGN KEY (`Location_ID`) REFERENCES `location` (`ID`),
  CONSTRAINT `FK_LOCATION_LOCATION_children_ID` FOREIGN KEY (`children_ID`) REFERENCES `location` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.manufacturer
CREATE TABLE IF NOT EXISTS `manufacturer` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.model
CREATE TABLE IF NOT EXISTS `model` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) NOT NULL,
  `c_id` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_MODEL_c_id` (`c_id`),
  CONSTRAINT `FK_MODEL_c_id` FOREIGN KEY (`c_id`) REFERENCES `classification` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.product
CREATE TABLE IF NOT EXISTS `product` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SKU` varchar(255) DEFAULT NULL,
  `MANUFACTURER_ID` int(11) DEFAULT NULL,
  `SCALE_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_PRODUCT_SCALE_ID` (`SCALE_ID`),
  KEY `FK_PRODUCT_MANUFACTURER_ID` (`MANUFACTURER_ID`),
  CONSTRAINT `FK_PRODUCT_MANUFACTURER_ID` FOREIGN KEY (`MANUFACTURER_ID`) REFERENCES `manufacturer` (`ID`),
  CONSTRAINT `FK_PRODUCT_SCALE_ID` FOREIGN KEY (`SCALE_ID`) REFERENCES `scale` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.railroad
CREATE TABLE IF NOT EXISTS `railroad` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.rollingstock
CREATE TABLE IF NOT EXISTS `rollingstock` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CARNUMBER` int(11) DEFAULT NULL,
  `INCHAIN` int(11) DEFAULT NULL,
  `LENGTH` int(11) DEFAULT NULL,
  `NOTES` varchar(255) DEFAULT NULL,
  `USERID` int(11) DEFAULT NULL,
  `MODEL_ID` int(11) DEFAULT NULL,
  `OWNER_ID` int(11) DEFAULT NULL,
  `PRODUCTINFO_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ROLLINGSTOCK_OWNER_ID` (`OWNER_ID`),
  KEY `FK_ROLLINGSTOCK_PRODUCTINFO_ID` (`PRODUCTINFO_ID`),
  KEY `FK_ROLLINGSTOCK_MODEL_ID` (`MODEL_ID`),
  CONSTRAINT `FK_ROLLINGSTOCK_MODEL_ID` FOREIGN KEY (`MODEL_ID`) REFERENCES `model` (`ID`),
  CONSTRAINT `FK_ROLLINGSTOCK_OWNER_ID` FOREIGN KEY (`OWNER_ID`) REFERENCES `railroad` (`ID`),
  CONSTRAINT `FK_ROLLINGSTOCK_PRODUCTINFO_ID` FOREIGN KEY (`PRODUCTINFO_ID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.scale
CREATE TABLE IF NOT EXISTS `scale` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SCALE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table locomanage.user
CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `EMAIL` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
