package com.cgihosting.domain;

import javax.persistence.*;

/**
 * Created by marinib on 03/01/2017.
 */

@Entity
@Table(name="ref_etattraitement_serveur")

public class EtatTraitementServeurDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="RES_ID")
    private int id;

    @Column(name="RES_CODE")
    private String code = "";

    @Column(name="RES_DESCRIPTION")
    private String description = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
