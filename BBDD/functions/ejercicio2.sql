DROP FUNCTION idioma_por_paises;

DELIMITER //

CREATE FUNCTION idioma_por_paises(idioma VARCHAR(10)) RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE num_paises INT;
	SELECT COUNT(pais.paisescodigo) 
	INTO num_paises 
	FROM paisesidioma pais 
	WHERE pais.idioma LIKE (idioma);
	
	RETURN num_paises;
	
END //

DELIMITER ;

SELECT idioma_por_paises("English");
