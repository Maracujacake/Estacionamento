CREATE DATABASE Estacionamento;
USE Estacionamento;

CREATE TABLE Cliente(
	idCliente INT AUTO_INCREMENT PRIMARY KEY,
	Nome varchar(100) NOT NULL,
	Telefone varchar(50)
	
);

CREATE TABLE Carros(
	idCarro INT AUTO_INCREMENT PRIMARY KEY,
	placa varchar(20) NOT NULL,
	horaChegada DATETIME,
	horaSaida DATETIME,
	idCliente INT, 
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);


CREATE TABLE Pagamento(
	idPagamento INT AUTO_INCREMENT PRIMARY KEY,
	Preco INT DEFAULT 6 NOT NULL,
	idCarro INT,
	FOREIGN KEY (idCarro) REFERENCES Carros(idCarro)
);
