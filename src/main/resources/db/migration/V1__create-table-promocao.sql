CREATE TABLE promocao (
    id SERIAL PRIMARY KEY,
    destino VARCHAR(255),
    imagem VARCHAR(255),
    preco NUMERIC(15, 2) 
);

INSERT INTO promocao (destino, imagem, preco) VALUES ('Atacama', 'atacama.png', 2500);
INSERT INTO promocao (destino, imagem, preco) VALUES ('Veneza', 'veneza.png', 1500);
INSERT INTO promocao (destino, imagem, preco) VALUES ('Patagônia', 'patagonia.png', 750);
INSERT INTO promocao (destino, imagem, preco) VALUES ('Grand Canyon', 'grand-canyon.png', 2500);
INSERT INTO promocao (destino, imagem, preco) VALUES ('Turquia', 'turquia.png', 1900);
INSERT INTO promocao (destino, imagem, preco) VALUES ('Cordilheira dos Andes', 'cordilheira-dos-andes.png', 800);
