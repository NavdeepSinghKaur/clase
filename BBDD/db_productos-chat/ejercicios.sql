-- Creación de la base de datos
DROP DATABASE IF EXISTS sistema_ventas;
CREATE DATABASE sistema_ventas;
USE sistema_ventas;

-- Tabla de clientes
CREATE TABLE clientes (
    cliente_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100),
    telefono VARCHAR(20),
    fecha_registro DATE DEFAULT (CURRENT_DATE),
    direccion TEXT,
    categoria ENUM('regular', 'premium', 'corporativo')
);

-- Tabla de productos
CREATE TABLE productos (
    producto_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio DECIMAL(10,2),
    stock INT NOT NULL DEFAULT 0,
    categoria VARCHAR(50),
    fecha_creacion DATE
);

-- Tabla de pedidos
CREATE TABLE pedidos (
    pedido_id INT AUTO_INCREMENT PRIMARY KEY,
    cliente_id INT,
    fecha_pedido DATE,
    estado ENUM('pendiente', 'procesando', 'enviado', 'entregado', 'cancelado') DEFAULT 'pendiente',
    total DECIMAL(12,2) DEFAULT 0,
    FOREIGN KEY (cliente_id) REFERENCES clientes(cliente_id)
);

-- Tabla de detalles de pedido
CREATE TABLE detalle_pedidos (
    detalle_id INT AUTO_INCREMENT PRIMARY KEY,
    pedido_id INT,
    producto_id INT,
    cantidad INT NOT NULL,
    precio_unitario DECIMAL(10,2) NOT NULL,
    subtotal DECIMAL(12,2),
    FOREIGN KEY (pedido_id) REFERENCES pedidos(pedido_id),
    FOREIGN KEY (producto_id) REFERENCES productos(producto_id)
);

INSERT INTO clientes (nombre, email, telefono, fecha_registro, direccion, categoria) VALUES
('Juan Pérez', 'juan.perez@email.com', '555-1234', '2022-01-15', 'Calle Primavera 123', 'regular'),
('María García', 'maria.garcia@email.com', '555-2345', '2022-02-20', 'Avenida Libertad 456', 'premium'),
('Carlos López', 'carlos.lopez@email.com', '555-3456', '2022-03-10', 'Boulevard Central 789', 'regular'),
('Ana Martínez', 'ana.martinez@email.com', '555-4567', '2022-04-05', 'Calle Roble 321', 'corporativo'),
('Luis Rodríguez', 'luis.rodriguez@email.com', '555-5678', '2022-05-12', 'Avenida Norte 654', 'regular'),
('Sofía Hernández', 'sofia.hernandez@email.com', '555-6789', '2022-06-18', 'Calle Sur 987', 'premium'),
('Miguel González', 'miguel.gonzalez@email.com', '555-7890', '2022-07-22', 'Boulevard Este 147', 'regular'),
('Elena Díaz', 'elena.diaz@email.com', '555-8901', '2022-08-30', 'Avenida Oeste 258', 'corporativo'),
('Jorge Sánchez', 'jorge.sanchez@email.com', '555-9012', '2022-09-14', 'Calle Central 369', 'regular'),
('Patricia Ruiz', 'patricia.ruiz@email.com', '555-0123', '2022-10-25', 'Boulevard Norte 741', 'premium'),
('Fernando Jiménez', 'fernando.jimenez@email.com', '555-1235', '2022-11-08', 'Avenida Sur 852', 'regular'),
('Lucía Gómez', 'lucia.gomez@email.com', '555-2346', '2022-12-03', 'Calle Este 963', 'corporativo'),
('Ricardo Castro', 'ricardo.castro@email.com', '555-3457', '2023-01-17', 'Boulevard Oeste 159', 'regular'),
('Adriana Vargas', 'adriana.vargas@email.com', '555-4568', '2023-02-21', 'Avenida Central 357', 'premium'),
('Oscar Romero', 'oscar.romero@email.com', '555-5679', '2023-03-09', 'Calle Norte 753', 'regular'),
('Claudia Mendoza', 'claudia.mendoza@email.com', '555-6780', '2023-04-12', 'Boulevard Sur 951', 'corporativo'),
('Roberto Silva', 'roberto.silva@email.com', '555-7891', '2023-05-24', 'Avenida Este 862', 'regular'),
('Isabel Ortega', 'isabel.ortega@email.com', '555-8902', '2023-06-07', 'Calle Oeste 764', 'premium'),
('Daniel Morales', 'daniel.morales@email.com', '555-9013', '2023-07-19', 'Boulevard Central 568', 'regular'),
('Gabriela Ríos', 'gabriela.rios@email.com', '555-0124', '2023-08-28', 'Avenida Norte 472', 'corporativo'),
('Héctor Guerrero', 'hector.guerrero@email.com', '555-1236', '2023-09-15', 'Calle Sur 386', 'regular'),
('Silvia Paredes', 'silvia.paredes@email.com', '555-2347', '2023-10-03', 'Boulevard Este 294', 'premium'),
('Francisco Campos', 'francisco.campos@email.com', '555-3458', '2023-11-11', 'Avenida Oeste 198', 'regular'),
('Verónica Vega', 'veronica.vega@email.com', '555-4569', '2023-12-22', 'Calle Central 876', 'corporativo'),
('Raúl Herrera', 'raul.herrera@email.com', '555-5670', '2024-01-05', 'Boulevard Norte 543', 'regular');

