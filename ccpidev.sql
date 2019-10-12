-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 12 oct. 2019 à 14:44
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ccpidev`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `cin` int(11) NOT NULL AUTO_INCREMENT,
  `mailA` varchar(20) NOT NULL,
  `pwdA` varchar(20) NOT NULL,
  PRIMARY KEY (`cin`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_art` int(11) NOT NULL AUTO_INCREMENT,
  `nom_art` varchar(20) NOT NULL,
  `description_art` varchar(100) NOT NULL,
  `prix_art` int(11) NOT NULL,
  `id_cat` int(11) NOT NULL,
  `image_art` int(11) NOT NULL,
  `qantité_art` int(11) NOT NULL,
  PRIMARY KEY (`id_art`),
  KEY `article_ibfk_1` (`id_cat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `catégoriec`
--

DROP TABLE IF EXISTS `catégoriec`;
CREATE TABLE IF NOT EXISTS `catégoriec` (
  `id_cat` int(11) NOT NULL AUTO_INCREMENT,
  `nom_cat` varchar(20) NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `catégorief`
--

DROP TABLE IF EXISTS `catégorief`;
CREATE TABLE IF NOT EXISTS `catégorief` (
  `id_catF` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(10) NOT NULL,
  PRIMARY KEY (`id_catF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `catégoriel`
--

DROP TABLE IF EXISTS `catégoriel`;
CREATE TABLE IF NOT EXISTS `catégoriel` (
  `Id_catL` int(11) NOT NULL AUTO_INCREMENT,
  `libellé` varchar(100) NOT NULL,
  PRIMARY KEY (`Id_catL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `catégoriev`
--

DROP TABLE IF EXISTS `catégoriev`;
CREATE TABLE IF NOT EXISTS `catégoriev` (
  `id_cat` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(10) NOT NULL,
  `description_cat` varchar(100) NOT NULL,
  PRIMARY KEY (`id_cat`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `club`
--

DROP TABLE IF EXISTS `club`;
CREATE TABLE IF NOT EXISTS `club` (
  `id_club` int(11) NOT NULL AUTO_INCREMENT,
  `nom_club` varchar(20) NOT NULL,
  `descriptionC` varchar(100) NOT NULL,
  `salleC` varchar(10) NOT NULL,
  `idC` int(11) NOT NULL,
  PRIMARY KEY (`id_club`),
  KEY `club_ibfk_1` (`idC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_cmd` int(11) NOT NULL AUTO_INCREMENT,
  `id_art` int(11) NOT NULL,
  `date` varchar(10) NOT NULL,
  `Montant` int(11) NOT NULL,
  `idU` int(11) NOT NULL,
  PRIMARY KEY (`id_cmd`),
  KEY `id_art` (`id_art`),
  KEY `commande_ibfk_2` (`idU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `commentaire`
--

DROP TABLE IF EXISTS `commentaire`;
CREATE TABLE IF NOT EXISTS `commentaire` (
  `idU` int(11) NOT NULL,
  `id_forum` int(11) NOT NULL,
  PRIMARY KEY (`idU`,`id_forum`),
  KEY `idU` (`idU`,`id_forum`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `emprunt`
--

DROP TABLE IF EXISTS `emprunt`;
CREATE TABLE IF NOT EXISTS `emprunt` (
  `id_emprunt` int(11) NOT NULL AUTO_INCREMENT,
  `id_L` int(11) NOT NULL,
  `idU` int(11) NOT NULL,
  `datedebut` varchar(10) NOT NULL,
  `date_retour` varchar(10) NOT NULL,
  PRIMARY KEY (`id_emprunt`),
  KEY `emprunt_ibfk_1` (`idU`),
  KEY `id_L` (`id_L`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `evenement`
--

DROP TABLE IF EXISTS `evenement`;
CREATE TABLE IF NOT EXISTS `evenement` (
  `id_event` int(11) NOT NULL AUTO_INCREMENT,
  `nom_event` varchar(10) NOT NULL,
  `date_dabut` varchar(10) NOT NULL,
  `date_fin` varchar(10) NOT NULL,
  `Sujet` varchar(100) NOT NULL,
  PRIMARY KEY (`id_event`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `favoris`
--

DROP TABLE IF EXISTS `favoris`;
CREATE TABLE IF NOT EXISTS `favoris` (
  `id_film` int(11) NOT NULL,
  KEY `id_film` (`id_film`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `film`
--

DROP TABLE IF EXISTS `film`;
CREATE TABLE IF NOT EXISTS `film` (
  `id_film` int(11) NOT NULL AUTO_INCREMENT,
  `nom_film` varchar(20) NOT NULL,
  `description_film` varchar(255) NOT NULL,
  PRIMARY KEY (`id_film`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `forum`
--

DROP TABLE IF EXISTS `forum`;
CREATE TABLE IF NOT EXISTS `forum` (
  `id_forum` int(11) NOT NULL AUTO_INCREMENT,
  `nomForum` varchar(20) NOT NULL,
  `descriptionForum` varchar(100) NOT NULL,
  `Sujet` varchar(10) NOT NULL,
  `id_catF` int(11) NOT NULL,
  PRIMARY KEY (`id_forum`),
  KEY `forum_ibfk_1` (`id_catF`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `livre`
--

DROP TABLE IF EXISTS `livre`;
CREATE TABLE IF NOT EXISTS `livre` (
  `idL` int(11) NOT NULL AUTO_INCREMENT,
  `titreL` varchar(10) NOT NULL,
  `date_edition` varchar(10) NOT NULL,
  `auteur` varchar(10) NOT NULL,
  `etat` tinyint(1) NOT NULL,
  `idCL` int(100) NOT NULL,
  PRIMARY KEY (`idL`),
  KEY `livre_ibfk_1` (`idCL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participant`
--

DROP TABLE IF EXISTS `participant`;
CREATE TABLE IF NOT EXISTS `participant` (
  `id_event` int(11) NOT NULL,
  `idU` int(11) NOT NULL,
  `Nbr_total` int(11) NOT NULL,
  PRIMARY KEY (`id_event`,`idU`),
  KEY `id_event` (`id_event`,`idU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `participation`
--

DROP TABLE IF EXISTS `participation`;
CREATE TABLE IF NOT EXISTS `participation` (
  `num_part` int(11) NOT NULL AUTO_INCREMENT,
  `id_club` int(11) NOT NULL,
  `idU` int(11) NOT NULL,
  PRIMARY KEY (`num_part`),
  KEY `idU` (`idU`),
  KEY `id_club` (`id_club`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
CREATE TABLE IF NOT EXISTS `responsable` (
  `cinR` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(10) NOT NULL,
  `mailR` varchar(20) NOT NULL,
  `pwdR` varchar(20) NOT NULL,
  `secteur` varchar(20) NOT NULL,
  `num_telR` varchar(10) NOT NULL,
  PRIMARY KEY (`cinR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `réservation`
--

DROP TABLE IF EXISTS `réservation`;
CREATE TABLE IF NOT EXISTS `réservation` (
  `id_film` int(11) NOT NULL,
  `num_s` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `nbr_place` int(100) NOT NULL,
  `num_res` int(11) NOT NULL,
  PRIMARY KEY (`id_film`,`num_s`),
  UNIQUE KEY `id_film` (`id_film`,`num_s`),
  KEY `num_s` (`num_s`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `salle`
--

DROP TABLE IF EXISTS `salle`;
CREATE TABLE IF NOT EXISTS `salle` (
  `num_s` int(11) NOT NULL AUTO_INCREMENT,
  `nbr_place` int(11) NOT NULL,
  PRIMARY KEY (`num_s`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `cinU` int(11) NOT NULL AUTO_INCREMENT,
  `nomU` varchar(20) NOT NULL,
  `prenomU` varchar(20) NOT NULL,
  `ageU` int(11) NOT NULL,
  `mailU` varchar(20) NOT NULL,
  `pwdU` varchar(20) NOT NULL,
  `num_tel` varchar(20) NOT NULL,
  PRIMARY KEY (`cinU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `article`
--
ALTER TABLE `article`
  ADD CONSTRAINT `article_ibfk_1` FOREIGN KEY (`id_cat`) REFERENCES `catégoriev` (`id_cat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `club`
--
ALTER TABLE `club`
  ADD CONSTRAINT `club_ibfk_1` FOREIGN KEY (`idC`) REFERENCES `catégoriec` (`id_cat`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `commande_ibfk_1` FOREIGN KEY (`id_art`) REFERENCES `article` (`id_art`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `commande_ibfk_2` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`cinU`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`cinU`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `emprunt_ibfk_2` FOREIGN KEY (`id_L`) REFERENCES `livre` (`idL`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `forum`
--
ALTER TABLE `forum`
  ADD CONSTRAINT `forum_ibfk_1` FOREIGN KEY (`id_catF`) REFERENCES `catégorief` (`id_catF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `livre`
--
ALTER TABLE `livre`
  ADD CONSTRAINT `livre_ibfk_1` FOREIGN KEY (`idCL`) REFERENCES `catégoriel` (`Id_catL`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `participation`
--
ALTER TABLE `participation`
  ADD CONSTRAINT `participation_ibfk_1` FOREIGN KEY (`idU`) REFERENCES `utilisateur` (`cinU`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `participation_ibfk_2` FOREIGN KEY (`id_club`) REFERENCES `club` (`id_club`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `réservation`
--
ALTER TABLE `réservation`
  ADD CONSTRAINT `réservation_ibfk_1` FOREIGN KEY (`id_film`) REFERENCES `film` (`id_film`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `réservation_ibfk_2` FOREIGN KEY (`num_s`) REFERENCES `salle` (`num_s`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
