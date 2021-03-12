/*
Train DB Creation script
*/
DROP DATABASE IF EXISTS Trains;
CREATE DATABASE Trains;

USE Trains;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	`userId` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`username` VARCHAR(15) NOT NULL,
	`password` VARCHAR(16));
							
DROP TABLE IF EXISTS train_cars;
CREATE TABLE train_cars(
	trainCarId INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	userId INT(10),
	trainCarLength INT(10),
	railroad VARCHAR(16),
	class VARCHAR(16),
	notes TEXT,
	manufacturer VARCHAR(16),
	sku VARCHAR(16),
	trainCarStatus VARCHAR(16),
	category VARCHAR(16),
	trainCarNumber INT(6),
	CONSTRAINT `fk_user_trainCars` FOREIGN KEY (userId) REFERENCES Users (userId));
  	
