DROP DATBASE IF EXISTS biblioteca;
CREATE DATABASE IF NOT EXISTS biblioteca;
USE biblioteca;

-- Tabla de Autores
CREATE TABLE autores (
    autor_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    nacionalidad VARCHAR(50),
    fecha_nacimiento DATE
);

-- Tabla de Libros
CREATE TABLE libros (
    libro_id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(200) NOT NULL,
    autor_id INT NOT NULL,
    isbn VARCHAR(20) UNIQUE,
    año_publicacion INT,
    cantidad_disponible INT DEFAULT 1,
    FOREIGN KEY (autor_id) REFERENCES autores(autor_id)
);

-- Tabla de Usuarios
CREATE TABLE usuarios (
    usuario_id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    fecha_registro DATE DEFAULT (CURRENT_DATE),
    estado ENUM('activo', 'inactivo', 'suspendido') DEFAULT 'activo'
);

-- Tabla de Préstamos
CREATE TABLE prestamos (
    prestamo_id INT AUTO_INCREMENT PRIMARY KEY,
    libro_id INT NOT NULL,
    usuario_id INT NOT NULL,
    fecha_prestamo DATE DEFAULT (CURRENT_DATE),
    fecha_devolucion DATE,
    fecha_devolucion_esperada DATE GENERATED ALWAYS AS (DATE_ADD(fecha_prestamo, INTERVAL 15 DAY)) STORED,
    estado ENUM('activo', 'devuelto', 'atrasado') DEFAULT 'activo',
    FOREIGN KEY (libro_id) REFERENCES libros(libro_id),
    FOREIGN KEY (usuario_id) REFERENCES usuarios(usuario_id)
);

1.- Función para calcular días de atraso.
DROP FUNCTION IF EXISTS calcularDiasAtraso;
DELIMITER //
CREATE FUNCTION calcularDiasAtraso(idPrestamo INT)
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
    IF EXISTS(SELECT 1 FROM prestamos WHERE prestamo_id=idPrestamo AND estado = 'atrasado') THEN
        DECLARE fechaInicio DATE;

        SELECT fecha_prestamo 
        INTO fechaInicio 
        FROM prestamos 
        WHERE prestamos.prestamo_id = idPrestamo;

        RETURN DATEDIFF(NOW(), fechaInicio);
    ELSE
        RETURN 0;
    END IF;
END//
DELIMITER ;

2.- Función para verificar disponibilidad de libro.
DROP FUNCTION IF EXISTS disponibilidadLibro;
DELIMITER //
CREATE FUNCTION disponibilidadLibro(idLibro INT)
RETURNS VARCHAR(20)
READS SQL DATA
DETERMINISTIC
BEGIN
    IF EXISTS(SELECT 1 FROM libros WHERE libro_id=idLibro) THEN
        IF (SELECT cantidad_disponible FROM libros WHERE libro_id=idLibro) > 0 THEN
            RETURN 'LIBRO DISPONIBLE';
        ELSE RETURN 'LIBRO NO DISPONIBLE';
        END IF;
    ELSE
        RETURN 'NO HAY LIBROS CON ESE ID';
    END IF;
END//
DELIMITER ;

3.- Procedimiento para registrar un nuevo préstamo.
DROP PROCEDURE IF EXISTS registrarPrestamo;
DELIMITER //
CREATE PROCEDURE registrarPrestamo(
    IN libroId INT, 
    IN usuarioId INT
)
BEGIN
    IF EXISTS(SELECT 1 FROM libros WHERE libro_id = libroId) AND EXISTS(SELECT 1 FROM usuarios WHERE usuario_id = usuarioId) THEN
        INSERT INTO prestamos (libro_id, usuario_id) VALUES (libroId, usuarioId);
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'EL ID DE LIBRO NO EXISTE O EL USUARIO NO EXISTE';
    END IF;

    SELECT * FROM prestamos ORDER BY prestamo_id DESC LIMIT 1;

END//
DELIMITER ;

4.- Procedimiento para devolver un libro.
DROP PROCEDURE IF EXISTS devolver_libro;
DELIMITER //
CREATE PROCEDURE devolver_libro(IN p_id_prestamo INT)
BEGIN

    IF EXISTS(SELECT 1 FROM prestamos WHERE prestamo_id = p_id_prestamo) THEN
        UPDATE prestamos
        SET fecha_devolucion = CURDATE()
        WHERE prestamo_id = p_id_prestamo;

        UPDATE libros
        INNER JOIN prestamos ON prestamos.libro_id = libros.libro_id
        SET cantidad_disponible = cantidad_disponible + 1
        WHERE prestamos.prestamo_id = p_id_prestamo;
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ID PRESTAMO NO EXISTE';
    END IF;

END//
DELIMITER ;

5.- Trigger para actualizar estado a "atrasado" cuando pasa la fecha de devolución.
DROP TRIGGER IF EXISTS cambiarEstadoFecha;
DELIMITER //
CREATE TRIGGER cambiarEstadoFecha
BEFORE UPDATE ON prestamos
FOR EACH ROW
BEGIN
    IF estado = 'activo' AND fecha_devolucion IS NULL AND CURDATE > fecha_devolucion_esperada THEN
        UPDATE prestamos
        SET NEW.estado = 'atrasado';
    END IF;
END //
DELIMITER ;

6.- Trigger para evitar préstamos a usuarios suspendidos.
DROP TRIGGER IF EXISTS evitarPrestamos
DELIMITER //
CREATE TRIGGER evitarPrestamos
BEFORE INSERT ON prestamos
FOR EACH ROW
BEGIN
    DECLARE idUsuario INT;
    DECLARE estadoUsuario VARCHAR(20);

    SET idUsuario = NEW.usuario_id;
    select estado INTO estadoUsuario from usuarios where usuario_id = idUsuario;

    IF estadoUsuario = 'suspendido' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'USUARIO SUSPENDIDO';
    END IF;
END//
DELIMITER ;

7.- Trigger para actualizar automáticamente el estado del préstamo cuando se devuelve.
DROP TRIGGER IF EXISTS actualizarEstadoPrestamo
DELIMITER //
CREATE TRIGGER actualizarEstadoPrestamo
BEFORE UPDATE ON prestamos
FOR EACH ROW
BEGIN
    IF NEW.fecha_devolucion IS NOT NULL THEN
        SET NEW.estado = 'devuelto';
    END IF;
END//
DELIMITER ;
