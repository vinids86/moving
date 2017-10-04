drop table if exists imoveis;
drop table if exists imobiliaria;
drop table if exists users;
create table imobiliaria (id bigint not null auto_increment, description varchar(255), name varchar(255), primary key (id));
create table imoveis (id bigint not null auto_increment, address varchar(255), description varchar(255), type integer, imobiliaria_id bigint, primary key (id));
create table users (id bigint not null auto_increment, email varchar(255) not null, lastname varchar(255) not null, name varchar(255) not null, password varchar(255) not null, reset_token varchar(255), primary key (id));

insert into imobiliaria(name, description) values ('Nome da Imobiliaria', 'Descricao da Imobiliaria');
INSERT INTO users (id, name, lastname, email, password) VALUES ('1', 'Vinicius', 'Saraiva', 'viniciusdsaraiva@gmail.com', '$2a$10$ARppQC0FRWaGP4pnZqYbpuVyYOWIp4q1r2ViT3PGYK6BafD5PXFiS');
