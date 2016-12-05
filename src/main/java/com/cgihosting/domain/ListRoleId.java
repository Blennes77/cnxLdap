package com.cgihosting.domain;

import javax.persistence.*;
import javax.validation.constraints.AssertFalse;
import java.util.Set;

/**
 * Created by garnons on 05/12/2016.
 */
@Entity
@Table(name = "appli_users_type_utilisateur")
public class ListRoleId {

    private int idRole;

    private User user;

    public ListRoleId(){}

    public ListRoleId(Integer idUser, User user){
        this.user = user;
        this.idRole = idRole;
    }

    @Id
    @Column(name="a_typeutils_clef")
    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @ManyToOne
    @JoinColumn(name="a_uti_user_cle")
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
