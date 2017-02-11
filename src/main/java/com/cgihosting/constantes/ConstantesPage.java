package com.cgihosting.constantes;

/**
 * Created by marinib on 09/12/2016.
 */
public class ConstantesPage {



    /***************************************************************************************************
     *
     * A. Module COMMUN
     *
     ***************************************************************************************************/

    public static final String NOM_FORMULAIRE_HTML = "formulaire";
    public static final String NOM_FORMULAIRE_AJAX = "formulaireAjax";
    public static final String ACTION_SAUVEGARDER = "Sauvegarder";
    public static final String ACTION_ANNULER = "Annuler";


    /***************************************************************************************************
     *
     * B. Module INFORMATIONS PERSONNELLES
     *
     ***************************************************************************************************/

    /** Titre des pages **/
    public static final String AFFICHAGE_MESINFOS_PERSO_TITRE = "Mes informations personnelles";
    public static final String AFFICHAGE_MESPROJETS = "Mes projets";

    public static final String AFFICHAGE_MESSAGES_TITRE = "Mes messages";
    public static final String AFFICHAGE_COMMANDES_TITRE = "Mes commandes";
    public static final String DETAILS_COMMANDE_TITRE = "Mes commandes";

    public static final String AFFICHAGE_AJOUT_SERVEUR_TITRE = "Ajouter serveur";


    public static final String AFFICHAGE_SERVEURS_VIRTUELS_TITRE = "Mes serveurs virtuels";

    public static final String DETAIL_SERVEUR_VIRTUEL_TITRE = "Mon serveur virtuel";

    /** Noms des boutons **/

    public static final String BOUTON_RETOUR_LISTE_MESSAGES = "Retour liste de messages";
    public static final String BOUTON_RETOUR_LISTE_COMMANDES =  "Retour";

    public static final String BOUTON_RETOUR_AJOUT_SERVEUR =  "Retour";
    public static final String BOUTON_AJOUT_SERVEUR_ENREGISTRER =  "Enregistrer";

    public static final String BOUTON_MODIFIER_SERVEUR_VIRTUEL = "Modifier Serveur Virtuel";
    public static final String BOUTON_RETOUR_LISTE_SERVEURS_VIRTUELS = "Retour";

    /***************************************************************************************************
     *
     * C. Module EXPLOITATION
     *
     ***************************************************************************************************/

    /**
     * SOUS MENU : liste des serveurs virtuels
     **/

    /** Ecran Affichage liste des serveurs **/
    public static final String AFFICHAGE_LISTE_SERVEURS_VIRTUELS_TITRE = "Liste des serveurs virtuels commandés";
    public static final String AFFICHAGE_LISTE_SERVEURS_VIRTUELS_ACTION_ENTREE = "/exploit/afficherServeursVirtuels";
    public static final String AFFICHAGE_LISTE_SERVEURS_VIRTUELS_PAGE_HTML = "exploit/serveursVirtuels/afficherServeursVirtuels";

    /** Ecran détails serveurs virtuels **/
    public static final String DETAILS_SERVEURS_VIRTUELS_TITRE = "Serveur virtuel";
    public static final String DETAILS_SERVEURS_VIRTUELS_ACTION_ENTREE = "/exploit/afficherDetailsServeurVirtuel";
    public static final String DETAILS_SERVEURS_VIRTUELS_ACTION_MODIFIER = "/exploit/modifierServeurVirtuel";
    public static final String DETAILS_SERVEURS_VIRTUELS_PAGE_HTML = "exploit/serveursVirtuels/detailsServeurVirtuel";
    public static final String DETAILS_SERVEURS_VIRTUELS_BOUTON_MODIFIER = "Modifier Serveur Virtuel";
    public static final String DETAILS_SERVEURS_VIRTUELS_BOUTON_RETOUR = "Retour";

    /**
     * SOUS MENU : liste des commandes
     **/

    /** Ecran Affichage liste des serveurs **/
    public static final String AFFICHAGE_LISTE_COMMANDES_TITRE = "Liste des commandes";
    public static final String AFFICHAGE_LISTE_COMMANDES_ACTION_ENTREE = "/exploit/afficherCommandes";
    public static final String AFFICHAGE_LISTE_COMMANDES_PAGE_HTML = "exploit/commandes/afficherCommandes";

