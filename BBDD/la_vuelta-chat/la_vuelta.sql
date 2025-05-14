-- Creación de la base de datos
DROP DATABASE IF EXISTS vuelta_ciclista;
CREATE DATABASE vuelta_ciclista;
USE vuelta_ciclista;

-- Tabla de equipos
CREATE TABLE equipos (
    id_equipo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    director VARCHAR(100),
    patrocinador_principal VARCHAR(100)
);

-- Tabla de ciclistas
CREATE TABLE ciclistas (
    id_ciclista INT AUTO_INCREMENT PRIMARY KEY,
    id_equipo INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    pais VARCHAR(50) NOT NULL,
    fecha_nacimiento DATE,
    especialidad ENUM('Esprínter', 'Rodador', 'Escalador', 'Gregario', 'Contrarrelojista'),
    FOREIGN KEY (id_equipo) REFERENCES equipos(id_equipo)
);

-- Tabla de etapas
CREATE TABLE etapas (
    id_etapa INT AUTO_INCREMENT PRIMARY KEY,
    numero INT NOT NULL,
    fecha DATE NOT NULL,
    inicio VARCHAR(100) NOT NULL,
    fin VARCHAR(100) NOT NULL,
    distancia DECIMAL(6,2) NOT NULL, -- en kilómetros
    tipo ENUM('Llana', 'Media montaña', 'Montaña', 'Contrarreloj individual', 'Contrarreloj por equipos'),
    descripcion TEXT
);

-- Tabla de puertos de montaña
CREATE TABLE puertos (
    id_puerto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    altura INT NOT NULL, -- en metros
    categoria ENUM('Especial', '1ª', '2ª', '3ª', 'HC'),
    pendiente_media DECIMAL(4,2), -- en porcentaje
    longitud DECIMAL(5,2), -- en kilómetros
    id_etapa INT NOT NULL,
    km_etapa DECIMAL(5,2) NOT NULL, -- kilómetro de la etapa donde se encuentra
    FOREIGN KEY (id_etapa) REFERENCES etapas(id_etapa)
);

-- Tabla de resultados de etapas
CREATE TABLE resultados_etapas (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    id_etapa INT NOT NULL,
    id_ciclista INT NOT NULL,
    posicion INT NOT NULL,
    tiempo TIME,
    puntos INT DEFAULT 0,
    FOREIGN KEY (id_etapa) REFERENCES etapas(id_etapa),
    FOREIGN KEY (id_ciclista) REFERENCES ciclistas(id_ciclista)
);

-- Tabla para registrar los primeros ciclistas en cada puerto
CREATE TABLE resultados_puertos (
    id_resultado INT AUTO_INCREMENT PRIMARY KEY,
    id_puerto INT NOT NULL,
    id_ciclista INT NOT NULL,
    posicion INT NOT NULL CHECK (posicion BETWEEN 1 AND 3),
    puntos_obtenidos INT NOT NULL,
    FOREIGN KEY (id_puerto) REFERENCES puertos(id_puerto),
    FOREIGN KEY (id_ciclista) REFERENCES ciclistas(id_ciclista)
);

-- Tabla de clasificación general
CREATE TABLE clasificacion_general (
    id_clasificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_ciclista INT NOT NULL,
    tiempo_total TIME,
    posicion INT NOT NULL,
    diferencia TIME,
    FOREIGN KEY (id_ciclista) REFERENCES ciclistas(id_ciclista)
);

-- Tabla de clasificación de la montaña
CREATE TABLE clasificacion_montana (
    id_clasificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_ciclista INT NOT NULL,
    puntos INT DEFAULT 0,
    posicion INT NOT NULL,
    FOREIGN KEY (id_ciclista) REFERENCES ciclistas(id_ciclista)
);

-- Tabla de clasificación por puntos
CREATE TABLE clasificacion_puntos (
    id_clasificacion INT AUTO_INCREMENT PRIMARY KEY,
    id_ciclista INT NOT NULL,
    puntos INT DEFAULT 0,
    posicion INT NOT NULL,
    FOREIGN KEY (id_ciclista) REFERENCES ciclistas(id_ciclista)
);

