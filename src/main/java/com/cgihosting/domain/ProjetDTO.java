package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="projets")
public class ProjetDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PRO_ID")
    private int id;

    @Column(name="PRO_CODE_PROJET")
    private String codeProjet;

    @Column(name="PRO_NOM_PROJET")
    private String nomProjet;

    @Column(name="PRO_LOGINDP")
    private String loginDP;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeProjet() {
        return codeProjet;
    }

    public void setCodeProjet(String codeProjet) {
        this.codeProjet = codeProjet;
    }

    public String getLoginDP() {
        return loginDP;
    }

    public void setLoginDP(String loginDP) {
        this.loginDP = loginDP;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }
}
