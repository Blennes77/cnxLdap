package com.cgihosting.domain.referentiel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by marinib on 03/02/2017.
 */

@Entity
@Table(name="referentiel_ind_actif")
public class ReferentielIndActifDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RIA_ID")
    private Integer id;


    @NotNull
    @Column(name="RIA_LIBELLE")
    private String libelle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
