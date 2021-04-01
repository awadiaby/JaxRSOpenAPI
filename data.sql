-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 01, 2021 at 10:01 PM
-- Server version: 5.7.31
-- PHP Version: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tpjpa`
--

-- --------------------------------------------------------

--
-- Table structure for table `collaborateur`
--

DROP TABLE IF EXISTS `collaborateur`;
CREATE TABLE IF NOT EXISTS `collaborateur` (
  `Type_Collaborateur` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `roleTech` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `collaborateur`
--

INSERT INTO `collaborateur` (`Type_Collaborateur`, `id`, `email`, `nom`, `prenom`, `role`, `roleTech`) VALUES
('Collaborateur', 1, 'ama@test.com', 'Dia', 'Ama', NULL, NULL),
('Collaborateur', 2, 'awa@test.com', 'Diaby', 'Awa', NULL, NULL),
('Collaborateur', 3, 'sadou@test.com', 'Barry', 'Sadou', NULL, NULL),
('Collaborateur', 4, 'sadou@test.com', 'Barry', 'Sadou', NULL, NULL),
('Collaborateur', 5, 'sadou@test.com', 'Barry barry', 'Sadou', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `fiche`
--

DROP TABLE IF EXISTS `fiche`;
CREATE TABLE IF NOT EXISTS `fiche` (
  `id` bigint(20) NOT NULL,
  `commit` varchar(255) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `dureeTache` bigint(20) DEFAULT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `lieu` varchar(255) DEFAULT NULL,
  `note` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `collaborateur_id` bigint(20) DEFAULT NULL,
  `section_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4xvow9kp3a94c8ql5xrcp96lf` (`collaborateur_id`),
  KEY `FKhku82603voqbyxsomrlihpeuq` (`section_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `fiche`
--

INSERT INTO `fiche` (`id`, `commit`, `date`, `dureeTache`, `libelle`, `lieu`, `note`, `url`, `collaborateur_id`, `section_id`) VALUES
(6, 'f35c8d0b', '2021-03-21', 2, 'Creation d\'un site web', 'Rennes', 'Creer une api test sur le machin', 'www.test.com', 2, 9),
(13, 'f35c8d0b', '2021-03-31', 2, 'Creation d\'un site web', 'Rennes', NULL, 'www.test.com', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE IF NOT EXISTS `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(18),
(18),
(18),
(18);

-- --------------------------------------------------------

--
-- Table structure for table `section`
--

DROP TABLE IF EXISTS `section`;
CREATE TABLE IF NOT EXISTS `section` (
  `id` bigint(20) NOT NULL,
  `status` varchar(255) DEFAULT NULL,
  `tableau_id` bigint(20) DEFAULT NULL,
  `tableauId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKeunrr6291jbnsrl4djcof0aug` (`tableau_id`),
  KEY `FK7xdavy3m9xh8mrwulqj24iagy` (`tableauId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `section`
--

INSERT INTO `section` (`id`, `status`, `tableau_id`, `tableauId`) VALUES
(9, 'EN_ATTENTE', 8, NULL),
(10, 'EN_COURS', 8, NULL),
(17, 'REALISE', 12, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tableau`
--

DROP TABLE IF EXISTS `tableau`;
CREATE TABLE IF NOT EXISTS `tableau` (
  `id` bigint(20) NOT NULL,
  `dateCreation` date DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tableau`
--

INSERT INTO `tableau` (`id`, `dateCreation`, `nom`) VALUES
(8, '2021-03-31', 'Test'),
(12, '2021-03-31', 'Tableau 2');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `fiche`
--
ALTER TABLE `fiche`
  ADD CONSTRAINT `FK4xvow9kp3a94c8ql5xrcp96lf` FOREIGN KEY (`collaborateur_id`) REFERENCES `collaborateur` (`id`),
  ADD CONSTRAINT `FKhku82603voqbyxsomrlihpeuq` FOREIGN KEY (`section_id`) REFERENCES `section` (`id`);

--
-- Constraints for table `section`
--
ALTER TABLE `section`
  ADD CONSTRAINT `FK7xdavy3m9xh8mrwulqj24iagy` FOREIGN KEY (`tableauId`) REFERENCES `tableau` (`id`),
  ADD CONSTRAINT `FKeunrr6291jbnsrl4djcof0aug` FOREIGN KEY (`tableau_id`) REFERENCES `tableau` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
