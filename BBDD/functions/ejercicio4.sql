DELIMITER //

CREATE FUNCTION ciudades_poblacion(poblacion_entrada INT) RETURNS VARCHAR(10000)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE ciudades_variable VARCHAR(10000);
	SELECT GROUP_CONCAT(nombre SEPARATOR ", ") INTO ciudades_variable FROM ciudades  WHERE ciudades.poblacion > poblacion_entrada;
	
	RETURN ciudades_variable;
	
END //

DELIMITER ;

SELECT ciudades_poblacion(100000);
