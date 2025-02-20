DROP FUNCTION IF EXISTS personas_idioma;

DELIMITER //

CREATE FUNCTION personas_idioma (idioma VARCHAR(20)) RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE poblacion_total INT;
	
	SELECT SUM(poblacion) 
	INTO poblacion_total 
	FROM paises 
	INNER JOIN paisesidioma ON paisesidioma.paisescodigo = paises.codigo 
	WHERE paisesidioma.idioma LIKE idioma;
	
	RETURN poblacion_total;
	
END //

DELIMITER ;

SELECT personas_idioma("English");
