CREATE TABLE reclamacao
(
    id                 VARCHAR(36) PRIMARY KEY,
    cpf_cnpj_reclamado VARCHAR(255) NOT NULL,
    descricao          TEXT         NOT NULL,
    data               TIMESTAMP    NOT NULL,
    usuario_id         VARCHAR(36),
    status             VARCHAR(10)  NOT NULL,
    fechado_por        VARCHAR(36),

    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios (id)


);

CREATE TABLE resposta
(
    id                 VARCHAR(36) PRIMARY KEY,
    descricao          TEXT      NOT NULL,
    data               TIMESTAMP NOT NULL,
    reclamacao_id      VARCHAR(36),
    usuario_id         VARCHAR(36),


    CONSTRAINT fk_usuario_id FOREIGN KEY (usuario_id) REFERENCES usuarios (id),
    CONSTRAINT fk_reclamacao_id FOREIGN KEY (reclamacao_id) REFERENCES reclamacao (id)
);