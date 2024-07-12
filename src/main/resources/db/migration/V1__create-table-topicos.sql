CREATE TABLE topicos(
id BIGINT NOT NULL AUTO_INCREMENT,
titulo VARCHAR(100) NOT NULL UNIQUE,
mensaje VARCHAR(500) NOT NULL UNIQUE,
fecha_de_creacion DATETIME NOT NULL,
status VARCHAR(20) NOT NULL,
curso VARCHAR(100) NOT NULL,

PRIMARY KEY (id)
);