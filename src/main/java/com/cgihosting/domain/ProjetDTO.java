package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="ref_projets")
public class ProjetDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="PRO_ID")
    private Integer id;

    @Column(name="PRO_UTI_ID")
    private Integer idUser;

    @Column(name="PRO_CODE_PROJET")
    private String codeProjet;

    @Column(name="PRO_NOM_PROJET")
    private String nomProjet;

    @Column(name="PRO_CODE_INGE")
    private String codeInge;

    @Column(name="PRO_NOMDP")
    private String nomDP;

    @Column(name="PRO_PRENOMDP")
    private String prenomDP;

    @Column(name="PRO_MAILDP")
    private String mailDP;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getCodeProjet() {
        return codeProjet;
    }

    public void setCodeProjet(String codeProjet) {
        this.codeProjet = codeProjet;
    }

    public String getNomProjet() {
        return nomProjet;
    }

    public void setNomProjet(String nomProjet) {
        this.nomProjet = nomProjet;
    }

    public String getCodeInge() {
        return codeInge;
    }

    public void setCodeInge(String codeInge) {
        this.codeInge = codeInge;
    }

    public String getNomDP() {
        return nomDP;
    }

    public void setNomDP(String nomDP) {
        this.nomDP = nomDP;
    }

    public String getPrenomDP() {
        return prenomDP;
    }

    public void setPrenomDP(String prenomDP) {
        this.prenomDP = prenomDP;
    }

    public String getMailDP() {
        return mailDP;
    }

    public void setMailDP(String mailDP) {
        this.mailDP = mailDP;
    }
}
