DELIMITER //

CREATE FUNCTION idioma_por_paises(idioma VARCHAR(10)) RETURNS VARCHAR (1000)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE paises VARCHAR(1000);
	SELECT GROUP_CONCAT(pais.paisescodigo SEPARATOR ', ') INTO paises FROM paisesidioma pais WHERE pais.idioma LIKE (idioma);
	
	RETURN paises;
	
END //

DELIMITER ;

SELECT idioma_por_paises("English");
