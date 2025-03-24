DROP FUNCTION IF EXISTS calcular_puntos_corredor;
DELIMITER //
CREATE FUNCTION calcular_puntos_corredor(corredor INT)
RETURNS INT
READS SQL DATA
BEGIN
	DECLARE tiempo INT;
	DECLARE penalizacion1 INT;
	DECLARE penalizacion2 INT;
	DECLARE puntos INT;
	
	SELECT  Time, Penalty1, Penalty2 
	INTO tiempo, penalizacion1, penalizacion2 
	FROM Runners 
	WHERE Runner_id = corredor;
	
	SET puntos = 500 - tiempo - penalizacion1*5 - penalizacion2*3;
	
	RETURN puntos;
END//
DELIMITER ;

SELECT calcular_puntos_corredor(1);