INSERT INTO productos (nombre, descripcion, precio, stock, categoria) VALUES
('Laptop Elite', 'Laptop de última generación con 16GB RAM', 1200.00, 15, 'Electrónicos'),
('Smartphone X', 'Teléfono inteligente con cámara de 48MP', 800.00, 25, 'Electrónicos'),
('Tablet Pro', 'Tablet de 10 pulgadas con stylus', 450.00, 18, 'Electrónicos'),
('Auriculares BT', 'Auriculares inalámbricos con cancelación de ruido', 150.00, 30, 'Accesorios'),
('Teclado Mecánico', 'Teclado gaming con retroiluminación RGB', 90.00, 40, 'Accesorios'),
('Mouse Inalámbrico', 'Mouse ergonómico con 6 botones programables', 45.00, 50, 'Accesorios'),
('Monitor 27"', 'Monitor QHD de 27 pulgadas', 350.00, 12, 'Electrónicos'),
('Impresora Multifunción', 'Impresora láser a color', 280.00, 8, 'Oficina'),
('Silla Ergonómica', 'Silla de oficina ajustable', 220.00, 10, 'Mobiliario'),
('Escritorio Ejecutivo', 'Escritorio de madera 160x80cm', 320.00, 7, 'Mobiliario'),
('Router WiFi 6', 'Router de última generación con 8 antenas', 180.00, 15, 'Redes'),
('Disco SSD 1TB', 'Disco sólido de alta velocidad', 120.00, 20, 'Componentes'),
('Memoria RAM 16GB', 'Módulo DDR4 3200MHz', 80.00, 25, 'Componentes'),
('Webcam 4K', 'Cámara web con micrófono integrado', 95.00, 18, 'Accesorios'),
('Micrófono Profesional', 'Micrófono de condensador USB', 130.00, 12, 'Audio'),
('Altavoz Bluetooth', 'Altavoz portátil resistente al agua', 75.00, 22, 'Audio'),
('Power Bank 20000mAh', 'Batería externa de carga rápida', 50.00, 30, 'Accesorios'),
('Kit Limpieza', 'Kit para limpieza de dispositivos electrónicos', 25.00, 40, 'Accesorios'),
('Funda Tablet', 'Funda protectora para tablet', 35.00, 28, 'Accesorios'),
('Mochila Portátil', 'Mochila con compartimento para laptop', 65.00, 15, 'Accesorios');