    /** Ecran détails serveurs virtuels **/
    public static final String DETAILS_COMMANDES_TITRE = "Serveur virtuel";
    public static final String DETAILS_COMMANDES_ACTION_ENTREE = "/exploit/afficherDetailsCommandes";
    public static final String DETAILS_COMMANDES_ACTION_MODIFIER = "/exploit/modifierCommande";
    public static final String DETAILS_COMMANDES_PAGE_HTML = "exploit/commandes/detailsCommandes";
    public static final String DETAILS_COMMANDES_BOUTON_MODIFIER = "Modifier commande";
    public static final String DETAILS_COMMANDES_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : liste des templates
     **/
    /** Ecran Affichage liste des templates **/
    public static final String AFFICHAGE_LISTE_TEMPLATES_OS_ACTION_ENTREE ="/exploit/afficherTemplateOS";
    public static final String AFFICHAGE_LISTE_TEMPLATES_OS_TITRE = "Liste des templates";
    public static final String AFFICHAGE_LISTE_TEMPLATES_OS_PAGE_HTML = "exploit/templatesOS/afficherTemplateOS";
    public static final String AFFICHAGE_LISTE_TEMPLATES_OS_BOUTON_AJOUTER = "Ajouter un template";
    public static final String AFFICHAGE_LISTE_TEMPLATES_OS_BOUTON_RETOUR = "Retour";

    /** Ecran Affichage détails des templates **/
    public static final String DETAILS_TEMPLATES_OS_ACTION_ENTREE = "/exploit/afficherDetailsTemplateOS";
    public static final String DETAILS_TEMPLATES_OS_ACTION_MODIFIER = "/exploit/modifierTemplateOS";
    public static final String DETAILS_TEMPLATES_OS_TITRE = "Template";
    public static final String DETAILS_TEMPLATES_OS_PAGE_HTML = "exploit/templatesOS/detailsTemplateOS";
    public static final String DETAILS_TEMPLATES_OS_BOUTON_AJOUTER = "Ajouter un template";
    public static final String DETAILS_TEMPLATES_OS_BOUTON_MODIFIER = "Modifier un template";
    public static final String DETAILS_TEMPLATES_OS_BOUTON_RETOUR = "Retour";

    /**
     * SOUS MENU : réferentiel des erreurs
     **/
    /** Ecran Affichage liste des erreurs rencontrées **/
    public static final String AFFICHAGE_LISTE_ERREURS_RENCONTREES_ACTION_ENTREE = "/exploit/afficherReferentielErreursRencontrees";
    public static final String AFFICHAGE_LISTE_ERREURS_RENCONTREES_TITRE = "Liste des erreurs générées";
    public static final String AFFICHAGE_LISTE_ERREURS_RENCONTREES_PAGE_HTML = "exploit/referentielErreursRencontrees/afficherReferentielErreursRencontrees";
    public static final String AFFICHAGE_LISTE_ERREURS_RENCONTREES_BOUTON_AJOUTER = "Ajouter une erreur type";
    public static final String AFFICHAGE_LISTE_ERREURS_RENCONTREES_BOUTON_RETOUR = "Retour";

    /** Ecran Affichage détails des erreurs rencontrées **/
    public static final String DETAILS_ERREURS_RENCONTREES_ACTION_ENTREE = "/exploit/afficherDetailsReferentielErreursRencontrees";
    public static final String DETAILS_ERREURS_RENCONTREES_ACTION_MODIFIER = "/exploit/modifierReferentielErreursRencontrees";
    public static final String DETAILS_ERREURS_RENCONTREES_PAGE_HTML = "exploit/referentielErreursRencontrees/detailsReferentielErreursRencontrees";
    public static final String DETAILS_ERREURS_RENCONTREES_TITRE = "Erreur type";
    public static final String DETAILS_ERREURS_RENCONTREES_BOUTON_AJOUTER = "Ajouter une erreur type";
    public static final String DETAILS_ERREURS_RENCONTREES_BOUTON_MODIFIER = "Modifier une erreur type";
    public static final String DETAILS_ERREURS_RENCONTREES_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : réferentiel des mails
     **/
    /** Ecran Affichage liste des mails**/
    public static final String AFFICHAGE_LISTE_MAILS_ACTION_ENTREE = "/exploit/afficherReferentielMails";
    public static final String AFFICHAGE_LISTE_MAILS_TITRE = "Liste des mails type";
    public static final String AFFICHAGE_LISTE_MAILS_PAGE_HTML = "exploit/referentielMails/afficherReferentielMails";
    public static final String AFFICHAGE_LISTE_MAILS_BOUTON_AJOUTER = "Ajouter un mail type";
    public static final String AFFICHAGE_LISTE_MAILS_BOUTON_RETOUR = "Retour";

