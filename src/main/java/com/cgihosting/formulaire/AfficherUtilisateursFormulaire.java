package com.cgihosting.formulaire;

import com.cgihosting.domain.User;
import com.cgihosting.service.GererRoleService;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by garnons on 08/12/2016.
 */
public class AfficherUtilisateursFormulaire {
    private GererRoleService gererRoleService;

    private List<User> userList;
    private Page<User> userPage;
    private int nbLigneAfficheParPage; // Y
    private int numPageCourante;       // X
    private Long numTotalUsers;         // Z
    private int numPageTotal;          // W

    public AfficherUtilisateursFormulaire(){}

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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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

    public Page<User> getUserPage() {
        return userPage;
    }

    public void setUserPage(Page<User> userPage) {
        this.userPage = userPage;
    }

    public Long getNumTotalUsers() {
        return numTotalUsers;
    }

    public void setNumTotalUsers(Long numTotalUsers) {
        this.numTotalUsers = numTotalUsers;
    }


}
