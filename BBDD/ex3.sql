DELIMITER //
CREATE FUNCTION notaMasBaja ()
RETURNS DECIMAL(5, 2)
READS SQL DATA
BEGIN
	DECLARE nota_mas_baja DECIMAL (5, 2) DEFAULT 0;
	SELECT MIN(nota) INTO nota_mas_baja FROM estudiantes;
	RETURN nota_mas_baja;
END //
DELIMITER;
