-- Creación de la base de datos
DROP DATABASE IF EXISTS AthleticsClub;
CREATE DATABASE AthleticsClub;
USE AthleticsClub;

-- Tabla Atletas
CREATE TABLE Atletas (
    id_atleta INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    genero ENUM('M', 'F') NOT NULL,
    email VARCHAR(100) UNIQUE,
    telefono VARCHAR(15)
);

-- Tabla Entrenadores
CREATE TABLE Entrenadores (
    id_entrenador INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    especialidad VARCHAR(50),
    anos_experiencia INT
);

-- Tabla Entrenamientos
CREATE TABLE Entrenamientos (
    id_entrenamiento INT PRIMARY KEY AUTO_INCREMENT,
    id_atleta INT,
    id_entrenador INT,
    fecha DATE NOT NULL,
    tipo_entrenamiento VARCHAR(50),
    duracion_minutos INT,
    FOREIGN KEY (id_atleta) REFERENCES Atletas(id_atleta),
    FOREIGN KEY (id_entrenador) REFERENCES Entrenadores(id_entrenador)
);

-- Tabla Competencias
CREATE TABLE Competencias (
    id_competencia INT PRIMARY KEY AUTO_INCREMENT,
    id_atleta INT,
    nombre_competencia VARCHAR(100) NOT NULL,
    fecha DATE NOT NULL,
    resultado DECIMAL(10,2),
    posicion INT,
    FOREIGN KEY (id_atleta) REFERENCES Atletas(id_atleta)
);

SELECT TIMESTAMPDIFF(YEAR,'1995-03-15',CURDATE());

-- Inserción de datos en Atletas
INSERT INTO Atletas (nombre, apellido, fecha_nacimiento, genero, email, telefono) VALUES
('Juan', 'Pérez', '1995-03-15', 'M', 'juan.perez@email.com', '123456789'),
('María', 'Gómez', '1998-07-22', 'F', 'maria.gomez@email.com', '987654321'),
('Carlos', 'López', '1993-11-30', 'M', 'carlos.lopez@email.com', '456789123'),
('Ana', 'Martínez', '2000-01-10', 'F', 'ana.martinez@email.com', '321654987');

-- Inserción de datos en Entrenadores
INSERT INTO Entrenadores (nombre, apellido, especialidad, anos_experiencia) VALUES
('Pedro', 'Sánchez', 'Velocidad', 10),
('Laura', 'Rodríguez', 'Resistencia', 8),
('Miguel', 'Fernández', 'Salto', 12);

-- Inserción de datos en Entrenamientos
INSERT INTO Entrenamientos (id_atleta, id_entrenador, fecha, tipo_entrenamiento, duracion_minutos) VALUES
(1, 1, '2025-05-01', 'Sprint', 60),
(2, 2, '2025-05-02', 'Fondo', 90),
(3, 3, '2025-05-03', 'Salto de longitud', 75),
(4, 1, '2025-05-04', 'Sprint', 60),
(1, 1, '2025-05-05', 'Sprint', 30),
(1, 1, '2025-05-25', 'Fondo', 50);

-- Inserción de datos en Competencias
INSERT INTO Competencias (id_atleta, nombre_competencia, fecha, resultado, posicion) VALUES
(1, 'Copa Nacional', '2025-04-20', 10.5, 1),
(2, 'Maratón Regional', '2025-04-25', 150.25, 3),
(3, 'Torneo de Salto', '2025-04-30', 7.8, 2),
(4, 'Copa Nacional', '2025-04-20', 11.2, 4);


--Funciones

