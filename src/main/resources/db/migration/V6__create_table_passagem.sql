CREATE TYPE tipo_passagem_enum AS ENUM ('ECONOMICA', 'EXECUTIVA');
CREATE TABLE IF NOT EXISTS "passagem" (
	"id" SERIAL PRIMARY KEY,
	"tipo" tipo_passagem_enum NOT NULL,
    "preco_ida" DECIMAL(10, 2) NOT NULL,
	"preco_volta" DECIMAL(10, 2) NOT NULL,
	"taxa_embarque" DECIMAL(10, 2) NOT NULL,
	"conexoes" SMALLINT NOT NULL,
	"tempo_voo" INTEGER NOT NULL,
	"origem_id" SMALLINT,
	"destino_id" SMALLINT,
	"companhia_id" INTEGER,
	CONSTRAINT "FK_COMPANHIA" FOREIGN KEY("companhia_id") REFERENCES "companhia"("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT "FK_ORIGEM" FOREIGN KEY("origem_id") REFERENCES "estado"("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT "FK_DESTINO" FOREIGN KEY("destino_id") REFERENCES "estado"("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT "REL_UNIQUE_DESTINO" UNIQUE("destino_id")
);
CREATE CAST (varchar AS tipo_passagem_enum) WITH INOUT AS IMPLICIT;

INSERT INTO "passagem" ("tipo","preco_ida","preco_volta","taxa_embarque","conexoes","tempo_voo","origem_id","destino_id","companhia_id") 
    VALUES 
        ('ECONOMICA',250,240,80.25,1,4,9,15,3),
        ('EXECUTIVA',2800,2700,175.75,2,6,11,19,4),
        ('ECONOMICA',180,170,95.5,0,2,7,13,2),
        ('ECONOMICA',200,190,125.25,2,5,18,16,2),
        ('EXECUTIVA',2300,2200,50.5,1,3,25,6,1),
        ('ECONOMICA',160,150,135.75,0,2,14,20,3),
        ('EXECUTIVA',2400,2300,165.25,2,6,3,24,4),
        ('ECONOMICA',140,130,95,1,4,20,22,2),
        ('EXECUTIVA',2300,2200,195.5,3,8,16,26,1),
        ('ECONOMICA',120,110,110.75,0,2,21,25,3),
        ('EXECUTIVA',2200,2100,225.25,4,9,6,11,4),
        ('ECONOMICA',100,90,125.25,2,5,4,23,2),
        ('EXECUTIVA',2100,2000,50.5,1,3,13,10,1),
        ('ECONOMICA',80,70,135.75,0,2,17,7,3),
        ('EXECUTIVA',2000,1900,165.25,3,8,22,2,4),
        ('ECONOMICA',40,30,110.75,0,2,24,14,3),
        ('EXECUTIVA',1600,1500,225.25,4,9,1,5,4),
        ('ECONOMICA',20,10,95.25,2,5,3,9,2),
        ('ECONOMICA',0,0,135.75,0,2,21,18,3),
        ('EXECUTIVA',2500,2400,240,3,8,12,21,4),
        ('ECONOMICA',500.5,480.5,85.25,1,4,3,17,2),
        ('ECONOMICA',550.5,535.5,90.25,1,4,17,3,2),
        ('EXECUTIVA',5000,4900,330.75,4,9,20,27,1),
        ('ECONOMICA',650.5,635.5,80.25,0,2,21,1,2),
        ('ECONOMICA',700.5,685.5,75.25,1,4,23,8,4);
