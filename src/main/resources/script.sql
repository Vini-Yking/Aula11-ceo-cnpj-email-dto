CREATE TABLE
 cursoapi.usuario(
id_usuario serial PRIMARY KEY,
 nome varchar(60),
email varchar(60),
senha varchar(255)

);
CREATE TABLE cursoapi.perfil(id_perfil serial PRIMARY KEY, nome varchar(40));

CREATE TABLE cursoapi.usuario_perfil(id_usuario int references cursoapi.usuario(id_usuario),
									 id_perfil int references cursoapi.perfil(id_perfil),
									data_criacao timestamp,
									 constraint pk_usuario_perfil
									PRIMARY KEY(id_usuario,id_perfil));

CREATE TABLE cursoapi.endereco(id_endereco serial PRIMARY KEY,cep varchar(10),
logradouro varchar(50),complemento varchar(30),bairro varchar(40),
localidade varchar(40),uf varchar(2),ibge int);

Alter TABLE cursoapi.usuario add column id_endereco bigint, 
Add constraint FK_ID_ENDERECO
Foreing key(id_endereco) references cursoapi.endereco(id_endereco);

CREATE  TABLE cursoapi.funcionario (id_funcionario serial primary key, nome varchar(60));
CREATE TABLE foto (id_foto serial primary key, dados oid, tipo varchar(100), nome varchar(100), id_funcionario bigint,
FOREIGN KEY (id_funcionario) REFERENCES cursoapi.funcionario(id_funcionario));

CREATE TABLE if not exists vendedor(id_vendedor serial primary key, nome varchar(40),data_nascimento date, salario numeric);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Carlos','2000-05-10',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('João','1999-06-11',2000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Arthur','1998-02-11',3550);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Marcos','2001-02-21',4200);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Adriana','1988-01-22',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Carlos','1974-11-21',2500);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Carlos','1966-08-12',1950);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Yure','1955-02-10',10000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Ana Beatriz','1969-06-11',2300);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Liliane','1974-11-10',3200);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Liliam','2000-01-22',6500);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Mariana','2001-04-28',2500);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Maria José','1978-02-12',2200);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Carlos André','1976-12-22',2300);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Carlos Arthur','1988-08-12',3800);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Carlos Rodrigues','1989-02-12',2800);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Lucas','2001-05-10',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Roni','2002-05-10',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Reinaldo','2003-06-10',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Silvio','2004-05-10',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Sergio','2000-02-11',1000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Silas','2000-01-10',2000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Juarez','1988-05-10',4000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Flávio','1978-05-10',5000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Augusto','1977-06-10',10000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Rômulo','1988-04-10',2900);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Osvaldo','1982-02-10',12000);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Adriana','2000-01-10',1400);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Maiara','2001-03-10',1040);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Paulo','1999-02-10',1850);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Beatriz','1976-01-10',11500);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Laura','1977-03-10',2300);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('José Carlos','1974-05-10',2800);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Ronaldo','1973-01-10',4300);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Priscila','1976-02-10',5500);
insert into cursoapi.vendedor(nome,data_nascimento,salario) values ('Leandro','1989-02-10',6800);