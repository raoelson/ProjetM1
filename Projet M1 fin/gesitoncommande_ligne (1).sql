-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 13 Février 2016 à 10:07
-- Version du serveur :  5.6.20
-- Version de PHP :  5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `gesitoncommande_ligne`
--

-- --------------------------------------------------------

--
-- Structure de la table `categories`
--

CREATE TABLE IF NOT EXISTS `categories` (
`id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  `nom` varchar(145) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=51 ;

--
-- Contenu de la table `categories`
--

INSERT INTO `categories` (`id`, `image_id`, `nom`) VALUES
(49, 185, 'COMPOSANTS'),
(50, 180, 'MATERIEL');

-- --------------------------------------------------------

--
-- Structure de la table `commandes`
--

CREATE TABLE IF NOT EXISTS `commandes` (
`id` int(11) NOT NULL,
  `utilisateur_id` int(11) DEFAULT NULL,
  `valider` tinyint(1) NOT NULL,
  `date_commandes` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `times_commandes` varchar(40) COLLATE utf8_unicode_ci NOT NULL,
  `heure` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `reference` int(11) NOT NULL,
  `commandes` longtext COLLATE utf8_unicode_ci NOT NULL COMMENT '(DC2Type:array)'
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=54 ;

--
-- Contenu de la table `commandes`
--

INSERT INTO `commandes` (`id`, `utilisateur_id`, `valider`, `date_commandes`, `times_commandes`, `heure`, `reference`, `commandes`) VALUES
(39, 98, 1, '06-02-2016 ', '22:47:10', '22', 1, '[{"livraison":"10","facturation":"10","id":"136","cat":"Ecran","tva":"20","multiplicate":"0.833","qte":"3","prix":"400"},{"id":"134","cat":"Disque dur","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"4000"}]'),
(40, 98, 1, '07-02-2016 ', '08:31:29', '08', 2, '[{"livraison":"10","facturation":"10","id":"136","cat":"Ecran","tva":"20","multiplicate":"0.833","qte":"1","prix":"400"},{"id":"134","cat":"Disque dur","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"4000"}]'),
(41, 98, 1, '08-02-2016 ', '10:56:35', '10', 3, '[{"id":"128","cat":"Carte mère","livraison":"10","facturation":"10","tva":"20","multiplicate":"0.833","qte":"1","prix":"3000"}]'),
(42, 98, 1, '08-02-2016 ', '12:15:15', '12', 4, '[{"livraison":"10","facturation":"10","id":"133","cat":"Disque dur","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"1000"},{"id":"136","cat":"Ecran","tva":"20","multiplicate":"0.833","qte":"1","prix":"400"},{"id":"135","cat":"Ecran","tva":"20","multiplicate":"0.833","qte":"1","prix":"2000"}]'),
(43, 98, 1, '08-02-2016 ', '14:08:24', '14', 5, '[{"id":"128","cat":"Carte mère","livraison":"8","facturation":"8","tva":"20","multiplicate":"0.833","qte":"6","prix":"3000"}]'),
(44, 98, 1, '08-02-2016 ', '14:57:31', '14', 6, '[{"livraison":"11","facturation":"11","id":"136","cat":"Ecran","tva":"20","multiplicate":"0.833","qte":"1","prix":"400"},{"id":"137","cat":"Gaming","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"3000"},{"id":"138","cat":"Gaming","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"2900"},{"id":"133","cat":"Disque dur","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"1000"}]'),
(45, 98, 1, '08-02-2016 ', '16:00:18', '16', 7, '[{"id":"128","cat":"Carte mère","livraison":"8","facturation":"8","tva":"20","multiplicate":"0.833","qte":"2","prix":"3000"}]'),
(48, 98, 0, '09-02-2016', '08:37:03', '08', 8, '[{"livraison":"11","facturation":"8","id":"136","cat":"Ecran","tva":"20","multiplicate":"0.833","qte":"1","prix":"400"},{"id":"134","cat":"Disque dur","tva":"1.75","multiplicate":"0.982","qte":"1","prix":"4000"}]'),
(49, 98, 0, '09-02-2016', '12:51:27', '12', 8, '[{"id":"129","cat":"Carte graphique","livraison":"11","facturation":"8","tva":"20","multiplicate":"0.833","qte":"2","prix":"1000"}]'),
(50, 98, 1, '09-02-2016', '12:55:21', '12', 8, '[{"id":"134","cat":"Disque dur","livraison":"11","facturation":"8","tva":"1.75","multiplicate":"0.982","qte":"4","prix":"4000"}]'),
(51, 98, 1, '09-02-2016', '23:00:19', '23', 9, '[{"id":"136","cat":"Ecran","livraison":"11","facturation":"8","tva":"20","multiplicate":"0.833","qte":"1","prix":"400"}]'),
(52, 98, 0, '10-02-2016', '08:12:00', '08', 10, '[{"id":"134","cat":"Disque dur","livraison":"11","facturation":"8","tva":"1.75","multiplicate":"0.982","qte":"2","prix":"4000"}]'),
(53, 98, 0, '10-02-2016', '09:23:21', '09', 10, '[{"id":"134","cat":"Disque dur","livraison":"11","facturation":"8","tva":"1.75","multiplicate":"0.982","qte":"6","prix":"4000"}]');

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE IF NOT EXISTS `media` (
`id` int(11) NOT NULL,
  `path` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `alt` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=190 ;

--
-- Contenu de la table `media`
--

INSERT INTO `media` (`id`, `path`, `alt`) VALUES
(173, 'uploads/04032032-photo-carte-mere-intel-dx58so2-1.jpg', 'carte-mère-intel-dx58so2'),
(174, 'uploads/04398038-photo-carte-mere-asus-f1a75-v-pro-2.jpg', 'carte-mere-asus-f1a75-v-pro-2'),
(175, 'uploads/05214140-photo-gigabyte-g1-assassin-2.jpg', 'gigabyte-g1-assassin-2'),
(176, 'uploads/adaptateur-d-disque-dur-sata-et-ide-noir.jpg', 'adaptateur-d-disque-dur-sata-et-ide-noir'),
(177, 'uploads/Samsung-P3-disque-dur-externe-Réductions-1000-Go.jpg', 'disque-dur-externe'),
(178, 'uploads/Nouveau-2-5-USB-3-0-sans-fil-Wifi-disque-dur-externe-disque-dur-cas-Soutien.jpg_640x640.jpg', 'USB-3-0-sans-fil-Wifi-disque-dur-externe'),
(179, 'uploads/samsung-disque-dur-externe-m3-500go-usb3-0.jpg', 'samsung-disque-dur-externe-m3-500go-usb3'),
(180, 'uploads/lg22g.jpg', 'LG 21"'),
(181, 'uploads/image.php.jpg', 'Ecran Samsung 17"'),
(182, 'uploads/cd7b266f.jpg', 'DELL 21"'),
(183, 'uploads/carte-graphique-driver.jpg', 'carte-graphique-drive'),
(184, 'uploads/carte-graphique-nvidia.jpg', 'carte-graphique-nvidia'),
(185, 'uploads/Gainward GeForce GTX 650 1GB .jpg', 'Gainward GeForce GTX 650 '),
(186, 'uploads/fifa-16-jeu-ps4.jpg', 'Fifa 16 jeux ps4'),
(187, 'uploads/saitek-pro-flight-yoke-system-peripherique-jeux.jpg', 'Saitek pro flight'),
(188, 'uploads/manette-de-jeux-tunisie-double-choc-vibreur-usb.jpg', 'Manette de jeux'),
(189, 'uploads/imprimante-workforce-pro.jpg', 'imprimante workforce pro');

-- --------------------------------------------------------

--
-- Structure de la table `pages`
--

CREATE TABLE IF NOT EXISTS `pages` (
`id` int(11) NOT NULL,
  `titre` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `contenu` longtext COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=57 ;

--
-- Contenu de la table `pages`
--

INSERT INTO `pages` (`id`, `titre`, `contenu`) VALUES
(55, 'CGV', '\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>'),
(56, 'Mentions légales', '<div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>\r\n            <div class="row">\r\n                <h4>Item Brand and Category</h4>\r\n                <h5>AB29837 Item Model</h5>\r\n                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry''s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.</p>\r\n            </div>');

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
`id` int(11) NOT NULL,
  `image_id` int(11) NOT NULL,
  `tva_id` int(11) NOT NULL,
  `categorie_id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL,
  `description` longtext NOT NULL,
  `prix` double NOT NULL,
  `disponible` tinyint(4) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=139 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`id`, `image_id`, `tva_id`, `categorie_id`, `nom`, `description`, `prix`, `disponible`) VALUES
