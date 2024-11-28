CREATE TABLE companhia (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO companhia (nome) 
    VALUES 
        ('Gol'),
        ('Avianca'),
        ('Azul'),
        ('Latam');