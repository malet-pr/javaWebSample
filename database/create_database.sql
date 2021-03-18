DROP SCHEMA IF EXISTS `registration_webapp`;
CREATE SCHEMA `registration_webapp`;
USE registration_webapp;
CREATE TABLE `registration_webapp`.`subjects` (
  `subject_id` VARCHAR(8) PRIMARY KEY NOT NULL DEFAULT "S-000-AA",
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(1000) NULL)
COMMENT = 'This table contains data on each subject';
CREATE TABLE `registration_webapp`.`classes` (
  `class_id` VARCHAR(8) PRIMARY KEY NOT NULL DEFAULT "C-000-00",
  `subject_id` VARCHAR(8) NOT NULL DEFAULT "S-000-AA",
  `room_id` INT NOT NULL,
  `time_code` INT NOT NULL,
  `day_code` INT NOT NULL,
  `is_full` TINYINT DEFAULT 0)
COMMENT = 'This table contains data on each class';
CREATE TABLE `registration_webapp`.`rooms` (
  `room_id` INT PRIMARY KEY NOT NULL,
  `max_occupancy` INT NOT NULL,
  `is_accessible` TINYINT DEFAULT 0,
  `is_available` TINYINT DEFAULT 0)
COMMENT = 'This table contains data on each room';
ALTER TABLE classes ADD CONSTRAINT fk_subject_id FOREIGN KEY (subject_id) REFERENCES subjects(subject_id);
ALTER TABLE classes ADD CONSTRAINT fk_room_id FOREIGN KEY (room_id) REFERENCES rooms(room_id);