-- Insertar equipos
INSERT INTO equipos (nombre, pais, director, patrocinador_principal) VALUES
('Movistar Team', 'España', 'Eusebio Unzué', 'Telefónica'),
('Team Jumbo-Visma', 'Países Bajos', 'Richard Plugge', 'Jumbo'),
('INEOS Grenadiers', 'Reino Unido', 'Dave Brailsford', 'INEOS'),
('UAE Team Emirates', 'Emiratos Árabes', 'Mauro Gianetti', 'Emirates'),
('Quick-Step Alpha Vinyl', 'Bélgica', 'Patrick Lefevere', 'Quick-Step'),
('Bahrain Victorious', 'Baréin', 'Milan Eržen', 'Bahrain'),
('EF Education-EasyPost', 'EEUU', 'Jonathan Vaughters', 'EF Education'),
('Bora-Hansgrohe', 'Alemania', 'Ralph Denk', 'Bora'),
('Groupama-FDJ', 'Francia', 'Marc Madiot', 'Groupama'),
('Astana Qazaqstan', 'Kazajistán', 'Alexandr Vinokurov', 'Samruk-Kazyna');

-- Insertar ciclistas
INSERT INTO ciclistas (id_equipo, nombre, apellidos, pais, fecha_nacimiento, especialidad) VALUES
(1, 'Alejandro', 'Valverde', 'España', '1980-04-25', 'Rodador'),
(1, 'Enric', 'Mas', 'España', '1995-01-07', 'Escalador'),
(2, 'Primož', 'Roglič', 'Eslovenia', '1989-10-29', 'Escalador'),
(2, 'Jonas', 'Vingegaard', 'Dinamarca', '1996-12-10', 'Escalador'),
(3, 'Egan', 'Bernal', 'Colombia', '1997-01-13', 'Escalador'),
(3, 'Richard', 'Carapaz', 'Ecuador', '1993-05-29', 'Escalador'),
(4, 'Tadej', 'Pogačar', 'Eslovenia', '1998-09-21', 'Escalador'),
(4, 'João', 'Almeida', 'Portugal', '1998-08-05', 'Rodador'),
(5, 'Remco', 'Evenepoel', 'Bélgica', '2000-01-25', 'Contrarrelojista'),
(5, 'Julian', 'Alaphilippe', 'Francia', '1992-06-11', 'Rodador'),
(6, 'Mikel', 'Landá', 'España', '1989-12-13', 'Escalador'),
(6, 'Jack', 'Haig', 'Australia', '1993-09-06', 'Escalador'),
(7, 'Rigoberto', 'Urán', 'Colombia', '1987-01-26', 'Escalador'),
(7, 'Hugh', 'Carthy', 'Reino Unido', '1994-07-09', 'Escalador'),
(8, 'Jai', 'Hindley', 'Australia', '1996-05-04', 'Escalador'),
(8, 'Sergio', 'Higuita', 'Colombia', '1997-08-01', 'Escalador'),
(9, 'David', 'Gaudu', 'Francia', '1996-10-10', 'Escalador'),
(9, 'Thibaut', 'Pinot', 'Francia', '1990-05-29', 'Escalador'),
(10, 'Vincenzo', 'Nibali', 'Italia', '1984-11-14', 'Escalador'),
(10, 'Alexey', 'Lutsenko', 'Kazajistán', '1992-09-07', 'Rodador');

-- Insertar etapas
INSERT INTO etapas (numero, fecha, inicio, fin, distancia, tipo, descripcion) VALUES
(1, '2023-08-19', 'Barcelona', 'Barcelona', 14.5, 'Contrarreloj individual', 'Prólogo en la ciudad condal'),
(2, '2023-08-20', 'Barcelona', 'Tarragona', 185.6, 'Llana', 'Etapa para esprínteres'),
(3, '2023-08-21', 'Tarragona', 'Andorra', 215.3, 'Montaña', 'Primera llegada en alto'),
(4, '2023-08-22', 'Andorra', 'Zaragoza', 198.7, 'Media montaña', 'Etapa de transición'),
(5, '2023-08-23', 'Zaragoza', 'Soria', 168.4, 'Llana', 'Otra oportunidad para velocistas'),
(6, '2023-08-24', 'Soria', 'Burgos', 210.2, 'Media montaña', 'Final en cuesta'),
(7, '2023-08-25', 'Burgos', 'Santander', 185.0, 'Llana', 'Llegada al mar Cantábrico'),
(8, '2023-08-26', 'Santander', 'Oviedo', 155.7, 'Montaña', 'Etapa reina con 5 puertos'),
(9, '2023-08-27', 'Oviedo', 'León', 32.5, 'Contrarreloj individual', 'Crono decisiva'),
(10, '2023-08-28', 'León', 'Salamanca', 220.8, 'Llana', 'Día de descanso para los favoritos');

