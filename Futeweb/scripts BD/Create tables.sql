use futeweb;

commit;

drop table Estabelecimento;
drop table Material;
drop table Quadra;
drop table Usuario;
drop table Pessoa_Fisica;
drop table Pessoa_Juridica;
drop table Estabelecimento_Pessoa_Juridica;
drop table Disponibilidade_Quadra;
drop table Disponibilidade_Material;
drop table Reserva;

select * from Estabelecimento;
select * from Material;
select * from Quadra;
select * from Usuario;
select * from Pessoa_Fisica;
select * from Pessoa_Juridica;
select * from Estabelecimento_Pessoa_Juridica;
select * from Disponibilidade_Quadra;
select * from Disponibilidade_Material;
select * from Reserva;

CREATE TABLE Endereco (
  id INT NOT NULL AUTO_INCREMENT,
  logradouro VARCHAR(200) NOT NULL,
  numero INT NOT NULL,
  cidade VARCHAR(200) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Estabelecimento (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(200) NOT NULL,
  logradouro VARCHAR(200) NOT NULL,
  numero INT NOT NULL,
  cidade VARCHAR(200) NOT NULL,
  estado VARCHAR(2) NOT NULL,
  cep VARCHAR(10) NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE Material (
  id INT NOT NULL AUTO_INCREMENT,
  id_estabelecimento INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(200) NULL,
  PRIMARY KEY(id),
  INDEX Material_FKIndex1(id_estabelecimento)
);

CREATE TABLE Quadra (
  id INT NOT NULL AUTO_INCREMENT,
  id_estabelecimento INT NOT NULL,
  nome VARCHAR(100) NOT NULL,
  descricao VARCHAR(200) NOT NULL,
  PRIMARY KEY(id),
  INDEX Quadra_FKIndex1(id_estabelecimento)
);

CREATE TABLE Usuario (
  id INT NOT NULL AUTO_INCREMENT,
  login VARCHAR(200) NOT NULL,
  senha VARCHAR(50) NOT NULL,
  ativo INT NOT NULL DEFAULT 1,
  PRIMARY KEY(id)
);

CREATE TABLE Pessoa_Fisica (
  id INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  nome VARCHAR(200) NOT NULL,
  cpf VARCHAR(14) NOT NULL,
  email VARCHAR(200) NOT NULL,
  data_nascimento DATETIME NOT NULL,
  PRIMARY KEY(id),
  INDEX Pessoa_Fisica_FKIndex1(id_usuario)
);

CREATE TABLE Pessoa_Juridica (
  id INT NOT NULL AUTO_INCREMENT,
  id_usuario INT NOT NULL,
  cnpj VARCHAR(18) NOT NULL,
  nome VARCHAR(200) NOT NULL,
  email VARCHAR(200) NOT NULL,
  PRIMARY KEY(id)
);


CREATE TABLE Estabelecimento_Pessoa_Juridica (
  id_estabelecimento INT NOT NULL,
  id_pessoa_juridica INT NOT NULL,
  PRIMARY KEY(id_estabelecimento, id_pessoa_juridica),
  INDEX Estabelecimento_Pessoa_Juridica_FKIndex1(id_estabelecimento),
  INDEX Estabelecimento_Pessoa_Juridica_FKIndex2(id_pessoa_juridica)
);

CREATE TABLE Disponibilidade_Quadra (
  id INT NOT NULL AUTO_INCREMENT,
  id_quadra INT NOT NULL,
  data_inicio DATETIME NOT NULL,
  data_fim DATETIME NOT NULL,
  PRIMARY KEY(id),
  INDEX Disponibilidade_Quadra_FKIndex1(id_quadra)
);

CREATE TABLE Disponibilidade_Material (
  id INT NOT NULL AUTO_INCREMENT,
  id_material INT NOT NULL,
  data_inicio DATETIME NOT NULL,
  data_fim DATETIME NOT NULL,
  PRIMARY KEY(id),
  INDEX Disponibilidade_Material_FKIndex1(id_material)
);

CREATE TABLE Reserva (
  id INT NOT NULL AUTO_INCREMENT,
  id_pessoa_fisica INT NOT NULL,
  id_disponibilidade_material INT NULL,
  id_disponibilidade_quadra INT NOT NULL,
  PRIMARY KEY(id),
  INDEX Reserva_FKIndex1(id_disponibilidade_quadra),
  INDEX Reserva_FKIndex2(id_disponibilidade_material),
  INDEX Reserva_FKIndex3(id_pessoa_fisica)
);
