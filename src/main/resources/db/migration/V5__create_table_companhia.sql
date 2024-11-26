CREATE TABLE companhia (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO companhia (nome) VALUES ('Gol');
INSERT INTO companhia (nome) VALUES ('Avianca');
INSERT INTO companhia (nome) VALUES ('Azul');
INSERT INTO companhia (nome) VALUES ('Latam');