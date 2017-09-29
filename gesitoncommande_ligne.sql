-- phpMyAdmin SQL Dump
-- version 4.0.4
-- http://www.phpmyadmin.net
--
-- Client: localhost
-- Généré le: Jeu 21 Janvier 2016 à 20:51
-- Version du serveur: 5.6.12-log
-- Version de PHP: 5.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données: `gesitoncommande_ligne`
--
CREATE DATABASE IF NOT EXISTS `gesitoncommande_ligne` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `gesitoncommande_ligne`;

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_id` int(11) NOT NULL,
  `nom` varchar(145) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_3AF346683DA5256D` (`image_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=47 ;

--
-- Contenu de la table `categories`
--

INSERT INTO `categories` (`id`, `image_id`, `nom`) VALUES
(45, 159, 'Légumes'),
(46, 163, 'fruits');

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE IF NOT EXISTS `commandes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `utilisateur_id` int(11) DEFAULT NULL,
  `valider` tinyint(1) NOT NULL,
  `date` datetime NOT NULL,
  `reference` int(11) NOT NULL,
  `commandes` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  PRIMARY KEY (`id`),
  KEY `IDX_B725AA8FFB88E14F` (`utilisateur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=15 ;

--
-- Contenu de la table `commandes`
--

INSERT INTO `commandes` (`id`, `utilisateur_id`, `valider`, `date`, `reference`, `commandes`) VALUES
(14, 94, 1, '2016-01-18 09:36:36', 1, 'a:3:{s:2:"00";a:1:{i:1;s:1:"5";}i:11;a:1:{i:2;s:1:"6";}i:22;a:1:{i:4;s:1:"7";}}');

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE IF NOT EXISTS `media` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `alt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=165 ;

--
-- Contenu de la table `media`
--

INSERT INTO `media` (`id`, `path`, `alt`) VALUES
(159, 'uploads/b876f70906264390e54636e76e48ca3234a24922.jpg', 'Poivron rouge'),
(160, 'uploads/b876f70906264390e54636e76e48ca3234a24444.jpg', 'Piment'),
(161, 'uploads/b876f70906264390e54636e76e48ca3234a24999.jpg', 'Tomate'),
(162, 'uploads/b876f70906264390e54636e76e48ca3234a24997.jpg', 'Poivron vert'),
(163, 'uploads/bc76f70906264390e54636e76e48ca3234a24999.jpg', 'Raisin'),
(164, 'uploads/bc76f70906264390e54636e76e48ca3234a24998.jpg', 'Orange');

-- --------------------------------------------------------

--
-- Structure de la table `pages`
--

CREATE TABLE IF NOT EXISTS `pages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titre` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `contenu` longtext COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=57 ;

--
-- Contenu de la table `pages`
--

INSERT INTO `pages` (`id`, `titre`, `contenu`) VALUES
(55, 'CGV', '\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>'),
(56, 'Mentions légales', '<div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>');

-- --------------------------------------------------------

--
-- Structure de la table `produits`
--

CREATE TABLE IF NOT EXISTS `produits` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `image_id` int(11) NOT NULL,
  `categorie_id` int(11) NOT NULL,
  `tva_id` int(11) NOT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` longtext COLLATE utf8_unicode_ci NOT NULL,
  `prix` double NOT NULL,
  `disponible` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_BE2DDF8C3DA5256D` (`image_id`),
  KEY `IDX_BE2DDF8CBCF5E72D` (`categorie_id`),
  KEY `IDX_BE2DDF8C4D79775F` (`tva_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=126 ;

--
-- Contenu de la table `produits`
--

INSERT INTO `produits` (`id`, `image_id`, `categorie_id`, `tva_id`, `nom`, `description`, `prix`, `disponible`) VALUES
(120, 159, 45, 45, 'Poivron rouge', 'Le poivron rouge est un groupe de cultivars de l''espèce Capsicum annuum.', 1.99, 1),
(121, 160, 45, 46, 'Piment', 'Piment est généralement associé à la saveur du piquant (pimenté).', 3.99, 1),
(122, 161, 45, 46, 'Tomate', 'La tomate est une espèce de plantes herbacées de la famille des Solanacées, originaire du nord-ouest de l''Amérique du Sud.', 0.99, 1),
(123, 162, 45, 46, 'Poivron vert', 'Le poivron vert est un groupe de cultivars de l''espèce Capsicum annuum.', 2.99, 1),
(124, 163, 46, 46, 'Raisin', 'Le raisin est le fruit de la Vigne. Le raisin de la vigne cultivée Vitis vinifera est un des fruits les plus cultivés au monde, avec 68 millions de tonnes produites en 2010.', 0.97, 1),
(125, 164, 46, 46, 'Orange', 'L’orange est un agrume, fruit des orangers, des arbres de différentes espèces de la famille des Rutacées ou d''hybrides de ceux-ci.', 1.2, 1);

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

CREATE TABLE IF NOT EXISTS `tva` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `multiplicate` double NOT NULL,
  `nom` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `valeur` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=47 ;

--
-- Contenu de la table `tva`
--

INSERT INTO `tva` (`id`, `multiplicate`, `nom`, `valeur`) VALUES
(45, 0.982, 'TVA 1.75%', 1.75),
(46, 0.833, 'TVA 20%', 20);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `username_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `email_canonical` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  `salt` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `last_login` datetime DEFAULT NULL,
  `locked` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL,
  `expires_at` datetime DEFAULT NULL,
  `confirmation_token` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password_requested_at` datetime DEFAULT NULL,
  `roles` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)',
  `credentials_expired` tinyint(1) NOT NULL,
  `credentials_expire_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UNIQ_514AEAA692FC23A8` (`username_canonical`),
  UNIQUE KEY `UNIQ_514AEAA6A0D96FBF` (`email_canonical`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=99 ;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`) VALUES
(94, 'mathilde', 'mathilde', 'mathilde@gmail.com', 'mathilde@gmail.com', 1, '86hdx1bvvmkggc0oc8cw00wko8ow0sg', '9kDcFdjhIp8m12sjBu2Ndm9sqz2H96X6gaATUrlFK2PAGylTPObiGJXtDvSzq2vYyOsIVe8WF5KIhTyf0ToROg==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(95, 'pauline', 'pauline', 'pauline@gmail.com', 'pauline@gmail.com', 1, '95helqyihp0cooso4o4wg8gg884sgos', 'fiBLhl2I8JH1QFx2aEa+ZjhQdIPu/TIo10WyvEWVPeHsfZeTi8wFCYIlaSdUMxhFSr4S8n0amSOZ96M56BAOiQ==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(96, 'tiffany', 'tiffany', 'tiffany@gmail.com', 'tiffany@gmail.com', 1, 'pvnhgw1ejpwoc4gkskw8k408wk848o0', 'NhB1sOuCjGp4Wf0fOL3F5sUJv9gxsp/Mvhn4O0YshUrMJ3k4n2SjqDVaG60muLdoQZXeI7dpeMM7XbvB6VogYQ==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(97, 'dominique', 'dominique', 'dominique@gmail.com', 'dominique@gmail.com', 1, 'ql9ucu9ncrkk4sg0ossco00wkwk8sc4', 'x6LviXd2ktNhD2bBUU+SstPe6R3OYiokfQj6BnromxNC+857H1j8p72j82j9NLAZzwF/okrbXiMJgV6Dtklftg==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(98, 'maoris', 'maoris', 'raoelsonmaoris@gmail.com', 'raoelsonmaoris@gmail.com', 1, '', '8d1b2d580ca9218dfa6b057dfe36ad833d971ed6a1d2db37ed6ac73716fffa8de7af14afc0fe5d5661e7fa1dcfd7d48e7fd4853add873364244ca1a3efe0497e', NULL, 0, 0, NULL, NULL, NULL, '', 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateursadresses`
--

CREATE TABLE IF NOT EXISTS `utilisateursadresses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `utilisateur_id` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cp` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `pays` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `complement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_95A7AD7AFB88E14F` (`utilisateur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=7 ;

--
-- Contenu de la table `utilisateursadresses`
--

INSERT INTO `utilisateursadresses` (`id`, `utilisateur_id`, `nom`, `prenom`, `telephone`, `adresse`, `cp`, `pays`, `ville`, `complement`) VALUES
(5, 98, 'maoris', 'raoelson', '0322547075', 'tanambao', '301', 'madagascar', 'fianarantsoa', NULL),
(6, 98, 'raoelson', 'leris', '0322547075', 'Andrainjato', '301', 'madagascar', 'fianarantsoa', NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `categories`
--
ALTER TABLE `categories`
  ADD CONSTRAINT `FK_3AF346683DA5256D` FOREIGN KEY (`image_id`) REFERENCES `media` (`id`);

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
  ADD CONSTRAINT `FK_B725AA8FFB88E14F` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`);

--
-- Contraintes pour la table `produits`
--
ALTER TABLE `produits`
  ADD CONSTRAINT `FK_BE2DDF8C3DA5256D` FOREIGN KEY (`image_id`) REFERENCES `media` (`id`),
  ADD CONSTRAINT `FK_BE2DDF8C4D79775F` FOREIGN KEY (`tva_id`) REFERENCES `tva` (`id`),
  ADD CONSTRAINT `FK_BE2DDF8CBCF5E72D` FOREIGN KEY (`categorie_id`) REFERENCES `categories` (`id`);

--
-- Contraintes pour la table `utilisateursadresses`
--
ALTER TABLE `utilisateursadresses`
  ADD CONSTRAINT `FK_95A7AD7AFB88E14F` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