(127, 173, 46, 17, 'Carte mère intel', 'SAPPHIRE AMD ATI Radeon HD5450 version Boite\nCarte Graphique - 1024Mo DDR3 - PCI Express - HDMI / DVI / VGA ', 2000, 1),
(128, 174, 46, 17, 'Carte mère asus', 'Carte mère Nvidia\nPCI 32bits\nCarte Graphique - PCI-E / DL-DVI-I / DL-DVI-D / HDMI / DisplayPort', 3000, 1),
(129, 183, 46, 18, 'Carte graphique driver', 'description', 1000, 1),
(130, 185, 46, 18, 'Gainward GeForce GTX 650 1GB ', 'Description', 1500, 1),
(132, 178, 45, 19, 'Disque dur externe', 'Descirption', 3000, 1),
(133, 179, 45, 19, 'Samsung P3', 'Samsung P3 disque dur externe Réductions 1000 Go', 1000, 1),
(134, 177, 45, 19, 'samsung disque dur extern 500Go', 'samsung disque dur externe m3 500go usb3\n', 4000, 1),
(135, 180, 46, 20, 'Ecran LG', 'Description', 2000, 1),
(136, 182, 46, 20, 'Ecran DELL', 'Description', 400, 1),
(137, 187, 45, 23, 'Saitek pro', 'Saitek pro flight yoke système périphérique jeux', 3000, 1),
(138, 188, 45, 23, 'Manette de jeux Usb', 'Manette de jeux tunisie double chocvibreur usb', 2900, 1);

