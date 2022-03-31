create database banco;
use banco;

create table Carro (
ID int not null auto_increment primary key,
nome varchar(40),
marca varchar(30),
cor varchar(30),
ano int
);

insert into Carro(nome, marca, cor, ano) values ('Gol', 'Volkswagen', 'Vermelho', '2015');
insert into Carro(nome, marca, cor, ano) values ('Fiesta', 'Ford', 'Branco', '2017');

select * from Carro;
