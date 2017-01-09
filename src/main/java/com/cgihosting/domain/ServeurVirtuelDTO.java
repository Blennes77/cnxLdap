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

    @Column(name="SVI_ID_TYPE_HEBERGEUR")
    private int idTypeHeberg;

    @Column(name="SVI_ID_WORKFLOW")
    private int idWorkflow;

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

    @Column(name="SVI_ID_PHPIPAM")
    private int idPhpipam;

    @Column(name="SVI_ID_UTI_EXPLOITANT")
    private Integer idExploitant;

    @Column(name="SVI_ID_UTI_ENREGISTREUR")
    private Integer idEnregistreur;

    @Column(name="SVI_ID_UTI_VALIDEUR")
    private Integer idValideur;


    @OneToOne
    @JoinColumn(name="SVI_IND_TRAITEMENT", insertable = false, updatable = false)
    private EtatTraitementServeurDTO etatTraitementServeurDTO ;

    @OneToOne
    @JoinColumn(name="SVI_ID_OS", insertable = false, updatable = false)
    private TemplateOSDTO templateOSDTO ;

    @OneToOne
    @JoinColumn(name="SVI_ID_PROJET", insertable = false, updatable = false)
    private ProjetDTO projetDTO ;


    @OneToOne
    @JoinColumn(name="SVI_ID_UTI_EXPLOITANT", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurExploitantDTO;

    @OneToOne
    @JoinColumn(name="SVI_ID_UTI_ENREGISTREUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurEnregistreurDTO;

    @OneToOne
    @JoinColumn(name="SVI_ID_UTI_VALIDEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurValideurDTO ;


    /**
     * Guetters et setters
     * @return
     */

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

    public int getIdTypeHeberg() {
        return idTypeHeberg;
    }

    public void setIdTypeHeberg(int idTypeHeberg) {
        this.idTypeHeberg = idTypeHeberg;
    }

    public int getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(int idWorkflow) {
        this.idWorkflow = idWorkflow;
    }

    public int getIdPhpipam() {
        return idPhpipam;
    }

    public void setIdPhpipam(int idPhpipam) {
        this.idPhpipam = idPhpipam;
    }

    public void setIdExploitant(Integer idExploitant) {
        this.idExploitant = idExploitant;
    }

    public void setIdEnregistreur(Integer idEnregistreur) {
        this.idEnregistreur = idEnregistreur;
    }

    public void setIdValideur(Integer idValideur) {
        this.idValideur = idValideur;
    }

    public int getIdExploitant() {
        return idExploitant;
    }

    public void setIdExploitant(int idExploitant) {
        this.idExploitant = idExploitant;
    }

    public int getIdEnregistreur() {
        return idEnregistreur;
    }

    public void setIdEnregistreur(int idEnregistreur) {
        this.idEnregistreur = idEnregistreur;
    }

    public int getIdValideur() {
        return idValideur;
    }

    public void setIdValideur(int idValideur) {
        this.idValideur = idValideur;
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


    public UtilisateurDTO getUtilisateurExploitantDTO() {
        return utilisateurExploitantDTO;
    }

    public void setUtilisateurExploitantDTO(UtilisateurDTO utilisateurExploitantDTO) {
        this.utilisateurExploitantDTO = utilisateurExploitantDTO;
    }


    public UtilisateurDTO getUtilisateurEnregistreurDTO() {
        return utilisateurEnregistreurDTO;
    }

    public void setUtilisateurEnregistreurDTO(UtilisateurDTO utilisateurEnregistreurDTO) {
        this.utilisateurEnregistreurDTO = utilisateurEnregistreurDTO;
    }

    public UtilisateurDTO getUtilisateurValideurDTO() {
        return utilisateurValideurDTO;
    }

    public void setUtilisateurValideurDTO(UtilisateurDTO utilisateurValideurDTO) {
        this.utilisateurValideurDTO = utilisateurValideurDTO;
    }
}
