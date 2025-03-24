DROP PROCEDURE IF EXISTS actualizar_puntos_corredores;
DELIMITER //
CREATE PROCEDURE actualizar_puntos_corredores()
BEGIN
	UPDATE Runners SET Points=(calcular_puntos_corredor(Runner_id));
END//
DELIMITER ;

CALL actualizar_puntos_corredores();
