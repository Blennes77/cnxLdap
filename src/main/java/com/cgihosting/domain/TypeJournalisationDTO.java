package com.cgihosting.domain;

import javax.persistence.*;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="ref_type_journalisation")
public class TypeJournalisationDTO {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RTJ_ID")
    private int id;

    @Column(name="RTJ_ACTION_LIBELLE")
    private String libelleAction = "";

    @Column(name="RTJ_DESCRIPTION")
    private String description = "";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelleAction() {
        return libelleAction;
    }

    public void setLibelleAction(String libelleAction) {
        this.libelleAction = libelleAction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