-- Insertar puertos de montaña
INSERT INTO puertos (nombre, altura, categoria, pendiente_media, longitud, id_etapa, km_etapa) VALUES
('Coll de la Gallina', 1925, 'HC', 8.5, 12.5, 3, 175.3),
('Port de Envalira', 2408, 'Especial', 6.2, 25.6, 3, 150.2),
('Alto del Naranco', 634, '2ª', 5.8, 7.5, 8, 140.7),
('Alto de la Manzaneda', 1780, '1ª', 7.9, 18.3, 8, 110.4),
('Puerto de Pajares', 1379, '1ª', 6.3, 15.8, 8, 85.2),
('Alto de Moncalvillo', 1225, '1ª', 9.2, 8.3, 6, 180.5),
('Alto de la Cruz de la Demanda', 1850, 'Especial', 7.1, 16.2, 8, 60.8);

-- Insertar resultados de etapas (ejemplo para la etapa 1)
INSERT INTO resultados_etapas (id_etapa, id_ciclista, posicion, tiempo, puntos) VALUES
(1, 9, 1, '00:17:25', 25),
(1, 7, 2, '00:17:38', 20),
(1, 3, 3, '00:17:42', 16),
(1, 5, 4, '00:17:45', 14),
(1, 15, 5, '00:17:49', 12),
(1, 11, 6, '00:17:52', 10),
(1, 1, 7, '00:17:55', 9),
(1, 13, 8, '00:17:58', 8),
(1, 17, 9, '00:18:01', 7),
(1, 19, 10, '00:18:04', 6);

-- Insertar datos para los primeros ciclistas en cada puerto
-- Los puntos varían según la categoría del puerto (HC y Especial: 10-6-4, 1ª: 5-3-2, 2ª: 3-2-1, 3ª: 1-0-0)

-- Puerto 1 (Coll de la Gallina - HC)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(1, 7, 1, 10),  -- Tadej Pogačar primero
(1, 3, 2, 6),   -- Primož Roglič segundo
(1, 5, 3, 4);   -- Egan Bernal tercero

-- Puerto 2 (Port de Envalira - Especial)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(2, 7, 1, 10),  -- Tadej Pogačar primero
(2, 3, 2, 6),   -- Primož Roglič segundo
(2, 1, 3, 4);   -- Alejandro Valverde tercero

-- Puerto 3 (Alto del Naranco - 2ª)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(3, 11, 1, 3),  -- Mikel Landa primero
(3, 7, 2, 2),   -- Tadej Pogačar segundo
(3, 5, 3, 1);   -- Egan Bernal tercero

-- Puerto 4 (Alto de la Manzaneda - 1ª)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(4, 3, 1, 5),   -- Primož Roglič primero
(4, 7, 2, 3),   -- Tadej Pogačar segundo
(4, 17, 3, 2);  -- David Gaudu tercero

-- Puerto 5 (Puerto de Pajares - 1ª)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(5, 7, 1, 5),   -- Tadej Pogačar primero
(5, 3, 2, 3),   -- Primož Roglič segundo
(5, 11, 3, 2);  -- Mikel Landa tercero

-- Puerto 6 (Alto de Moncalvillo - 1ª)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(6, 1, 1, 5),   -- Alejandro Valverde primero
(6, 19, 2, 3),  -- Vincenzo Nibali segundo
(6, 13, 3, 2);  -- Rigoberto Urán tercero

-- Puerto 7 (Alto de la Cruz de la Demanda - Especial)
INSERT INTO resultados_puertos (id_puerto, id_ciclista, posicion, puntos_obtenidos) VALUES
(7, 7, 1, 10),  -- Tadej Pogačar primero
(7, 3, 2, 6),   -- Primož Roglič segundo
(7, 5, 3, 4);   -- Egan Bernal tercero

-- Insertar clasificación general (después de la etapa 1)
INSERT INTO clasificacion_general (id_ciclista, tiempo_total, posicion, diferencia) VALUES
(9, '00:17:25', 1, '00:00:00'),
(7, '00:17:38', 2, '00:00:13'),
(3, '00:17:42', 3, '00:00:17'),
(5, '00:17:45', 4, '00:00:20'),
(15, '00:17:49', 5, '00:00:24'),
(11, '00:17:52', 6, '00:00:27'),
(1, '00:17:55', 7, '00:00:30'),
(13, '00:17:58', 8, '00:00:33'),
(17, '00:18:01', 9, '00:00:36'),
(19, '00:18:04', 10, '00:00:39');