INSERT INTO pedidos (cliente_id, fecha_pedido, estado, total) VALUES
(1, '2023-01-10 09:15:00', 'entregado', 0),
(2, '2023-01-12 14:30:00', 'entregado', 0),
(3, '2023-01-15 11:45:00', 'entregado', 0),
(4, '2023-01-18 16:20:00', 'entregado', 0),
(5, '2023-01-20 10:10:00', 'entregado', 0),
(6, '2023-02-05 13:25:00', 'entregado', 0),
(7, '2023-02-10 15:30:00', 'entregado', 0),
(8, '2023-02-15 09:45:00', 'entregado', 0),
(9, '2023-02-20 11:20:00', 'entregado', 0),
(10, '2023-03-01 14:15:00', 'entregado', 0),
(11, '2023-03-05 10:30:00', 'entregado', 0),
(12, '2023-03-10 16:45:00', 'entregado', 0),
(13, '2023-03-15 12:10:00', 'entregado', 0),
(14, '2023-03-20 09:25:00', 'entregado', 0),
(15, '2023-04-01 14:40:00', 'entregado', 0),
(16, '2023-04-05 11:55:00', 'entregado', 0),
(17, '2023-04-10 15:10:00', 'entregado', 0),
(18, '2023-04-15 10:25:00', 'entregado', 0),
(19, '2023-04-20 13:40:00', 'entregado', 0),
(20, '2023-05-01 09:55:00', 'entregado', 0),
(21, '2023-05-05 14:10:00', 'procesando', 0),
(22, '2023-05-10 10:25:00', 'procesando', 0),
(23, '2023-05-15 15:40:00', 'enviado', 0),
(24, '2023-05-20 11:55:00', 'enviado', 0),
(25, '2023-06-01 16:10:00', 'pendiente', 0),
(1, '2023-06-05 09:25:00', 'pendiente', 0),
(3, '2023-06-10 14:40:00', 'pendiente', 0),
(5, '2023-06-15 10:55:00', 'pendiente', 0),
(7, '2023-06-20 15:10:00', 'pendiente', 0),
(9, '2023-06-25 11:25:00', 'pendiente', 0);

INSERT INTO detalle_pedidos (pedido_id, producto_id, cantidad, precio_unitario) VALUES
-- Pedido 1
(1, 1, 1, 1200.00),
(1, 4, 1, 150.00),
(1, 12, 1, 120.00),

-- Pedido 2
(2, 2, 1, 800.00),
(2, 5, 1, 90.00),
(2, 6, 1, 45.00),

-- Pedido 3
(3, 3, 1, 450.00),
(3, 14, 1, 95.00),

-- Pedido 4
(4, 7, 2, 350.00),
(4, 11, 1, 180.00),

-- Pedido 5
(5, 8, 1, 280.00),
(5, 9, 1, 220.00),
(5, 10, 1, 320.00),

-- Pedido 6
(6, 12, 2, 120.00),
(6, 13, 2, 80.00),

-- Pedido 7
(7, 15, 1, 130.00),
(7, 16, 1, 75.00),

-- Pedido 8
(8, 17, 3, 50.00),
(8, 18, 2, 25.00),

-- Pedido 9
(9, 19, 1, 35.00),
(9, 20, 1, 65.00),

-- Pedido 10
(10, 1, 1, 1200.00),
(10, 4, 1, 150.00),
(10, 5, 1, 90.00),

-- Pedido 11
(11, 2, 1, 800.00),
(11, 6, 1, 45.00),

-- Pedido 12
(12, 3, 1, 450.00),
(12, 14, 1, 95.00),

-- Pedido 13
(13, 7, 1, 350.00),
(13, 11, 1, 180.00),

-- Pedido 14
(14, 8, 1, 280.00),
(14, 9, 1, 220.00),

-- Pedido 15
(15, 10, 1, 320.00),
(15, 12, 1, 120.00),

