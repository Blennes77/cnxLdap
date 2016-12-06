package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by garnons on 05/12/2016.
 */
@Entity
@Table(name = "utilisateur_a_role_utilisateur")
public class UserRole implements Serializable{

    @Id
    @Column(name="URU_UTI_ID")
    private int idUser;

    //@Id
    @Column(name="URU_RRU_ID")
    private int idRole;

    public UserRole() {
    }

    public UserRole(int idUser, int idRole) {
        this.idUser = idUser;
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