-- Insertar clasificación de la montaña (ejemplo después de etapa 3)
INSERT INTO clasificacion_montana (id_ciclista, puntos, posicion) VALUES
(7, 25, 1),
(3, 20, 2),
(5, 18, 3),
(11, 15, 4),
(1, 12, 5);

-- Insertar clasificación por puntos (ejemplo después de etapa 2)
INSERT INTO clasificacion_puntos (id_ciclista, puntos, posicion) VALUES
(9, 50, 1),
(7, 45, 2),
(3, 36, 3),
(5, 34, 4),
(15, 30, 5);



Función para calcular la edad de un ciclista
DROP FUNCTION IF EXISTS calcularEdadCiclista;
DELIMITER //
CREATE FUNCTION calcularEdadCiclista(idCiclista INT)
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE edad INT;

    SELECT DATEDIFF(CURDATE(), fecha_nacimiento)/365 INTO edad 
    FROM ciclistas 
    WHERE id_ciclista = idCiclista;
    
    RETURN edad;
END//
DELIMITER ;

SELECT *, calcularEdadCiclista(1) FROM ciclistas WHERE id_ciclista = 1;

Función para obtener el líder de una clasificación específica
-- DROP FUNCTION IF EXISTS obtenerLider;
-- DELIMITER //
-- CREATE FUNCTION obtenerLider(clasificacion ENUM('general', 'montana', 'puntos'))
-- RETURNS TEXT
-- READS SQL DATA
-- DETERMINISTIC
-- BEGIN
--     DECLARE datosCiclista TEXT;

--     IF (clasificacion = 'montana') THEN
--         SELECT CONCAT(ciclistas.nombre, ' ', ciclistas.apellidos, ' ', ciclistas.pais, ' ', ciclistas.fecha_nacimiento, ' ', ciclistas.especialidad)
--         INTO datosCiclista
--         FROM ciclistas
--         INNER JOIN clasificacion_montana
--         ON clasificacion_montana.id_ciclista = ciclistas.id_ciclista
--         ORDER BY clasificacion_montana.posicion
--         LIMIT 1;
--     ELSEIF (clasificacion = 'puntos') THEN
--         SELECT CONCAT(ciclistas.nombre, ' ', ciclistas.apellidos, ' ', ciclistas.pais, ' ', ciclistas.fecha_nacimiento, ' ', ciclistas.especialidad)
--         INTO datosCiclista
--         FROM ciclistas
--         INNER JOIN clasificacion_puntos
--         ON clasificacion_puntos.id_ciclista = ciclistas.id_ciclista
--         ORDER BY clasificacion_puntos.posicion
--         LIMIT 1;
--     ELSE
--         SELECT CONCAT(ciclistas.nombre, ' ', ciclistas.apellidos, ' ', ciclistas.pais, ' ', ciclistas.fecha_nacimiento, ' ', ciclistas.especialidad)
--         INTO datosCiclista
--         FROM ciclistas
--         INNER JOIN clasificacion_general
--         ON clasificacion_general.id_ciclista = ciclistas.id_ciclista
--         ORDER BY clasificacion_general.posicion
--         LIMIT 1;
--     END IF;

--     RETURN datosCiclista;
-- END//
-- DELIMITER ;

-- SELECT obtenerLider('general') AS 'Lider';

-- SELECT *
-- FROM ciclistas
-- INNER JOIN clasificacion_general
-- ORDER BY clasificacion_general.posicion DESC
-- LIMIT 1;

Función para calcular la velocidad media de un ciclista en una etapa
DROP FUNCTION IF EXISTS calcularVelocidadCiclista;
DELIMITER //
CREATE FUNCTION calcularVelocidadCiclista(idCiclista INT, idEtapa INT)
RETURNS DECIMAL(10, 2)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE varDistancia DECIMAL(10, 2);
    DECLARE varTiempo DECIMAL(10, 2);
    
    SELECT distancia INTO varDistancia 
    FROM etapas 
    WHERE id_etapa = idEtapa;
    
    SELECT MINUTE(tiempo)/60 INTO varTiempo 
    FROM resultados_etapas 
    WHERE id_ciclista = idCiclista;
    
    RETURN varDistancia/varTiempo;