--CalcularEdad: Calcula la edad de un atleta según su fecha de nacimiento (básica).
DROP FUNCTION IF EXISTS calcularEdadAtleta;
DELIMITER //
CREATE FUNCTION calcularEdadAtleta(v_id_atleta INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE edad_atleta DATE;

    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT fecha_nacimiento INTO edad_atleta FROM Atletas WHERE id_atleta = v_id_atleta;
    RETURN (TIMESTAMPDIFF(YEAR, edad_atleta, CURDATE()));
END//
DELIMITER ;

SELECT calcularEdadAtleta(1);

--ContarEntrenamientos: Cuenta los entrenamientos de un atleta (media).
DROP FUNCTION IF EXISTS numEntrenamientosAtleta;
DELIMITER //
CREATE FUNCTION numEntrenamientosAtleta(v_id_atleta INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE num_entrenamientos INT DEFAULT 0;

    IF NOT EXISTS(SELECT 1 FROM Entrenamientos WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT COUNT(id_atleta) INTO num_entrenamientos FROM Entrenamientos WHERE id_atleta = v_id_atleta;

    RETURN num_entrenamientos;
END//
DELIMITER ;

SELECT numEntrenamientosAtleta(1);

--MejorResultado: Devuelve el mejor resultado en competencias de un atleta (media).
DROP FUNCTION IF EXISTS mejorResultadoAtleta;
DELIMITER //
CREATE FUNCTION mejorResultadoAtleta(v_id_atleta INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE mejor_resultado INT DEFAULT 0;

    IF NOT EXISTS(SELECT 1 FROM Competencias WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT MIN(posicion) INTO mejor_resultado FROM Competencias WHERE id_atleta = v_id_atleta LIMIT 1;

    RETURN mejor_resultado;
END//
DELIMITER ;

SELECT mejorResultadoAtleta(1) AS "MEJOR RESULTADO:";

--PromedioDuracionEntrenamientos: Calcula el promedio de duración de los entrenamientos de un atleta (avanzada).
DROP FUNCTION IF EXISTS promedioDuracionEntrenamiento;
DELIMITER //
CREATE FUNCTION promedioDuracionEntrenamiento(v_id_atleta INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE promedio INT DEFAULT 0;

    IF NOT EXISTS(SELECT 1 FROM Entrenamientos WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT AVG(duracion_minutos) INTO promedio FROM Entrenamientos WHERE id_atleta = v_id_atleta;

    RETURN promedio;
END//
DELIMITER ;

SELECT promedioDuracionEntrenamiento(1);

--NombreCompletoAtleta: Concatena nombre y apellido de un atleta (básica).
DROP FUNCTION IF EXISTS nombreCompletoAtleta;
DELIMITER //
CREATE FUNCTION NombreCompletoAtleta(v_id_atleta INT)
RETURNS VARCHAR(120)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE nombre_atleta VARCHAR(120);

    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT CONCAT(Nombre, ' ', apellido) INTO nombre_atleta FROM Atletas WHERE id_atleta = v_id_atleta;

    RETURN nombre_atleta;
END//
DELIMITER ;

SELECT nombreCompletoAtleta(1);

--ContarVictorias: Cuenta las competencias ganadas (posición 1) por un atleta (media).
DROP FUNCTION IF EXISTS competenciasGanadasAtleta;
DELIMITER //
CREATE FUNCTION competenciasGanadasAtleta(v_id_atleta INT)
RETURNS INT
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE competencias_ganadas INT DEFAULT 0;

    IF NOT EXISTS(SELECT 1 FROM Competencias WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT COUNT(posicion) INTO competencias_ganadas FROM Competencias WHERE id_atleta = v_id_atleta AND posicion = 1;


    RETURN competencias_ganadas;
END//
DELIMITER ;

SELECT competenciasGanadasAtleta(2);

--EspecialidadEntrenadorAtleta: Obtiene la especialidad del entrenador asignado a un atleta (avanzada).
DROP FUNCTION IF EXISTS especialidadEntrenador;
DELIMITER //
CREATE FUNCTION especialidadEntrenador(v_id_atleta INT)
RETURNS VARCHAR(50)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_especialidad VARCHAR(50);

    IF NOT EXISTS(SELECT 1 FROM Entrenamientos WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT e.especialidad 
    FROM Entrenamientos ent 
    INNER JOIN Entrenadores e 
        ON ent.id_entrenador = e.id_entrenador 
    WHERE ent.id_atleta = 1
    LIMIT 1;

    RETURN v_especialidad;
END//
DELIMITER ;

SELECT especialidadEntrenador(1);

--EsMayorEdad: Verifica si un atleta es mayor de edad (básica).
DROP FUNCTION IF EXISTS altetaMayorEdad;
DELIMITER //
CREATE FUNCTION altetaMayorEdad(v_id_atleta INT)
RETURNS VARCHAR(2)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE v_fecha_nacimiento INT;
    DECLARE v_mayor_edad VARCHAR(2) DEFAULT 'NO';

    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT TIMESTAMPDIFF(YEAR, fecha_nacimiento, CURDATE()) INTO v_fecha_nacimiento FROM Atletas WHERE id_atleta = v_id_atleta;

    IF(v_fecha_nacimiento > 18) THEN
        SET v_mayor_edad = 'Si';
    END IF;

    RETURN v_mayor_edad;
END//
DELIMITER ;

SELECT altetaMayorEdad(1) AS 'Es mayor de edad?';

--UltimaFechaEntrenamiento: Devuelve la fecha del último entrenamiento de un atleta (media).
DROP FUNCTION IF EXISTS fechaUltimoEntrenamientoAtleta;
DELIMITER //
CREATE FUNCTION fechaUltimoEntrenamientoAtleta(v_id_atleta INT)
RETURNS VARCHAR(12)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE dia DATE;

    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT fecha INTO dia 
    FROM Entrenamientos 
    WHERE id_atleta = 1 
    ORDER BY FECHA DESC 
    LIMIT 1;
 
    RETURN dia;
END//
DELIMITER ;

SELECT fechaUltimoEntrenamientoAtleta(1);

--DiasDesdeUltimaCompetencia: Calcula los días transcurridos desde la última competencia de un atleta (avanzada).
DROP FUNCTION IF EXISTS DiasDesdeUltimaCompetencia;
DELIMITER //
CREATE FUNCTION DiasDesdeUltimaCompetencia(v_id_atleta INT)
RETURNS VARCHAR(12)
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE fecha_competencia DATE;

    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT fecha INTO fecha_competencia FROM Competencias WHERE id_atleta = v_id_atleta ORDER BY fecha DESC LIMIT 1;

    RETURN TIMESTAMPDIFF(DAY, fecha_competencia, CURDATE());
END//
DELIMITER ;

SELECT DiasDesdeUltimaCompetencia(1);

--Procedimientos

--InsertarAtleta: Inserta un nuevo atleta (básico).
DROP PROCEDURE IF EXISTS insertarAtleta;
DELIMITER //
CREATE PROCEDURE InsertarAtleta(
    v_nombre VARCHAR(50),
    v_apellido VARCHAR(50),
    v_fecha_nacimiento DATE,
    v_genero ENUM('M', 'F'),
    v_email VARCHAR(100),
    v_telefono VARCHAR(15)
)
BEGIN
    INSERT INTO Atletas (nombre, apellido, fecha_nacimiento, genero, email, telefono) 
    VALUES (v_nombre, v_apellido, v_fecha_nacimiento, v_genero, v_email, v_telefono);
END//
DELIMITER ;

CALL InsertarAtleta('a', 'b', '2000-12-12', 'M', 'a@a.com', 333333333);

--ActualizarTelefonoAtleta: Actualiza el teléfono de un atleta (básico).
DROP PROCEDURE IF EXISTS actualizarTelefonoAtleta;
DELIMITER //
CREATE PROCEDURE actualizarTelefonoAtleta(v_id_aleta INT, v_telefono INT)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_aleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    UPDATE Atletas
    SET telefono = v_telefono
    WHERE id_atleta = v_id_aleta;
END//
DELIMITER ;

CALL actualizarTelefonoAtleta(5, 111111111);

--RegistrarEntrenamiento: Registra un nuevo entrenamiento (medio).
DROP PROCEDURE IF EXISTS RegistrarEntrenamiento;
DELIMITER //
CREATE PROCEDURE RegistrarEntrenamiento(
    v_id_atleta INT,
    v_id_entrenador INT,
    v_fecha DATE,
    v_tipo_entrenamiento VARCHAR(50),
    v_duracion_minutos INT
)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_aleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    ELSEIF NOT EXISTS(SELECT 1 FROM Entrenadores WHERE v_id_entrenador = id_entrenador) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ENTRENADOR NO EXISTE';
    END IF;

    INSERT INTO Entrenamientos (id_atleta, id_entrenador, fecha, tipo_entrenamiento, duracion_minutos) 
    VALUES (v_id_atleta, v_id_entrenador, v_fecha, v_tipo_entrenamiento, v_duracion_minutos);
END//
DELIMITER ;

CALL RegistrarEntrenamiento(2, 2, '2025-05-15', 'Salto de Longitud', 80);

--EliminarEntrenamientosAntiguos: Elimina entrenamientos anteriores a una fecha (medio).
DROP PROCEDURE IF EXISTS EliminarEntrenamientosAntiguos;
DELIMITER //
CREATE PROCEDURE EliminarEntrenamientosAntiguos(v_fecha DATE)
BEGIN
    DELETE FROM Entrenamientos WHERE fecha < v_fecha;
END//
DELIMITER ;

CALL EliminarEntrenamientosAntiguos('2025-05-02');

--TransferirEntrenador: Cambia el entrenador de los entrenamientos futuros de un atleta (avanzado).
DROP PROCEDURE IF EXISTS TransferirEntrenador;
DELIMITER //
CREATE PROCEDURE TransferirEntrenador(v_id_aleta INT, v_id_entrenador_nuevo INT)
BEGIN

    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_aleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;
    IF NOT EXISTS(SELECT 1 FROM Entrenadores WHERE id_entrenador = v_id_entrenador_nuevo) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ENTRENADOR NO EXISTE';
    END IF;
    UPDATE Entrenamientos
    SET id_entrenador = v_id_entrenador_nuevo
    WHERE v_id_aleta = id_atleta AND fecha > CURDATE();
END//
DELIMITER ;

CALL TransferirEntrenador(1, 3);

--RegistrarResultadoCompetencia: Registra un resultado de competencia (básico).
DROP PROCEDURE IF EXISTS RegistrarResultadoCompetencia;
DELIMITER //
CREATE PROCEDURE RegistrarResultadoCompetencia(
    v_id_atleta INT,
    v_nombre_competencia VARCHAR(1000),
    v_fecha DATE,
    v_resultado DECIMAL(10, 2),
    v_posicion INT
)
BEGIN
    INSERT INTO Competencias (id_atleta, nombre_competencia, fecha, resultado, posicion) 
    VALUES (v_id_atleta, v_nombre_competencia, v_fecha, v_resultado, v_posicion);
END//
DELIMITER ;

CALL RegistrarResultadoCompetencia(1, 'Copa Nacional', '2025-06-20', 12, 2);
--ActualizarEspecialidadEntrenador: Actualiza la especialidad de un entrenador (medio).
DROP PROCEDURE IF EXISTS ActualizarEspecialidadEntrenador;
DELIMITER //
CREATE PROCEDURE ActualizarEspecialidadEntrenador(v_id_entrenador INT, v_especialidad VARCHAR(50))
BEGIN
    IF NOT EXISTS(SELECT 1 FROM Entrenadores WHERE id_entrenador = v_id_entrenador) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ENTRENADOR NO EXISTE';
    END IF;

    UPDATE Entrenadores
    SET especialidad = v_especialidad
    WHERE id_entrenador = v_id_entrenador;
END//
DELIMITER ;

CALL ActualizarEspecialidadEntrenador(1, 'Velocidad');

--ReporteEntrenamientosAtleta: Genera un reporte de entrenamientos de un atleta (avanzado).
DROP PROCEDURE IF EXISTS ReporteEntrenamientosAtleta;
DELIMITER //
CREATE PROCEDURE ReporteEntrenamientosAtleta(v_id_atleta INT)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM Atletas WHERE id_atleta = v_id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ATLETA NO EXISTE';
    END IF;

    SELECT * FROM Entrenamientos WHERE id_atleta = v_id_atleta;
END//
DELIMITER ;

CALL ReporteEntrenamientosAtleta(1);

--ListarAtletasPorGenero: Lista atletas por género (medio).
DROP PROCEDURE IF EXISTS ListarAtletasPorGenero;
DELIMITER //
CREATE PROCEDURE ListarAtletasPorGenero(v_genero ENUM('M', 'F'))
BEGIN
    SELECT * FROM Atletas WHERE genero = v_genero;
END//
DELIMITER ;

CALL ListarAtletasPorGenero('F');

--ActualizarResultadosCompetencia: Ajusta los resultados de una competencia por un factor (avanzado).


--Triggers


--InsertAtleta: Valida el formato del email antes de insertar un atleta (básico).
DROP TRIGGER IF EXISTS InsertarAtleta;
DELIMITER //
CREATE TRIGGER InsertarAtleta
BEFORE INSERT ON Atletas
FOR EACH ROW
BEGIN
    IF NEW.email NOT LIKE '%@%.%' THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'EMAIL INVÁLIDO';
    END IF;
END//
DELIMITER ;

--InsertEntrenamiento: Establece la fecha actual si no se proporciona en un entrenamiento (básico).
DROP TRIGGER IF EXISTS InsertEntrenamiento;
DELIMITER //
CREATE TRIGGER InsertEntrenador
BEFORE INSERT ON Entrenamientos
FOR EACH ROW
BEGIN
    IF (NEW.tipo_entrenamiento LIKE '' OR NEW.tipo_entrenamiento IS NULL) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ENTRENAMIENO INVÁLIDO';
    END IF;
END//
DELIMITER ;

--InsertEntrenamientoDuracion: Verifica que la duración del entrenamiento esté entre 0 y 240 minutos (medio).
DROP TRIGGER IF EXISTS InsertEntrenamientoDuracion;
DELIMITER //
CREATE TRIGGER InsertEntrenamientoDuracion
BEFORE INSERT ON Entrenamientos
FOR EACH ROW
BEGIN
    IF NEW.duracion_minutos NOT BETWEEN 0 AND 240 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'DURACIÓN DE ENTRENAMIENTO INVÀLIDA';
    END IF;
END//
DELIMITER ;

--InsertEntrenador: Inicializa los años de experiencia a 0 si no se especifican (medio).
DROP TRIGGER IF EXISTS InsertEntrenador;
DELIMITER //
CREATE TRIGGER InsertEntrenador
BEFORE INSERT ON Entrenadores
FOR EACH ROW
BEGIN
    IF (NEW.anos_experiencia IS NULL OR NEW.anos_experiencia < 0) THEN
        SET NEW.anos_experiencia = 0;
    END IF;
END//
DELIMITER ;


id_competencia INT PRIMARY KEY AUTO_INCREMENT,
id_atleta INT,
nombre_competencia VARCHAR(100) NOT NULL,
fecha DATE NOT NULL,
resultado DECIMAL(10,2),
posicion INT,
FOREIGN KEY (id_atleta) REFERENCES Atletas(id_atleta)

--UpdateCompetencia: Registra cambios en los resultados de competencias en una tabla de log (avanzado).
DROP TABLE IF EXISTS tablaLog;
CREATE TABLE tablaLog (
    id INT PRIMARY KEY AUTO_INCREMENT,
    id_atleta INT,
    nombre_competencia VARCHAR(100),
    fecha DATE,
    resultado DECIMAL(10,2),
    posicion INT
)

DROP TRIGGER IF EXISTS UpdateCompetencia
DELIMITER //
CREATE TRIGGER UpdateCompetencia
AFTER UPDATE ON Competencias
FOR EACH ROW
BEGIN
END//
DELIMITER ;


--DeleteAtleta: Impide eliminar atletas con entrenamientos registrados (básico).
DROP TRIGGER IF EXISTS DeleteAtleta;
DELIMITER //
CREATE TRIGGER DeleteAtleta
BEFORE DELETE ON Atletas
FOR EACH ROW
BEGIN
    IF EXISTS(SELECT 1 FROM Entrenamientos e WHERE e.id_atleta = OLD.id_atleta) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'NO SE PUEDE ELIMINAR ESTE ATLETA';
    END IF;
END//
DELIMITER ;

--InsertCompetencia: Prohíbe registrar competencias futuras (medio).
DROP TRIGGER IF EXISTS InsertCompetencia;
DELIMITER //
CREATE TRIGGER InsertCompetencia
BEFORE INSERT ON Competencias
FOR EACH ROW
BEGIN
    IF NEW.fecha > CURDATE() THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'FECHA INVÁLIDA. NO PUEDEN HABER COMPETENCIAS FUTURAS';
    END IF;
END//
DELIMITER ;

--InsertCompetencia: Actualiza el promedio de resultados de un atleta tras una nueva competencia (avanzado).

--UpdateAtletaTelefono: Registra cambios en el teléfono de un atleta en una tabla de log (medio).


--InsertEntrenamientoConsistencia: Verifica que el entrenador exista antes de registrar un entrenamiento (avanzado).
DROP TRIGGER IF EXISTS InsertEntrenamientoConsistencia;
DELIMITER //
CREATE TRIGGER InsertEntrenamientoConsistencia
BEFORE INSERT ON Entrenamientos
FOR EACH ROW
BEGIN
    IF NOT EXISTS(SELECT 1 FROM Entrenadores e WHERE NEW.id_entrenador = e.id_entrenador) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'NO HAY ENTRENADOR CON DETERMINADO ID';
    END IF;
END//
DELIMITER ;