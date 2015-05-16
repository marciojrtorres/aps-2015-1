-- SQL maiusculo RESTANTE minusculo
CREATE DATABASE agenda;

USE agenda;

DROP TABLE IF EXISTS contatos;

-- tabelas no plural
CREATE TABLE contatos (
  id_contato INTEGER     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  nome       VARCHAR(50) NOT NULL,
  sobrenome  VARCHAR(50)     NULL,
  telefone   VARCHAR(15)     NULL
);

INSERT INTO contatos (nome, telefone)
VALUES ('Alex', '88776655');

SELECT * FROM contatos;