END//
DELIMITER ;

SELECT calcularVelocidadCiclista(7, 1) AS 'velocidad media';

Función para obtener la categoría más común de los puertos ganados por un ciclista
DROP FUNCTION IF EXISTS categoriasPuertosGanados;
DELIMITER //
CREATE FUNCTION categoriasPuertosGanados()
RETURNS VARCHAR(15)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE v_categoria VARCHAR(15) DEFAULT '';

    SELECT categoria INTO v_categoria FROM puertos GROUP BY categoria ORDER BY COUNT(categoria) DESC LIMIT 1;

    RETURN v_categoria;
END//
DELIMITER ;

SELECT categoriasPuertosGanados();

Función para calcular la diferencia de tiempo entre dos ciclistas
DROP FUNCTION IF EXISTS calcularDiferenciaCIclistas;
DELIMITER //
CREATE FUNCTION calcularDiferenciaCiclistas(id_ciclista_1 INT, id_ciclista_2 INT, id_etapa INT)
RETURNS TIME
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE diferenciaTiempo TIME;

    SELECT TIMEDIFF(re.tiempo, re2.tiempo) INTO diferenciaTiempo
    FROM resultados_etapas re, resultados_etapas re2 
    WHERE re.id_ciclista = id_ciclista_1 AND re2.id_ciclista = id_ciclista_2 AND re.id_etapa = re2.id_etapa = id_etapa; 

    IF diferenciaTiempo IS NULL THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Algun dato no esta correcto';
    END IF;

    RETURN diferenciaTiempo;
END//
DELIMITER ;

SELECT calcularDiferenciaCiclistas(9, 7, 1);

Función para contar las veces que un ciclista ha estado en el podio de una etapa
DROP FUNCTION IF EXISTS podioEtapaCiclista;
DELIMITER //
CREATE FUNCTION podioEtapaCiclista(var_id_ciclista INT)
RETURNS INT
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE podiosPorEtapa INT DEFAULT -1;

    IF EXISTS(SELECT COUNT(id_ciclista) FROM resultados_etapas WHERE id_ciclista = var_id_ciclista) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'INTRODUCE UN CICILSTA VALIDO';
    END IF;

    SELECT COUNT(posicion) INTO podiosPorEtapa 
    FROM resultados_etapas 
    WHERE id_ciclista = var_id_ciclista AND posicion <= 3;


    RETURN podiosPorEtapa;
END//
DELIMITER ;

SELECT podioEtapaCiclista(9);

Función para obtener el equipo con más victorias de etapa
DROP FUNCTION IF EXISTS equipoMasVictorias;
DELIMITER //
CREATE FUNCTION equipoMasVictorias()
RETURNS VARCHAR(50)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE nombreEquipo VARCHAR(50);

    SELECT equipos.nombre INTO nombreEquipo FROM equipos 
    INNER JOIN ciclistas 
    INNER JOIN resultados_etapas 
        ON ciclistas.id_equipo = equipos.id_equipo AND resultados_etapas.id_ciclista = ciclistas.id_ciclista
    ORDER BY puntos DESC
    LIMIT 1;
    
    RETURN nombreEquipo;
END//
DELIMITER ;

SELECT equipoMasVictorias();

Función para calcular el porcentaje de puertos ganados por un ciclista
DROP FUNCTION IF EXISTS puertosGanadosCiclista;
DELIMITER //
CREATE FUNCTION puertosGanadosCiclista(v_id_ciclista INT)
RETURNS DECIMAL(10, 2)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE v_puertos INT DEFAULT 0;
    DECLARE v_puertos_ganados_ciclista INT DEFAULT 0;
    DECLARE resultado INT DEFAULT 0;

    IF NOT EXISTS(SELECT 1 FROM ciclistas WHERE v_id_ciclista = id_ciclista) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'NO EXISTE EL CICLISTA CON ESE ID';
    END IF;

    SELECT COUNT(resultados_puertos.posicion) INTO v_puertos FROM resultados_puertos;

    SELECT COUNT(rp.posicion) INTO v_puertos_ganados_ciclista 
    FROM resultados_puertos rp 
    INNER JOIN ciclistas c 
        ON rp.id_ciclista = c.id_ciclista
    WHERE c.id_ciclista = v_id_ciclista AND rp.posicion = 1;

    SET resultado = ((v_puertos_ganados_ciclista*100) / v_puertos );

    RETURN resultado;
