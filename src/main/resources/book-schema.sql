DROP TABLE if exists `book` CASCADE; 
CREATE TABLE book (
	`id` BIGINT primary key auto_increment,
 	`author` VARCHAR(255), 
 	`award` VARCHAR(255), 
 	`genre` VARCHAR(255), 
 	`pages` INTEGER check (pages<=1000 AND pages>=1), 
 	`title` VARCHAR(255) NOT NULL UNIQUE
 );