    /** Ecran Affichage détails des mails **/
    public static final String DETAILS_MAILS_ACTION_ENTREE = "/exploit/afficherDetailsReferentielMails";
    public static final String DETAILS_MAILS_ACTION_MODIFIER = "/exploit/modifierReferentielMails";
    public static final String DETAILS_MAILS_TITRE = "Mail type";
    public static final String DETAILS_MAILS_PAGE_HTML = "exploit/referentielMails/detailsReferentielMails";
    public static final String DETAILS_MAILS_BOUTON_AJOUTER = "Modifier un mail type";
    public static final String DETAILS_MAILS_BOUTON_MODIFIER = "Modifier un mail type";
    public static final String DETAILS_MAILS_BOUTON_RETOUR = "Retour";





    /***************************************************************************************************
     *
     * D. Module ADMINISTRATION fonctionnel
     *
     ***************************************************************************************************/

    /**
     * SOUS MENU : Paramétrage appli
     **/

    /** Ecran Affichage paramétrage**/
    public static final String AFFICHAGE_PARAMETRAGE_ACTION_ENTREE = "/adminFonctionnel/afficherParametresAppli";
    public static final String AFFICHAGE_PARAMETRAGE_ACTION_MODIFIER = "/adminFonctionnel/modifierParametresAppli";
    public static final String AFFICHAGE_PARAMETRAGE_PAGE_HTML = "adminFonctionnel/parametres/afficherParametresAppli";

    public static final String AFFICHAGE_PARAMETRAGE_TITRE = "Paramétrage de l'application";
    public static final String AFFICHAGE_PARAMETRAGE_MESSAGE_ERREUR = "Impossible d'enregistrer les données de paramétrage, les données saisies ne sont pas valides";
    public static final String AFFICHAGE_PARAMETRAGE_BOUTON_ENREGISTRER = "Enregistrer paramètres";


    /**
     * SOUS MENU : liste des hebergeur
     **/

    /** Ecran Affichage liste des hébergeurs **/
    public static final String AFFICHAGE_LISTE_HEBERGEURS_ACTION_ENTREE = "/adminFonctionnel/afficherReferentielHebergeurs";
    public static final String AFFICHAGE_LISTE_HEBERGEURS_TITRE= "Liste des hébergeurs";
    public static final String AFFICHAGE_LISTE_HEBERGEURS_PAGE_HTML = "adminFonctionnel/referentielHebergeurs/afficherReferentielHebergeurs";
    public static final String AFFICHAGE_LISTE_HEBERGEURS_BOUTON_AJOUTER= "Ajouter un hébergeur";
    public static final String AFFICHAGE_LISTE_HEBERGEURS_BOUTON_MODIFIER = "Modifier hébergeur";

    /** Ecran détails hébergeurs **/
    public static final String DETAILS_HEBERGEURS_ACTION_ENTREE = "/adminFonctionnel/afficherDetailsReferentielHebergeurs";
    public static final String DETAILS_HEBERGEURS_ACTION_MODIFIER = "/adminFonctionnel/modifierReferentielHebergeurs";
    public static final String DETAILS_HEBERGEURS_TITRE = "Hébergeur";
    public static final String DETAILS_HEBERGEURS_MESSAGE_ERREUR = "Impossible d'enregistrer un hébergeur, les données saisies ne sont pas valides";