END//
DELIMITER ;

SELECT puertosGanadosCiclista(7);

Función para determinar el tipo de etapa favorita de un ciclista


Función para calcular la distancia total recorrida por un ciclista en la vuelta
DROP FUNCTION IF EXISTS distanciaTotal;
DELIMITER //
CREATE FUNCTION distanciaTotal(v_id_ciclista INT)
RETURNS DECIMAL(10,2)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE v_km_totales DECIMAL(10, 2) DEFAULT 0.00;

    IF NOT EXISTS(SELECT 1 FROM ciclistas WHERE id_ciclista = v_id_ciclista) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Id no válido';
    END IF;

    SELECT SUM(e.distancia + p.longitud) INTO v_km_totales
    FROM ciclistas c 
    INNER JOIN resultados_etapas re 
    INNER JOIN resultados_puertos rp 
    INNER JOIN etapas e
    INNER JOIN puertos p
        ON v_id_ciclista = c.id_ciclista = re.id_ciclista = rp.id_ciclista AND re.id_etapa = e.id_etapa AND rp.id_puerto = p.id_puerto
    WHERE c.id_ciclista = v_id_ciclista;
    
    RETURN v_km_totales;
END//
DELIMITER ;

SELECT distanciaTotal(1);

PROCEDURES
Procedimiento para insertar un nuevo ciclista
DROP PROCEDURE IF EXISTS insertarCiclista;
DELIMITER //
CREATE PROCEDURE insertarCiclista(
    IN v_id_equipo INT,
    IN v_nombre VARCHAR(30),
    IN v_apellidos VARCHAR(30),
    IN v_pais VARCHAR(30),
    IN v_fecha_nacimiento DATE,
    IN v_especialidad ENUM('Esprínter', 'Rodador', 'Escalador', 'Gregario', 'Contrarrelojista')
)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM equipos WHERE id_equipo = v_id_equipo) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ID de equipo no válido';
    END IF;

    INSERT INTO ciclistas(id_equipo, nombre, apellidos, pais, fecha_nacimiento, especialidad) 
    VALUES (v_id_equipo, v_nombre, v_apellidos, v_pais, v_fecha_nacimiento, v_especialidad);

    SELECT * FROM ciclistas ORDER BY id_ciclista DESC LIMIT 1;
END//
DELIMITER ;

CALL insertarCiclista(1, 'n', 'S', 'A', '1899-10-20', 'Esprinter');

Procedimiento para actualizar el tiempo de un ciclista en una etapa
DROP PROCEDURE IF EXISTS actualizarTiempoCiclista;
DELIMITER //
CREATE PROCEDURE actualizarTiempoCiclista(IN v_id_ciclista INT, IN v_tiempo TIME)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM ciclistas WHERE id_ciclista = v_id_ciclista) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ID DE USUARIO INCORRECTO';
    END IF;

    UPDATE resultados_etapas
    SET tiempo = v_tiempo
    WHERE id_ciclista = v_id_ciclista;
END//
DELIMITER ;

CALL actualizarTiempoCiclista(9, '00:17:25');

Procedimiento para obtener los ciclistas de un equipo
DROP PROCEDURE IF EXISTS ciclistasEquipo;
DELIMITER //
CREATE PROCEDURE ciclistasEquipo(IN v_id_equipo INT)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM equipos WHERE id_equipo = v_id_equipo) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ID DE EQUIPO INCORRECTO';
    END IF;

    SELECT * FROM ciclistas WHERE id_equipo = v_id_equipo;
END//
DELIMITER ;

CALL ciclistasEquipo(1);

Procedimiento para registrar los primeros en un puerto
DROP PROCEDURE IF EXISTS primerosPuerto;
DELIMITER //
CREATE PROCEDURE primerosPuerto(IN v_id_puerto INT)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM resultados_puertos WHERE id_puerto = v_id_puerto) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ID NO VÁLIDO';
    END IF;

    SELECT * FROM resultados_puertos WHERE posicion = 1 AND id_puerto = v_id_puerto;
END//
DELIMITER ;

CALL primerosPuerto(1);

Procedimiento para obtener el podio de una etapa
DROP PROCEDURE IF EXISTS podioEtapa;
DELIMITER //
CREATE PROCEDURE podioEtapa(IN v_id_etapa INT)
BEGIN
    IF NOT EXISTS(SELECT 1 FROM resultados_etapas WHERE v_id_etapa = id_etapa) THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'ID DE ETAPA NO VÁLIDO';
    END IF;

    SELECT * FROM resultados_etapas WHERE id_etapa = v_id_etapa AND posicion BETWEEN 1 AND 3;
