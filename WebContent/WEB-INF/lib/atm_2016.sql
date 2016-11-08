
CREATE SCHEMA IF NOT EXISTS atm_2016 DEFAULT CHARACTER SET utf8 ;
USE atm_2016 ;

-- -----------------------------------------------------
-- Table atm_2016.`cliente`
-- -----------------------------------------------------
DROP TABLE IF EXISTS atm_2016.`cliente` ;

CREATE TABLE IF NOT EXISTS atm_2016.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_cliente`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table atm_2016.`conta`
-- -----------------------------------------------------
DROP TABLE IF EXISTS atm_2016.`conta` ;

CREATE TABLE IF NOT EXISTS atm_2016.`conta` (
  `conta` INT NOT NULL,
  `agencia` INT NOT NULL,
  `senha` INT NOT NULL,
  `saldo` DECIMAL NOT NULL,
  `cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`conta`, `cliente_id_cliente`),
  INDEX `fk_conta_cliente_idx` (`cliente_id_cliente` ASC),
  CONSTRAINT `fk_conta_cliente`
    FOREIGN KEY (`cliente_id_cliente`)
    REFERENCES atm_2016.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table atm_2016.`movimento`
-- -----------------------------------------------------
DROP TABLE IF EXISTS atm_2016.`movimento` ;

CREATE TABLE IF NOT EXISTS atm_2016.`movimento` (
  `id_movimento` INT NOT NULL AUTO_INCREMENT,
  `data_movimento` DATETIME NOT NULL,
  `valor_movimento` DECIMAL NOT NULL,
  `tipo_movimento` VARCHAR(45) NOT NULL,
  `conta_conta` INT NOT NULL,
  `conta_cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_movimento`, `conta_conta`, `conta_cliente_id_cliente`),
  INDEX `fk_movimento_conta1_idx` (`conta_conta` ASC, `conta_cliente_id_cliente` ASC),
  CONSTRAINT `fk_movimento_conta1`
    FOREIGN KEY (`conta_conta` , `conta_cliente_id_cliente`)
    REFERENCES atm_2016.`conta` (`conta` , `cliente_id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table atm_2016.`log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS atm_2016.`log` ;

CREATE TABLE IF NOT EXISTS atm_2016.`log` (
  `id_log` INT NOT NULL AUTO_INCREMENT,
  `data_operacao_log` DATE NOT NULL,
  `tipo_operacao_log` VARCHAR(45) NOT NULL,
  `agencia_destino_log` INT NOT NULL,
  `conta_destino_log` INT NOT NULL,
  `valor_log` DECIMAL NOT NULL,
  `movimento_id_movimento` INT NOT NULL,
  `movimento_conta_conta` INT NOT NULL,
  `movimento_conta_cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_log`, `movimento_id_movimento`, `movimento_conta_conta`, `movimento_conta_cliente_id_cliente`),
  INDEX `fk_log_movimento1_idx` (`movimento_id_movimento` ASC, `movimento_conta_conta` ASC, `movimento_conta_cliente_id_cliente` ASC),
  CONSTRAINT `fk_log_movimento1`
    FOREIGN KEY (`movimento_id_movimento` , `movimento_conta_conta` , `movimento_conta_cliente_id_cliente`)
    REFERENCES atm_2016.`movimento` (`id_movimento` , `conta_conta` , `conta_cliente_id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table atm_2016.`debito_automatico`
-- -----------------------------------------------------
DROP TABLE IF EXISTS atm_2016.`debito_automatico` ;

CREATE TABLE IF NOT EXISTS atm_2016.`debito_automatico` (
  `id_debito` INT NOT NULL AUTO_INCREMENT,
  `tipo_debito` VARCHAR(45) NOT NULL,
  `valor_debito` DECIMAL NOT NULL,
  `data_debito` DATE NOT NULL,
  `cod_consumidor` INT NOT NULL,
  `conta_conta` INT NOT NULL,
  `conta_cliente_id_cliente` INT NOT NULL,
  `movimento_id_movimento` INT NOT NULL,
  `movimento_conta_conta` INT NOT NULL,
  `movimento_conta_cliente_id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_debito`, `conta_conta`, `conta_cliente_id_cliente`, `movimento_id_movimento`, `movimento_conta_conta`, `movimento_conta_cliente_id_cliente`),
  INDEX `fk_debito_automatico_conta1_idx` (`conta_conta` ASC, `conta_cliente_id_cliente` ASC),
  INDEX `fk_debito_automatico_movimento1_idx` (`movimento_id_movimento` ASC, `movimento_conta_conta` ASC, `movimento_conta_cliente_id_cliente` ASC),
  CONSTRAINT `fk_debito_automatico_conta1`
    FOREIGN KEY (`conta_conta` , `conta_cliente_id_cliente`)
    REFERENCES atm_2016.`conta` (`conta` , `cliente_id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_debito_automatico_movimento1`
    FOREIGN KEY (`movimento_id_movimento` , `movimento_conta_conta` , `movimento_conta_cliente_id_cliente`)
    REFERENCES atm_2016.`movimento` (`id_movimento` , `conta_conta` , `conta_cliente_id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

