-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 29-05-2014 a las 22:55:01
-- Versión del servidor: 5.6.15
-- Versión de PHP: 5.4.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `memoagenda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `amigos`
--

CREATE TABLE IF NOT EXISTS `amigos` (
  `id_usuario` int(11) NOT NULL,
  `id_amigo` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id_usuario`,`id_amigo`),
  KEY `id_amigo` (`id_amigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos`
--

CREATE TABLE IF NOT EXISTS `eventos` (
  `id_evento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE utf8_unicode_ci NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_final` date NOT NULL,
  `hora_inicio` text COLLATE utf8_unicode_ci NOT NULL,
  `hora_final` text COLLATE utf8_unicode_ci NOT NULL,
  `ubicacion` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_evento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos_grupos`
--

CREATE TABLE IF NOT EXISTS `eventos_grupos` (
  `id_evento` int(11) NOT NULL,
  `id_integrante` int(11) NOT NULL,
  PRIMARY KEY (`id_evento`,`id_integrante`),
  KEY `id_integrante` (`id_integrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `eventos_integrantes`
--

CREATE TABLE IF NOT EXISTS `eventos_integrantes` (
  `id_grupo` int(11) NOT NULL,
  `id_integrante` int(11) NOT NULL,
  PRIMARY KEY (`id_grupo`,`id_integrante`),
  KEY `id_integrante` (`id_integrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `grupos`
--

CREATE TABLE IF NOT EXISTS `grupos` (
  `id_grupo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE utf8_unicode_ci NOT NULL,
  `id_creador` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id_grupo`),
  KEY `id_creador` (`id_creador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `integrantes`
--

CREATE TABLE IF NOT EXISTS `integrantes` (
  `id_grupo` int(11) NOT NULL,
  `id_integrante` int(11) NOT NULL,
  PRIMARY KEY (`id_grupo`,`id_integrante`),
  KEY `id_integrante` (`id_integrante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `listas_tareas`
--

CREATE TABLE IF NOT EXISTS `listas_tareas` (
  `id_lista` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE utf8_unicode_ci NOT NULL,
  `fecha_limite` date NOT NULL,
  `fecha_inicio` date NOT NULL,
  `hora_inicio` text COLLATE utf8_unicode_ci NOT NULL,
  `hora_limite` text COLLATE utf8_unicode_ci NOT NULL,
  `id_creador` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id_lista`),
  KEY `id_creador` (`id_creador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lista_archivos`
--

CREATE TABLE IF NOT EXISTS `lista_archivos` (
  `id_archivo` int(11) NOT NULL AUTO_INCREMENT,
  `id_lista` int(11) NOT NULL,
  `nombre_archivo` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_archivo`),
  KEY `id_lista` (`id_lista`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notificaciones`
--

CREATE TABLE IF NOT EXISTS `notificaciones` (
  `id_emisor` int(11) NOT NULL,
  `id_receptor` int(11) NOT NULL,
  `tipo` int(2) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id_emisor`,`id_receptor`),
  KEY `id_emisor` (`id_emisor`),
  KEY `id_receptor` (`id_receptor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tareas`
--

CREATE TABLE IF NOT EXISTS `tareas` (
  `id_tarea` int(11) NOT NULL AUTO_INCREMENT,
  `id_lista` int(11) NOT NULL,
  `nombre` text COLLATE utf8_unicode_ci NOT NULL,
  `descripcion` longtext COLLATE utf8_unicode_ci NOT NULL,
  `id_responsable` int(11) NOT NULL,
  `status` int(1) NOT NULL,
  PRIMARY KEY (`id_tarea`),
  KEY `id_lista` (`id_lista`),
  KEY `id_responsable` (`id_responsable`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE IF NOT EXISTS `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` text COLLATE utf8_unicode_ci NOT NULL,
  `alias` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `correo` text COLLATE utf8_unicode_ci NOT NULL,
  `contrasena` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `foto` text COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=1 ;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `amigos`
--
ALTER TABLE `amigos`
  ADD CONSTRAINT `amigos_ibfk_2` FOREIGN KEY (`id_amigo`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `amigos_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `eventos_grupos`
--
ALTER TABLE `eventos_grupos`
  ADD CONSTRAINT `eventos_grupos_ibfk_2` FOREIGN KEY (`id_integrante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `eventos_grupos_ibfk_1` FOREIGN KEY (`id_evento`) REFERENCES `eventos` (`id_evento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `eventos_integrantes`
--
ALTER TABLE `eventos_integrantes`
  ADD CONSTRAINT `eventos_integrantes_ibfk_2` FOREIGN KEY (`id_integrante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `eventos_integrantes_ibfk_1` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id_grupo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `grupos`
--
ALTER TABLE `grupos`
  ADD CONSTRAINT `grupos_ibfk_1` FOREIGN KEY (`id_creador`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `integrantes`
--
ALTER TABLE `integrantes`
  ADD CONSTRAINT `integrantes_ibfk_2` FOREIGN KEY (`id_integrante`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `integrantes_ibfk_1` FOREIGN KEY (`id_grupo`) REFERENCES `grupos` (`id_grupo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `listas_tareas`
--
ALTER TABLE `listas_tareas`
  ADD CONSTRAINT `listas_tareas_ibfk_1` FOREIGN KEY (`id_creador`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `lista_archivos`
--
ALTER TABLE `lista_archivos`
  ADD CONSTRAINT `lista_archivos_ibfk_1` FOREIGN KEY (`id_lista`) REFERENCES `listas_tareas` (`id_lista`);

--
-- Filtros para la tabla `notificaciones`
--
ALTER TABLE `notificaciones`
  ADD CONSTRAINT `notificaciones_ibfk_2` FOREIGN KEY (`id_receptor`) REFERENCES `usuarios` (`id_usuario`),
  ADD CONSTRAINT `notificaciones_ibfk_1` FOREIGN KEY (`id_emisor`) REFERENCES `usuarios` (`id_usuario`);

--
-- Filtros para la tabla `tareas`
--
ALTER TABLE `tareas`
  ADD CONSTRAINT `tareas_ibfk_2` FOREIGN KEY (`id_responsable`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tareas_ibfk_1` FOREIGN KEY (`id_lista`) REFERENCES `listas_tareas` (`id_lista`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
