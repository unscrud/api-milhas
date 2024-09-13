CREATE TABLE estado (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL UNIQUE,
    sigla VARCHAR(2) NOT NULL UNIQUE
);

 INSERT INTO estado (nome,sigla) VALUES ('Alagoas', 'AL');
 INSERT INTO estado (nome,sigla) VALUES ('Amapá', 'AP');
 INSERT INTO estado (nome,sigla) VALUES ('Distrito Federal', 'DF');
 INSERT INTO estado (nome,sigla) VALUES ('Espírito Santo', 'ES');
 INSERT INTO estado (nome,sigla) VALUES ('Goiás', 'GO');
 INSERT INTO estado (nome,sigla) VALUES ('Maranhão', 'MA');
 INSERT INTO estado (nome,sigla) VALUES ('Mato Grosso', 'MT');
 INSERT INTO estado (nome,sigla) VALUES ('Mato Grosso do Sul', 'MS');
 INSERT INTO estado (nome,sigla) VALUES ('Minas Gerais', 'MG');
 INSERT INTO estado (nome,sigla) VALUES ('Pará', 'PA');
 INSERT INTO estado (nome,sigla) VALUES ('Paraíba', 'PB');
 INSERT INTO estado (nome,sigla) VALUES ('Paraná', 'PR');
 INSERT INTO estado (nome,sigla) VALUES ('Pernambuco', 'PE');
 INSERT INTO estado (nome,sigla) VALUES ('Piauí', 'PI');
 INSERT INTO estado (nome,sigla) VALUES ('Rio de Janeiro', 'RJ');
 INSERT INTO estado (nome,sigla) VALUES ('Rio Grande do Norte', 'RN');
 INSERT INTO estado (nome,sigla) VALUES ('Rio Grande do Sul', 'RS');
 INSERT INTO estado (nome,sigla) VALUES ('Rondônia', 'RO');
 INSERT INTO estado (nome,sigla) VALUES ('Roraima', 'RR');
 INSERT INTO estado (nome,sigla) VALUES ('Santa Catarina', 'SC');
 INSERT INTO estado (nome,sigla) VALUES ('São Paulo', 'SP');
 INSERT INTO estado (nome,sigla) VALUES ('Sergipe', 'SE');
 INSERT INTO estado (nome,sigla) VALUES ('Tocantins', 'TO');
 INSERT INTO estado (nome,sigla) VALUES ('Bahia', 'BA');
 INSERT INTO estado (nome,sigla) VALUES ('Amazonas', 'AM');
 INSERT INTO estado (nome,sigla) VALUES ('Ceará', 'CE');
 INSERT INTO estado (nome,sigla) VALUES ('Acre', 'AC');