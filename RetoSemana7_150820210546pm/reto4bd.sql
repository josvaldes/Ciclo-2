-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-08-2021 a las 18:09:21
-- Versión del servidor: 10.4.20-MariaDB
-- Versión de PHP: 8.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `reto4bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_categoria`
--

CREATE TABLE `tb_categoria` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Descripcion` varchar(100) NOT NULL,
  `idProductos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_categoria`
--

INSERT INTO `tb_categoria` (`Id`, `Nombre`, `Descripcion`, `idProductos`) VALUES
(1, 'Trigo', 'Productos a base de trigo', 6),
(2, 'Trigo', 'Productos a base de trigo', 2),
(3, 'Lacteos', 'Productos a base de leche', 3),
(4, 'Huevos', 'Productos de animales oviparos', 4),
(5, 'Carne', 'Productos de carne de animales', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_clientes`
--

CREATE TABLE `tb_clientes` (
  `Id` int(11) NOT NULL,
  `DocumentoIdentidad` varchar(20) NOT NULL,
  `Nombres` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Telefono2` varchar(20) DEFAULT NULL,
  `CorreoElectronico` varchar(20) NOT NULL,
  `idDireccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_clientes`
--

INSERT INTO `tb_clientes` (`Id`, `DocumentoIdentidad`, `Nombres`, `Apellidos`, `Telefono`, `Telefono2`, `CorreoElectronico`, `idDireccion`) VALUES
(1, '1083432789', 'Carlos Mario', 'Gonzales Pereira', '3152341045', '3112431125', 'carlos.gonzales@hotm', 1),
(2, '1100921345', 'Maria Jose', 'Camargo Zuñiga', '3124231234', '3213286749', 'mcamargo@outlook.com', 2),
(3, '85214269', 'Luis Carlos', 'Bustamante Castro', '3162561289', '3221114589', 'luisk@gmail.com', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_direcciones`
--

CREATE TABLE `tb_direcciones` (
  `Id` int(11) NOT NULL,
  `CalleCarrera` varchar(20) NOT NULL,
  `Numero` varchar(20) NOT NULL,
  `Barrio` varchar(20) NOT NULL,
  `Ciudad` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_direcciones`
--

INSERT INTO `tb_direcciones` (`Id`, `CalleCarrera`, `Numero`, `Barrio`, `Ciudad`) VALUES
(1, 'Calle 4 Carrera 2', '23', 'San Antonio', 'Buenaventura'),
(2, 'Calle 54 Carrera 22', '39', 'Antonio Nariño', 'Bogota'),
(3, 'Calle 23 Carrera 12', '13', 'Coralino', 'Manizales'),
(4, 'Calle 2 Carrera 15', '34', 'Andra Carolina', 'Barranquilla'),
(5, 'Calle 9 Carrera 8', '23', 'Centro', 'Ibague'),
(6, 'dasd', 'asdas', 'dsad', 'sada'),
(7, '4 5', '6', 'centro', 'santa marta'),
(8, 'Calle 23 Carrera 135', '345', 'Teusaquillo', 'Bogota'),
(9, '34 56', '234', 'sdadas', 'dasdsa'),
(10, 'Calle 23 Carrera 35', '34', 'la chinita', 'Barranquilla'),
(11, '', '', '', ''),
(12, 'Calle 15 Carrera 65', '134', 'Alcazares', 'Medellin'),
(13, 'fsdfds', 'dsfsdf', 'dsfds', 'dsfds'),
(14, 'Calle 23 Carrera 2', '45', 'La Cordialidad', 'Manizales'),
(15, 'dasd', 'dsad', 'sad', 'sadsa'),
(16, 'fsdf', 'fsdf', 'fsdf', 'dfsdf'),
(17, 'fdsf', 'dsfsd', 'sdf', 'sf'),
(18, 'Calle 34 Carrera 23', '12', 'San Vicente', 'Dos Quebrada'),
(19, 'Calle 23 Carrera 12', '34', 'Centro', 'Cucuta'),
(20, 'fsdfd', 'sdf', 'dfs', 'fdsf'),
(21, 'dasdsa', 'dasd', 'dasd', 'dasd'),
(22, 'Calle 34 Carrera 52', '32', 'Pando', 'Cienaga'),
(23, '', '', '', ''),
(24, '', '', '', ''),
(25, '', '', '', ''),
(26, '', '', '', ''),
(27, '', '', '', ''),
(28, '', '', '', ''),
(29, '', '', '', ''),
(30, '', '', '', ''),
(31, '', '', '', ''),
(32, '', '', '', ''),
(33, '', '', '', ''),
(34, 'dasds', 'sdasd', 'asdsa', 'asd'),
(35, '', '', '', ''),
(36, '', '', '', ''),
(37, '', '', '', ''),
(38, '', '', '', ''),
(39, '', '', '1', ''),
(40, '', '', '', ''),
(41, '', '', '', ''),
(42, '', '', '', ''),
(43, '', '', '', ''),
(44, '', '', '', ''),
(45, '', '', '', ''),
(46, '', '', '', ''),
(47, '', '', 'dsd', ''),
(48, '', '', '', ''),
(49, '', '', '', ''),
(50, 'Calle 34 Carrera 23', '2', 'Los Olivos', 'Maicao'),
(51, 'fdsf', 'fdsf', 'dsf', 'sdf'),
(52, 'dsad', 'dsad', 'sad', 'asd'),
(53, 'fsdf', 'dsf', 'dsfs', 'fsdf'),
(54, 'Calle 4 Carrera 5', '2', 'Centro', 'Cali'),
(55, 'dasdsa', 'dasd', 'asd', 'asd'),
(56, '', '', '', ''),
(57, '', '', '', ''),
(58, '', '', '', ''),
(59, '', '', '', ''),
(60, '', '', '', ''),
(61, 'asas', 'asas', 'asa', 'as'),
(62, 'Calle 34 Carrera 56', '127', 'Los Corales', 'Pereira'),
(63, '', '', '', ''),
(64, '', '', '', ''),
(65, 'asdsad', 'dasds', 'dasds', 'asd'),
(66, 'dasdsa', 'dasd', 'asd', 'asd'),
(67, 'dasdsa', 'dasd', 'asd', 'asd'),
(68, 'dasdsa', 'dasd', 'asd', 'asd'),
(69, 'dasdsa', 'dasd', 'asd', 'asd'),
(70, 'dasdsa', 'dasd', 'asd', 'asd'),
(71, 'fsdfds', 'dsfsdf', 'dsfds', 'dsfds'),
(72, 'fsdfds', 'dsfsdf', 'dsfds', 'dsfds'),
(73, 'fsdfds', 'dsfsdf', 'dsfds', 'dsfds'),
(74, 'fsdfds', 'dsfsdf', 'dsfds', 'dsfds'),
(75, 'Calle 34 Carrera 52', '32', 'Pando', 'Cienaga');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_productos`
--

CREATE TABLE `tb_productos` (
  `Id` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `PrecioActual` varchar(20) NOT NULL,
  `Existencia` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_productos`
--

INSERT INTO `tb_productos` (`Id`, `Nombre`, `PrecioActual`, `Existencia`, `idProveedor`) VALUES
(2, 'Cereal', '8500', 125, 1),
(3, 'Leche', '1200', 1029, 2),
(4, 'Huevo', '300', 5401, 1),
(5, 'Carne', '14500', 50, 2),
(6, 'Pan', '2200', 102, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_proveedores`
--

CREATE TABLE `tb_proveedores` (
  `Id` int(11) NOT NULL,
  `Nit` varchar(20) NOT NULL,
  `RazonSocial` varchar(20) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `CorreoElectronico` varchar(20) NOT NULL,
  `RepresentanteLegal` varchar(20) NOT NULL,
  `SitioWeb` varchar(20) NOT NULL,
  `idDireccion` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_proveedores`
--

INSERT INTO `tb_proveedores` (`Id`, `Nit`, `RazonSocial`, `Telefono`, `CorreoElectronico`, `RepresentanteLegal`, `SitioWeb`, `idDireccion`) VALUES
(1, '901345762-4', 'Productos y Servicio', '4345045', 'productosyservicios@', 'Calos Slim', 'www.productosyservic', 4),
(2, '900324589-2', 'Vivero LDTA', '6345712', 'info@vivero.com', 'Maria Camila Quinter', 'www.vivero.com.co', 5),
(3, '900.001.324-3', 'telecosta', '4567234', 'inf@telecosta.com', 'Carlos Medrano', 'www.telecosta.com', 10),
(4, '', '', '', '', '', '', 11),
(5, '902.345.672-3', 'linea', '6745621', 'info@linea.com', 'Juan Camargo', 'www.linea.com.co', 12),
(6, '900.324.567-3', 'fruber LTDA', '4768920', 'gerencia@fruber.com', 'Alejandra Ramirez', 'www.fruber.com.c0', 13),
(7, 'dasd', 'dasddasd', 'sda', 'dasd', 'dasd', 'sad', 15),
(8, 'dfsf', 'dafsdf', 'dfsdf', 'dfsdf', 'dsfsdf', 'fsfd', 16),
(9, 'sdfdsf', 'dsdfds', 'sdfds', 'dsfsd', 'sdfsd', 'sdf', 17),
(10, '900.023.739-7', 'vivero1a SAS', '6345091', 'info@vivero1a.com', 'Luis Guzman', 'www.vivero1a.com', 18),
(11, 'sfsdf', 'fdsfsd', 'sdfdsf', 'fsdf', 'sdfsd', 'fsd', 20),
(13, '12', 'Claroro', '123', 'info@claroro.com.co', 'Pedro Galvan', 'www.claroro.com.co', 22),
(14, '12', '', '', '', '', '', 23),
(15, '', '', '', '', '', '', 24),
(16, '', '', '', '', '', '', 25),
(17, '', '', '', '', '', '', 26),
(18, '', '', '', '', '', '', 27),
(19, '', '', '', '', '', '', 28),
(20, '', '', '', '', '', '', 29),
(21, '', '', '', '', '', '', 30),
(22, '', '', '', '', '', '', 31),
(23, '', '', '', '', '', '', 32),
(24, '', '', '', '', '', '', 33),
(25, '13', 'dasdsa', 'sdasd', 'dadas', 'dasdsa', 'asd', 34),
(26, '13', '', '', '', '', '', 35),
(27, '', '', '', '', '', '', 36),
(28, '14', 'asd', 'dsad', 'dsa', 'ads', '', 37),
(29, '', '', '', '', '', '', 38),
(30, '', '', '', '', '', '', 39),
(31, '', '', '', '', '', '', 40),
(32, '', '', '', '', '', '', 41),
(33, '', '', '', '', '', '', 42),
(34, '', '', '', '', '', '', 43),
(35, '', '', '', '', '', '', 44),
(36, '', '', '', '', '', '', 45),
(37, '', '', '', '', '', '', 46),
(38, '', '', '', '', '', '', 47),
(39, '', '', '', '', '', '', 48),
(40, '', '', '', '', '', '', 49),
(42, '1', 'dasdas', 'asdas', 'dasd', 'dasd', 'asd', 52),
(43, 'fsdfds', 'ddfsdf', 'fsdf', 'dsfds', 'fsdf', 'dsf', 53),
(44, '1', 'jose', 'ewerrewr', 'rewr', 'rewrw', 'wer', 55),
(45, '13', 'dasdsa', 'sdasd', 'dadas', 'dasdsa', 'asd', 56),
(46, '13', 'dasdsa', 'sdasd', 'dadas', 'dasdsa', 'asd', 57),
(47, '13', 'dasdsa', 'sdasd', 'dadas', 'dasdsa', 'asd', 58),
(48, '13', 'dasdsa', 'sdasd', 'dadas', 'dasdsa', 'asd', 59),
(49, '1', 'dsdf', 'dfsdf', 'fsdf', 'fdsf', 'sdf', 60),
(51, '12', 'Claroro', 'dfsdfds', 'fsdfds', 'fsdfds', 'sdfs', 62),
(52, 'sfsdf', 'fdsfsd', 'sdfdsf', 'fsdf', 'sdfsd', 'fsd', 63),
(53, '13', 'dasdsa', 'sdasd', 'dadas', 'dasdsa', 'asd', 64),
(60, '12', 'Claroro', 'dfsdfds', 'fsdfds', 'fsdfds', 'sdfs', 71),
(61, '12', 'Claroro', '123', 'fsdfds', 'fsdfds', 'sdfs', 72),
(62, '12', 'Claroro', '123', 'fsdfds', 'fsdfds', 'sdfs', 73),
(63, '12', 'Claroro', '123', 'fsdfds', 'fsdfds', 'sdfs', 74),
(64, '12', 'Claroro', '123', 'info@claroro.com.co', 'Pedro Galvan', 'www.claroro.com.co', 75);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tb_ventas`
--

CREATE TABLE `tb_ventas` (
  `Id` int(11) NOT NULL,
  `FechaVenta` varchar(30) NOT NULL,
  `Descuento` varchar(100) NOT NULL DEFAULT '0',
  `ValorTotal` int(11) NOT NULL,
  `idClientes` int(11) NOT NULL,
  `idProductos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `tb_ventas`
--

INSERT INTO `tb_ventas` (`Id`, `FechaVenta`, `Descuento`, `ValorTotal`, `idClientes`, `idProductos`) VALUES
(1, '06/08/2021', '0', 14500, 2, 5),
(2, '02/06/2021', '0', 8500, 1, 2),
(3, '06/07/2021', '0', 2200, 3, 6),
(4, '08/08/2021', '0', 300, 2, 4),
(5, '04/06/2021', '0', 1200, 3, 3);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idProductos` (`idProductos`);

--
-- Indices de la tabla `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idDireccion` (`idDireccion`);

--
-- Indices de la tabla `tb_direcciones`
--
ALTER TABLE `tb_direcciones`
  ADD PRIMARY KEY (`Id`);

--
-- Indices de la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `tb_proveedores`
--
ALTER TABLE `tb_proveedores`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idDireccion` (`idDireccion`);

--
-- Indices de la tabla `tb_ventas`
--
ALTER TABLE `tb_ventas`
  ADD PRIMARY KEY (`Id`),
  ADD KEY `idClientes` (`idClientes`),
  ADD KEY `idProductos` (`idProductos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `tb_clientes`
--
ALTER TABLE `tb_clientes`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `tb_direcciones`
--
ALTER TABLE `tb_direcciones`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=76;

--
-- AUTO_INCREMENT de la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `tb_proveedores`
--
ALTER TABLE `tb_proveedores`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;

--
-- AUTO_INCREMENT de la tabla `tb_ventas`
--
ALTER TABLE `tb_ventas`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `tb_categoria`
--
ALTER TABLE `tb_categoria`
  ADD CONSTRAINT `tb_categoria_ibfk_1` FOREIGN KEY (`idProductos`) REFERENCES `tb_productos` (`Id`);

--
-- Filtros para la tabla `tb_clientes`
--
ALTER TABLE `tb_clientes`
  ADD CONSTRAINT `tb_clientes_ibfk_1` FOREIGN KEY (`idDireccion`) REFERENCES `tb_direcciones` (`Id`);

--
-- Filtros para la tabla `tb_productos`
--
ALTER TABLE `tb_productos`
  ADD CONSTRAINT `tb_productos_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `tb_proveedores` (`Id`);

--
-- Filtros para la tabla `tb_proveedores`
--
ALTER TABLE `tb_proveedores`
  ADD CONSTRAINT `tb_proveedores_ibfk_1` FOREIGN KEY (`idDireccion`) REFERENCES `tb_direcciones` (`Id`);

--
-- Filtros para la tabla `tb_ventas`
--
ALTER TABLE `tb_ventas`
  ADD CONSTRAINT `tb_ventas_ibfk_1` FOREIGN KEY (`idClientes`) REFERENCES `tb_clientes` (`Id`),
  ADD CONSTRAINT `tb_ventas_ibfk_2` FOREIGN KEY (`idProductos`) REFERENCES `tb_productos` (`Id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
