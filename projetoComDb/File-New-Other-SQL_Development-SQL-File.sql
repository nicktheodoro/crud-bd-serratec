create database exercicios;
use exercicios;

create table conta (
	numero_conta int primary key auto_increment,
	titular varchar(30),
	saldo double
    );

insert into conta values(null,'Ana',1000);
insert into conta values(null,'Maria',2000);
insert into conta values(null,'Jorge',2800);
insert into conta values(null,'Jose',4000);