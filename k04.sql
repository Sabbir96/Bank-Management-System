-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2019 at 06:12 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+06:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `k04`
--

-- --------------------------------------------------------

--
-- Table structure for table `customers_information`
--

CREATE TABLE `customers_information` (
  `accountNumber` varchar(30) NOT NULL,
  `name` varchar(30) NOT NULL,
  `accountType` varchar(30) NOT NULL,
  `amount` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customers_information`
--

INSERT INTO `customers_information` (`accountNumber`, `name`, `accountType`, `amount`) VALUES
('c01', 'xyz', 'saving', 0),
('c02', 'customer', 'current', 0),
('c06', 'abcd', 'current', 15000);

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `empId` varchar(6) NOT NULL,
  `employeeName` varchar(30) NOT NULL,
  `designation` varchar(20) NOT NULL,
  `salary` double(8,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`empId`, `employeeName`, `designation`, `salary`) VALUES
('e01', 'employee1', 'manager', 900000.00),
('e02', 'employee2', 'Accountant', 500000.00),
('e03', 'employee3', 'Accountant', 400000.00),
('e04', 'John', 'Manager', 900000.00),
('e05', 'Arnoob', 'Accountant', 400000.00);

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `userId` varchar(8) NOT NULL,
  `password` varchar(10) NOT NULL,
  `status` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`userId`, `password`, `status`) VALUES
('c01', '15211069', 2),
('c02', '10075798', 2),
('c06', '1234', 2),
('e01', '1234', 0),
('e02', '1234', 1),
('e03', '1234', 1),
('e04', '1234', 0),
('e05', '1234', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customers_information`
--
ALTER TABLE `customers_information`
  ADD PRIMARY KEY (`accountNumber`);

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`empId`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`userId`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
