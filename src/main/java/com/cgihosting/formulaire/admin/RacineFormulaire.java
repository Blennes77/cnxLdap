package com.cgihosting.formulaire.admin;

import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.constantes.ConstantesPage;

/**
 * Created by marinib on 09/12/2016.
 */
public class RacineFormulaire {

 /** Attributs du formulaire **/
    private String titrePage;
    private String boutonSoumissionLabel;
    private String boutonRetourLabel;


    private static final String actionSauvegarder = ConstantesPage.ACTION_SAUVEGARDER;
    private static final String actionAnnuler = ConstantesPage.ACTION_ANNULER;

    private PaginationObjet paginationObjet;


    /** Getters et seters **/
    public static String getActionSauvegarder() {
        return actionSauvegarder;
    }

    public static String getActionAnnuler() {
        return actionAnnuler;
    }

    public String getTitrePage() {
        return titrePage;
    }

    public void setTitrePage(String titrePage) {
        this.titrePage = titrePage;
    }

    public String getBoutonSoumissionLabel() {
        return boutonSoumissionLabel;
    }

    public void setBoutonSoumissionLabel(String boutonSoumissionLabel) {
        this.boutonSoumissionLabel = boutonSoumissionLabel;
    }

    public String getBoutonRetourLabel() {
        return boutonRetourLabel;
    }

    public void setBoutonRetourLabel(String boutonRetourLabel) {
        this.boutonRetourLabel = boutonRetourLabel;
    }

    public PaginationObjet getPaginationObjet() {
        return paginationObjet;
    }

    public void setPaginationObjet(PaginationObjet paginationObjet) {
        this.paginationObjet = paginationObjet;
    }
}