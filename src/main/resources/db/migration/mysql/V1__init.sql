CREATE TABLE `construtora` (
  `id` INT NOT NULL,
  `razao_social` VARCHAR(145) NOT NULL,
  `cnpj` VARCHAR(20) NOT NULL,
  `data_criacao` DATE NOT NULL,
  `data_atualizacao` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));
  
CREATE TABLE `obra` (
  `id` INT NOT NULL,
  `nome_obra` VARCHAR(100) NOT NULL,
  `status` VARCHAR(45) NULL,
  `data_inicio` DATE NOT NULL,
  `data_termino` DATE NULL,
  `data_criacao` DATE NOT NULL,
  `data_atualizacao` DATE NULL,
  `construtora_id` INT NOT NULL,
  PRIMARY KEY (`id`));
    
ALTER TABLE `obra` 
ADD CONSTRAINT `fk_obra_construtora`
  FOREIGN KEY (`construtora_id`)
  REFERENCES `construtora` (`id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;