-- --------------------------------------------------------

--
-- Structure de la table `sous_categories`
--

CREATE TABLE IF NOT EXISTS `sous_categories` (
`id` int(11) NOT NULL,
  `categories_id` int(11) NOT NULL,
  `nom` varchar(255) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Contenu de la table `sous_categories`
--

INSERT INTO `sous_categories` (`id`, `categories_id`, `nom`) VALUES
(17, 49, 'Carte mère'),
(18, 49, 'Carte graphique'),
(19, 49, 'Disque dur'),
(20, 50, 'Ecran'),
(21, 50, 'Onduleur /Multiprise'),
(22, 50, 'Imprimante'),
(23, 50, 'Gaming');

-- --------------------------------------------------------

--
-- Structure de la table `tva`
--

CREATE TABLE IF NOT EXISTS `tva` (
`id` int(11) NOT NULL,
  `multiplicate` double NOT NULL,
  `nom` varchar(120) COLLATE utf8_unicode_ci NOT NULL,
  `valeur` double NOT NULL
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
`id` int(11) NOT NULL,
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
  `credentials_expire_at` datetime DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=100 ;

--
-- Contenu de la table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `username`, `username_canonical`, `email`, `email_canonical`, `enabled`, `salt`, `password`, `last_login`, `locked`, `expired`, `expires_at`, `confirmation_token`, `password_requested_at`, `roles`, `credentials_expired`, `credentials_expire_at`) VALUES
(94, 'mathilde', 'mathilde', 'mathilde@gmail.com', 'mathilde@gmail.com', 1, '86hdx1bvvmkggc0oc8cw00wko8ow0sg', '9kDcFdjhIp8m12sjBu2Ndm9sqz2H96X6gaATUrlFK2PAGylTPObiGJXtDvSzq2vYyOsIVe8WF5KIhTyf0ToROg==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(95, 'pauline', 'pauline', 'pauline@gmail.com', 'pauline@gmail.com', 1, '95helqyihp0cooso4o4wg8gg884sgos', 'fiBLhl2I8JH1QFx2aEa+ZjhQdIPu/TIo10WyvEWVPeHsfZeTi8wFCYIlaSdUMxhFSr4S8n0amSOZ96M56BAOiQ==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(96, 'tiffany', 'tiffany', 'tiffany@gmail.com', 'tiffany@gmail.com', 1, 'pvnhgw1ejpwoc4gkskw8k408wk848o0', 'NhB1sOuCjGp4Wf0fOL3F5sUJv9gxsp/Mvhn4O0YshUrMJ3k4n2SjqDVaG60muLdoQZXeI7dpeMM7XbvB6VogYQ==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(97, 'dominique', 'dominique', 'dominique@gmail.com', 'dominique@gmail.com', 1, 'ql9ucu9ncrkk4sg0ossco00wkwk8sc4', 'x6LviXd2ktNhD2bBUU+SstPe6R3OYiokfQj6BnromxNC+857H1j8p72j82j9NLAZzwF/okrbXiMJgV6Dtklftg==', NULL, 0, 0, NULL, NULL, NULL, 'a:0:{}', 0, NULL),
(98, 'maoris', 'maoris', 'raoelsonmaoris@gmail.com', 'raoelsonmaoris@gmail.com', 1, '', 'cae7621e7b216fae6f42240d9d982b2de8fa567ba423e87a797e1ff364f051e4', NULL, 0, 0, NULL, NULL, NULL, '', 0, NULL),
(99, 'admin', 'admin', 'admin@gmail.com', 'admin@gmail.com', 1, '', '8c6976e5b5410415bde908bd4dee15dfb167a9c873fc4bb8a81f6f2ab448a918', '2016-02-04 00:00:00', 0, 0, NULL, NULL, NULL, 'ROLE_ADMIN', 0, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `utilisateursadresses`
--

CREATE TABLE IF NOT EXISTS `utilisateursadresses` (
`id` int(11) NOT NULL,
  `utilisateur_id` int(11) DEFAULT NULL,
  `nom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `telephone` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `adresse` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `cp` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `pays` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `ville` varchar(125) COLLATE utf8_unicode_ci NOT NULL,
  `complement` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Contenu de la table `utilisateursadresses`
--

INSERT INTO `utilisateursadresses` (`id`, `utilisateur_id`, `nom`, `prenom`, `telephone`, `adresse`, `cp`, `pays`, `ville`, `complement`) VALUES
(8, 98, 'raoelson', 'maoris', '0324567890', 'tanambao', '301', 'madagascar', 'Fianarantsoa', NULL),
(11, 98, 'leris', 'raoelson', '0324576890', 'Andrainjanto', '301', 'Madagascar', 'Fianarantsoa', NULL);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `categories`
--
ALTER TABLE `categories`
 ADD PRIMARY KEY (`id`), ADD KEY `image_id` (`image_id`);

--
-- Index pour la table `commandes`
--
ALTER TABLE `commandes`
 ADD PRIMARY KEY (`id`), ADD KEY `IDX_B725AA8FFB88E14F` (`utilisateur_id`);

--
-- Index pour la table `media`
--
ALTER TABLE `media`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pages`
--
ALTER TABLE `pages`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
 ADD PRIMARY KEY (`id`), ADD KEY `image_id` (`image_id`), ADD KEY `tva_id` (`tva_id`), ADD KEY `categorie_id` (`categorie_id`);

--
-- Index pour la table `sous_categories`
--
ALTER TABLE `sous_categories`
 ADD PRIMARY KEY (`id`), ADD KEY `categories_id` (`categories_id`);

--
-- Index pour la table `tva`
--
ALTER TABLE `tva`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `UNIQ_514AEAA692FC23A8` (`username_canonical`), ADD UNIQUE KEY `UNIQ_514AEAA6A0D96FBF` (`email_canonical`);

--
-- Index pour la table `utilisateursadresses`
--
ALTER TABLE `utilisateursadresses`
 ADD PRIMARY KEY (`id`), ADD KEY `IDX_95A7AD7AFB88E14F` (`utilisateur_id`), ADD KEY `utilisateur_id` (`utilisateur_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `categories`
--
ALTER TABLE `categories`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=51;
--
-- AUTO_INCREMENT pour la table `commandes`
--
ALTER TABLE `commandes`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=54;
--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=190;
--
-- AUTO_INCREMENT pour la table `pages`
--
ALTER TABLE `pages`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=57;
--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=139;
--
-- AUTO_INCREMENT pour la table `sous_categories`
--
ALTER TABLE `sous_categories`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT pour la table `tva`
--
ALTER TABLE `tva`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT pour la table `utilisateurs`
--
ALTER TABLE `utilisateurs`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=100;
--
-- AUTO_INCREMENT pour la table `utilisateursadresses`
--
ALTER TABLE `utilisateursadresses`
MODIFY `id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `categories`
--
ALTER TABLE `categories`
ADD CONSTRAINT `categories_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `media` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `commandes`
--
ALTER TABLE `commandes`
ADD CONSTRAINT `FK_B725AA8FFB88E14F` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
ADD CONSTRAINT `produit_ibfk_1` FOREIGN KEY (`image_id`) REFERENCES `media` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `produit_ibfk_2` FOREIGN KEY (`tva_id`) REFERENCES `tva` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `produit_ibfk_3` FOREIGN KEY (`categorie_id`) REFERENCES `sous_categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `sous_categories`
--
ALTER TABLE `sous_categories`
ADD CONSTRAINT `sous_categories_ibfk_1` FOREIGN KEY (`categories_id`) REFERENCES `categories` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `utilisateursadresses`
--
ALTER TABLE `utilisateursadresses`
ADD CONSTRAINT `utilisateursadresses_ibfk_1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateurs` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
