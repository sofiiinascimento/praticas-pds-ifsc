create database sofia;
USE sofia;
create table pessoa (
	cpf INT PRIMARY KEY,
    nome VARCHAR(100)
);

insert into pessoa (cpf, nome) values (125, 'Sofia');