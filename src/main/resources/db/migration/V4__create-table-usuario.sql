CREATE TYPE genero_enum AS ENUM ('masculino', 'feminino', 'outro');
CREATE TABLE usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    nascimento DATE NOT NULL,
    telefone  VARCHAR(20) NOT NULL,
    genero genero_enum NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    estado_id INT NOT NULL,
    CONSTRAINT fk_estado FOREIGN KEY (estado_id) REFERENCES estado(id)
);
