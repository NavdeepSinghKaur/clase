DROP FUNCTION IF EXISTS ciudades_poblacion;

DELIMITER //

CREATE FUNCTION ciudades_poblacion(poblacion_entrada INT) RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE ciudades_variable INT;
	SELECT COUNT(nombre) INTO ciudades_variable 
	FROM ciudades 
	WHERE ciudades.poblacion > poblacion_entrada;
	
	RETURN ciudades_variable;
	
END //

DELIMITER ;

SELECT ciudades_poblacion(1000000);