-- Pedido 16
(16, 13, 2, 80.00),
(16, 15, 1, 130.00),

-- Pedido 17
(17, 16, 1, 75.00),
(17, 17, 2, 50.00),

-- Pedido 18
(18, 18, 3, 25.00),
(18, 19, 1, 35.00),

-- Pedido 19
(19, 20, 1, 65.00),
(19, 1, 1, 1200.00),

-- Pedido 20
(20, 2, 1, 800.00),
(20, 3, 1, 450.00),

-- Pedido 21
(21, 4, 2, 150.00),
(21, 5, 1, 90.00),

-- Pedido 22
(22, 6, 1, 45.00),
(22, 7, 1, 350.00),

-- Pedido 23
(23, 8, 1, 280.00),
(23, 9, 1, 220.00),

-- Pedido 24
(24, 10, 1, 320.00),
(24, 11, 1, 180.00),

-- Pedido 25
(25, 12, 1, 120.00),
(25, 13, 1, 80.00),

-- Pedido 26
(26, 14, 1, 95.00),
(26, 15, 1, 130.00),

-- Pedido 27
(27, 16, 1, 75.00),
(27, 17, 1, 50.00),

-- Pedido 28
(28, 18, 2, 25.00),
(28, 19, 1, 35.00),

-- Pedido 29
(29, 20, 1, 65.00),
(29, 1, 1, 1200.00),

-- Pedido 30
(30, 2, 1, 800.00),
(30, 3, 1, 450.00);

FUNCIONES
Funcion 1-Clasificar producto por precio(Económico menor de 50, Estandar entre 50 y 200, Premium entre 201 y 500 y Lujo mayor de 500)
DROP FUNCTION IF EXISTS clasificador_productos;
DELIMITER //
CREATE FUNCTION clasificador_productos(var_id_producto INT)
RETURNS VARCHAR(50)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE var_gama VARCHAR(50) DEFAULT '';
	DECLARE var_precio DECIMAL(10, 2);
	SELECT precio INTO var_precio FROM productos WHERE producto_id = var_id_producto;
	
	SET var_gama = CASE 
		WHEN var_precio < 51 THEN 'Económico'
		WHEN var_precio BETWEEN 50 AND 200 THEN 'Estandar'
		WHEN var_precio BETWEEN 201 AND 500 THEN 'Premium'
		ELSE 'Lujo'
	END IF;

	RETURN var_gama;
END//
DELIMITER ;

SELECT nombre, clasificador_productos(producto_id) AS categoria FROM productos;

Funcion 2-Calcular días desde el último pedido pasando como parametro el id del clientes

DROP FUNCTION IF EXISTS dias_ultimo_pedido;
DELIMITER //
CREATE FUNCTION dias_ultimo_pedido(id INT)
RETURNS BIGINT
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE var_fecha BIGINT;
	SELECT DATEDIFF(CURDATE(), MAX(fecha_pedido)) INTO var_fecha 
	FROM pedidos 
	INNER JOIN clientes 
		ON clientes.cliente_id = pedidos.cliente_id 
		WHERE id = clientes.cliente_id;
	RETURN var_fecha;
END//
DELIMITER ;

SELECT nombre, dias_ultimo_pedido(3) FROM clientes WHERE cliente_id = 3;


Funcion 3-Función para obtener el nombre completo de un cliente pasando como parametro el id del cliente

DROP FUNCTION IF EXISTS obtener_nombre_cliente;
DELIMITER //
CREATE FUNCTION obtener_nombre_cliente(id INT)
RETURNS VARCHAR(100)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE var_nombre VARCHAR(100);
	SELECT nombre INTO var_nombre FROM clientes WHERE cliente_id = id;
	RETURN var_nombre;
END//
DELIMITER ;

SELECT obtener_nombre_cliente(3) FROM clientes WHERE cliente_id = 3;

