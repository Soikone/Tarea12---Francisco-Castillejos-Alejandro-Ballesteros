-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.15-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para bd_votaciones_fcr
CREATE DATABASE IF NOT EXISTS `bd_votaciones_fcr` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bd_votaciones_fcr`;

-- Volcando estructura para tabla bd_votaciones_fcr.backup_partido_politico
CREATE TABLE IF NOT EXISTS `backup_partido_politico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acronimo` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `logo` varchar(50) NOT NULL,
  `num_votos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_votaciones_fcr.backup_partido_politico: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `backup_partido_politico` DISABLE KEYS */;
INSERT INTO `backup_partido_politico` (`id`, `acronimo`, `nombre`, `logo`, `num_votos`) VALUES
	(6, 'PP', 'Partido Popular', 'pp.jpg', 0),
	(7, 'PSOE', 'Partido Socialista Obrero Español', 'psoe.jpg', 0),
	(8, 'PODEMOS', 'Podemos', 'podemos.jpg', 0),
	(9, 'C\'s', 'Ciudadanos', 'ciudadanos.jpg', 0),
	(10, 'IU', 'Izquierda Unida', 'iu.jpg', 0);
/*!40000 ALTER TABLE `backup_partido_politico` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votaciones_fcr.partido_politico
CREATE TABLE IF NOT EXISTS `partido_politico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `acronimo` varchar(10) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `logo` varchar(50) NOT NULL,
  `num_votos` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla bd_votaciones_fcr.partido_politico: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `partido_politico` DISABLE KEYS */;
INSERT INTO `partido_politico` (`id`, `acronimo`, `nombre`, `logo`, `num_votos`) VALUES
	(6, 'PP', 'Partido Popular', 'pp.jpg', 0),
	(7, 'PSOE', 'Partido Socialista Obrero Español', 'psoe.jpg', 0),
	(8, 'PODEMOS', 'Podemos', 'podemos.jpg', 0),
	(9, 'C\'s', 'Ciudadanos', 'ciudadanos.jpg', 0),
	(10, 'IU', 'Izquierda Unida', 'iu.jpg', 0);
/*!40000 ALTER TABLE `partido_politico` ENABLE KEYS */;

-- Volcando estructura para tabla bd_votaciones_fcr.votante
CREATE TABLE IF NOT EXISTS `votante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `pass` blob NOT NULL,
  `voto` varchar(2) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;


/*!40000 ALTER TABLE `votante` DISABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
