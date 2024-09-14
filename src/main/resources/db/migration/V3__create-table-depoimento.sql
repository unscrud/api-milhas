CREATE TABLE depoimento (
    id SERIAL PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    avatar VARCHAR(255)
)

INSERT INTO depoimento (texto,autor,avatar) VALUES ('A Jornada foi uma das melhores agências de viagens que eu já experimentei. O serviço ao cliente foi excepcional, e toda a equipe foi muito atenciosa e prestativa.','Lauro Matos','avatar-1.png');
INSERT INTO depoimento (texto,autor,avatar) VALUES ('Recomendo fortemente a agência de viagens Jornada. Eles oferecem um serviço personalizado e de alta qualidade que excedeu minhas expectativas em minha última viagem.','Talita Magalhães','avatar-2.png');
INSERT INTO depoimento (texto,autor,avatar) VALUES ('Minha viagem com a Jornada foi incrível! Recomendo muito a agência para quem busca uma experiência emocionante e personalizada a partir das nossas necessidades.','Mariana Faustino','avatar-3.png');