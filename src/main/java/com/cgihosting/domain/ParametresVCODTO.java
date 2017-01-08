package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="configuration_orchestrator")
public class ParametresVCODTO implements Serializable{


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="COR_ID")
    private int id;

    @Column(name="COR_URL_VCO")
    private String urlVco;

    @Column(name="COR_ADMIN_VCO")
    private String adminVco;

    @Column(name="COR_MOTDEPASSE_VCO")
    private String motDePasseVco;

    @Column(name="COR_ADRESSEIP_PHPIPAM")
    private String adressePhpipam;

    @Column(name="COR_BASE_PHPIPAM")
    private String basePhpipam;

    @Column(name="COR_COMPTE_PHPIPAM")
    private String comptePhpipam;

    @Column(name="COR_MOTDEPASSE_PHPIPAM")
    private String motDePassePhpipam;

    @Column(name="COR_ADRESSEIP_TEAMPASS")
    private String adresseTeampass;

    @Column(name="COR_BASE_TEAMPASS")
    private String baseTeampass;

    @Column(name="COR_COMPTE_TEAMPASS")
    private String compteTeampass;

    @Column(name="COR_MOTDEPASSE_TEAMPASS")
    private String motDePasseTeampass;

    @Column(name="COR_ADRESSEIP_DOLIBARR")
    private String adresseDolibarr;

    @Column(name="COR_BASE_DOLIBARR")
    private String baseDolibarr;

    @Column(name="COR_COMPTE_DOLIBARR")
    private String compteDolibarr;

    @Column(name="COR_MOTDEPASSE_DOLIBARR")
    private String motDePasseDolibarr;

    @Column(name="COR_ADRESSE_SMTP")
    private String adresseSmtp;

    @Column(name="COR_MAIL_SMTP")
    private String expediteurSMTP;


    @Column(name="COR_LONGUEUR_MOTSDEPASSE")
    private int longueurMotDePasse;

    @Column(name="COR_TIMEOUTPING_PHPIPAM")
    private int timeoutPing;

    @Column(name="COR_TEXTE_RESERVATIONPHPIPAM")
    private String texteReservationPhpIpam;

    @Column(name="COR_ID_TYPE_ENVIRONNEMENT")
    private int typeEnvironnement;

    @OneToOne
    @JoinColumn(name="COR_ID_TYPE_ENVIRONNEMENT", insertable = false, updatable = false)
    private TypeEnvironnementDTO typeEnvironnementDTO;


    /**
     *
     * getters et setters
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrlVco() {
        return urlVco;
    }

    public void setUrlVco(String urlVco) {
        this.urlVco = urlVco;
    }

    public String getAdminVco() {
        return adminVco;
    }

    public void setAdminVco(String adminVco) {
        this.adminVco = adminVco;
    }

    public String getMotDePasseVco() {
        return motDePasseVco;
    }

    public void setMotDePasseVco(String motDePasseVco) {
        this.motDePasseVco = motDePasseVco;
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

    public int getLongueurMotDePasse() {
        return longueurMotDePasse;
    }

    public void setLongueurMotDePasse(int longueurMotDePasse) {
        this.longueurMotDePasse = longueurMotDePasse;
    }

    public int getTimeoutPing() {
        return timeoutPing;
    }

    public void setTimeoutPing(int timeoutPing) {
        this.timeoutPing = timeoutPing;
    }

    public String getTexteReservationPhpIpam() {
        return texteReservationPhpIpam;
    }

    public void setTexteReservationPhpIpam(String texteReservationPhpIpam) {
        this.texteReservationPhpIpam = texteReservationPhpIpam;
    }

    public int getTypeEnvironnement() {
        return typeEnvironnement;
    }

    public void setTypeEnvironnement(int typeEnvironnement) {
        this.typeEnvironnement = typeEnvironnement;
    }

    public TypeEnvironnementDTO getTypeEnvironnementDTO() {
        return typeEnvironnementDTO;
    }

    public void setTypeEnvironnementDTO(TypeEnvironnementDTO typeEnvironnementDTO) {
        this.typeEnvironnementDTO = typeEnvironnementDTO;
    }
}
