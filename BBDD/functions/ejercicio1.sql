DROP FUNCTION IF EXISTS idiomas_pais;

DELIMITER //

CREATE FUNCTION idiomas_pais(pais VARCHAR(20)) RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE num_idiomas INT;
	
	SELECT COUNT(paisesidioma.idioma) 
	INTO num_idiomas 
	FROM paises
	INNER JOIN paisesidioma ON paises.codigo = paisesidioma.paisescodigo 
	WHERE paises.nombre LIKE (pais);
	
	RETURN num_idiomas;
	
END //

DELIMITER ;

SELECT idiomas_pais("Australia");
