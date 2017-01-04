package com.cgihosting.domain;

import java.io.Serializable;

/**
 * Created by marinib on 04/01/2017.
 */
public class RoleUtilisateurDTOPK implements Serializable{

    private int idUser;
    private int idRole;

    public RoleUtilisateurDTOPK() {

    }

    public RoleUtilisateurDTOPK(int idUser, int idRole) {

        this.idUser= idUser;
        this.idRole = idRole;

    }


    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }
}
