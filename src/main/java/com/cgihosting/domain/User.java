package com.cgihosting.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Set;

/**
 * Created by garnons on 02/12/2016.
 */

@Entity
@Table(name="appli_utilisateurs")
public class User {

    private int a_uti_cle;
    private String a_uti_prenom;
    private String a_uti_nom;
    private String a_uti_mail;
    private String a_uti_telephone_fixe;
    private String a_uti_telephone_mobi;
    private Date a_uti_date_creation;
    private int a_uti_type_utilisateur;
    private String a_uti_code_cgi;
    private String identi;

    private Set<ListRoleId> listRoleId;

    public User() {
    }

    public User(String a_uti_prenom, String a_uti_nom, String a_uti_mail, String a_uti_telephone_fixe, String a_uti_telephone_mobi, Date a_uti_date_creation, int a_uti_type_utilisateur, String identi, String a_uti_code_cgi) {
        this.a_uti_prenom = a_uti_prenom;
        this.a_uti_nom = a_uti_nom;
        this.a_uti_mail = a_uti_mail;
        this.a_uti_telephone_fixe = a_uti_telephone_fixe;
        this.a_uti_telephone_mobi = a_uti_telephone_mobi;
        this.a_uti_date_creation = a_uti_date_creation;
        this.a_uti_type_utilisateur = a_uti_type_utilisateur;
        this.identi = identi;
        this.a_uti_code_cgi = a_uti_code_cgi;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getA_uti_cle() {
        return a_uti_cle;
    }

    public void setA_uti_cle(int a_uti_cle) {
        this.a_uti_cle = a_uti_cle;
    }

    @NotNull
    public String getA_uti_prenom() {
        return a_uti_prenom;
    }

    public void setA_uti_prenom(String a_uti_prenom) {
        this.a_uti_prenom = a_uti_prenom;
    }

    @NotNull
    public String getA_uti_nom() {
        return a_uti_nom;
    }

    public void setA_uti_nom(String a_uti_nom) {
        this.a_uti_nom = a_uti_nom;
    }

    @NotNull
    public String getA_uti_mail() {
        return a_uti_mail;
    }

    public void setA_uti_mail(String a_uti_mail) {
        this.a_uti_mail = a_uti_mail;
    }

    @Null
    public String getA_uti_telephone_fixe() {
        return a_uti_telephone_fixe;
    }

    public void setA_uti_telephone_fixe(String a_uti_telephone_fixe) {
        this.a_uti_telephone_fixe = a_uti_telephone_fixe;
    }

    @Null
    public String getA_uti_telephone_mobi() {
        return a_uti_telephone_mobi;
    }

    public void setA_uti_telephone_mobi(String a_uti_telephone_mobi) {
        this.a_uti_telephone_mobi = a_uti_telephone_mobi;
    }

    @Null
    public Date getA_uti_date_creation() {
        return a_uti_date_creation;
    }

    public void setA_uti_date_creation(Date a_uti_date_creation) {
        this.a_uti_date_creation = a_uti_date_creation;
    }

    @NotNull
    public int getA_uti_type_utilisateur() {
        return a_uti_type_utilisateur;
    }

    public void setA_uti_type_utilisateur(int a_uti_type_utilisateur) {
        this.a_uti_type_utilisateur = a_uti_type_utilisateur;
    }

    @NotNull
    @Column(name="a_uti_identi_cgi")
    public String getIdenti() {
        return identi;
    }

    public void setIdenti(String identi) {
        this.identi = identi;
    }

    @NotNull
    public String getA_uti_code_cgi() {
        return a_uti_code_cgi;
    }

    public void setA_uti_code_cgi(String a_uti_code_cgi) {
        this.a_uti_code_cgi = a_uti_code_cgi;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    public Set<ListRoleId> getListRoleId() {
        return listRoleId;
    }

    public void setListRoleId(Set<ListRoleId> listRoleId) {
        this.listRoleId = listRoleId;
    }
}
