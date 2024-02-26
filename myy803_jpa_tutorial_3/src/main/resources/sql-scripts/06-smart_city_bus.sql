
CREATE DATABASE  IF NOT EXISTS `myy803_spring_boot_jpa_demo_db_4`;
USE `myy803_spring_boot_jpa_demo_db_4`;

DROP TABLE IF EXISTS `stop`;
DROP TABLE IF EXISTS `route`;
DROP TABLE IF EXISTS `service`;

CREATE TABLE `service` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `route` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `service_id` int DEFAULT NULL, 
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_service` FOREIGN KEY (`service_id`) REFERENCES `service` (`id`) 
);

CREATE TABLE `stop` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `latitude` double DEFAULT 0,
  `longtitude` double DEFAULT 0,
  `route_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_route` FOREIGN KEY (`route_id`) REFERENCES `route` (`id`) 
);
