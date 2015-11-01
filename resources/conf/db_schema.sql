CREATE SCHEMA IF NOT EXISTS 'carloan' DEFAULT CHARACTER SET latin1 ;
USE 'carloan' ;

CREATE TABLE IF NOT EXISTS 'carloan'.'agenzia' (
	'id' INT(4) NOT NULL,
	'citta' VARCHAR(45) NOT NULL,
	'indirizzo' VARCHAR(45) NOT NULL,
	'telefono' INT(10) NOT NULL,
	PRIMARY KEY ('id'))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS 'carloan'.'fascia' (
	'id' CHARACTER(1) NOT NULL,
	'descrizione' VARCHAR(100) NOT NULL,
	'tariffa_giornaliera' DOUBLE NOT NULL,
	'tariffa_settimanale' DOUBLE NOT NULL,
	'tariffa_km' DOUBLE NOT NULL,
	PRIMARY KEY ('id'))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;