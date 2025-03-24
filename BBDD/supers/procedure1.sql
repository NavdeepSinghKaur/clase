DROP PROCEDURE mostrar_edad_empleados;
DELIMITER //
CREATE PROCEDURE mostrar_edad_empleados(IN fecha_entrada INT)
BEGIN
	SELECT * FROM cajeros WHERE YEAR(fecha_nac) = fecha_entrada;
END//
DELIMITER ;

CALL mostrar_edad_empleados(1990);
