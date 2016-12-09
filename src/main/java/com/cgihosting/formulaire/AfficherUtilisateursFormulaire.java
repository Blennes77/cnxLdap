package com.cgihosting.formulaire;

import com.cgihosting.domain.User;

import java.util.List;

/**
 * Created by garnons on 08/12/2016.
 */
public class AfficherUtilisateursFormulaire {
    private List<User> userList;
    private int nbLigneAfficheParPage;
    private int numPageCourante;
    private int numPageTotal;

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
}
