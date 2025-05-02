DROP DATABASE IF EXISTS motogp;
CREATE DATABASE motogp;
USE motogp;

CREATE TABLE carreras (
	id_carrera int NOT NULL PRIMARY KEY,
	fecha date,
	circuito varchar(20));

CREATE TABLE pilotos (
	id_piloto int NOT NULL PRIMARY KEY,
	nombre varchar(30),
	equipo varchar(20));
	
CREATE TABLE resultados (
	id_carrera int,
	id_piloto int,
	posicion int,
	PRIMARY KEY(id_carrera,id_piloto));
	
CREATE TABLE puntuacion (
	posicion int,
	puntos int);
	
CREATE TABLE clasificacion (DECLARE total_carreras 
	id_piloto int NOT NULL PRIMARY KEY,
	pc1 int,
	pc2 int,
	pc3 int,
	pc4 int,
	pc5 int,
	pc6 int,
	pc7 int,
	pc8 int);
	
INSERT INTO carreras values (1,"2022-04-05","LAS AMÉRICAS"),(2,"2022-04-19","TERMAS DE RÍO HONDO"),(3,"2022-05-03","JEREZ"),(4,"2022-05-17","LE MANS"),(5,"2022-05-31","MUGELLO"),(6,"2022-05-17","CATALUNYA"),(7,"2022-05-31","JAPON"),(8,"2022-06-14","TERUEL");


INSERT INTO puntuacion values (1,25),(2,20),(3,16),(4,13),(5,11),(6,10),(7,9),(8,8),(9,7),(10,6),(11,5),(12,4),(13,3),(14,2),(15,1);

1.- realizar un procedure para insertar los pilotos en la tabla pilotos.
DROP PROCEDURE IF EXISTS insertarPilotos;
DELIMITER //
CREATE PROCEDURE insertarPilotos(IN p_nombre VARCHAR(30), IN p_equipo VARCHAR(30))
BEGIN
    IF LENGTH(p_nombre) <= 3 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'NOMBRE INVÁLIDO'
    END IF;

    INSERT INTO insertarPilotos (nombre, equipo) VALUES (nombre, equipo)
END//
DELIMITER ;

2.- Realizar un procedure para insertar el resultado de un piloto en una carrera. Parametros numero de carrera, numero piloto y posicion.
DROP PROCEDURE IF EXISTS insertarResultadoPiloto;
DELIMITER //
CREATE PROCEDURE insertarResultadoPiloto(IN p_id_carrera INT, IN p_id_piloto INT, IN p_posicion INT)
BEGIN
    INSERT INTO resultados (id_carrera, id_piloto, posicion) VALUES (p_id_carrera, p_id_piloto, p_posicion);
END//
DELIMITER ;

3.- Realizar una funcion en que se le pasa el numero de u piloto y nos devuelve en cuantas carreras ha participado.
DROP FUNCTION IF EXISTS carrerasPiloto;
DELIMITER //
CREATE FUNCTION carrerasPiloto(f_id INT)
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE carr_counter INT DEFAULT 0;
    
    SELECT COUNT(*) INTO carr_counter 
    FROM resultados 
    WHERE id_piloto = f_id;

    RETURN carr_counter;
END//
DELIMITER //

SELECT carrerasPiloto(1) AS 'NUM. CARRERAS';