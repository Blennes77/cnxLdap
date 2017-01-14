package com.cgihosting.domain.application;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by garnons on 05/12/2016.
 */
@Entity
@IdClass (RoleUtilisateurDTOPK.class)
@Table(name = "utilisateur_a_role_utilisateur")
public class RoleUtilisateurDTO implements Serializable{

    @Id
    @Column(name="URU_UTI_ID")
    private Integer idUser;

    @Id
    @Column(name="URU_RRU_ID")
    private Integer idRole;

    public RoleUtilisateurDTO() {
    }

    public RoleUtilisateurDTO(Integer idUser, Integer idRole) {
        this.idUser = idUser;
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
