package com.cgihosting.domain;

import javax.persistence.*;

/**
 * Created by marinib on 12/01/2017.
 */

@Entity
@Table(name="ref_virtualisation")
public class TypeVirtualisationDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RVI_ID")
    private Integer id;

    @Column(name="RVI_NOM_VIRTUALISATION")
    private String nomVirtualisation = "";

    @Column(name="RVI_DESCRPTION_VIRTUALISATION")
    private String descriptionVirtualisation = "";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomVirtualisation() {
        return nomVirtualisation;
    }

    public void setNomVirtualisation(String nomVirtualisation) {
        this.nomVirtualisation = nomVirtualisation;
    }

    public String getDescriptionVirtualisation() {
        return descriptionVirtualisation;
    }

    public void setDescriptionVirtualisation(String descriptionVirtualisation) {
        this.descriptionVirtualisation = descriptionVirtualisation;
    }
}
