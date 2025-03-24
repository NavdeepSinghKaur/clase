DROP PROCEDURE IF EXISTS cajeros_por_tienda;

DELIMITER //
CREATE PROCEDURE cajeros_por_tienda(IN nombre_tienda VARCHAR(25))
BEGIN
    SELECT COUNT(tiendas_cajeros.id_cajero) AS numero_cajeros
    FROM tiendas
    JOIN tiendas_cajeros ON tiendas.id = tiendas_cajeros.id_tienda
    WHERE tiendas.nombre = nombre_tienda;
END //

DELIMITER ;