END//
DELIMITER ;

CALL podioEtapa(2);

PROCEDURES CON CURSOR
Listar ciclistas con su equipo y especialidad
DROP PROCEDURE IF EXISTS ciclistasEquipoEspecialidad;
DELIMITER //
CREATE PROCEDURE ciclistasEquipoEspecialidad()
BEGIN
    DECLARE v_ciclista_nombre VARCHAR(30);
    DECLARE v_cilista_apellidos VARCHAR(30);
    DECLARE v_nombre_equipo VARCHAR(30);
    DECLARE v_especialidad VARCHAR(30);
    DECLARE done INT DEFAULT FALSE;


    DECLARE ciclista_cursor CURSOR FOR
        SELECT c.nombre, c.apellidos, e.nombre, c.especialidad
        FROM ciclistas c
        INNER JOIN equipos e 
            ON e.id_equipo = c.id_equipo
        ORDER BY e.nombre;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

    DROP TABLE IF EXISTS resultadosTemp;
    CREATE TABLE resultadosTemp(
        t_nombre_apellidos VARCHAR(60),
        t_nombre_equipo VARCHAR(60),
        t_especialidad VARCHAR(30)
    );

    OPEN ciclista_cursor;
    
    read_loop: LOOP
        FETCH ciclista_cursor INTO v_ciclista_nombre, v_cilista_apellidos, v_nombre_equipo, v_especialidad;

        IF done THEN
            LEAVE read_loop;
        END IF;

        INSERT INTO resultadosTemp (t_nombre_apellidos, t_nombre_equipo, t_especialidad) VALUES
        (CONCAT(v_ciclista_nombre, ' ', v_cilista_apellidos), v_nombre_equipo, v_especialidad);
    END LOOP;
    
    CLOSE ciclista_cursor;
    SELECT * FROM resultadosTemp;
    DROP TABLE resultadosTemp;
END//
DELIMITER ;

CALL ciclistasEquipoEspecialidad();


Mostrar podios de todas las etapas
DROP PROCEDURE IF EXISTS podiosEtapas;
DELIMITER //
CREATE PROCEDURE podiosEtapas()
BEGIN
    DECLARE v_nombre_ciclista VARCHAR(30);
    DECLARE v_apellido_cilista VARCHAR(30);
    DECLARE v_posicion INT;
    DECLARE v_etapa INT;
    DECLARE done INT DEFAULT FALSE;

    DECLARE cursor_podios CURSOR FOR
        SELECT c.nombre, c.apellidos, re.posicion, re.id_etapa FROM ciclistas c
        INNER JOIN resultados_etapas re ON re.id_ciclista = c.id_ciclista
        WHERE Posicion < 4
        ORDER BY re.posicion;
        
        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

        DROP TABLE IF EXISTS resultadosPodios;
        CREATE TABLE resultadosPodios(
            t_nombre_completo VARCHAR(60),
            t_posicion INT,
            t_etapa INT
        );

        OPEN cursor_podios;

        read_loop : LOOP
            FETCH cursor_podios INTO v_nombre_ciclista, v_apellido_cilista, v_posicion, v_etapa;

            IF done THEN
                LEAVE read_loop;
            END IF;

            INSERT INTO resultadosPodios(t_nombre_completo, t_posicion, t_etapa) 
            VALUES (CONCAT(v_nombre_ciclista, ' ', v_apellido_cilista), v_posicion, v_etapa);
        END LOOP;
    CLOSE cursor_podios;

    SELECT * FROM resultadosPodios;
    DROP TABLE resultadosPodios;
END//
DELIMITER ;

CALL podiosEtapas();

