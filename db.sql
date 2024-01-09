-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.5.15


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema studyroomdb
--

CREATE DATABASE IF NOT EXISTS studyroomdb;
USE studyroomdb;

--
-- Definition of table `studentdb`
--

DROP TABLE IF EXISTS `studentdb`;
CREATE TABLE `studentdb` (
  `userID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobno` varchar(45) NOT NULL,
  `parentsMobNo` varchar(45) NOT NULL,
  `collegeName` varchar(45) NOT NULL,
  `preferredTime` varchar(45) NOT NULL,
  `education` varchar(45) NOT NULL,
  PRIMARY KEY (`userID`,`mobno`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1234568 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `studentdb`
--

/*!40000 ALTER TABLE `studentdb` DISABLE KEYS */;
INSERT INTO `studentdb` (`userID`,`name`,`email`,`mobno`,`parentsMobNo`,`collegeName`,`preferredTime`,`education`) VALUES 
 (1,'abhishek','mjabhishek@gmauil.com','7972163622','1234567890','icem','Afternoon 2pm to 10pm','BE COMP'),
 (2,'Vaishnavi kale','vaishkale@gmail.com','8007902874','-','Icem','Afternoon 2pm to 10pm','BE comp'),
 (3,'Sakshi Khalate','kaskshi.khalate@gmail.com','1234567890','1234567098','ICEM','Afternoon 2pm to 10pm','BE comp'),
 (4,'Tushar J','tjrocks333@gmail.com','1234560987','9123453987','SP Pune','Afternoon 2pm to 10pm','BBA'),
 (5,'Vijay Bihone','Vijay.bihone@gmail.com','8888309565','-','DyP','Afternoon 2pm to 10pm','McA'),
 (5,'Lakhan Balmiki','LakhanBhai@gmail.com','9892123456','-','ICS','Afternoon 2pm to 10pm','Bcs'),
 (34,'','','1125','','','',''),
 (67,'','','1126','','','',''),
 (68,'akku','','1127','','','',''),
 (69,'a','','1128','','','',''),
 (70,'','','1129','','','',''),
 (76,'','','3456','','','',''),
 (79,'','','','','','',''),
 (144,'','','','','','',''),
 (243,'','','','','','',''),
 (123456,'','','','','','','');
/*!40000 ALTER TABLE `studentdb` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
