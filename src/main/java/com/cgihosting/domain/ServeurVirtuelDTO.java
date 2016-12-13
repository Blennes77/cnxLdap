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

    @Column(name="SVI_CODE_OS")
    private String codeOS;

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
    private int indWindows;
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

    public String getCodeOS() {
        return codeOS;
    }

    public void setCodeOS(String codeOS) {
        this.codeOS = codeOS;
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

    public int getIndWindows() {
        return indWindows;
    }

    public void setIndWindows(int indWindows) {
        this.indWindows = indWindows;
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
}
