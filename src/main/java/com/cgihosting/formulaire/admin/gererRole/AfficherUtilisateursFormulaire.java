package com.cgihosting.formulaire;


import com.cgihosting.domain.UtilisateurDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by garnons on 08/12/2016.
 */
public class AfficherUtilisateursFormulaire {

    private List<UtilisateurDTO> utilisateurDTOListeAffiches;
    private int nbLigneAfficheParPage; // Y
    private int numPageCourante;       // X
    private Long numTotalUsers;         // Z
    private int numPageTotal;          // W

    private Page<UtilisateurDTO> userPage;

    public AfficherUtilisateursFormulaire(){}

    public AfficherUtilisateursFormulaire(int page, int ligneParPage) {
        // Constructeur


        //TODO : Initialisation des attributs
        this.numPageCourante = page;
        this.nbLigneAfficheParPage = ligneParPage;
    }

    public List<UtilisateurDTO> getUtilisateurDTOListeAffiches() {
        return utilisateurDTOListeAffiches;
    }

    public void setUtilisateurDTOListeAffiches(List<UtilisateurDTO> utilisateurDTOListeAffiches) {
        this.utilisateurDTOListeAffiches = utilisateurDTOListeAffiches;
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

    public int getNumPageTotal() {
        return numPageTotal;
    }

    public void setNumPageTotal(int numPageTotal) {
        this.numPageTotal = numPageTotal;
    }


    public Long getNumTotalUsers() {
        return numTotalUsers;
    }

    public void setNumTotalUsers(Long numTotalUsers) {
        this.numTotalUsers = numTotalUsers;
    }

    public Page<UtilisateurDTO> getUserPage() {
        return userPage;
    }

    public void setUserPage(Page<UtilisateurDTO> userPage) {
        this.userPage = userPage;
    }
}
