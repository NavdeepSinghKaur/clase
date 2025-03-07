DROP PROCEDURE IF EXISTS productos_grupo;

DELIMITER //

CREATE PROCEDURE productos_grupo(IN nombre_grupo_var VARCHAR(12), OUT productos_var INT)
BEGIN
	SELECT COUNT(*) INTO productos_var FROM grupos INNER JOIN productos ON grupos.IdGrupo = productos.IdGrupo WHERE grupos.NombreGrupo = nombre_grupo_var;
END//

DELIMITER ;

CALL productos_grupo("Frutas", @productos_var);
SELECT @productos_var;
