CREATE TABLE IF NOT EXISTS usuarios
(
    id               SERIAL PRIMARY KEY,
    nome             VARCHAR(255) NOT NULL,
    email            VARCHAR(255) NOT NULL,
    senha            VARCHAR(255) NOT NULL,
    data_de_cadastro timestamp    NOT NULL
);