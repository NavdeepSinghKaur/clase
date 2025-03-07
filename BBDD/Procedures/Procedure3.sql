DROP PROCEDURE IF EXISTS vendedor_ventas;

DELIMITER //

CREATE PROCEDURE vendedor_ventas(IN cod_vendedor INT, OUT datos_vendedor VARCHAR(50))
BEGIN
	SET datos_vendedor = (
		SELECT CONCAT('Ventas: ', COUNT(ventas.CodVendedor), ' Total ventas (kg*€/kg) €: ', SUM(ventas.Kilos*productos.Precio)) 
		FROM vendedores 
		INNER JOIN ventas 
			ON vendedores.IdVendedor = ventas.CodVendedor
		INNER JOIN productos
			ON ventas.CodProducto = productos.IdProducto
		WHERE vendedores.IdVendedor = cod_vendedor
	);
END//

DELIMITER ;

CALL vendedor_ventas(7, @ventas_totales);
SELECT @ventas_totales;
