CREATE DATABASE IF NOT EXISTS `bst`;

CREATE TABLE IF NOT EXISTS `bst`.`customer` (
  `name` VARCHAR(64) NOT NULL COMMENT '',
  `description` VARCHAR(255) NULL COMMENT '',
  PRIMARY KEY (`name`)  COMMENT '',
  INDEX `name_idx` (`name` ASC)  COMMENT '',
  UNIQUE INDEX `name_UNIQUE` (`name` ASC)  COMMENT '')
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `bst`.`address` (
  `address_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `street_number` VARCHAR(45) NULL COMMENT '',
  `street_name` VARCHAR(64) NOT NULL COMMENT '',
  `city` VARCHAR(64) NOT NULL COMMENT '',
  `state` VARCHAR(64) NOT NULL COMMENT '',
  `zipcode` VARCHAR(16) NOT NULL COMMENT '',
  `latitude` FLOAT NULL COMMENT '',
  `longitude` FLOAT NULL COMMENT '',
  PRIMARY KEY (`address_id`)  COMMENT '',
  INDEX `zip_idx` (`zipcode` ASC)  COMMENT '')
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `bst`.`contact` (
  `contact_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '',
  `first_name` VARCHAR(16) NOT NULL COMMENT '',
  `last_name` VARCHAR(255) NULL COMMENT '',
  `organization` VARCHAR(64) NULL COMMENT '',
  `phone_number` VARCHAR(32) NOT NULL COMMENT '',
  `email` VARCHAR(80) NULL COMMENT '',
  PRIMARY KEY (`contact_id`)  COMMENT '');


