package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="ref_type_environnement")
public class TypeEnvironnementDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RTE_ID")
    private int id;

    @Column(name="RTE_CODE_ENVIRONNEMENT")
    private String codeEnvironnement = "";

    @Column(name="RTE_DESCRIPTION_ENVIRONNEMENT")
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
