create table
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

Alter table cursoapi.usuario add column id_endereco bigint, 
Add constraint FK_ID_ENDERECO
Foreing key(id_endereco) references cursoapi.endereco(id_endereco);