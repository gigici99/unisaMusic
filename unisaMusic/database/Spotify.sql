drop database if exists Spotify;
create database if not exists Spotify;
use Spotify;

drop user if exists 'admin'@'localhost';
create user 'admin'@'localhost' identified by 'One_plus3t';
grant all privileges on Spotify.* to 'admin'@'localhost';

create table Genere(
	genere varchar(10) PRIMARY KEY
);

create table Artista(
	nome_arte varchar(50) PRIMARY KEY,
	numero_brani int,
    ascolti int default 0
);

create table Compone(
	genere varchar(40),
	nome_arte varchar (50),
	
	CONSTRAINT PK_Compone PRIMARY KEY (genere,nome_arte),
	FOREIGN KEY (genere) REFERENCES Genere(genere),
	FOREIGN KEY (nome_arte) REFERENCES Artista(nome_arte)	
);

create table Brano(
	id int auto_increment PRIMARY KEY,
	titolo varchar(40),
	durata varchar(8), 
	nome_arte varchar(50),
    ascolti int default 0,
	
	FOREIGN KEY (nome_arte) REFERENCES Artista(nome_arte),
    FULLTEXT KEY(titolo)
    
);

create table Abbonamento(
	id int auto_increment,
	descrizione varchar(50),
	
	PRIMARY KEY(id)
);

create table Cliente(
	id int auto_increment,
	username varchar(40) unique,
	email varchar(40) unique,
	nome varchar(20),
	cognome varchar(20),
    tipo boolean default false,
    active boolean default true,
	cf varchar(16),
    dataNascita varchar(40),
    password varchar(40),
	abbonamento int,
	
    PRIMARY KEY(id),
	FOREIGN KEY (abbonamento) references Abbonamento(id)
);

create table Paypal(
	email varchar(40),
	id int,
    
	PRIMARY KEY(email),
    FOREIGN KEY (id) REFERENCES Cliente(id)
);

create table Ascolta(
	id int,
    titolo varchar(40),
    nome_arte varchar(50),
    CONSTRAINT PK_Compone PRIMARY KEY (id, titolo, nome_arte),
    FOREIGN KEY (id) REFERENCES Cliente(id),
    FOREIGN KEY (id) REFERENCES Brano(id),
    FOREIGN KEY (nome_arte) REFERENCES Artista(nome_arte)
);

create table canzoniAcquistate(
	idCliente int,
    idBrano int, 
    foreign key (idCliente) references Cliente(id),
    foreign key (idBrano) references Brano(id),
    primary key (idCliente, idBrano)
);

insert into Cliente(username, email, tipo, password) values
("admin", "admin@admin.it", true, "admin");