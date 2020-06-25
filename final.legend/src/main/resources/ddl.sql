SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `legendsdb` DEFAULT CHARACTER SET utf8 ;
USE `legendsdb` ;

-- -----------------------------------------------------
-- Table `legendsdb`.`player`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`player` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `level` INT(11) NOT NULL,
  `classId` INT(11) NOT NULL,
  `statId` INT(11) NOT NULL,
  `experience` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_class_player_idx` (`classId` ASC),
  INDEX `fk_stat_player_idx` (`statId` ASC),
  UNIQUE (`name`),
  CONSTRAINT `fk_class_player`
  FOREIGN KEY (`classId`)
  REFERENCES `legendsdb`.`class` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_stat_player`
  FOREIGN KEY (`statId`)
  REFERENCES `legendsdb`.`stat` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`stat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`stat` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `health` INT(11) NOT NULL,
  `mana` INT(11) NOT NULL,
  `attack` INT(11) NOT NULL,
  `defense` INT(11) NOT NULL,
  `intelligence` INT(11) NOT NULL,
  `agility` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`class`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`class` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`monster`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`monster` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `statId` INT(11) NOT NULL,
  `xp` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_stat_monster_idx` (`statId` ASC),
  UNIQUE (`name`),
  CONSTRAINT `fk_stat_monster`
  FOREIGN KEY (`statId`)
  REFERENCES `legendsdb`.`stat` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`dungeon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`dungeon` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`skill` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `damage` INT(11) NOT NULL,
  `cost` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE (`name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`class_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`class_skill` (
  `classId` INT(11) NOT NULL,
  `skillId` INT(11) NOT NULL,
  INDEX `fk_class_idx` (`classId` ASC),
  INDEX `fk_skill_idx` (`skillId` ASC),
  UNIQUE (`classId`, `skillId`),
  CONSTRAINT `fk_class`
  FOREIGN KEY (`classId`)
  REFERENCES `legendsdb`.`class` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill`
  FOREIGN KEY (`skillId`)
  REFERENCES `legendsdb`.`skill` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`monster_skill`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`monster_skill` (
  `monsterId` INT(11) NOT NULL,
  `skillId` INT(11) NOT NULL,
  INDEX `fk_monster_idx` (`monsterId` ASC),
  INDEX `fk_skill2_idx` (`skillId` ASC),
  UNIQUE (`monsterId`, `skillId`),
  CONSTRAINT `fk_monster`
  FOREIGN KEY (`monsterId`)
  REFERENCES `legendsdb`.`monster` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_skill2`
  FOREIGN KEY (`skillId`)
  REFERENCES `legendsdb`.`skill` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`dungeon_monster`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `legendsdb`.`dungeon_monster` (
  `dungeonId` INT(11) NOT NULL,
  `monsterId` INT(11) NOT NULL,
  INDEX `fk_dungeon_idx` (`monsterId` ASC),
  INDEX `fk_monster2_idx` (`monsterId` ASC),
  UNIQUE (`dungeonId`, `monsterId`),
  CONSTRAINT `fk_dungeon`
  FOREIGN KEY (`dungeonId`)
  REFERENCES `legendsdb`.`dungeon` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION,
  CONSTRAINT `fk_monster2`
  FOREIGN KEY (`monsterId`)
  REFERENCES `legendsdb`.`monster` (`id`)
  ON DELETE CASCADE
  ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `legendsdb`.`class`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`class`(`name`)
VALUES('Mage'),
('Guerrier'),
('Rôdeur');


-- -----------------------------------------------------
-- Table `legendsdb`.`skill`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`skill`(`name`, `damage`, `cost`)
VALUES ('Boule de feu', 30, 20),
('Eclair', 40, 30),
('Destruction', 50, 40),
('Lame tranchante', 30, 20),
('Spirale de dague', 40, 30),
('Execution du guerrier', 50, 50),
('Flèche lumineuse', 30, 20),
('Esprit du rôdeur', 40, 30),
('Fureur de la forêt', 50, 50),
('Attaque de gobelin', 20, 0),
('Charge de la horde', 40, 0),
('Prison de soie', 30, 0),
('Morsure empoisonnée', 50, 0),
('Attaque de la mort', 20, 0),
('Nécromancie avancée', 30, 0);


-- -----------------------------------------------------
-- Table `legendsdb`.`class_skill`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`class_skill`
(`classId`,
`skillId`)
VALUES (1, 1),
(1, 2),
(1, 3),
(2, 1),
(2, 2),
(2, 3),
(3, 1),
(3, 2),
(3, 3);


-- -----------------------------------------------------
-- Table `legendsdb`.`dungeon`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`dungeon`(`name`)
VALUES('Les mines de la Moria'),
('Isengard'),
('Le gouffre de Helm');


-- -----------------------------------------------------
-- Table `legendsdb`.`stat`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`stat`(`health`, `mana`, `attack`, `defense`, `intelligence`, `agility`)
VALUES (100, 0, 6, 5, 1, 3),
(150, 0, 8, 6, 1, 4),
(200, 0, 10, 7, 1, 5),
(70, 0, 5, 3, 2, 6),
(110, 0, 6, 4, 3, 8),
(150, 0, 7, 5, 3, 10),
(60, 0, 2, 3, 6, 5),
(100, 0, 2, 4, 8, 6),
(140, 0, 3, 5, 10, 7);


-- -----------------------------------------------------
-- Table `legendsdb`.`monster`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`monster`(`name`, `statId`, `xp`)
VALUES ('Gobelin', 1, 25),
('Gobelin berserk', 2, 50),
('Gobelin chef', 3, 100),
('Araignée naine', 4, 25),
('Araignée soldat', 5, 50),
('Araignée mère', 6, 100),
('Nécromancien apprenti', 7, 25),
('Nécromancien Novice', 8, 50),
('Archi-Nécromancien', 9, 100);


-- -----------------------------------------------------
-- Table `legendsdb`.`monster_skill`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`monster_skill`(`monsterId`, `skillId`)
VALUES(1, 10),
(2, 10),
(3, 10),
(3, 11),
(4, 12),
(5, 12),
(6, 12),
(6, 13),
(7, 14),
(8, 14),
(9, 14),
(9, 15);


-- -----------------------------------------------------
-- Table `legendsdb`.`dungeon_monster`
-- -----------------------------------------------------
INSERT INTO `legendsdb`.`dungeon_monster`(`dungeonId`, `monsterId`)
VALUES (1, 1),
(1, 4),
(1, 7),
(2, 2),
(2, 5),
(2, 8),
(3, 3),
(3, 6),
(3, 9);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
