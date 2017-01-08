package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="serveurs_virtuels")
public class ServeurVirtuelDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="SVI_ID")
    private int id;

    @Column(name="SVI_ID_ITEM_COMMANDE")
    private int itemCommandeId;

    @Column(name="SVI_NOM_SERVEUR")
    private String nomServeur;

    @Column(name="SVI_RAM")
    private int ram;

    @Column(name="SVI_CPUS")
    private int cpus;

    @Column(name="SVI_ID_OS")
    private int idOS;

    @Column(name="SVI_DISQUE_SYSTEME")
    private int tailleDisqueSysteme;

    @Column(name="SVI_IND_DISQUE_ADDITIF")
    private int indDisqueAdditif;

    @Column(name="SVI_DISQUE_ADDITIF")
    private int tailleDisqueAdditif;

    @Column(name="SVI_NOM_ADMIN")
    private String nomAdmin;

    @Column(name="SVI_MOTDEPASSE_ADMIN")
    private String motDePasseAdmin;

    @Column(name="SVI_ADRESSEIP")
    private String adresseIp;

    @Column(name="SVI_MASQUE")
    private String masque;

    @Column(name="SVI_TYPE_HEBERG_ID")
    private int typeHebergId;

    @Column(name="SVI_WORKFLOW_ID")
    private int workflowId;

    @Column(name="SVI_MASQUECICDR")
    private int masqueCICDR;

    @Column(name="SVI_IND_TRAITEMENT")
    private int indTraitement;


    @Column(name="SVI_ID_PROJET")
    private int idProjet;



/*
    @Column(name="SVI_DATE_TRAITEMENT")
    private Date dateTraitement;
    */

    @Column(name="SVI_MESSAGE_ERREUR")
    private String messageErreur;


    @Column(name="SVI_IND_CUSTOMISATION")
    private int indCustomisation;

    @Column(name="SVI_PHPIPAM_ID")
    private int phpipamId;

    @Column(name="SVI_UTI_INTERV_ID")
    private int utiIntervId;


    @OneToOne
    @JoinColumn(name="SVI_IND_TRAITEMENT", insertable = false, updatable = false)
    private EtatTraitementServeurDTO etatTraitementServeurDTO ;

    @OneToOne
    @JoinColumn(name="SVI_ID_OS", insertable = false, updatable = false)
    private TemplateOSDTO templateOSDTO ;

    @OneToOne
    @JoinColumn(name="SVI_ID_PROJET", insertable = false, updatable = false)
    private ProjetDTO projetDTO ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemCommandeId() {
        return itemCommandeId;
    }

    public void setItemCommandeId(int itemCommandeId) {
        this.itemCommandeId = itemCommandeId;
    }

    public String getNomServeur() {
        return nomServeur;
    }

    public void setNomServeur(String nomServeur) {
        this.nomServeur = nomServeur;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getCpus() {
        return cpus;
    }

    public void setCpus(int cpus) {
        this.cpus = cpus;
    }

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public int getTailleDisqueSysteme() {
        return tailleDisqueSysteme;
    }

    public void setTailleDisqueSysteme(int tailleDisqueSysteme) {
        this.tailleDisqueSysteme = tailleDisqueSysteme;
    }

    public int getIndDisqueAdditif() {
        return indDisqueAdditif;
    }

    public void setIndDisqueAdditif(int indDisqueAdditif) {
        this.indDisqueAdditif = indDisqueAdditif;
    }

    public int getTailleDisqueAdditif() {
        return tailleDisqueAdditif;
    }

    public void setTailleDisqueAdditif(int tailleDisqueAdditif) {
        this.tailleDisqueAdditif = tailleDisqueAdditif;
    }

    public String getNomAdmin() {
        return nomAdmin;
    }

    public void setNomAdmin(String nomAdmin) {
        this.nomAdmin = nomAdmin;
    }

    public String getMotDePasseAdmin() {
        return motDePasseAdmin;
    }

    public void setMotDePasseAdmin(String motDePasseAdmin) {
        this.motDePasseAdmin = motDePasseAdmin;
    }

    public String getAdresseIp() {
        return adresseIp;
    }

    public void setAdresseIp(String adresseIp) {
        this.adresseIp = adresseIp;
    }

    public String getMasque() {
        return masque;
    }

    public void setMasque(String masque) {
        this.masque = masque;
    }

    public int getTypeHebergId() {
        return typeHebergId;
    }

    public void setTypeHebergId(int typeHebergId) {
        this.typeHebergId = typeHebergId;
    }

    public int getWorkflowId() {
        return workflowId;
    }

    public void setWorkflowId(int workflowId) {
        this.workflowId = workflowId;
    }

    public int getMasqueCICDR() {
        return masqueCICDR;
    }

    public void setMasqueCICDR(int masqueCICDR) {
        this.masqueCICDR = masqueCICDR;
    }


    public String getMessageErreur() {
        return messageErreur;
    }

    public void setMessageErreur(String messageErreur) {
        this.messageErreur = messageErreur;
    }

    public int getIndCustomisation() {
        return indCustomisation;
    }

    public void setIndCustomisation(int indCustomisation) {
        this.indCustomisation = indCustomisation;
    }

    public int getPhpipamId() {
        return phpipamId;
    }

    public void setPhpipamId(int phpipamId) {
        this.phpipamId = phpipamId;
    }

    public int getUtiIntervId() {
        return utiIntervId;
    }

    public void setUtiIntervId(int utiIntervId) {
        this.utiIntervId = utiIntervId;
    }


    public EtatTraitementServeurDTO getEtatTraitementServeurDTO() {
        return etatTraitementServeurDTO;
    }

    public void setEtatTraitementServeurDTO(EtatTraitementServeurDTO etatTraitementServeurDTO) {
        this.etatTraitementServeurDTO = etatTraitementServeurDTO;
    }

    public TemplateOSDTO getTemplateOSDTO() {
        return templateOSDTO;
    }

    public void setTemplateOSDTO(TemplateOSDTO templateOSDTO) {
        this.templateOSDTO = templateOSDTO;
    }

    public int getIndTraitement() {
        return indTraitement;
    }

    public void setIndTraitement(int indTraitement) {
        this.indTraitement = indTraitement;
    }

    public ProjetDTO getProjetDTO() {
        return projetDTO;
    }

    public void setProjetDTO(ProjetDTO projetDTO) {
        this.projetDTO = projetDTO;
    }

    public int getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(int idProjet) {
        this.idProjet = idProjet;
    }
}
