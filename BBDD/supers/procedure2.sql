DROP PROCEDURE IF EXISTS nombre_cajeros;
DELIMITER //
CREATE PROCEDURE nombre_cajero(IN codigo INT)
BEGIN
	SELECT nombre, apellidos FROM cajeros WHERE codigo = id;
END//
DELIMITER ;

