package com.cgihosting.domain.application;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by marinib on 14/01/2017.
 */
@Entity
@Table(name="solutions_hebergement")
public class SolutionsHebergementDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="SHE_ID")
    private Integer id;

    @Column(name="SHE_LIBELLE")
    @NotNull
    private String libelleSolution ="";

    @Column(name="SHE_DESCRIPTION")
    private String descriptionSolution ="";


    @Column(name="SHE_ID_HEBERGEUR")
    private Integer idHebergeur;

    @Column(name="SHE_ADRESSE_PROXY")
    private String adresseProxy ="";

    @Column(name="SHE_MASQUE_PROXY")
    private String masqueProxy ="";

    @Column(name="SHE_PORT_PROXY")
    private Integer portProxy;

    @Column(name="SHE_ADRESSE_DNS1")
    private String adresseDNS1 ="";

    @Column(name="SHE_ADRESSE_DNS2")
    private String adresseDNS2 ="";

    @Column(name="SHE_IND_ACTIF")
    private Integer indActif;

    @Column(name="SHE_NOM_DOMAINE")
    private String nomDomaine ="";

    @Column(name="SHE_ADMIN_DOMAINE")
    private String adminDomaine ="";

    @Column(name="SHE_MOTDEPASSE_DOMAINE")
    private String motDePasseDomaine ="";

    @Column(name="SHE_PREFIXE_NOM_MACHINE")
    private String prefixeNomMachine ="";

    @Column(name="SHE_TEXTEDEFINITF_PHPIPAM")
    private String texteDefinitifPhpipam ="";

    @Column(name="SHE_TEXTERESERVATION_PHPIPAM")
    private String texteReservationPhpipam ="";

    @Column(name="SHE_ID_VIRTUALISATION")
    private Integer idVirtualisation;

    @Column(name="SHE_ID_TYPE_ENVIRONNEMENT")
    private Integer idTypeEnvironnement;

    @Column(name="SHE_URL_VIRTUALISATION")
    private String urlVirtualisation ="";

    @Column(name="SHE_COMPTE_VIRTUALISATION")
    private String compteVirtualisation ="";

    @Column(name="SHE_MOTDEPASSE_VIRTUALISATION")
    private String motDePassevirtualisation ="";


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getIdHebergeur() {
        return idHebergeur;
    }

    public void setIdHebergeur(Integer idHebergeur) {
        this.idHebergeur = idHebergeur;
    }

    public String getAdresseProxy() {
        return adresseProxy;
    }

    public void setAdresseProxy(String adresseProxy) {
        this.adresseProxy = adresseProxy;
    }

    public String getMasqueProxy() {
        return masqueProxy;
    }

    public void setMasqueProxy(String masqueProxy) {
        this.masqueProxy = masqueProxy;
    }

    public Integer getPortProxy() {
        return portProxy;
    }

    public void setPortProxy(Integer portProxy) {
        this.portProxy = portProxy;
    }

    public String getAdresseDNS1() {
        return adresseDNS1;
    }

    public void setAdresseDNS1(String adresseDNS1) {
        this.adresseDNS1 = adresseDNS1;
    }

    public String getAdresseDNS2() {
        return adresseDNS2;
    }

    public void setAdresseDNS2(String adresseDNS2) {
        this.adresseDNS2 = adresseDNS2;
    }

    public Integer getIndActif() {
        return indActif;
    }

    public void setIndActif(Integer indActif) {
        this.indActif = indActif;
    }

    public String getNomDomaine() {
        return nomDomaine;
    }

    public void setNomDomaine(String nomDomaine) {
        this.nomDomaine = nomDomaine;
    }

    public String getAdminDomaine() {
        return adminDomaine;
    }

    public void setAdminDomaine(String adminDomaine) {
        this.adminDomaine = adminDomaine;
    }

    public String getMotDePasseDomaine() {
        return motDePasseDomaine;
    }

    public void setMotDePasseDomaine(String motDePasseDomaine) {
        this.motDePasseDomaine = motDePasseDomaine;
    }

    public String getPrefixeNomMachine() {
        return prefixeNomMachine;
    }

    public void setPrefixeNomMachine(String prefixeNomMachine) {
        this.prefixeNomMachine = prefixeNomMachine;
    }

    public String getTexteDefinitifPhpipam() {
        return texteDefinitifPhpipam;
    }

    public void setTexteDefinitifPhpipam(String texteDefinitifPhpipam) {
        this.texteDefinitifPhpipam = texteDefinitifPhpipam;
    }

    public String getTexteReservationPhpipam() {
        return texteReservationPhpipam;
    }

    public void setTexteReservationPhpipam(String texteReservationPhpipam) {
        this.texteReservationPhpipam = texteReservationPhpipam;
    }

    public Integer getIdVirtualisation() {
        return idVirtualisation;
    }

    public void setIdVirtualisation(Integer idVirtualisation) {
        this.idVirtualisation = idVirtualisation;
    }

    public Integer getIdTypeEnvironnement() {
        return idTypeEnvironnement;
    }

    public void setIdTypeEnvironnement(Integer idTypeEnvironnement) {
        this.idTypeEnvironnement = idTypeEnvironnement;
    }

    public String getUrlVirtualisation() {
        return urlVirtualisation;
    }

    public void setUrlVirtualisation(String urlVirtualisation) {
        this.urlVirtualisation = urlVirtualisation;
    }

    public String getCompteVirtualisation() {
        return compteVirtualisation;
    }

    public void setCompteVirtualisation(String compteVirtualisation) {
        this.compteVirtualisation = compteVirtualisation;
    }

    public String getMotDePassevirtualisation() {
        return motDePassevirtualisation;
    }

    public void setMotDePassevirtualisation(String motDePassevirtualisation) {
        this.motDePassevirtualisation = motDePassevirtualisation;
    }

    public String getLibelleSolution() {
        return libelleSolution;
    }

    public void setLibelleSolution(String libelleSolution) {
        this.libelleSolution = libelleSolution;
    }

    public String getDescriptionSolution() {
        return descriptionSolution;
    }

    public void setDescriptionSolution(String descriptionSolution) {
        this.descriptionSolution = descriptionSolution;
    }
}
