USE bancoecosun;

-- Inserindo dados na tabela Clientes
INSERT INTO Clientes (email, nome, rua, bairro, cidade, CEP, telefone, CPF, CNPJ, Clientes_TIPO)
VALUES
    ('joao@gmail.com', 'João Silva', 'Rua A', 'Bairro X', 'Cidade Y', 12345678, '11999999999', '12345678901', '98765432000199', 1),
    ('maria@empresa.com', 'Maria Souza', 'Rua B', 'Bairro Y', 'Cidade Z', 87654321, '11988888888', '23456789012', '87654321000188', 1),
    ('empresa@abc.com', 'Empresa ABC', 'Rua C', 'Bairro Z', 'Cidade W', 11223344, '11333333333', '34567890123', '12345678000199', 2),
    ('cliente@teste.com', 'Cliente Teste', 'Rua D', 'Bairro A', 'Cidade V', 44556677, '11955555555', '45678901234', '23456789000177', 2);

-- Inserindo dados na tabela Instalacao
INSERT INTO Instalacao (ID_instalacao, comentario_servico, data_instalacao)
VALUES
    (1, 'Instalação concluída sem problemas', '2024-11-15'),
    (2, 'Manutenção realizada', '2024-11-16'),
    (3, 'Instalação adiada devido ao clima', '2024-11-17'),
    (4, 'Verificação de sistema', '2024-11-18');

-- Inserindo dados na tabela Tecnico
INSERT INTO Tecnico (Nome, Telefone, Email, ID_Tecnico, fk_Instalacao_ID_instalacao)
VALUES
    ('Carlos Santos', '11977777777', 'carlos@tecnico.com', 1, 1),
    ('Ana Oliveira', '11966666666', 'ana@tecnico.com', 2, 2),
    ('Paulo Lima', '11955555555', 'paulo@tecnico.com', 3, 3),
    ('Fernanda Costa', '11944444444', 'fernanda@tecnico.com', 4, 4);

-- Inserindo dados na tabela Fornecedor
INSERT INTO Fornecedor (Nome_Empresa, CNPJ, telefone, email, rua, bairro, Cidade, CEP)
VALUES
    ('SolarTech', '11122233000144', '11955555555', 'contato@solartech.com', 'Rua Solar', 'Bairro Luz', 'Cidade Sol', '12345000'),
    ('EcoPanels', '22233344000155', '11944444444', 'contato@ecopanels.com', 'Rua Verde', 'Bairro Natureza', 'Cidade Eco', '54321000'),
    ('GreenEnergy', '33344455000166', '11933333333', 'contato@greenenergy.com', 'Rua Energia', 'Bairro Sustentável', 'Cidade Verde', '67891000'),
    ('PowerSun', '44455566000177', '11922222222', 'contato@powersun.com', 'Rua Luz', 'Bairro Solar', 'Cidade Brilho', '98765000');

-- Inserindo dados na tabela Forma_Pagamento
INSERT INTO Forma_Pagamento (valor_total, ID_Pagamento, data_emissao)
VALUES
    (1000.00, 1, '2024-11-17'),
    (2000.00, 2, '2024-11-18'),
    (1500.00, 3, '2024-11-19'),
    (1800.00, 4, '2024-11-20');

-- Inserindo dados na tabela Placa
INSERT INTO Placa (Potencia_placa, qtd_placas, ID_placa, prazo_garantia, fk_Instalacao_ID_instalacao, fk_Fornecedor_CNPJ)
VALUES
    ('350W', 10, 1, '5 anos', 1, '11122233000144'),
    ('400W', 8, 2, '6 anos', 2, '22233344000155'),
    ('300W', 12, 3, '4 anos', 3, '33344455000166'),
    ('450W', 6, 4, '7 anos', 4, '44455566000177');

-- Inserindo dados na tabela pedido_faz
INSERT INTO pedido_faz (fk_Forma_Pagamento_ID_Pagamento, fk_Instalacao_ID_instalacao, fk_Clientes_CPF, fk_Clientes_CNPJ)
VALUES
    (1, 1, '12345678901', '98765432000199'),
    (2, 2, '23456789012', '87654321000188'),
    (3, 3, '34567890123', '12345678000199'),
    (4, 4, '45678901234', '23456789000177');

-- Inserindo dados na tabela supervisor
INSERT INTO supervisor (fk_Tecnico_ID_Tecnico, fk_Tecnico_ID_Tecnico_)
VALUES
    (1, 2),
    (3, 4),
    (2, 3),
    (4, 1);