create database ch10;

use ch10;

create table species (
id 			INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY, 
name 		VARCHAR(25) NOT NULL,
num_acres 	DECIMAL(5, 2) NOT NULL
)ENGINE=INNODB;

create table animals (
id 			INTEGER NOT NULL AUTO_INCREMENT PRIMARY KEY,
species_id 	INTEGER,
name		VARCHAR(25),
date_born 	DATETIME,
FOREIGN KEY (species_id) REFERENCES species(id) ON DELETE CASCADE
)ENGINE=INNODB;

INSERT INTO species (name, num_acres) VALUES('African Elephant', 7.5);
INSERT INTO species (name, num_acres) VALUES('Zebra', 1.2);

INSERT INTO animals (species_id, name, date_born) VALUES(1, 'Else', '2016-01-01 01:00:00');
INSERT INTO animals (species_id, name, date_born) VALUES(1, 'Ester', '2016-01-02 01:00:00');
INSERT INTO animals (species_id, name, date_born) VALUES(1, 'Eddie', '2016-01-03 01:00:00');
INSERT INTO animals (species_id, name, date_born) VALUES(2, 'Zelds', '2016-01-04 01:00:00');
INSERT INTO animals (species_id, name, date_born) VALUES(2, 'Zoe', '2016-01-05 01:00:00');
INSERT INTO animals (species_id, name, date_born) VALUES(2, 'Zoita', '2016-01-06 01:00:00');
