DELIMITER //

CREATE FUNCTION notaMasAlta()
RETURNS DECIMAL(5, 2)
READS SQL DATA
BEGIN
	DECLARE nota_mas_alta DECIMAL(5, 2);
	SELECT MAX(nota) INTO nota_mas_alta FROM estudiantes;
	RETURN nota_mas_alta;
END //

DELIMITER ;
