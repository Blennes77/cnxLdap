package com.cgihosting.constantes;

/**
 * Created by garnons on 06/12/2016.
 */
public class ConstantesAdmin {

    /**
     * Environnement
     */


    public static final String CODE_ENVIRONNEMENT_PROD = "PROD";
    public static final String CODE_ENVIRONNEMENT_DEV = "DEV";
    public static final String CODE_ENVIRONNEMENT_REC = "REC";
    public static final String CODE_ENVIRONNEMENT_PREPROD = "PREPROD";



    /**
     * Rôles
     */
    public static final int ROLE_ADMIN = 2;
    public static final int ROLE_EXPLOITANT = 3;
    public static final int ROLE_USER = 1;
    public static final int ROLE_DP = 4;

    public static final String LIBELLE_ROLE_ADMIN = "ROLE_ADMIN";
    public static final String LIBELLE_ROLE_EXPLOITANT = "ROLE_EXPLOIT";
    public static final String LIBELLE_ROLE_USER = "ROLE_USER";
    public static final String LIBELLE_ROLE_DP = "ROLE_DP";

    /**
     * Journalisation
     */
    public static final Integer JOURNAL_PREMIERE_CONNEXION = 1;
    public static final Integer JOURNAL_CONNEXION = 2;
    public static final Integer JOURNAL_MAUVAIS_MOT_DE_PASSE = 3;
    public static final Integer JOURNAL_VALIDATION_COMMANDE = 4;
    public static final Integer JOURNAL_MODIFICATION_PARAMETRESVCO = 5;
    public static final Integer JOURNAL_MODIFICATION_PARAMETRESAPPLI = 6;
    public static final Integer JOURNAL_AJOUT_HEBERGEUR = 7;
    public static final Integer JOURNAL_MODIFICATION_HEBERGEUR = 8;
    public static final Integer JOURNAL_INTERVENTION_EXPLOITATION = 9;
    public static final Integer JOURNAL_MODIFICATION_ROLES_UTILISATEUR = 10;
    public static final Integer JOURNAL_AJOUT_TEMPLATE = 11;
    public static final Integer JOURNAL_MODIFICATION_TEMPLATE = 12;
    public static final Integer JOURNAL_AJOUT_REF_JOURNAL= 13;
    public static final Integer JOURNAL_MODIFICATION_REF_JOURNAL = 14;
    public static final Integer JOURNAL_AJOUT_SERVEUR_VIRTUEL = 15;



}
