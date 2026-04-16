-- ============================================
-- Script SQL para crear la base de datos Cine
-- ============================================

-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS Cine;
USE Cine;

-- Eliminar tablas si existen (en orden correcto por FK)
DROP TABLE IF EXISTS Pelicula;
DROP TABLE IF EXISTS Director;

-- ============================================
-- Tabla Director
-- ============================================
CREATE TABLE Director (
    idDirector INT NOT NULL AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    anyoNacimiento INT NOT NULL,
    PRIMARY KEY (idDirector)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- Tabla Pelicula
-- ============================================
CREATE TABLE Pelicula (
    idPelicula INT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(255) NOT NULL,
    anyo INT NOT NULL,
    idDirector INT DEFAULT NULL,
    PRIMARY KEY (idPelicula),
    FOREIGN KEY (idDirector) REFERENCES Director(idDirector)
        ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ============================================
-- Datos de ejemplo: Directores
-- ============================================
INSERT INTO Director (nombre, anyoNacimiento) VALUES
('George Lucas', 1944),
('J.J. Abrams', 1966),
('Rian Johnson', 1973),
('Ron Howard', 1954),
('Gareth Edwards', 1975),
('Steven Spielberg', 1946),
('Christopher Nolan', 1970),
('Quentin Tarantino', 1963);

-- ============================================
-- Datos de ejemplo: Películas
-- ============================================
INSERT INTO Pelicula (titulo, anyo, idDirector) VALUES
('La Amenaza Fantasma', 1999, 1),
('El Ataque de los Clones', 2002, 1),
('La Venganza de los Sith', 2005, 1),
('Una Nueva Esperanza', 1977, 1),
('El Imperio Contraataca', 1980, 1),
('El Retorno del Jedi', 1983, 1),
('El Despertar de la Fuerza', 2015, 2),
('Los Últimos Jedi', 2017, 3),
('Rogue One', 2016, 5),
('Solo: A Star Wars Story', 2018, 4),
('El Ascenso de Skywalker', 2019, 2),
('Indiana Jones: Raiders of the Lost Ark', 1981, NULL),
('Indiana Jones: Temple of Doom', 1984, NULL),
('Jurassic Park', 1993, 6),
('E.T. El Extraterrestre', 1982, 6),
('Interstellar', 2014, 7),
('Inception', 2010, 7),
('The Dark Knight', 2008, 7),
('Pulp Fiction', 1994, 8),
('Kill Bill', 2003, 8);

-- ============================================
-- Verificar datos insertados
-- ============================================
SELECT 'Directores insertados:' AS Info;
SELECT * FROM Director;

SELECT 'Películas insertadas:' AS Info;
SELECT p.idPelicula, p.titulo, p.anyo, d.nombre AS director
FROM Pelicula p
LEFT JOIN Director d ON p.idDirector = d.idDirector;
