package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="configuration_application")
public class ParametresAppliDTO implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="CAP_ID")
    private int id;

    @Column(name="CAP_TITRE_SITE")
    private String titreSite;

    @Column(name="CAP_CHAINE_CONNEXIONLDAP")
    private String chaineConnexionLDAP;

    @Column(name="CAP_COMPTE_LDAP")
    private String compteLDAP;

    @Column(name="CAP_MOTDEPASSE_LDAP")
    private String motDePasseLDAP;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitreSite() {
        return titreSite;
    }

    public void setTitreSite(String titreSite) {
        this.titreSite = titreSite;
    }

    public String getChaineConnexionLDAP() {
        return chaineConnexionLDAP;
    }

    public void setChaineConnexionLDAP(String chaineConnexionLDAP) {
        this.chaineConnexionLDAP = chaineConnexionLDAP;
    }

    public String getCompteLDAP() {
        return compteLDAP;
    }

    public void setCompteLDAP(String compteLDAP) {
        this.compteLDAP = compteLDAP;
    }

    public String getMotDePasseLDAP() {
        return motDePasseLDAP;
    }

    public void setMotDePasseLDAP(String motDePasseLDAP) {
        this.motDePasseLDAP = motDePasseLDAP;
    }
}
