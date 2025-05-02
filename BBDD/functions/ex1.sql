DELIMITER //
CREATE FUNCTION contar_genero(genero ENUM('M', 'F'))
RETURNS INT(10)
READS SQL DATA
BEGIN
	DECLARE numero INT(10) DEFAULT 0;
	SELECT count(e.genero) INTO numero FROM estudiantes e WHERE e.genero = genero;
	RETURN numero;
END //
DELIMITER ;
