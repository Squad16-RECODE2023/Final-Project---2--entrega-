-- Geração de Modelo físico
-- Sql ANSI 2003 - brModelo.



CREATE TABLE  cliente_empresa (
empresa_id VARCHAR(5),
cliente_id BIGINT(5),
id BIGINT(10),
PRIMARY KEY(empresa_id,cliente_id)
);

CREATE TABLE cliente (
email VARCHAR(50),
id BIGINT(5) PRIMARY KEY,
cpfOuCnpj VARCHAR(14),
nome VARCHAR(50),
descricao VARCHAR(255)
);

CREATE TABLE empresa (
id BIGINT(5) PRIMARY KEY,
departamento VARCHAR(50),
quantidadeDeFuncionarios INTEGER,
nome VARCHAR(50),
descricao VARCHAR(255)
);
