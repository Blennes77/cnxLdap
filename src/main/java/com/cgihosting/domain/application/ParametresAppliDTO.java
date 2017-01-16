package com.cgihosting.domain.application;

import com.cgihosting.domain.referentiel.ReferentielEnvironnementDTO;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
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

    @NotNull
    @NotEmpty
    @Column(name = "CAP_TITRE_SITE")
    private String titreSite;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_CHAINE_CONNEXIONLDAP")
    private String chaineConnexionLDAP;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_COMPTE_LDAP")
    private String compteLDAP;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_MOTDEPASSE_LDAP")
    private String motDePasseLDAP;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_COMPTE_ADMIN")
    private String compteAdmin;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_MOTDEPASSE_ADMIN")
    private String motDePasseAdmin;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_MAIL_ADMIN")
    private String mailAdmin;

    @NotNull
    @NotEmpty
    @Column(name = "CAP_ID_TYPE_ENVIRONNEMENT")
    private Integer typeEnvironnement;

    @NotNull
    @NotEmpty
    @Column(name="CAP_ADRESSEIP_PHPIPAM")
    private String adressePhpipam;

    @NotNull
    @NotEmpty
    @Column(name="CAP_BASE_PHPIPAM")
    private String basePhpipam;

    @NotNull
    @NotEmpty
    @Column(name="CAP_COMPTE_PHPIPAM")
    private String comptePhpipam;

    @NotNull
    @NotEmpty
    @Column(name="CAP_MOTDEPASSE_PHPIPAM")
    private String motDePassePhpipam;

    @NotNull
    @NotEmpty
    @Column(name="CAP_ADRESSEIP_TEAMPASS")
    private String adresseTeampass;

    @NotNull
    @NotEmpty
    @Column(name="CAP_BASE_TEAMPASS")
    private String baseTeampass;

    @NotNull
    @NotEmpty
    @Column(name="CAP_COMPTE_TEAMPASS")
    private String compteTeampass;

    @NotNull
    @NotEmpty
    @Column(name="CAP_MOTDEPASSE_TEAMPASS")
    private String motDePasseTeampass;

    @NotNull
    @NotEmpty
    @Column(name="CAP_ADRESSEIP_DOLIBARR")
    private String adresseDolibarr;

    @NotNull
    @NotEmpty
    @Column(name="CAP_BASE_DOLIBARR")
    private String baseDolibarr;

    @NotNull
    @NotEmpty
    @Column(name="CAP_COMPTE_DOLIBARR")
    private String compteDolibarr;

    @NotNull
    @NotEmpty
    @Column(name="CAP_MOTDEPASSE_DOLIBARR")
    private String motDePasseDolibarr;

    @NotNull
    @NotEmpty
    @Column(name="CAP_ADRESSE_SMTP")
    private String adresseSmtp;

    @NotNull
    @NotEmpty
    @Column(name="CAP_MAIL_SMTP")
    private String expediteurSMTP;

    @NotNull
    @NotEmpty
    @Column(name="CAP_LONGUEUR_MOTDEPASSE")
    private Integer longueurMotDePasse;

    @NotNull
    @NotEmpty
    @Column(name="CAP_TIMEOUTPING_PHPIPAM")
    private Integer timeoutPingPhpipam;

    @NotNull
    @NotEmpty
    @Max(12)
    @Column(name = "CAP_DELAIMOIS_PURGE")
    private Integer delaiPurge;


    @OneToOne
    @JoinColumn(name = "CAP_ID_TYPE_ENVIRONNEMENT", insertable = false, updatable = false)
    private ReferentielEnvironnementDTO referentielEnvironnementDTO;

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

    public String getAdressePhpipam() {
        return adressePhpipam;
    }

    public void setAdressePhpipam(String adressePhpipam) {
        this.adressePhpipam = adressePhpipam;
    }

    public String getBasePhpipam() {
        return basePhpipam;
    }

    public void setBasePhpipam(String basePhpipam) {
        this.basePhpipam = basePhpipam;
    }

    public String getComptePhpipam() {
        return comptePhpipam;
    }

    public void setComptePhpipam(String comptePhpipam) {
        this.comptePhpipam = comptePhpipam;
    }

    public String getMotDePassePhpipam() {
        return motDePassePhpipam;
    }

    public void setMotDePassePhpipam(String motDePassePhpipam) {
        this.motDePassePhpipam = motDePassePhpipam;
    }

    public String getAdresseTeampass() {
        return adresseTeampass;
    }

    public void setAdresseTeampass(String adresseTeampass) {
        this.adresseTeampass = adresseTeampass;
    }

    public String getBaseTeampass() {
        return baseTeampass;
    }

    public void setBaseTeampass(String baseTeampass) {
        this.baseTeampass = baseTeampass;
    }

    public String getCompteTeampass() {
        return compteTeampass;
    }

    public void setCompteTeampass(String compteTeampass) {
        this.compteTeampass = compteTeampass;
    }

    public String getMotDePasseTeampass() {
        return motDePasseTeampass;
    }

    public void setMotDePasseTeampass(String motDePasseTeampass) {
        this.motDePasseTeampass = motDePasseTeampass;
    }

    public String getAdresseDolibarr() {
        return adresseDolibarr;
    }

    public void setAdresseDolibarr(String adresseDolibarr) {
        this.adresseDolibarr = adresseDolibarr;
    }

    public String getBaseDolibarr() {
        return baseDolibarr;
    }

    public void setBaseDolibarr(String baseDolibarr) {
        this.baseDolibarr = baseDolibarr;
    }

    public String getCompteDolibarr() {
        return compteDolibarr;
    }

    public void setCompteDolibarr(String compteDolibarr) {
        this.compteDolibarr = compteDolibarr;
    }

    public String getMotDePasseDolibarr() {
        return motDePasseDolibarr;
    }

    public void setMotDePasseDolibarr(String motDePasseDolibarr) {
        this.motDePasseDolibarr = motDePasseDolibarr;
    }

    public String getAdresseSmtp() {
        return adresseSmtp;
    }

    public void setAdresseSmtp(String adresseSmtp) {
        this.adresseSmtp = adresseSmtp;
    }

    public String getExpediteurSMTP() {
        return expediteurSMTP;
    }

    public void setExpediteurSMTP(String expediteurSMTP) {
        this.expediteurSMTP = expediteurSMTP;
    }

    public Integer getLongueurMotDePasse() {
        return longueurMotDePasse;
    }

    public void setLongueurMotDePasse(Integer longueurMotDePasse) {
        this.longueurMotDePasse = longueurMotDePasse;
    }

    public Integer getTimeoutPingPhpipam() {
        return timeoutPingPhpipam;
    }

    public void setTimeoutPingPhpipam(Integer timeoutPingPhpipam) {
        this.timeoutPingPhpipam = timeoutPingPhpipam;
    }

    public ReferentielEnvironnementDTO getReferentielEnvironnementDTO() {
        return referentielEnvironnementDTO;
    }

    public void setReferentielEnvironnementDTO(ReferentielEnvironnementDTO referentielEnvironnementDTO) {
        this.referentielEnvironnementDTO = referentielEnvironnementDTO;
    }

    public Integer getDelaiPurge() {
        return delaiPurge;
    }

    public void setDelaiPurge(Integer delaiPurge) {
        this.delaiPurge = delaiPurge;
    }
}
