CREATE TABLE estado (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(20) NOT NULL UNIQUE,
    sigla VARCHAR(2) NOT NULL UNIQUE
);

 INSERT INTO estado (nome,sigla) 
    VALUES 
        ('Alagoas', 'AL'),
        ('Amapá', 'AP'),
        ('Distrito Federal', 'DF'),
        ('Espírito Santo', 'ES'),
        ('Goiás', 'GO'),
        ('Maranhão', 'MA'),
        ('Mato Grosso', 'MT'),
        ('Mato Grosso do Sul', 'MS'),
        ('Minas Gerais', 'MG'),
        ('Pará', 'PA'),
        ('Paraíba', 'PB'),
        ('Paraná', 'PR'),
        ('Pernambuco', 'PE'),
        ('Piauí', 'PI'),
        ('Rio de Janeiro', 'RJ'),
        ('Rio Grande do Norte', 'RN'),
        ('Rio Grande do Sul', 'RS'),
        ('Rondônia', 'RO'),
        ('Roraima', 'RR'),
        ('Santa Catarina', 'SC'),
        ('São Paulo', 'SP'),
        ('Sergipe', 'SE'),
        ('Tocantins', 'TO'),
        ('Bahia', 'BA'),
        ('Amazonas', 'AM'),
        ('Ceará', 'CE'),
        ('Acre', 'AC');