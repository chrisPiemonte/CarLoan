CREATE SCHEMA IF NOT EXISTS `carloan` DEFAULT CHARACTER SET latin1 ;
USE `carloan` ;

CREATE TABLE IF NOT EXISTS `carloan`.`agenzia` (
	`id` INT(3) ZEROFILL NOT NULL AUTO_INCREMENT,
	`citta` VARCHAR(45) NOT NULL,
	`indirizzo` VARCHAR(45) NOT NULL,
	`telefono` INT(10) NOT NULL,
	PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`fascia` (
	`id` CHARACTER(1) NOT NULL,
	`descrizione` VARCHAR(100) NOT NULL,
	`tariffa_giornaliera` DOUBLE UNSIGNED NOT NULL,
	`tariffa_settimanale` DOUBLE UNSIGNED NOT NULL,
	`tariffa_km` DOUBLE UNSIGNED NOT NULL,
	PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`stato` (
	`id` CHARACTER(1) NOT NULL,
	`descrizione` VARCHAR(100) NOT NULL,
	PRIMARY KEY(`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`auto` (
	`targa` VARCHAR(10) NOT NULL,
	`modello` VARCHAR(30) NOT NULL,
	`stato` CHARACTER(1) NOT NULL,
	`fascia` CHARACTER(1) NOT NULL,
	`km` FLOAT(8, 2) UNSIGNED NOT NULL,
	`manutenzione_ord` DATE NOT NULL,
	`agenzia` INT(3) NOT NULL,
	PRIMARY KEY (`targa`),
	INDEX `fk_autostato_idx` (`stato`),
	FOREIGN KEY (`stato`) REFERENCES `carloan`.`stato` (`id`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_autofascia_idx` (`fascia`),
	FOREIGN KEY (`fascia`) REFERENCES `carloan`.`fascia` (`id`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_autoagenzia_idx` (`agenzia`),
	FOREIGN KEY (`agenzia`) REFERENCES `carloan`.`agenzia` (`id`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`cliente` (
	`cf` VARCHAR(16) NOT NULL,
	`nome` VARCHAR(45) NOT NULL,
	`cognome` VARCHAR(45) NOT NULL,
	`data_nascita` DATE NOT NULL,
	`telefono` INT(10) UNSIGNED NOT NULL,
	PRIMARY KEY (`cf`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`impiegato` (
	`cf` VARCHAR(16) NOT NULL,
	`nome` VARCHAR(45) NOT NULL,
	`cognome` VARCHAR(45) NOT NULL,
	`data_nascita` DATE NOT NULL,
	`telefono` INT(10) UNSIGNED NOT NULL,
	`agenzia` INT(3) NOT NULL,
	`username` VARCHAR(20),
	PRIMARY KEY (`cf`),
	INDEX `fk_impiegatoagenzia_idx` (`agenzia`),
	FOREIGN KEY (`agenzia`) REFERENCES `carloan`.`agenzia` (`id`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_impiegatousername_idx` (`username`),
	FOREIGN KEY (`username`) REFERENCES `carloan`.`account` (`username`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`account` (
	`username` VARCHAR(20) NOT NULL,
	`password` INT(5) NOT NULL,
	`ruolo` ENUM('admin', 'manager', 'impiegato') DEFAULT 'impiegato',
	PRIMARY KEY (`username`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

CREATE TABLE IF NOT EXISTS `carloan`.`contratto` (
	`id` INT(5) NOT NULL AUTO_INCREMENT,
	`cliente` VARCHAR(16) NOT NULL,
	`auto` VARCHAR(10) NOT NULL,
	`mod_noleggio` ENUM('giornaliero', 'settimanale'),
	`km_noleggio` ENUM('limitato', 'illimitato'),
	`data_inizio` DATE NOT NULL,
	`data_fine` DATE NOT NULL,
	`agenzia_inizio` INT(3) NOT NULL,
	`agenzia_fine` INT(3) NOT NULL,
	`impiegato_inizio` VARCHAR(16) NOT NULL,
	`impiegato_fine` VARCHAR(16),
	`acconto` DOUBLE UNSIGNED NOT NULL,
	`km_percorsi` DOUBLE UNSIGNED,
	`tariffa_base` DOUBLE UNSIGNED NOT NULL,
	`stato` ENUM('aperto', 'chiuso'),
	`totale` DOUBLE UNSIGNED,
	PRIMARY KEY (`id`),
	INDEX `fk_contrattocliente_idx` (`cliente`),
	FOREIGN KEY (`cliente`) REFERENCES `carloan`.`cliente` (`cf`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_contrattoauto_idx` (`auto`),
	FOREIGN KEY (`auto`) REFERENCES `carloan`.`auto` (`targa`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_contrattoagenziainizio_idx` (`agenzia_inizio`),
	FOREIGN KEY (`agenzia_inizio`) REFERENCES `carloan`.`agenzia` (`id`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_contrattoagenziafine_idx` (`agenzia_fine`),
	FOREIGN KEY (`agenzia_fine`) REFERENCES `carloan`.`agenzia` (`id`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_contrattoimpiegato_inizio_idx` (`impiegato_inizio`),
	FOREIGN KEY (`impiegato_inizio`) REFERENCES `carloan`.`impiegato` (`cf`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE,
	INDEX `fk_contrattoimpiegato_fine_idx` (`impiegato_fine`),
	FOREIGN KEY (`impiegato_fine`) REFERENCES `carloan`.`impiegato` (`cf`)
		ON DELETE NO ACTION
		ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = latin1;

