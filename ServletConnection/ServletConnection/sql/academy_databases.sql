-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2016 at 02:52 AM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `academy_databases`
--

-- --------------------------------------------------------

--
-- Table structure for table `tbl_courses`
--

CREATE TABLE `tbl_courses` (
  `course_id` int(11) NOT NULL,
  `course_name` varchar(100) NOT NULL,
  `fees` int(11) NOT NULL,
  `added_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_courses`
--

INSERT INTO `tbl_courses` (`course_id`, `course_name`, `fees`, `added_date`, `status`) VALUES
(1, 'Core Java', 12000, '2016-08-28 13:35:23', 1),
(2, 'Advanced Java', 20000, '2016-08-28 13:35:23', 1);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_enquiries`
--

CREATE TABLE `tbl_enquiries` (
  `enquiry_id` int(11) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `contact_number` varchar(20) NOT NULL,
  `email_address` varchar(100) NOT NULL,
  `course_id` int(11) NOT NULL,
  `enquiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tbl_enquiries`
--

INSERT INTO `tbl_enquiries` (`enquiry_id`, `first_name`, `last_name`, `contact_number`, `email_address`, `course_id`, `enquiry_date`) VALUES
(1, 'Mohit', 'Paudel', '9860684040', 'mohit.paudel1996@gmail.com', 1, '2016-08-30 12:18:36'),
(2, 'Kafle', 'Seth', '9850122312', 'mohit.paudel1996@gmail.com', 0, '2016-08-30 12:20:58'),
(3, 'Mohan', 'Bagan', '984241242', 'mohit.sasdsa@gmail.com', 0, '2016-08-30 12:23:10');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_courses`
--
ALTER TABLE `tbl_courses`
  ADD PRIMARY KEY (`course_id`);

--
-- Indexes for table `tbl_enquiries`
--
ALTER TABLE `tbl_enquiries`
  ADD PRIMARY KEY (`enquiry_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_courses`
--
ALTER TABLE `tbl_courses`
  MODIFY `course_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `tbl_enquiries`
--
ALTER TABLE `tbl_enquiries`
  MODIFY `enquiry_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