Funcion 4-Función para contar productos en una categoría pasando como parametro el nombre de la categoría
DROP FUNCTION IF EXISTS contador_productos;
DELIMITER //
CREATE FUNCTION contador_productos(nombre_categoria VARCHAR(50))
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE contador INT DEFAULT 0;
	SELECT COUNT(categoria) INTO contador FROM productos WHERE categoria = nombre_categoria;
	RETURN contador;
END//
DELIMITER ;

SELECT contador_productos("Accesorios") AS numero;

Funcion 5-Función para obtener el estado de un pedido pasandole el id del pedido
DROP FUNCTION IF EXISTS estado_pedido;
DELIMITER //
CREATE FUNCTION estado_pedido(id INT)
RETURNS VARCHAR(300)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE var_estado VARCHAR(300);
	SELECT estado INTO var_estado FROM pedidos WHERE pedido_id = id;
	RETURN var_estado;
 
END//
DELIMITER ;
 
SELECT estado_pedido(1);

Funcion 6-Función para contar los pedidos de un cliente pasando como parametro el id del cliente
DROP FUNCTION IF EXISTS contar_pedidos_cliente;
DELIMITER //
CREATE FUNCTION contar_pedidos_cliente(id INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE var_num_pedidos INT DEFAULT 0;
	SELECT COUNT(cliente_id) INTO var_num_pedidos FROM pedidos WHERE pedidos.cliente_id = id;
	RETURN var_num_pedidos;
END//
DELIMITER ;

SELECT contar_pedidos_cliente(3);

Funcion 7-Función para verificar si hay stock de un producto pasando el id del producto
DROP FUNCTION IF EXISTS verificar_stock_producto;
DELIMITER //
CREATE FUNCTION verificar_stock_producto(id INT)
RETURNS VARCHAR(3)
DETERMINISTIC
READS SQL DATA
BEGIN
	DECLARE hay_stock VARCHAR(3);
	DECLARE num_stock INT DEFAULT 0;
	SELECT productos.stock INTO num_stock FROM productos WHERE productos.producto_id = id;
	IF (num_stock > 0) THEN
		RETURN "SI";
	ELSE 
		RETURN "NO";
	END IF;
	END //
DELIMITER ;

SELECT verificar_stock_producto(2);



PROCEDURES
PROCEDURE 01-Procedimiento para registrar un nuevo cliente

DROP PROCEDURE IF EXISTS RegistrarCliente;
DELIMITER //
CREATE PROCEDURE registrarCliente(
	IN varNombre VARCHAR(100),
	IN varEmail VARCHAR(100),
	IN varTelefono VARCHAR(20),
	IN varDireccion TEXT,
	IN varCategoria ENUM('regular', 'premium', 'corporativo')
	)
BEGIN
	INSERT INTO clientes (nombre, email, telefono, direccion, categoria)
	VALUES (varNombre, varEmail, varTelefono, varDireccion, varCategoria);
END//
DELIMITER ;

CALL registrarCliente("Nombre Cliente Procedure", "email@cliente.xyz", "+1 1234567890", "Calle ABC", "corporativo");

PROCEDURE 02-Procedimiento para actualizar el stock de un producto

DROP PROCEDURE IF EXISTS actualizarStockProducto;
DELIMITER //
CREATE PROCEDURE actualizarStockProducto(
			IN idProducto INT, 
			IN varStock INT
			)
BEGIN
	UPDATE productos
	SET stock = varStock
	WHERE producto_id = idProducto;
END//
DELIMITER ;

CALL actualizarStockProducto(1, 300000);
CALL actualizarStockProducto(1, 15);

PROCEDURE 03-Procedimiento para cambiar el estado de un pedido pasar el id del pedido y el nuevo estado

DROP PROCEDURE IF EXISTS cambiarEstadoPedido;
DELIMITER //
CREATE PROCEDURE cambiarEstadoPedido(
		IN idPedido INT, 
		IN nuevoEstado ENUM('pendiente', 'procesando', 'enviado', 'entregado', 'cancelado')
		)
BEGIN
	UPDATE pedidos
	SET estado = nuevoEstado
	WHERE pedido_id = idPedido;
END//
DELIMITER ;

CALL cambiarEstadoPedido(1, 'procesando');
	
PROCEDURE 04-Procedimiento para obtener información básica de un cliente pasando el id del Cliente

DROP PROCEDURE IF EXISTS obtenerInfoCliente;
DELIMITER //
CREATE PROCEDURE obtenerInfoCliente(IN entradaId INT)
BEGIN
	SELECT nombre, email, telefono FROM clientes WHERE cliente_id = entradaId;
END//
DELIMITER ;

CALL obtenerInfoCliente(1);

PROCEDURE 05-Procedimiento para listar productos por categoría
DROP PROCEDURE IF EXISTS listarProductosCategoria;
DELIMITER //
CREATE PROCEDURE listarProductosCategoria(IN categoriaProducto VARCHAR(20))
BEGIN
	SELECT * FROM productos WHERE categoria = categoriaProducto;
END//
DELIMITER ;

CALL listarProductosCategoria("Accesorios");

PROCEDURE 06-Procedimiento para listar productos con stock bajo pasando la cantidad, a la que por debajo de la cual, se considera bajo

DROP PROCEDURE IF EXISTS productosStockBajo;
DELIMITER //
CREATE PROCEDURE productosStockBajo(IN cantidadMaxima INT)
BEGIN
	SELECT * FROM productos WHERE stock < cantidadMaxima;
END//
DELIMITER ;

CALL productosStockBajo(30);

PROCEDURE 07-Procedimiento Actualizar estado de pedidos antiguos, pasar los dias para que se considere antiguo y mostar mensaje con este formato, Pedido x cancelado por antigüedad
DROP PROCEDURE IF EXISTS actualizarPedidoAntiguo;
DELIMITER //
CREATE PROCEDURE actualizarPedidoAntiguo(IN dias INT)
BEGIN

	CREATE TABLE mostrarMensajeCancelado
	SELECT pedido_id FROM pedidos
	WHERE DATEDIFF(NOW(), fecha_pedido) > dias;
	
	UPDATE pedidos
	SET estado = "cancelado"
	WHERE DATEDIFF(NOW(), fecha_pedido) > dias;
	
	SELECT CONCAT('Pedido', pedido_id, ' cancelado por aniguedad') FROM mostrarMensajeCancelado;
	DROP TABLE mostrarMensajeCancelado;
END//
DELIMITER ;

CALL actualizarPedidoAntiguo(30);

PROCEDURE 08-Procedimiento Calcular ventas totales por cliente

DROP PROCEDURE IF EXISTS calcularVentasCliente;
DELIMITER //
CREATE PROCEDURE calcularVentasCliente(IN idCliente INT)
BEGIN
	SELECT COUNT(*) AS 'Ventas totales' FROM pedidos WHERE cliente_id = idCliente;
END//
DELIMITER ;

CALL calcularVentasCliente(1);

PROCEDURE 09-Procedimiento Generar reporte de productos por categoría, mostrar categoría, cantidad productos y media del precio
DROP PROCEDURE IF EXISTS reporteProductos;
DELIMITER //
CREATE PROCEDURE reporteProductos(IN categoriaProducto VARCHAR(20))
BEGIN
	SELECT categoria, COUNT(*) AS "Cantidad", AVG(precio) AS "Precio medio" FROM productos WHERE categoria = categoriaProducto GROUP BY categoria;
END//
DELIMITER ;

CALL reporteProductos("Electrónicos");

PROCEDURE 10-Procedimiento Aplicar descuento a productos seleccionados, pasar a que categoría y el porcentaje de descuento
DROP PROCEDURE IF EXISTS aplicarDescuentosCategoria;
DELIMITER //
CREATE PROCEDURE aplicarDescuentosCategoria(
		IN categoriaProductos VARCHAR(20),
		IN porcentajeDescuento DECIMAL (3, 1)
		)
BEGIN
	UPDATE productos
	SET precio = precio - precio*(porcentajeDescuento/100)
	WHERE categoria = categoriaProductos;
END//
DELIMITER ;

CALL aplicarDescuentosCategoria("Electrónicos", 50);

TRIGGERS
TRIGGER 1-Trigger para actualizar stock después de un pedido
DROP TRIGGER IF EXISTS actualizarStock;
DELIMITER //
CREATE TRIGGER actualizarStock AFTER INSERT 
ON detalle_pedidos
FOR EACH ROW
BEGIN
    UPDATE productos
    SET stock = stock - NEW.cantidad
    WHERE productos.producto_id = NEW.producto_id;
END//
DELIMITER ;

TRIGGER 2-Trigger para validar email de cliente
DROP TRIGGER IF EXISTS validarMailCliente;
DELIMITER //
CREATE TRIGGER validarMailCliente 
BEFORE INSERT ON clientes
FOR EACH ROW
BEGIN
    DECLARE validMail INT DEFAULT 0;
    
    IF NEW.email LIKE '%@%.%' THEN
        SET validMail = 1;
    END IF;
    
    IF validMail = 0 THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Mail no valido';
    END IF;
END //
DELIMITER ;

TRIGGER 3-Trigger para calcular automáticamente el total del pedido
-- DROP TRIGGER IF EXISTS calcularCantidadPedido;
-- DELIMITER //
-- CREATE TRIGGER calcularCantidadPedido
-- BEFORE INSERT ON detalle_pedidos
-- FOR EACH ROW
-- BEGIN
-- 	SET NEW.subtotal = NEW.cantidad * NEW.precio_unitario;
-- END//
-- DELIMITER ;

DROP TRIGGER IF EXISTS calcularPedido;
DELIMITER //
CREATE TRIGGER calcularPedido 
AFTER INSERT ON detalle_pedidos
FOR EACH ROW
BEGIN
    UPDATE pedidos
    SET total = (
        SELECT SUM(subtotal)
        FROM detalle_pedidos
        WHERE pedido_id = NEW.pedido_id
    )
    WHERE pedido_id = NEW.pedido_id;
END//
DELIMITER ;

TRIGGER 4-Trigger para actualizar automáticamente el stock al cancelar un pedido(Solo cuando el estado cambia a 'cancelado')
DROP TRIGGER IF EXISTS stockPedidoCancelado;
DELIMITER //
CREATE TRIGGER stockPedidoCancelado
BEFORE UPDATE ON pedidos
FOR EACH ROW
BEGIN
	IF NEW.estado_pedido = 'cancelado' THEN
		UPDATE productos
		INNER JOIN detalle_pedidos ON productos.producto_id = detalle_pedidos.producto_id
		SET stock = stock + detalle_pedidos.cantidad
		WHERE detalle_pedidos.pedido_id = NEW.pedido_id;
	END IF;
END//
DELIMITER ;

TRIGGER 5-Trigger para evitar modificar pedidos ya completados
DROP TRIGGER IF EXISTS pedidoCompletado;
DELIMITER //
CREATE TRIGGER pedidoCompletado
BEFORE UPDATE ON pedidos
FOR EACH ROW
BEGIN
	IF OLD.estado_pedido = 'entregado' THEN
		SIGNAL SQLSTATE '45000' 
		SET MESSAGE_TEXT = 'El pedido ya está entregado. No se puede modificar';
	END IF;
END//
DELIMITER ;

TRIGGER 6-Trigger para actualizar automáticamente la fecha de pedido al cambiar el estado
DROP TRIGGER IF EXISTS acualizarFechaPedido;
DELIMITER //
CREATE TRIGGER acualizarFechaPedido
BEFORE UPDATE ON pedidos
FOR EACH ROW
BEGIN
	SET NEW.fecha_pedido = CURRENT_DATE;
END//
DELIMITER ;
