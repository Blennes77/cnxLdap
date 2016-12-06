package com.cgihosting.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.InterruptedIOException;
import java.io.Serializable;

/**
 * Created by garnons on 06/12/2016.
 */
@Entity
@Table(name="ref_role_utilisateur")
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="RRU_ID")
    private int id;

    @Column(name="RRU_LIBELLE_ROLE")
    @NotNull
    private String libelleRole;

    public Role() {
    }

    public Role(int id){
        this.id = id;
    }

    public Role(String libelleRole) {
        this.libelleRole = libelleRole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleRole() {
        return libelleRole;
    }

    public void setLibelleRole(String libelleRole) {
        this.libelleRole = libelleRole;
    }
}
