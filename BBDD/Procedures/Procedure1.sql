DROP PROCEDURE IF EXISTS ventas_dia;

DELIMITER //

CREATE PROCEDURE ventas_dia(IN dia VARCHAR(15), OUT ventas VARCHAR(360))
BEGIN
	SET ventas = (
		SELECT CONCAT(productos.NombreProducto,' - ', vendedores.NombreVendedor, ' - ', ventas.Kilos, ' - ', ventas.Fecha) FROM ventas INNER JOIN productos ON ventas.CodProducto = productos.IdProducto INNER JOIN vendedores ON vendedores.IdVendedor = ventas.CodVendedor WHERE DATE(Fecha) = DATE(dia)
	);
END//

DELIMITER ;

CALL ventas_dia("2021-05-02", @ventas);
SELECT @ventas;
