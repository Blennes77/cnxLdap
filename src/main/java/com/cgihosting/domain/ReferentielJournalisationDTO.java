package com.cgihosting.domain;

import javax.persistence.*;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="referentiel_journalisation")
public class ReferentielJournalisationDTO {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RJO_ID")
    private Integer id;

    @Column(name="RJO_ACTION_LIBELLE")
    private String libelleAction = "";

    @Column(name="RJO_DESCRIPTION")
    private String description = "";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
