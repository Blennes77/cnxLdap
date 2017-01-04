package com.cgihosting.constantes;

/**
 * Created by garnons on 06/12/2016.
 */
public class ConstantesAdmin {

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



}
