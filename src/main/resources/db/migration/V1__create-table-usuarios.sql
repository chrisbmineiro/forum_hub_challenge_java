create table usuarios(

    id bigint not null auto_increment,
    nome varchar(100) not null,
    email varchar(100) not null unique,
    telefone varchar(100) not null unique,
    status varchar(100) not null,

    primary key(id)

);