    public static final String DETAILS_HEBERGEURS_PAGE_HTML = "adminFonctionnel/referentielHebergeurs/detailsReferentielHebergeur";
    public static final String DETAILS_HEBERGEURS_BOUTON_AJOUTER = "Ajouter un  hébergeur";
    public static final String DETAILS_HEBERGEURS_BOUTON_MODIFIER = "Modifier hébergeur";
    public static final String DETAILS_HEBERGEURS_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : réferentiel produits
     **/
    public static final String AFFICHAGE_LISTE_PRODUITS_TITRE = "Liste des projets CGI";


    /**
     * SOUS MENU : réferentiel produits
     **/

    public static final String AFFICHAGE_LISTE_PROJETS_TITRE = "Liste des projets CGI";

    /**
     * SOUS MENU : liste des solutions hébergement
     **/

    /** Ecran Affichage liste des hébergeurs **/
    public static final String AFFICHAGE_LISTE_SOLUTIONS_HEBERGEMENT_ACTION_ENTREE = "/adminFonctionnel/afficherSolutionsHebergement";
    public static final String AFFICHAGE_LISTE_SOLUTIONS_HEBERGEMENT_TITRE = "Liste des solutions hébergement";
    public static final String AFFICHAGE_LISTE_SOLUTIONS_HEBERGEMENT_PAGE_HTML = "adminFonctionnel/solutionsHebergement/afficherSolutionsHebergement";
    public static final String AFFICHAGE_LISTE_SOLUTIONS_HEBERGEMENT_BOUTON_AJOUTER= "Ajouter une solution d'hébergement";
    public static final String AFFICHAGE_LISTE_SOLUTIONS_HEBERGEMENT_BOUTON_MODIFIER = "Modifier la solution d'hébergement";

    /** Ecran détails hébergeurs **/
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_ACTION_ENTREE = "/adminFonctionnel/afficherDetailsSolutionsHebergement";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_ACTION_MODIFIER = "/adminFonctionnel/modifierSolutionsHebergement";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_TITRE = "Hébergement";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_MESSAGE_ERREUR = "Impossible d'enregistrer un hébergement, les données saisies ne sont pas valides";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_PAGE_HTML = "adminFonctionnel/solutionsHebergement/detailsSolutionsHebergement";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_BOUTON_AJOUTER = "Ajouter un  hébergement";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_BOUTON_MODIFIER = "Modifier hébergement";
    public static final String DETAILS_SOLUTIONS_HEBERGEMENT_BOUTON_RETOUR = "Retour";


    /** Ecran Affichage liste des utilisateurs **/
    public static final String AFFICHAGE_LISTE_UTILISATEURS_ACTION_ENTREE= "/adminFonctionnel/afficherUtilisateurs";
    public static final String AFFICHAGE_LISTE_UTILISATEURS_TITRE= "Liste des utilisateurs";
    public static final String AFFICHAGE_LISTE_UTILISATEURS_PAGE_HTML= "adminFonctionnel/utilisateurs/afficherUtilisateurs";

    /** Ecran rôles **/
    public static final String DETAILS_ROLES_ACTION_ENTREE = "/adminFonctionnel/afficherDetailsUtilisateur";
    public static final String DETAILS_ROLES_ACTION_MODIFIER = "/adminFonctionnel/modifierDetailsUtilisateur";
    public static final String DETAILS_ROLES_TITRE = "Rôles utilisateur";
    public static final String DETAILS_ROLES_MESSAGE_ERREUR = "Impossible d'enregistrer les rôles, les données saisies ne sont pas valides";
    public static final String DETAILS_ROLES_PAGE_HTML = "adminFonctionnel/utilisateurs/detailsUtilisateur";
    public static final String DETAILS_ROLES_BOUTON_MODIFIER = "Modifier les rôles";
    public static final String DETAILS_ROLES_BOUTON_RETOUR = "Retour";


    /** Ecran Affichage liste des êvenements **/
    public static final String AFFICHAGE_LISTE_EVENEMENT_ACTION_ENTREE= "/adminFonctionnel/afficherJournalisation";
    public static final String AFFICHAGE_LISTE_EVENEMENT_TITRE= "Liste des êvenements";
    public static final String AFFICHAGE_LISTE_EVENEMENT_PAGE_HTML= "adminFonctionnel/journalisation/afficherJournalisation";









