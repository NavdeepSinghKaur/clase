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
(1, 1, '2025-05-05', 'Sprint', 30);

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

CALL InsertarAtleta('a', 'b', 12-12-2000, 'a@a.com', 333333333);

--ActualizarTelefonoAtleta: Actualiza el teléfono de un atleta (básico).

--RegistrarEntrenamiento: Registra un nuevo entrenamiento (medio).

--EliminarEntrenamientosAntiguos: Elimina entrenamientos anteriores a una fecha (medio).

--TransferirEntrenador: Cambia el entrenador de los entrenamientos futuros de un atleta (avanzado).

--RegistrarResultadoCompetencia: Registra un resultado de competencia (básico).

--ActualizarEspecialidadEntrenador: Actualiza la especialidad de un entrenador (medio).

--ReporteEntrenamientosAtleta: Genera un reporte de entrenamientos de un atleta (avanzado).

--ListarAtletasPorGenero: Lista atletas por género (medio).

--ActualizarResultadosCompetencia: Ajusta los resultados de una competencia por un factor (avanzado).


--Triggers


--InsertAtleta: Valida el formato del email antes de insertar un atleta (básico).

--InsertEntrenamiento: Establece la fecha actual si no se proporciona en un entrenamiento (básico).

--InsertEntrenamientoDuracion: Verifica que la duración del entrenamiento esté entre 0 y 240 minutos (medio).

--InsertEntrenador: Inicializa los años de experiencia a 0 si no se especifican (medio).

--UpdateCompetencia: Registra cambios en los resultados de competencias en una tabla de log (avanzado).

--DeleteAtleta: Impide eliminar atletas con entrenamientos registrados (básico).

--InsertCompetencia: Prohíbe registrar competencias futuras (medio).

--InsertCompetencia: Actualiza el promedio de resultados de un atleta tras una nueva competencia (avanzado).

--UpdateAtletaTelefono: Registra cambios en el teléfono de un atleta en una tabla de log (medio).

--InsertEntrenamientoConsistencia: Verifica que el entrenador exista antes de registrar un entrenamiento (avanzado).