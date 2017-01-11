package com.cgihosting.domain;

import java.io.Serializable;

/**
 * Created by marinib on 04/01/2017.
 */
public class RoleUtilisateurDTOPK implements Serializable{

    private Integer idUser;
    private Integer idRole;

    public RoleUtilisateurDTOPK() {

    }

    public RoleUtilisateurDTOPK(Integer idUser, Integer idRole) {

        this.idUser= idUser;
        this.idRole = idRole;

    }


    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }
}
