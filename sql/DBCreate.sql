/*
Train DB Creation script
*/
<<<<<<< HEAD
DROP DATABASE IF EXISTS trains;
CREATE DATABASE trains;

USE trains;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	userId INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	username VARCHAR(15) NOT NULL,
	userPassword VARCHAR(16));
=======
DROP DATABASE IF EXISTS Trains;
CREATE DATABASE Trains;

USE Trains;

DROP TABLE IF EXISTS users;
CREATE TABLE users(
	`userId` INT(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	`username` VARCHAR(15) NOT NULL,
	`password` VARCHAR(16));
>>>>>>> c578a7f268ab55509526dc5f230aa6cd718054cb
							
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
<<<<<<< HEAD
	CONSTRAINT `fk_user_trainCars` FOREIGN KEY (userId) REFERENCES users (userId));
=======
	CONSTRAINT `fk_user_trainCars` FOREIGN KEY (userId) REFERENCES Users (userId));
>>>>>>> c578a7f268ab55509526dc5f230aa6cd718054cb
  	
