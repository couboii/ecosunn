CREATE DATABASE bancoecosun; -- Criação do banco de dados
USE bancoecosun; -- Setando o banco que será utilizado a partir daqui

-- Tabela Clientes
CREATE TABLE Clientes (
    email VARCHAR(40),
    nome VARCHAR(40),
    rua VARCHAR(40),
    bairro VARCHAR(40),
    cidade VARCHAR(40),
    CEP INTEGER,
    telefone VARCHAR(40), -- Telefone agora armazenado diretamente em Clientes
    CPF VARCHAR(40),
    CNPJ VARCHAR(40),
    Clientes_TIPO INT,
    PRIMARY KEY (CPF, CNPJ) -- Mantendo CPF e CNPJ como PK composta para permitir CPF ou CNPJ nulos
);



-- Tabela Instalacao
CREATE TABLE Instalacao (
    ID_instalacao INTEGER PRIMARY KEY,
    comentario_servico VARCHAR(40),
    data_instalacao VARCHAR(40)
);

-- Tabela Tecnico
CREATE TABLE Tecnico (
    Nome VARCHAR(40),
    Telefone VARCHAR(40),
    Email VARCHAR(40),
    ID_Tecnico INTEGER PRIMARY KEY,
    fk_Instalacao_ID_instalacao INTEGER,
    FOREIGN KEY (fk_Instalacao_ID_instalacao) REFERENCES Instalacao (ID_instalacao) ON DELETE SET NULL -- Permite que o valor seja nulo se a instalação for excluída
);

-- Tabela Fornecedor
CREATE TABLE Fornecedor (
    Nome_Empresa VARCHAR(40),
    CNPJ VARCHAR(40) PRIMARY KEY,
    telefone VARCHAR(40),
    email VARCHAR(40),
    rua VARCHAR(40),
    bairro VARCHAR(40),
    Cidade VARCHAR(40),
    CEP VARCHAR(40)
);

-- Tabela Forma_Pagamento
CREATE TABLE Forma_Pagamento (
    valor_total REAL,
    ID_Pagamento INTEGER PRIMARY KEY,
    data_emissao VARCHAR(40)
);

CREATE TABLE Placa (
    Potencia_placa VARCHAR(40),
    qtd_placas INTEGER,
    ID_placa INTEGER,
    prazo_garantia VARCHAR(40),
    fk_Instalacao_ID_instalacao INTEGER NULL, -- Permitir NULL para suportar ON DELETE SET NULL
    fk_Fornecedor_CNPJ VARCHAR(40),
    PRIMARY KEY (ID_placa, fk_Fornecedor_CNPJ, prazo_garantia), -- Removido fk_Instalacao_ID_instalacao
    UNIQUE (ID_placa, fk_Fornecedor_CNPJ, fk_Instalacao_ID_instalacao, prazo_garantia), -- Garantir unicidade, mesmo com NULL
    FOREIGN KEY (fk_Instalacao_ID_instalacao) REFERENCES Instalacao (ID_instalacao) ON DELETE SET NULL,
    FOREIGN KEY (fk_Fornecedor_CNPJ) REFERENCES Fornecedor (CNPJ) ON DELETE RESTRICT
);


-- Tabela pedido_faz
CREATE TABLE pedido_faz (
    fk_Forma_Pagamento_ID_Pagamento INTEGER,
    fk_Instalacao_ID_instalacao INTEGER,
    fk_Clientes_CPF VARCHAR(40),
    fk_Clientes_CNPJ VARCHAR(40),
    FOREIGN KEY (fk_Forma_Pagamento_ID_Pagamento) REFERENCES Forma_Pagamento (ID_Pagamento) ON DELETE RESTRICT,
    FOREIGN KEY (fk_Instalacao_ID_instalacao) REFERENCES Instalacao (ID_instalacao) ON DELETE SET NULL,
    FOREIGN KEY (fk_Clientes_CPF, fk_Clientes_CNPJ) REFERENCES Clientes (CPF, CNPJ) ON DELETE CASCADE -- Permitindo exclusão em cascata para Clientes
);

-- Tabela supervisor
CREATE TABLE supervisor (
    fk_Tecnico_ID_Tecnico INTEGER,
    fk_Tecnico_ID_Tecnico_ INTEGER,
    FOREIGN KEY (fk_Tecnico_ID_Tecnico) REFERENCES Tecnico (ID_Tecnico) ON DELETE CASCADE,
    FOREIGN KEY (fk_Tecnico_ID_Tecnico_) REFERENCES Tecnico (ID_Tecnico) ON DELETE CASCADE
);

