create table cursos(

    id bigint not null auto_increment,
    titulo varchar(100) not null,
    descricao varchar(100) not null,
    carga_horaria int not null,
    total_aulas int not null,
    categoria varchar(100) not null,

    primary key(id)

);