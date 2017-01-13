package com.cgihosting.objets;

/**
 * Created by marinib on 07/01/2017.
 */
public class PaginationObjet {


    /**
     * Pagination
     **/
    private Integer nbLigneAfficheParPage; // Y
    private Integer numPageCourante;       // X
    private Long numTotalLignes;         // Z
    private Integer numPageTotal;          // W


    public PaginationObjet(int nbLigneAfficheParPage, int numPageCourante, long numTotalLignes) {
        this.nbLigneAfficheParPage = nbLigneAfficheParPage;
        this.numPageCourante = numPageCourante;
        this.numTotalLignes = numTotalLignes;

        if (numTotalLignes > 0) {
            this.numPageTotal = (int) Math.ceil((double) numTotalLignes / (double) nbLigneAfficheParPage);

        } else {
            this.numPageTotal = 1;

        }
    }


    public Integer getNbLigneAfficheParPage() {
        return nbLigneAfficheParPage;
    }

    public void setNbLigneAfficheParPage(Integer nbLigneAfficheParPage) {
        this.nbLigneAfficheParPage = nbLigneAfficheParPage;
    }

    public Integer getNumPageCourante() {
        return numPageCourante;
    }

    public void setNumPageCourante(Integer numPageCourante) {
        this.numPageCourante = numPageCourante;
    }

    public Long getNumTotalLignes() {
        return numTotalLignes;
    }

    public void setNumTotalLignes(Long numTotalLignes) {
        this.numTotalLignes = numTotalLignes;
    }

    public Integer getNumPageTotal() {
        return numPageTotal;
    }

    public void setNumPageTotal(Integer numPageTotal) {
        this.numPageTotal = numPageTotal;
    }
}
