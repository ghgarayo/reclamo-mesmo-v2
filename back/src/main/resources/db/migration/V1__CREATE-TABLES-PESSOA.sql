CREATE TABLE usuarios
(
    id        VARCHAR(255) NOT NULL PRIMARY KEY,
    login     VARCHAR(255) NOT NULL UNIQUE,
    senha     VARCHAR(255) NOT NULL,
    is_admin  BOOLEAN DEFAULT FALSE,
    is_active BOOLEAN DEFAULT TRUE
);

CREATE TABLE pessoa_fisica
(
    id          VARCHAR(36)  NOT NULL PRIMARY KEY,
    nome        VARCHAR(255) NOT NULL,
    cpf         VARCHAR(255) NOT NULL UNIQUE,
    email       VARCHAR(255) NOT NULL UNIQUE,
    usuario_id  VARCHAR(36)  NOT NULL UNIQUE,
    telefone    VARCHAR(255) NOT NULL,
    logradouro  VARCHAR(100) NOT NULL,
    bairro      VARCHAR(100) NOT NULL,
    cep         VARCHAR(9)   NOT NULL,
    complemento VARCHAR(100),
    numero      VARCHAR(20),
    uf          VARCHAR(2)   NOT NULL,
    cidade      VARCHAR(100) NOT NULL,
    is_active   BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE pessoa_juridica
(
    id           VARCHAR(36)  NOT NULL PRIMARY KEY,
    razao_social VARCHAR(255) NOT NULL,
    cnpj         VARCHAR(255) NOT NULL UNIQUE,
    email        VARCHAR(255) NOT NULL UNIQUE,
    usuario_id   VARCHAR(36)  NOT NULL UNIQUE,
    telefone     VARCHAR(255) NOT NULL,
    logradouro   VARCHAR(100) NOT NULL,
    bairro       VARCHAR(100) NOT NULL,
    cep          VARCHAR(9)   NOT NULL,
    complemento  VARCHAR(100),
    numero       VARCHAR(20),
    uf           VARCHAR(2)   NOT NULL,
    cidade       VARCHAR(100) NOT NULL,
    is_active    BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);

CREATE TABLE administrador
(
    id          VARCHAR(36)  NOT NULL PRIMARY KEY,
    nome        VARCHAR(255) NOT NULL,
    cpf         VARCHAR(255) NOT NULL UNIQUE,
    email       VARCHAR(255) NOT NULL UNIQUE,
    usuario_id  VARCHAR(36)  NOT NULL UNIQUE,
    telefone    VARCHAR(255) NOT NULL,
    logradouro  VARCHAR(100) NOT NULL,
    bairro      VARCHAR(100) NOT NULL,
    cep         VARCHAR(9)   NOT NULL,
    complemento VARCHAR(100),
    numero      VARCHAR(20),
    uf          VARCHAR(2)   NOT NULL,
    cidade      VARCHAR(100) NOT NULL,
    is_active   BOOLEAN DEFAULT TRUE,
    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios(id)
);