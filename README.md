# Sistema CRUD de Controle de Estoque em Java

## Descrição do Projeto
Este sistema CRUD, desenvolvido em Java, utiliza JDBC para interagir com um banco de dados MySQL e Java Swing para oferecer uma interface gráfica. Gerencia o estoque de produtos, fornecedores, usuários, e controla as entradas e saídas.

## Funcionalidades
O sistema inclui as seguintes operações para cada entidade:

### Entrada

   **Tabela do Banco de Dados:**
   
   CREATE TABLE Entrada (
    idEntrada INT AUTO_INCREMENT PRIMARY KEY,
    observacao VARCHAR(255),
    dataEntrada DATE,
    idUsuario INT
);

1. 📝 **Registro de Entrada:**
   - Permite registrar o cadastro de uma entrada.

2. 📋 **Listagem de Entradas:**
   - Exibe uma lista completa de todas as entradas registradas.

3. 🔍 **Listagem de Entradas por ID:**
   - Mostra informações detalhadas de uma entrada específica.

4. 🗑️ **Exclusão de Entrada:**
   - Permite excluir um registro de entrada do sistema.
     
### Estoque

   **Tabela do Banco de Dados:**

   CREATE TABLE Estoque (
    idEstoque INT AUTO_INCREMENT PRIMARY KEY,
    custo FLOAT NOT NULL,
    descricao VARCHAR(255),
    quantidade INT NOT NULL,
    min INT NOT NULL,
    max INT NOT NULL,
    StatusEstoque BOOLEAN NOT NULL
);

1. 📝 **Registro de Estoque:**
   - Permite registrar o cadastro de um estoque.

2. 📋 **Listagem de Estoque:**
   - Exibe uma lista completa de todos estoques registrados.

3. 🔍 **Listagem de Estoque por ID:**
   - Mostra informações detalhadas de um estoque específico.

4. 🗑️ **Exclusão de Estoque:**
   - Permite excluir um registro de estoque do sistema.

### Fornecedor

   **Tabela do Banco de Dados:**

   CREATE TABLE Fornecedor (
    idFornecedor INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80),
    cnpj VARCHAR(14),
    localizacao VARCHAR(200),
    contato VARCHAR(200)
);

1. 📝 **Cadastro de Fornecedor:**
   - Permite adicionar um novo fornecedor ao sistema.

2. 🔄 **Atualização de Fornecedor:**
   - Possibilita a atualização das informações de um fornecedor existente.

3. 📋 **Listagem de Fornecedores:**
   - Exibe uma lista completa de todos os fornecedores cadastrados.

4. 🔍 **Listagem de Fornecedores por ID:**
   - Mostra informações detalhadas de um fornecedor específico.

5. 🗑️ **Exclusão de Fornecedor:**
   - Permite excluir um fornecedor do sistema.

### Produto

   **Tabela do Banco de Dados:**

   CREATE TABLE Produto (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    preco FLOAT NOT NULL,
    vali DATE NOT NULL,
    uni VARCHAR(10) NOT NULL
);

1. 📝 **Cadastro de Produto:**
   - Permite adicionar um novo produto.
   
2. 🔄 **Atualização de Produto:**
   - Possibilita a atualização das informações de um produto existente.

3. 📋 **Listagem de Produtos:**
   - Exibe uma lista completa de todos os produtos.

4. 🔍 **Listagem de Produtos por ID:**
   - Mostra informações detalhadas de um produto específico.

5. 🗑️ **Exclusão de Produto:**
   - Permite excluir um produto.

### Usuário

   **Tabela do Banco de Dados:**

   CREATE TABLE Usuario (
    idUsuario INT AUTO_INCREMENT PRIMARY KEY,
    senha VARCHAR(16),
    nome VARCHAR(80),
    cpf VARCHAR(11)
);

1. 📝 **Cadastro de Usuário:**
   - Permite adicionar um novo usuário ao sistema, incluindo informações como nome, cargo, etc.

2. 🔄 **Atualização de Usuário:**
   - Possibilita a atualização das informações de um usuário existente.

3. 📋 **Listagem de Usuários:**
   - Exibe uma lista completa de todos os usuários cadastrados.

4. 🔍 **Listagem de Usuários por ID:**
   - Mostra informações detalhadas de um usuário específico.

5. 🗑️ **Exclusão de Usuário:**
   - Permite excluir um usuário do sistema.

### Saída

   **Tabela do Banco de Dados:**

   CREATE TABLE Vendas (
    idVendas INT AUTO_INCREMENT PRIMARY KEY,
    observacao VARCHAR(255),
    dataSaida DATE
);

1. 📝 **Registro de Saída:**
   - Permite registrar a saída

2. 📋 **Listagem de Saídas:**
   - Exibe uma lista completa de todas as saídas registradas.

3. 🔍 **Listagem de Saídas por ID:**
   - Mostra informações detalhadas de uma saída específica.

4. 🗑️ **Exclusão de Saída:**
   - Permite excluir um registro de saída do sistema.

## Equipe de Desenvolvimento
Equipe composta por:

- Igor Alexandre da Costa
- Paola Julie dos Santos da Silva
- Arthur Gattermann Noronha
- João Vitor Schneider Braz da Silva
- Victor José Angélico

Agradecemos por fazerem parte do nosso projeto! 🌟
