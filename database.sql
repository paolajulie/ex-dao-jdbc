CREATE DATABASE tradeon;

USE tradeon;

CREATE TABLE produto (
    codigo INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    quantidade INT NOT NULL
);