Contar ciclistas por país
DROP PROCEDURE IF EXISTS contarCiclistasPais;
DELIMITER //
CREATE PROCEDURE contarCiclistasPais()
BEGIN
    DECLARE v_num_ciclistas INT DEFAULT 0;
    DECLARE v_pais VARCHAR(60);
    DECLARE done INT DEFAULT FALSE;

    DECLARE cursor_paises CURSOR FOR
        SELECT COUNT(nombre), pais FROM ciclistas GROUP BY pais;

        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

        DROP TABLE IF EXISTS paisesCiclistas;
        CREATE TABLE paisesCiclistas(
            t_numero INT DEFAULT 0,
            t_pais VARCHAR(60)
        );

        OPEN cursor_paises;

        read_loop: LOOP
            FETCH cursor_paises INTO v_num_ciclistas, v_pais;

            IF done THEN
                LEAVE read_loop;
            END IF;

            INSERT INTO paisesCiclistas(t_numero, t_pais) VALUES (v_num_ciclistas, v_pais);
        END LOOP;
    CLOSE cursor_paises;

    SELECT * FROM paisesCiclistas;
    DROP TABLE paisesCiclistas;
END//
DELIMITER ;

CALL contarCiclistasPais();

Mostrar puertos de montaña por etapa
DROP PROCEDURE IF EXISTS puertosPorEtapa;
DELIMITER //
CREATE PROCEDURE puertosPorEtapa()
BEGIN
    DECLARE v_id_etapa INT;
    DECLARE v_numero INT;
    DECLARE v_fecha DATE;
    DECLARE v_inicio VARCHAR(60);
    DECLARE v_fin VARCHAR(60);
    DECLARE v_distancia DECIMAL(6,2);
    DECLARE v_tipo VARCHAR(30);
    DECLARE v_descripcion VARCHAR(150);
    DECLARE done INT DEFAULT FALSE;

    DECLARE cursor_etapa CURSOR FOR
        SELECT id_etapa, numero, fecha, inicio, fin, distancia, tipo, descripcion FROM etapas;

        DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;

        DROP TABLE IF EXISTS tablaEtapa;
        CREATE TABLE tablaEtapa(
            t_id_etapa INT,
            t_numero INT,
            t_fecha DATE,
            t_inicio VARCHAR(60),
            t_fin VARCHAR(60),
            t_distancia DECIMAL(6,2),
            t_tipo VARCHAR(30),
            t_descripcion VARCHAR(150)
        );

        OPEN cursor_etapa;

        read_loop: LOOP
            FETCH cursor_etapa INTO v_id_etapa, v_numero, v_fecha, v_inicio, v_fin, v_distancia, v_tipo, v_descripcion;

            IF done THEN
                LEAVE read_loop;
            END IF;

            INSERT INTO tablaEtapa(t_id_etapa, t_numero, t_fecha, t_inicio, t_fin, t_distancia, t_tipo, t_descripcion)
            VALUES (v_id_etapa, v_numero, v_fecha, v_inicio, v_fin, v_distancia, v_tipo, v_descripcion);
        END LOOP;
    CLOSE cursor_etapa;

    SELECT * FROM tablaEtapa WHERE t_tipo LIKE '%ontaña%';
    DROP TABLE tablaEtapa;

END//
DELIMITER ;

CALL puertosPorEtapa();

Calcular puntos de equipo en la clasificación general


TRIGGERS
Trigger para actualizar clasificación general al insertar resultados
DROP TRIGGER IF EXISTS actualizarClasificacionGeneral;
DELIMITER //
CREATE TRIGGER actualizarClasificacionGeneral
AFTER UPDATE ON resultados_etapas
FOR EACH ROW
BEGIN
    INSERT INTO clasificacion_general (id_clasificacion, id_ciclista, tiempo_total, posicion, diferencia) VALUES (id_resultado, id_ciclista, )
END//
DELIMITER ;

Trigger para actualizar puntos de montaña


Trigger para validar edad del ciclista(EDAD MINIMA 18 AÑOS)
DROP TRIGGER IF EXISTS validadEdadCiclista;
DELIMITER //
CREATE TRIGGER validadEdadCiclista
BEFORE INSERT ON ciclistas
FOR EACH ROW
BEGIN
    IF TIMESTAMPDIFF(YEAR, CURDATE(), NEW.fecha_nacimiento) < 18 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'EL CICLISTA ES MENOR DE EDAD';
    END IF;
END//
DELIMITER ;

Trigger para actualizar clasificación por puntos


Trigger para registrar cambios en equipos(cambio de nombre o patrocinador)


Trigger para evitar eliminación de etapas con resultados


Trigger para actualizar posiciones en clasificación general


Trigger para validar distancia de etapa(MINIMA 10KM, MAXIMA 300KM)


Trigger para actualizar estadísticas de equipo(Actualizar contador de ciclistas en el equipo)


Trigger para registrar abandono de ciclista ANTES DE ELIMINARLO

