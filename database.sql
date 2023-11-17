-- Para quem ja tem a tabele feita use o seguinte comando :
-- ALTER TABLE Vendas dataEntrada dataSaida date;

CREATE DATABASE tradeon;

USE tradeon;

CREATE TABLE Entrada (
    idEntrada INT AUTO_INCREMENT PRIMARY KEY,
    observacao VARCHAR(255),
    dataEntrada DATE,
    idUsuario INT
);

CREATE TABLE Estoque (
    idEstoque INT AUTO_INCREMENT PRIMARY KEY,
    custo FLOAT NOT NULL,
    descricao VARCHAR(255),
    quantidade INT NOT NULL,
    min INT NOT NULL,
    max INT NOT NULL,
    StatusEstoque BOOLEAN NOT NULL
);

CREATE TABLE Fornecedor (
    idFornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80),
    cnpj VARCHAR(14),
    localizacao VARCHAR(200),
    contato VARCHAR(200)
);

CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco FLOAT NOT NULL,
    vali DATE NOT NULL,
    uni VARCHAR(10) NOT NULL
);

CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    senha VARCHAR(16),
    nome VARCHAR(80),
    cpf VARCHAR(11)
);

CREATE TABLE Vendas (
    idVendas INT AUTO_INCREMENT PRIMARY KEY,
    observacao VARCHAR(255),
    dataSaida DATE
);
