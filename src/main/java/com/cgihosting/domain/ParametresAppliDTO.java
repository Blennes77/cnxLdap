package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="configuration_application")
public class ParametresAppliDTO implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAP_ID")
    private Integer id;

    @Column(name = "CAP_TITRE_SITE")
    private String titreSite;

    @Column(name = "CAP_CHAINE_CONNEXIONLDAP")
    private String chaineConnexionLDAP;

    @Column(name = "CAP_COMPTE_LDAP")
    private String compteLDAP;

    @Column(name = "CAP_MOTDEPASSE_LDAP")
    private String motDePasseLDAP;

    @Column(name = "CAP_COMPTE_ADMIN")
    private String compteAdmin;

    @Column(name = "CAP_MOTDEPASSE_ADMIN")
    private String motDePasseAdmin;

    @Column(name = "CAP_MAIL_ADMIN")
    private String mailAdmin;

    @Column(name = "CAP_ID_TYPE_ENVIRONNEMENT")
    private Integer typeEnvironnement;


    @OneToOne
    @JoinColumn(name = "CAP_ID_TYPE_ENVIRONNEMENT", insertable = false, updatable = false)
    private TypeEnvironnementDTO typeEnvironnementDTO;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCompteAdmin() {
        return compteAdmin;
    }

    public void setCompteAdmin(String compteAdmin) {
        this.compteAdmin = compteAdmin;
    }

    public String getMotDePasseAdmin() {
        return motDePasseAdmin;
    }

    public void setMotDePasseAdmin(String motDePasseAdmin) {
        this.motDePasseAdmin = motDePasseAdmin;
    }

    public String getMailAdmin() {
        return mailAdmin;
    }

    public void setMailAdmin(String mailAdmin) {
        this.mailAdmin = mailAdmin;
    }

    public Integer getTypeEnvironnement() {
        return typeEnvironnement;
    }

    public void setTypeEnvironnement(Integer typeEnvironnement) {
        this.typeEnvironnement = typeEnvironnement;
    }

    public TypeEnvironnementDTO getTypeEnvironnementDTO() {
        return typeEnvironnementDTO;
    }

    public void setTypeEnvironnementDTO(TypeEnvironnementDTO typeEnvironnementDTO) {
        this.typeEnvironnementDTO = typeEnvironnementDTO;
    }
}
