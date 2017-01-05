package com.cgihosting.formulaire.admin.gererRole;

import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.admin.ModeleFormulaire;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by garnons on 08/12/2016.
 */
public class AfficherUtilisateursFormulaire extends ModeleFormulaire {

    private List<UtilisateurDTO> utilisateurDTOList;
    private Page<UtilisateurDTO> utilisateurDTOPage;
    private int nbLigneAfficheParPage; // Y
    private int numPageCourante;       // X
    private Long numTotalUsers;         // Z
    private int numPageTotal;          // W

    public AfficherUtilisateursFormulaire(){}

    /*
    public AfficherUtilisateursFormulaire(int page, int ligneParPage, GererRoleService gererRoleService) {
        // Constructeur
        //gererRoleService = new GererRoleServiceImpl();
        this.gererRoleService = gererRoleService;

        //TODO : Nb d'utilisateurs Total
        this.numTotalUsers = gererRoleService.totalUsers();

        //TODO : Initialisation des attributs
        this.numPageCourante = page;
        this.nbLigneAfficheParPage = ligneParPage;
        this.numPageTotal = (int) Math.ceil((double) this.numTotalUsers / (double) this.nbLigneAfficheParPage);

        //TODO : Recherche des utilisateurs en fonction de la page et du nombre de ligne par page
        userPage = gererRoleService.searchAllUsersByPage(this.numPageCourante, this.nbLigneAfficheParPage);
    }
    */

    public List<UtilisateurDTO> getUtilisateurDTOList() {
        return utilisateurDTOList;
    }

    public void setUtilisateurDTOList(List<UtilisateurDTO> utilisateurDTOList) {
        this.utilisateurDTOList = utilisateurDTOList;
    }

    public Page<UtilisateurDTO> getUtilisateurDTOPage() {
        return utilisateurDTOPage;
    }

    public void setUtilisateurDTOPage(Page<UtilisateurDTO> utilisateurDTOPage) {
        this.utilisateurDTOPage = utilisateurDTOPage;
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

    public Long getNumTotalUsers() {
        return numTotalUsers;
    }

    public void setNumTotalUsers(Long numTotalUsers) {
        this.numTotalUsers = numTotalUsers;
    }

    public int getNumPageTotal() {
        return numPageTotal;
    }

    public void setNumPageTotal(int numPageTotal) {
        this.numPageTotal = numPageTotal;
    }
}
