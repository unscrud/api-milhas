CREATE TABLE promocao (
    id SERIAL PRIMARY KEY,
    destino VARCHAR(255),
    imagem VARCHAR(255),
    preco NUMERIC(15, 2) 
);

INSERT INTO promocao (destino, imagem, preco) 
    VALUES 
        ('Atacama', 'atacama.png', 2500),
        ('Veneza', 'veneza.png', 1500),
        ('Patagônia', 'patagonia.png', 750),
        ('Grand Canyon', 'grand-canyon.png', 2500),
        ('Turquia', 'turquia.png', 1900),
        ('Cordilheira dos Andes', 'cordilheira-dos-andes.png', 800);