    /***************************************************************************************************
     *
     * D. Module ADMINISTRATION technique
     *
     ***************************************************************************************************/

    /**
     * SOUS MENU : liste des rôles
     **/

    /** Ecran Affichage liste des rôles **/
    public static final String AFFICHAGE_LISTE_ROLES_UTILISATEUR_ACTION_ENTREE = "/adminTechnique/afficherReferentielRolesUtilisateur";
    public static final String AFFICHAGE_LISTE_ROLES_UTILISATEUR_TITRE= "Liste des rôles utilisateur";
    public static final String AFFICHAGE_LISTE_ROLES_UTILISATEUR_PAGE_HTML = "adminTechnique/referentielRolesutilisateur/afficherReferentielRolesUtilisateur";
    public static final String AFFICHAGE_LISTE_ROLES_UTILISATEUR_BOUTON_AJOUTER= "Ajouter un rôle";

    /** Ecran détails rôle **/
    public static final String DETAILS_ROLES_UTILISATEUR_ACTION_ENTREE =  "/adminTechnique/afficherDetailsReferentielRolesUtilisateur";
    public static final String DETAILS_ROLES_UTILISATEUR_ACTION_MODIFIER =  "/adminTechnique/modifierReferentielRolesUtilisateur";
    public static final String DETAILS_ROLES_UTILISATEUR_TITRE = "Rôle utilisateur";
    public static final String DETAILS_ROLES_UTILISATEUR_MESSAGE_ERREUR = "Impossible d'enregistrer un rôle, les données saisies ne sont pas valides";
    public static final String DETAILS_ROLES_UTILISATEUR_PAHGE_HTML = "adminTechnique/referentielRolesUtilisateur/detailsReferentielRolesutilisateur";
    public static final String DETAILS_ROLES_UTILISATEUR_BOUTON_AJOUTER = "Ajouter un rôle";
    public static final String DETAILS_ROLES_UTILISATEUR_BOUTON_MODIFIER = "Modifier un rôle";
    public static final String DETAILS_ROLES_UTILISATEUR_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : liste des états de traitement serveur
     **/

    /** Ecran Affichage liste d' états traitement **/
    public static final String AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_ACTION_ENTREE= "/adminTechnique/afficherReferentielEtatTraitementServeur";
    public static final String AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_TITRE= "Liste des états de traitement serveur";
    public static final String AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_PAGE_HTML= "adminTechnique/referentielEtatTraitementServeur/afficherReferentielEtatTraitementServeur";
    public static final String AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_BOUTON_AJOUTER= "Ajouter un état traitement";

    /** Ecran détails états traitement **/
    public static final String DETAILS_ETATTRAITEMENT_ACTION_ENTREE = "/adminTechnique/afficherDetailsReferentielEtatTraitementServeur";
    public static final String DETAILS_ETATTRAITEMENT_ACTION_MODIFIER = "/adminTechnique/modifierReferentielEtatTraitementServeur";
    public static final String DETAILS_ETATTRAITEMENT_SERVEURS_TITRE = "Etat traitement";
    public static final String DETAILS_ETATTRAITEMENT_MESSAGE_ERREUR = "Impossible d'enregistrer un état traitement, les données saisies ne sont pas valides";
    public static final String DETAILS_ETATTRAITEMENT_SERVEURS_PAGE_HTML = "adminTechnique/referentielEtatTraitementServeur/detailsReferentielEtatTraitementServeur";
    public static final String DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_AJOUTER = "Ajouter un état traitement";
    public static final String DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_MODIFIER = "Modifier un état traitement";
    public static final String DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : liste des états de traitement serveur
     **/

    /** Ecran Affichage liste d' états traitement **/
    public static final String AFFICHAGE_LISTE_ETATCOMMANDE_ACTION_ENTREE= "/adminTechnique/afficherReferentielEtatCommande";
    public static final String AFFICHAGE_LISTE_ETATCOMMANDE_TITRE= "Liste des états de commande";
    public static final String AFFICHAGE_LISTE_ETATCOMMANDE_PAGE_HTML= "adminTechnique/referentielEtatCommande/afficherReferentielEtatCommande";
    public static final String AFFICHAGE_LISTE_ETATCOMMANDE_BOUTON_AJOUTER= "Ajouter un état commande";

