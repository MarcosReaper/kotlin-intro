drop table if exists persona;

create table if not exists persona(
	ID int PRIMARY KEY auto_increment,
	NOMBRE varchar(50),
	APELLIDO varchar(50)
);