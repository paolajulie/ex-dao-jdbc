CREATE DATABASE tradeon;

USE tradeon;

CREATE TABLE Fornecedor (
    idFornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80),
    cnpj VARCHAR(14),
    localizacao VARCHAR(200),
    contato VARCHAR(200)

CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco FLOAT NOT NULL,
    vali DATE NOT NULL,
    uni VARCHAR(10) NOT NULL,
    idForn INT,
    FOREIGN KEY (idForn) REFERENCES Fornecedor(idFornecedor)
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

CREATE TABLE Entrada (
    idEntrada INT AUTO_INCREMENT PRIMARY KEY,
    observacao VARCHAR(255),
    dataEntrada DATE,
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Vendas (
    idVendas INT AUTO_INCREMENT PRIMARY KEY,
    observacao VARCHAR(255),
    dataEntrada DATE,
    idUsuario INT,
    FOREIGN KEY (idUsuario) REFERENCES Usuario(idUsuario)
);

CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    senha VARCHAR(16),
    nome VARCHAR(80),
    cpf VARCHAR(11)
);

CREATE TABLE Itens_Venda (
    idItem_Venda INT AUTO_INCREMENT PRIMARY KEY,
    idVenda INT,
    idProduto INT,
    quantidade INT NOT NULL,
    FOREIGN KEY (idVenda) REFERENCES Vendas(idVendas),
    FOREIGN KEY (idProduto) REFERENCES Produto(id)
);

CREATE TABLE Itens_Entrada (
    idItem_Entrada INT AUTO_INCREMENT PRIMARY KEY,
    idEntrada INT,
    idProduto INT,
    quantidade INT NOT NULL,
    FOREIGN KEY (idEntrada) REFERENCES Entrada(idEntrada),
    FOREIGN KEY (idProduto) REFERENCES Produto(id)
);