    /** Ecran détails états traitement **/
    public static final String DETAILS_ETATCOMMANDE_ACTION_ENTREE = "/adminTechnique/afficherDetailsReferentielEtatCommande";
    public static final String DETAILS_ETATCOMMANDE_ACTION_MODIFIER = "/adminTechnique/modifierReferentielEtatCommande";
    public static final String DETAILS_ETATCOMMANDE_TITRE = "Etat commande";
    public static final String DETAILS_ETATCOMMANDE_MESSAGE_ERREUR = "Impossible d'enregistrer un état commande, les données saisies ne sont pas valides";
    public static final String DETAILS_ETATCOMMANDE_PAGE_HTML = "adminTechnique/referentielEtatCommande/detailsReferentielEtatCommande";
    public static final String DETAILS_ETATCOMMANDE_BOUTON_AJOUTER = "Ajouter un état commande";
    public static final String DETAILS_ETATCOMMANDE_BOUTON_MODIFIER = "Modifier un état commande";
    public static final String DETAILS_ETATCOMMANDE_BOUTON_RETOUR = "Retour";



    /**
     * SOUS MENU : liste des actions workflows
     **/

    /** Ecran Affichage liste des actions workflow **/
    public static final String AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_ACTION_ENTREE= "/adminTechnique/afficherReferentielActionsWorkflows";
    public static final String AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_TITRE= "Liste des actions workflows";
    public static final String AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_PAGE_HTML= "adminTechnique/referentielActionsWorkflows/afficherReferentielActionsWorkflows";
    public static final String AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_BOUTON_AJOUTER= "Ajouter une action";

    /** Ecran détails actions workflows **/
    public static final String DETAILS_ACTIONS_WORKFLOWS_ACTION_ENTREE = "/adminTechnique/afficherDetailsReferentielActionsWorkflows";
    public static final String DETAILS_ACTIONS_WORKFLOWS_ACTION_MODIFIER = "/adminTechnique/modifierReferentielActionsWorkflows";
    public static final String DETAILS_ACTIONS_WORKFLOWS_TITRE = "Action workflow";
    public static final String DETAILS_ACTIONS_WORKFLOWS_MESSAGE_ERREUR = "Impossible d'enregistrer une action workflow, les données saisies ne sont pas valides";
    public static final String DETAILS_ACTIONS_WORKFLOWS_PAGE_HTML = "adminTechnique/referentielActionsWorkflows/detailsReferentielActionsWorkflows";
    public static final String DETAILS_ACTIONS_WORKFLOWS_BOUTON_AJOUTER = "Ajouter une action";
    public static final String DETAILS_ACTIONS_WORKFLOWS_BOUTON_MODIFIER = "Modifier une action";
    public static final String DETAILS_ACTIONS_WORKFLOWS_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : liste journalisation
     **/

    /** Ecran Affichage liste des êvenements **/
    public static final String AFFICHAGE_LISTE_REFERENTIEL_JOURNALISATION_ACTION_ENTREE= "/adminTechnique/afficherReferentielJournalisation";
    public static final String AFFICHAGE_LISTE_REFERENTIEL_JOURNALISATION_TITRE= "Référentiel Journalisation";
    public static final String AFFICHAGE_LISTE_REFERENTIEL_JOURNALISATION_PAHE_HTML= "adminTechnique/referentielJournalisation/afficherReferentielJournalisation";
    public static final String AFFICHAGE_LISTE_REFERENTIEL_JOURNALISATION_BOUTON_AJOUTER= "Ajouter un evênement";

    /** Ecran détails evênements **/
    public static final String DETAILS_REFERENTIEL_JOURNALISATION_ACTION_ENTREE = "/adminTechnique/afficherDetailsReferentielJournalisation";
    public static final String DETAILS_REFERENTIEL_JOURNALISATION_ACTION_MODIFIER = "/adminTechnique/enregistrerReferentielJournalisation";
    public static final String DETAILS_REFERENTIEL_JOURNALISATION_TITRE = "Evênement";
    public static final String DETAILS_REFERENTIEL_OURNALISATION_MESSAGE_ERREUR = "Impossible d'enregistrer un type de journalisation, les données saisies ne sont pas valides";

