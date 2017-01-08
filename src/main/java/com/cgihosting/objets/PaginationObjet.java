package com.cgihosting.objets;

/**
 * Created by marinib on 07/01/2017.
 */
public class PaginationObjet {


    /** Pagination **/
    private int nbLigneAfficheParPage; // Y
    private int numPageCourante;       // X
    private Long numTotalLignes;         // Z
    private int numPageTotal;          // W


    public PaginationObjet(int nbLigneAfficheParPage, int numPageCourante, long numTotalLignes) {
        this.nbLigneAfficheParPage = nbLigneAfficheParPage;
        this.numPageCourante = numPageCourante;
        this.numTotalLignes = numTotalLignes;
        this.numPageTotal = (int) Math.ceil((double) numTotalLignes / (double) nbLigneAfficheParPage);
    }


    public int getNbLigneAfficheParPage() {
        return nbLigneAfficheParPage;
    }

    public void setNbLigneAfficheParPage(int nbLigneAfficheParPage) {
        this.nbLigneAfficheParPage = nbLigneAfficheParPage;
    }

    public int getNumPageCourante() {
        return numPageCourante;
    }

    public void setNumPageCourante(int numPageCourante) {
        this.numPageCourante = numPageCourante;
    }

    public Long getNumTotalLignes() {
        return numTotalLignes;
    }

    public void setNumTotalLignes(Long numTotalLignes) {
        this.numTotalLignes = numTotalLignes;
    }

    public int getNumPageTotal() {
        return numPageTotal;
    }

    public void setNumPageTotal(int numPageTotal) {
        this.numPageTotal = numPageTotal;
    }
}
