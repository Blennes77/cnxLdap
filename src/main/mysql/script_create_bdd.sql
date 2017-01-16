-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: cgihosting
-- ------------------------------------------------------
-- Server version	5.6.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `appli_ind_actif`
--

DROP TABLE IF EXISTS `appli_ind_actif`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appli_ind_actif` (
  `APPLI_INDACTIF_CLE` int(11) NOT NULL AUTO_INCREMENT,
  `APPLI_INDACTIF_LIBELLE` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`APPLI_INDACTIF_CLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `appli_items_commande`
--

DROP TABLE IF EXISTS `appli_items_commande`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `appli_items_commande` (
  `A_ITEMSCOM_CLE` int(11) NOT NULL AUTO_INCREMENT,
  `A_ITEMS_COM_UTI_ID_VALIDEUR` int(11) DEFAULT NULL,
  `A_ITEMSCOM_DATE_VALID` date DEFAULT NULL,
  `A_ITEMS_COM_IND_TRAITEMENT` tinyint(1) DEFAULT NULL,
  `A_ITEMSCOM_FICHIER_DEVIS` blob,
  `A_ITEMSCOM_FICHIER_COMMANDE` blob,
  `A_ITEMSCOM_ID_COMMANDE_DOLIBARR` int(11) DEFAULT NULL,
  `A_ITEMSCOM_ID_PROJET` int(11) DEFAULT NULL,
  `A_ITEMSCOM_ID_TYPE_HEBERGEMENT` int(11) DEFAULT NULL,
  `A_ITEMSCOM_MESSAGE_TRAITEMENT` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`A_ITEMSCOM_CLE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `catalogue_produits`
--

DROP TABLE IF EXISTS `catalogue_produits`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `catalogue_produits` (
  `CPR_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CPR_TYPE_ID` int(11) NOT NULL,
  `CPR_DESCRIPTION` varchar(45) DEFAULT NULL,
  `CPR_CODE` varchar(45) DEFAULT NULL,
  `CPR_LIBELLE` varchar(45) NOT NULL,
  `CPR_PRIX_UNITAIRE` int(11) NOT NULL,
  `CPR_HEBERGEUR_ID` int(11) NOT NULL,
  `CPR_DOLIBARR_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`CPR_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `commandes_hosting`
--

DROP TABLE IF EXISTS `commandes_hosting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `commandes_hosting` (
  `COH_ID` int(11) NOT NULL AUTO_INCREMENT,
  `COH_ID_UTI_CREATEUR` int(11) NOT NULL,
  `COH_ID_UTI_VALIDEUR` int(11) DEFAULT NULL,
  `COH_DATE_CREATION` datetime DEFAULT NULL,
  `COH_DATE_ACHAT` date DEFAULT NULL,
  `COH_IND_ACHAT` tinyint(1) DEFAULT NULL,
  `COMMANDES_HOSTINGcol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`COH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `configuration_application`
--

DROP TABLE IF EXISTS `configuration_application`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration_application` (
  `CAP_ID` int(11) NOT NULL AUTO_INCREMENT,
  `CAP_TITRE_SITE` varchar(45) NOT NULL,
  `CAP_ID_TYPE_ENVIRONNEMENT` int(11) NOT NULL,
  `CAP_CHAINE_CONNEXIONLDAP` varchar(100) NOT NULL,
  `CAP_COMPTE_LDAP` varchar(100) NOT NULL,
  `CAP_MOTDEPASSE_LDAP` varchar(45) NOT NULL,
  `CAP_COMPTE_ADMIN` varchar(20) NOT NULL,
  `CAP_MOTDEPASSE_ADMIN` varchar(20) NOT NULL,
  `CAP_MAIL_ADMIN` varchar(45) NOT NULL,
  `CAP_ADRESSEIP_PHPIPAM` varchar(45) NOT NULL,
  `CAP_PORT_PHPIPAM` int(11) NOT NULL,
  `CAP_BASE_PHPIPAM` varchar(45) NOT NULL,
  `CAP_COMPTE_PHPIPAM` varchar(45) NOT NULL,
  `CAP_MOTDEPASSE_PHPIPAM` varchar(45) NOT NULL,
  `CAP_ADRESSEIP_TEAMPASS` varchar(45) NOT NULL,
  `CAP_PORT_TEAMPASS` int(11) NOT NULL,
  `CAP_BASE_TEAMPASS` varchar(45) NOT NULL,
  `CAP_COMPTE_TEAMPASS` varchar(45) NOT NULL,
  `CAP_MOTDEPASSE_TEAMPASS` varchar(45) NOT NULL,
  `CAP_ADRESSEIP_DOLIBARR` varchar(45) NOT NULL,
  `CAP_BASE_DOLIBARR` varchar(45) NOT NULL,
  `CAP_PORT_DOLIBARR` int(11) NOT NULL,
  `CAP_COMPTE_DOLIBARR` varchar(45) NOT NULL,
  `CAP_MOTDEPASSE_DOLIBARR` varchar(45) NOT NULL,
  `CAP_ADRESSE_SMTP` varchar(45) DEFAULT NULL,
  `CAP_MAIL_SMTP` varchar(45) NOT NULL,
  `CAP_LONGUEUR_MOTDEPASSE` int(11) NOT NULL,
  `CAP_TIMEOUTPING_PHPIPAM` int(11) NOT NULL,
  `CAP_DELAIMOIS_PURGE` int(11) NOT NULL,
  PRIMARY KEY (`CAP_ID`),
  UNIQUE KEY `A_CONF_ID_UNIQUE` (`CAP_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `journalisation_evenements`
--

DROP TABLE IF EXISTS `journalisation_evenements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `journalisation_evenements` (
  `JEV_ID` int(11) NOT NULL AUTO_INCREMENT,
  `JEV_LOGIN_NAME` varchar(45) NOT NULL,
  `JEV_TYPEACTION_ID` int(11) NOT NULL,
  `JEV_DATE_EVENEMENT` datetime DEFAULT NULL,
  `JEV_ID_DONNEE` int(11) DEFAULT NULL,
  PRIMARY KEY (`JEV_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `messages_utilisateur`
--

DROP TABLE IF EXISTS `messages_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `messages_utilisateur` (
  `MUT_ID` int(11) NOT NULL AUTO_INCREMENT,
  `MUT_SUJET` varchar(45) NOT NULL,
  `MUT_CONTENU` varchar(45) DEFAULT NULL,
  `MUT_ID_DEST` int(11) NOT NULL,
  `MUT_ID_EXP` int(11) DEFAULT NULL,
  `MUT_IND_LU` int(11) DEFAULT NULL,
  `MUT_DATE_ENVOI` date DEFAULT NULL,
  `MUT_DATE_LECTURE` int(11) DEFAULT NULL,
  PRIMARY KEY (`MUT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `projets`
--

DROP TABLE IF EXISTS `projets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projets` (
  `PRO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `PRO_UTI_ID` int(11) DEFAULT NULL,
  `PRO_CODE_PROJET` varchar(45) NOT NULL,
  `PRO_NOM_PROJET` varchar(45) NOT NULL,
  `PRO_CODE_INGE` varchar(15) NOT NULL,
  `PRO_NOMDP` varchar(45) DEFAULT NULL,
  `PRO_PRENOMDP` varchar(45) DEFAULT NULL,
  `PRO_MAILDP` varchar(45) DEFAULT NULL,
  `PRO_DATE_DEBUT` datetime DEFAULT NULL,
  `PRO_DATE_FIN` datetime DEFAULT NULL,
  PRIMARY KEY (`PRO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=9545 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ref_phpipam`
--

DROP TABLE IF EXISTS `ref_phpipam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_phpipam` (
  `RPH_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RPH_ID_TYE_ENVIRONNEMENT` int(11) NOT NULL,
  `RPH_NOM_SECTION` varchar(45) NOT NULL,
  `RPH_ID_TYPE_HEBERGEMENT` int(11) NOT NULL,
  PRIMARY KEY (`RPH_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ref_workflows_uuid`
--

DROP TABLE IF EXISTS `ref_workflows_uuid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ref_workflows_uuid` (
  `RWU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RWU_ID_NOM_WORKFLOW` int(11) DEFAULT NULL,
  `RWU_UUID_WORKFLOW` varchar(45) DEFAULT NULL,
  `RWU_ID_ENV` int(11) DEFAULT NULL,
  PRIMARY KEY (`RWU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_actions_workflows`
--

DROP TABLE IF EXISTS `referentiel_actions_workflows`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_actions_workflows` (
  `RAW_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RAW_ACTION_WORKFLOW` varchar(45) DEFAULT NULL,
  `RAW_DESCRIPTION_WORKFLOW` varchar(45) DEFAULT NULL,
  `RAW_DATE_CREATION` datetime DEFAULT NULL,
  `RAW_DATE_MODIFICATION` datetime DEFAULT NULL,
  `RAW_ID_CREATEUR` int(11) DEFAULT NULL,
  `RAW_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`RAW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_environnement`
--

DROP TABLE IF EXISTS `referentiel_environnement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_environnement` (
  `REN_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REN_CODE_ENVIRONNEMENT` varchar(10) DEFAULT NULL,
  `REN_DESCRIPTION_ENVIRONNEMENT` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`REN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_erreurs_rencontrees`
--

DROP TABLE IF EXISTS `referentiel_erreurs_rencontrees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_erreurs_rencontrees` (
  `RER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RER_LIBELLE` varchar(50) NOT NULL DEFAULT '0',
  `RER_DESCRIPTION` varchar(50) NOT NULL DEFAULT '0',
  `RER_DATE_CREATION` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RER_DATE_MODIFICATION` datetime NOT NULL DEFAULT '0000-00-00 00:00:00',
  `RER_ID_CREATEUR` int(11) NOT NULL DEFAULT '0',
  `RER_ID_MODIFICATEUR` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`RER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_etattraitement_serveur`
--

DROP TABLE IF EXISTS `referentiel_etattraitement_serveur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_etattraitement_serveur` (
  `RES_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RES_CODE` varchar(45) NOT NULL,
  `RES_DESCRIPTION` varchar(200) DEFAULT NULL,
  `RES_DATE_CREATION` datetime DEFAULT NULL,
  `RES_DATE_MODIFICATION` datetime DEFAULT NULL,
  `RES_ID_CREATEUR` int(11) DEFAULT NULL,
  `RES_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`RES_ID`),
  UNIQUE KEY `A_INDTYPETRAIT_CLE_UNIQUE` (`RES_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_hebergeurs`
--

DROP TABLE IF EXISTS `referentiel_hebergeurs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_hebergeurs` (
  `RHE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RHE_NOM` varchar(45) NOT NULL,
  `RHE_DESCRIPTION` varchar(45) DEFAULT NULL,
  `RHE_DATE_CREATION` datetime DEFAULT NULL,
  `RHE_DATE_MODIFICATION` datetime DEFAULT NULL,
  `RHE_ID_CREATEUR` int(11) DEFAULT NULL,
  `RHE_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`RHE_ID`),
  UNIQUE KEY `RHE_NOM_UNIQUE` (`RHE_NOM`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_journalisation`
--

DROP TABLE IF EXISTS `referentiel_journalisation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_journalisation` (
  `RJO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RJO_ACTION_LIBELLE` varchar(100) DEFAULT NULL,
  `RJO_DESCRIPTION` varchar(45) DEFAULT NULL,
  `RJO_DATE_CREATION` datetime DEFAULT NULL,
  `RJO_DATE_MODIFICATION` datetime DEFAULT NULL,
  `RJO_ID_CREATEUR` int(11) DEFAULT NULL,
  `RJO_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  `RJO_IND_PURGEABLE` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`RJO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_mails`
--

DROP TABLE IF EXISTS `referentiel_mails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_mails` (
  `RMA_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RMA_LIBELLE` varchar(45) DEFAULT NULL,
  `RMA_OBJET` varchar(45) NOT NULL,
  `RMA_CORPS` varchar(45) NOT NULL,
  `RMA_DATE_CREATION` datetime NOT NULL,
  `RMA_DATE_MODIFICATION` datetime NOT NULL,
  `RMA_ID_CREATEUR` int(11) NOT NULL,
  `RMA_ID_MODIFICATEUR` int(11) NOT NULL,
  PRIMARY KEY (`RMA_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_os`
--

DROP TABLE IF EXISTS `referentiel_os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_os` (
  `REO_ID` int(11) NOT NULL AUTO_INCREMENT,
  `REO_NOMOS` varchar(45) DEFAULT NULL,
  `REO_DATE_CREATION` datetime DEFAULT NULL,
  `REO_DATE_MODIFICATION` datetime DEFAULT NULL,
  `REO_ID_CREATEUR` int(11) DEFAULT NULL,
  `REO_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`REO_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_psa`
--

DROP TABLE IF EXISTS `referentiel_psa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_psa` (
  `PAYS` varchar(20) DEFAULT NULL,
  `OU` varchar(45) DEFAULT NULL,
  `LIBELLE_OU` varchar(50) DEFAULT NULL,
  `PROJET` varchar(50) DEFAULT NULL,
  `DESCRIPTION` varchar(45) DEFAULT NULL,
  `DPT` varchar(45) DEFAULT NULL,
  `LIBELLE` varchar(100) DEFAULT NULL,
  `MATRICULE_PM` varchar(45) DEFAULT NULL,
  `NOM_PM` varchar(50) DEFAULT NULL,
  `PRENOM_PM` varchar(50) DEFAULT NULL,
  `MAIL_PM` varchar(45) DEFAULT NULL,
  `DATE_DEBUT` datetime DEFAULT NULL,
  `DATE_FIN` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_role_utilisateur`
--

DROP TABLE IF EXISTS `referentiel_role_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_role_utilisateur` (
  `RRU_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RRU_LIBELLE_ROLE` varchar(45) NOT NULL,
  `RRU_DATE_CREATION` datetime DEFAULT NULL,
  `RRU_ID_CREATEUR` int(11) DEFAULT NULL,
  `RRU_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  `RRU_DESCRIPTION_ROLE` int(11) DEFAULT NULL,
  PRIMARY KEY (`RRU_ID`),
  UNIQUE KEY `RRU_LIBELLE_ROLE_UNIQUE` (`RRU_LIBELLE_ROLE`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `referentiel_virtualisation`
--

DROP TABLE IF EXISTS `referentiel_virtualisation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `referentiel_virtualisation` (
  `RVI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RVI_NOM_VIRTUALISATION` varchar(45) DEFAULT NULL,
  `RVI_DESCRPTION_VIRTUALISATION` varchar(45) DEFAULT NULL,
  `RVI_DATE_CREATION` datetime DEFAULT NULL,
  `RVI_DATE_MODIFICATION` datetime DEFAULT NULL,
  `RVI_ID_CREATEUR` int(11) DEFAULT NULL,
  `RVI_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  PRIMARY KEY (`RVI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reseaux_autorises_hebergement`
--

DROP TABLE IF EXISTS `reseaux_autorises_hebergement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reseaux_autorises_hebergement` (
  `RAH_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RAH_ADRESSE_RESEAU` varchar(45) DEFAULT NULL,
  `RAH_MASQUE_CICDR` tinyint(2) DEFAULT NULL,
  `RAH_ORDRE` int(11) NOT NULL,
  `RAH_ID_SOLUTION_HEBERGEMENT` int(11) NOT NULL,
  `RAH_IND_ACTIF` int(11) NOT NULL,
  `RAH_ID_TYPE_ENVIRONNEMENT` int(11) NOT NULL,
  `RAH_ADRESSE_PASSERELLE` varchar(50) NOT NULL,
  PRIMARY KEY (`RAH_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `serveurs_virtuels`
--

DROP TABLE IF EXISTS `serveurs_virtuels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `serveurs_virtuels` (
  `SVI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SVI_ID_ITEM_COMMANDE` int(11) DEFAULT NULL,
  `SVI_NOM_SERVEUR` varchar(45) DEFAULT NULL,
  `SVI_RAM` int(11) NOT NULL,
  `SVI_CPUS` int(11) NOT NULL,
  `SVI_ID_TEMPLATE` int(11) NOT NULL,
  `SVI_DISQUE_SYSTEME` int(11) DEFAULT NULL,
  `SVI_IND_DISQUE_ADDITIF` int(11) DEFAULT NULL,
  `SVI_DISQUE_ADDITIF` int(11) DEFAULT NULL,
  `SVI_NOM_ADMIN` varchar(45) DEFAULT NULL,
  `SVI_MOTDEPASSE_ADMIN` varchar(45) DEFAULT NULL,
  `SVI_ADRESSEIP` varchar(45) DEFAULT NULL,
  `SVI_MASQUE` varchar(45) DEFAULT NULL,
  `SVI_ID_SOLUTION_HEBERGEMENT` int(11) DEFAULT NULL,
  `SVI_ID_WORKFLOW` int(11) NOT NULL,
  `SVI_MASQUECICDR` tinyint(2) DEFAULT NULL,
  `SVI_IND_TRAITEMENT` int(11) NOT NULL,
  `SVI_DATE_TRAITEMENT` datetime DEFAULT NULL,
  `SVI_MESSAGE_ERREUR` varchar(45) DEFAULT NULL,
  `SVI_IND_CUSTOMISATION` int(11) DEFAULT NULL,
  `SVI_ID_PHPIPAM` int(11) DEFAULT NULL,
  `SVI_ID_UTI_EXPLOITANT` int(11) DEFAULT NULL,
  `SVI_ID_PROJET` int(11) NOT NULL,
  `SVI_ID_UTI_ENREGISTREUR` int(11) NOT NULL,
  `SVI_ID_UTI_VALIDEUR` int(11) DEFAULT NULL,
  `SVI_ID_UTI_DP` int(11) DEFAULT NULL,
  `SVI_DATE_ENREGISTREMENT` datetime DEFAULT NULL,
  `SVi_DATE_VALIDATION` datetime DEFAULT NULL,
  PRIMARY KEY (`SVI_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `solutions_hebergement`
--

DROP TABLE IF EXISTS `solutions_hebergement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `solutions_hebergement` (
  `SHE_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SHE_LIBELLE` varchar(45) NOT NULL,
  `SHE_ID_HEBERGEUR` int(11) NOT NULL,
  `SHE_ADRESSE_PROXY` varchar(45) DEFAULT NULL,
  `SHE_MASQUE_PROXY` varchar(50) DEFAULT NULL,
  `SHE_PORT_PROXY` int(11) DEFAULT NULL,
  `SHE_DESCRIPTION` varchar(50) DEFAULT NULL,
  `SHE_ADRESSE_DNS1` varchar(45) DEFAULT NULL,
  `SHE_ADRESSE_DNS2` varchar(45) DEFAULT NULL,
  `SHE_IND_ACTIF` int(11) DEFAULT NULL,
  `SHE_NOM_DOMAINE` varchar(45) DEFAULT NULL,
  `SHE_ADMIN_DOMAINE` varchar(45) DEFAULT NULL,
  `SHE_MOTDEPASSE_DOMAINE` varchar(45) DEFAULT NULL,
  `SHE_PREFIXE_NOMMACHINE` varchar(45) NOT NULL,
  `SHE_TEXTEDEFINITIF_PHPIPAM` varchar(45) NOT NULL,
  `SHE_TEXTERESERVATION_PHPIPAM` varchar(45) NOT NULL,
  `SHE_ID_VIRTUALISATION` int(11) NOT NULL,
  `SHE_ID_TYPE_ENVIRONNEMENT` int(11) DEFAULT NULL,
  `SHE_URL_VIRTUALISATION` varchar(45) DEFAULT NULL,
  `SHE_COMPTE_VIRTUALISATION` varchar(45) DEFAULT NULL,
  `SHE_MOTDEPASSE_VIRTUALISATION` varchar(45) DEFAULT NULL,
  `SHE_DATE_CREATION` datetime DEFAULT NULL,
  `SHE_DATE_MODIFICATION` datetime DEFAULT NULL,
  `SHE_ID_CREATEUR` int(11) DEFAULT NULL,
  `SHE_ID_MODIFICATEUR` int(11) DEFAULT NULL,
  `SHE_NOMSECTION_PHPIPAM` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`SHE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `templates_os`
--

DROP TABLE IF EXISTS `templates_os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `templates_os` (
  `TOS_ID` int(11) NOT NULL AUTO_INCREMENT,
  `TOS_CODE_TEMPLATE` varchar(45) DEFAULT NULL,
  `TOS_LIBELLE_TEMPLATE` varchar(45) DEFAULT NULL,
  `TOS_DESCRIPTION_TEMPLATE` varchar(45) DEFAULT NULL,
  `TOS_DATE_CREATION` datetime DEFAULT NULL,
  `TOS_DATE_FIN_ACTIF` datetime DEFAULT NULL,
  `TOS_IND_ACTIF` tinyint(4) DEFAULT NULL,
  `TOS_ID_CREATEUR` int(11) NOT NULL,
  `TOS_ID_HEBERGEUR` int(11) NOT NULL,
  `TOS_ID_MODIFICATEUR` int(11) NOT NULL,
  `TOS_MINRAM` int(11) DEFAULT NULL,
  `TOS_MINCPU` int(11) DEFAULT NULL,
  `TOS_ID_OS` int(11) DEFAULT NULL,
  `TOS_MINDISQUE` varchar(45) DEFAULT NULL,
  `TOS_DATE_MODIFICATION` datetime DEFAULT NULL,
  PRIMARY KEY (`TOS_ID`),
  UNIQUE KEY `TEO_LIBELLE_TEMPLATE_UNIQUE` (`TOS_LIBELLE_TEMPLATE`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur` (
  `UTI_ID` int(11) NOT NULL AUTO_INCREMENT,
  `UTI_PRENOM` varchar(45) NOT NULL,
  `UTI_NOM` varchar(45) NOT NULL,
  `UTI_MAIL` varchar(45) NOT NULL,
  `UTI_TEL_BUR` varchar(45) DEFAULT NULL,
  `UTI_TEL_MOB` varchar(20) DEFAULT NULL,
  `UTI_DATE_CREATION` datetime NOT NULL,
  `UTI_DATE_CONNEXION` datetime NOT NULL,
  `UTI_LOGON_NAME` varchar(45) NOT NULL,
  `UTI_CODE_INGE` varchar(45) NOT NULL,
  PRIMARY KEY (`UTI_ID`),
  UNIQUE KEY `UTI_LOGON_NAME_UNIQUE` (`UTI_LOGON_NAME`),
  UNIQUE KEY `UTI_MAIL_UNIQUE` (`UTI_MAIL`),
  UNIQUE KEY `UTI_CODE_INGE_UNIQUE` (`UTI_CODE_INGE`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `utilisateur_a_role_utilisateur`
--

DROP TABLE IF EXISTS `utilisateur_a_role_utilisateur`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `utilisateur_a_role_utilisateur` (
  `URU_UTI_ID` int(11) NOT NULL,
  `URU_RRU_ID` int(11) NOT NULL,
  PRIMARY KEY (`URU_UTI_ID`,`URU_RRU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-01-16 11:52:31