    public static final String DETAILS_REFERENTIEL_JOURNALISATION_PAGE_HTML = "adminTechnique/referentielJournalisation/detailsReferentielJournalisation";
    public static final String DETAILS_REFERENTIEL_JOURNALISATION_BOUTON_AJOUTER = "Ajouter un evênement";
    public static final String DETAILS_REFERENTIEL_JOURNALISATION_BOUTON_MODIFIER = "Modifier un evênement";
    public static final String DETAILS_REFERENTIEL_JOURNALISATION_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : liste OS
     **/

    /** Ecran Affichage liste OS **/
    public static final String AFFICHAGE_LISTE_OS_ACTION_ENTREE= "/adminTechnique/afficherReferentielOS";
    public static final String AFFICHAGE_LISTE_OS_TITRE= "Liste des OS";
    public static final String AFFICHAGE_LISTE_OS_PAGE_HTML= "adminTechnique/referentielSystemesExploitation/afficherReferentielOS";
    public static final String AFFICHAGE_LISTE_OS_BOUTON_AJOUTER= "Ajouter un OS";

    /** Ecran détails OS **/
    public static final String DETAILS_OS_ACTION_ENTREE = "/adminTechnique/afficherDetailsReferentielOS";
    public static final String DETAILS_OS_ACTION_MODIFIER = "/adminTechnique/modifierReferentielOS";
    public static final String DETAILS_OS_TITRE = "Système d'exploitation";
    public static final String DETAILS_OS_MESSAGE_ERREUR = "Impossible d'enregistrer un système d'exploitation, les données saisies ne sont pas valides";
    public static final String DETAILS_OS_PAGE_HTML = "adminTechnique/referentielSystemesExploitation/detailsReferentielOS";
    public static final String DETAILS_OS_BOUTON_AJOUTER = "Ajouter un OS";
    public static final String DETAILS_OS_BOUTON_MODIFIER = "Modifier un OS";
    public static final String DETAILS_OS_BOUTON_RETOUR = "Retour";


    /**
     * SOUS MENU : liste virtualisation
     **/

    /** Ecran Affichage liste OS **/
    public static final String AFFICHAGE_LISTE_VIRTUALISATION_ACTION_ENTREE= "/adminTechnique/afficherReferentielVirtualisation";
    public static final String AFFICHAGE_LISTE_VIRTUALISATION_TITRE= "Liste des types de virtualisation";
    public static final String AFFICHAGE_LISTE_VIRTUALISATION_PAGE_HTML= "adminTechnique/referentielVirtualisation/afficherReferentielVirtualisation";
    public static final String AFFICHAGE_LISTE_VIRTUALISATION_BOUTON_AJOUTER= "Ajouter une virtualisation";

    /** Ecran détails OS **/
    public static final String DETAILS_VIRTUALISATION_ACTION_ENTREE = "/adminTechnique/afficherDetailsReferentielVirtualisation";
    public static final String DETAILS_VIRTUALISATION_ACTION_MODIFIER = "/adminTechnique/modifierReferentielVirtualisation";
    public static final String DETAILS_VIRTUALISATION_TITRE = "Type de virtualisation ";
    public static final String DETAILS_VIRTUALISATION_MESSAGE_ERREUR = "Impossible d'enregistrer un type de virtualisation, les données saisies ne sont pas valides";
    public static final String DETAILS_VIRTUALISATION_PAGE_HTML = "adminTechnique/referentielVirtualisation/detailsReferentielVirtualisation";
    public static final String DETAILS_VIRTUALISATION_BOUTON_AJOUTER = "Ajouter une virtualisation";
    public static final String DETAILS_VIRTUALISATION_BOUTON_MODIFIER = "Modifier une virtualisation";
    public static final String DETAILS_VIRTUALISATION_BOUTON_RETOUR = "Retour";

}
