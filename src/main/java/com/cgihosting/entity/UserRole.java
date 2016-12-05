package com.cgihosting.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * Created by garnons on 05/12/2016.
 */
@Entity
@Table(name="appli_utilisateurs_type_utilisateurs")
public class UserRole {
    @NotNull
    @Column(name="a_uti_cle")
    private int idUser;

    @NotNull
    @Column(name="a_typeutil_clef")
    private int idRole;

    @OneToOne
    private UserType libelleRole;

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
