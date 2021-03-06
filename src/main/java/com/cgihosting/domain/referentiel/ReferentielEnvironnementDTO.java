package com.cgihosting.domain.referentiel;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="referentiel_environnement")
public class ReferentielEnvironnementDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="REN_ID")
    private int id;

    @NotNull
    @NotEmpty
    @Size(min=10, max = 100)
    @Column(name="REN_CODE_ENVIRONNEMENT")
    private String codeEnvironnement = "";

    @NotNull
    @NotEmpty
    @Size(min=10, max = 100)
    @Column(name="REN_DESCRIPTION_ENVIRONNEMENT")
    private String descriptionEnvironnement = "";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeEnvironnement() {
        return codeEnvironnement;
    }

    public void setCodeEnvironnement(String codeEnvironnement) {
        this.codeEnvironnement = codeEnvironnement;
    }

    public String getDescriptionEnvironnement() {
        return descriptionEnvironnement;
    }

    public void setDescriptionEnvironnement(String descriptionEnvironnement) {
        this.descriptionEnvironnement = descriptionEnvironnement;
    }
}
