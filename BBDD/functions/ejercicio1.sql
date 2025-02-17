DELIMITER //

CREATE FUNCTION idiomas_pais(pais VARCHAR(20)) RETURNS VARCHAR(1000)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE idiomas VARCHAR(1000);
	SELECT GROUP_CONCAT(paisesidioma.idioma SEPARATOR ', ' ) INTO idiomas FROM paises p INNER JOIN paisesidioma ON p.codigo = paisesidioma.paisescodigo WHERE p.nombre LIKE (pais);
	
	RETURN idiomas;
	
END //

DELIMITER ;

SELECT idiomas_pais("Australia");
