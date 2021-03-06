package com.cgihosting.domain.application;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by garnons on 02/12/2016. Classe utilisateur
 */

@Entity
@Table(name="utilisateur")
public class UtilisateurDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="UTI_ID")
    private Integer id;

    @Column(name="UTI_PRENOM")
    @NotNull
    private String prenom ="";

    @Column(name="UTI_NOM")
    @NotNull
    private String nom = "";

    @Column(name="UTI_MAIL")
    @NotNull
    private String mail;

    @Column(name="UTI_TEL_BUR")
    private String telephoneBureau;

    @Column(name="UTI_TEL_MOB")
    private String telephoneMobile;

    @Column(name="UTI_DATE_CREATION")
    @NotNull
    private Date dateCreation;

    @Column(name="UTI_DATE_CONNEXION")
    @NotNull
    private Date dateConnexion;

    @Column(name="UTI_LOGON_NAME")
    @NotNull
    private String logonName;

    @Column(name="UTI_CODE_INGE")
    @NotNull
    private String codeIngenieur;

    public UtilisateurDTO() {
    }

    public UtilisateurDTO(String prenom, String nom, String mail, String telephoneBureau, String telephoneMobile,
                Date dateCreation, Date dateConnexion, String logonName, String codeIngenieur) {
        this.prenom = prenom;
        this.nom = nom;
        this.mail = mail;
        this.telephoneBureau = telephoneBureau;
        this.telephoneMobile = telephoneMobile;
        this.dateCreation = dateCreation;
        this.dateConnexion = dateConnexion;
        this.logonName = logonName;
        this.codeIngenieur = codeIngenieur;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelephoneBureau() {
        return telephoneBureau;
    }

    public void setTelephoneBureau(String telephoneBureau) {
        this.telephoneBureau = telephoneBureau;
    }

    public String getTelephoneMobile() {
        return telephoneMobile;
    }

    public void setTelephoneMobile(String telephoneMobile) {
        this.telephoneMobile = telephoneMobile;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateConnexion() {
        return dateConnexion;
    }

    public void setDateConnexion(Date dateConnexion) {
        this.dateConnexion = dateConnexion;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public String getCodeIngenieur() {
        return codeIngenieur;
    }

    public void setCodeIngenieur(String codeIngenieur) {
        this.codeIngenieur = codeIngenieur;
    }



}
