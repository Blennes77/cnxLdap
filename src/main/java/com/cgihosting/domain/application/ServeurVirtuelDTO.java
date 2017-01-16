package com.cgihosting.domain.application;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

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
    private Integer ram;

    @Column(name="SVI_CPUS")
    private Integer cpus;

    @Column(name="SVI_ID_TEMPLATE")
    private Integer idTemplate;

    @Column(name="SVI_DISQUE_SYSTEME")
    private Integer tailleDisqueSysteme;

    @Column(name="SVI_IND_DISQUE_ADDITIF")
    private Integer indDisqueAdditif;

    @Column(name="SVI_DISQUE_ADDITIF")
    private Integer tailleDisqueAdditif;

    @Column(name="SVI_NOM_ADMIN")
    private String nomAdmin;

    @Column(name="SVI_MOTDEPASSE_ADMIN")
    private String motDePasseAdmin;

    @Column(name="SVI_ADRESSEIP")
    private String adresseIp;

    @Column(name="SVI_MASQUE")
    private String masque;

    @Column(name="SVI_ID_SOLUTION_HEBERGEMENT")
    private Integer idSolutionHebergement;

    @Column(name="SVI_ID_WORKFLOW")
    private Integer idWorkflow;

    @Column(name="SVI_MASQUECICDR")
    private Integer masqueCICDR;

    @Column(name="SVI_IND_TRAITEMENT")
    private Integer indTraitement;

    @Column(name="SVI_ID_PROJET")
    private Integer idProjet;

    @Column(name="SVI_MESSAGE_ERREUR")
    private String messageErreur;


    @Column(name="SVI_IND_CUSTOMISATION")
    private Integer indCustomisation;

    @Column(name="SVI_ID_PHPIPAM")
    private Integer idPhpipam;

    @Column(name="SVI_ID_UTI_EXPLOITANT")
    private Integer idExploitant;

    @Column(name="SVI_ID_UTI_ENREGISTREUR")
    private Integer idEnregistreur;

    @Column(name="SVI_ID_UTI_VALIDEUR")
    private Integer idValideur;

    @Column(name="SVI_ID_UTI_DP")
    private Integer idDP;

    @Column(name="SVI_DATE_TRAITEMENT")
    private Date dateTraitement;

    @Column(name="SVI_DATE_ENREGISTREMENT")
    private Date dateEnregistrement;

    @Column(name="SVI_DATE_VALIDATION")
    private Date dateValidation;

    @OneToOne
    @JoinColumn(name="SVI_IND_TRAITEMENT", insertable = false, updatable = false)
    private ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO ;

    @OneToOne
    @JoinColumn(name="SVI_ID_TEMPLATE", insertable = false, updatable = false)
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


    @OneToOne
    @JoinColumn(name="SVI_ID_SOLUTION_HEBERGEMENT", insertable = false, updatable = false)
    private SolutionsHebergementDTO solutionsHebergementDTO ;


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

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    public Integer getCpus() {
        return cpus;
    }

    public void setCpus(Integer cpus) {
        this.cpus = cpus;
    }

    public Integer getIdTemplate() {
        return idTemplate;
    }

    public void setIdTemplate(Integer idTemplate) {
        this.idTemplate = idTemplate;
    }

    public Integer getTailleDisqueSysteme() {
        return tailleDisqueSysteme;
    }

    public void setTailleDisqueSysteme(Integer tailleDisqueSysteme) {
        this.tailleDisqueSysteme = tailleDisqueSysteme;
    }

    public Integer getIndDisqueAdditif() {
        return indDisqueAdditif;
    }

    public void setIndDisqueAdditif(Integer indDisqueAdditif) {
        this.indDisqueAdditif = indDisqueAdditif;
    }

    public Integer getTailleDisqueAdditif() {
        return tailleDisqueAdditif;
    }

    public void setTailleDisqueAdditif(Integer tailleDisqueAdditif) {
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

    public Integer getIdSolutionHebergement() {
        return idSolutionHebergement;
    }

    public void setIdSolutionHebergement(Integer idSolutionHebergement) {
        this.idSolutionHebergement = idSolutionHebergement;
    }

    public Integer getIdWorkflow() {
        return idWorkflow;
    }

    public void setIdWorkflow(Integer idWorkflow) {
        this.idWorkflow = idWorkflow;
    }

    public Integer getMasqueCICDR() {
        return masqueCICDR;
    }

    public void setMasqueCICDR(Integer masqueCICDR) {
        this.masqueCICDR = masqueCICDR;
    }

    public Integer getIndTraitement() {
        return indTraitement;
    }

    public void setIndTraitement(Integer indTraitement) {
        this.indTraitement = indTraitement;
    }

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
    }

    public Integer getIdDP() {
        return idDP;
    }

    public void setIdDP(Integer idDP) {
        this.idDP = idDP;
    }

    public String getMessageErreur() {
        return messageErreur;
    }

    public void setMessageErreur(String messageErreur) {
        this.messageErreur = messageErreur;
    }

    public Integer getIndCustomisation() {
        return indCustomisation;
    }

    public void setIndCustomisation(Integer indCustomisation) {
        this.indCustomisation = indCustomisation;
    }

    public Integer getIdPhpipam() {
        return idPhpipam;
    }

    public void setIdPhpipam(Integer idPhpipam) {
        this.idPhpipam = idPhpipam;
    }

    public Integer getIdExploitant() {
        return idExploitant;
    }

    public void setIdExploitant(Integer idExploitant) {
        this.idExploitant = idExploitant;
    }

    public Integer getIdEnregistreur() {
        return idEnregistreur;
    }

    public void setIdEnregistreur(Integer idEnregistreur) {
        this.idEnregistreur = idEnregistreur;
    }

    public Integer getIdValideur() {
        return idValideur;
    }

    public void setIdValideur(Integer idValideur) {
        this.idValideur = idValideur;
    }

    public ReferentielEtatTraitementServeurDTO getReferentielEtatTraitementServeurDTO() {
        return referentielEtatTraitementServeurDTO;
    }

    public void setReferentielEtatTraitementServeurDTO(ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO) {
        this.referentielEtatTraitementServeurDTO = referentielEtatTraitementServeurDTO;
    }

    public TemplateOSDTO getTemplateOSDTO() {
        return templateOSDTO;
    }

    public void setTemplateOSDTO(TemplateOSDTO templateOSDTO) {
        this.templateOSDTO = templateOSDTO;
    }

    public ProjetDTO getProjetDTO() {
        return projetDTO;
    }

    public void setProjetDTO(ProjetDTO projetDTO) {
        this.projetDTO = projetDTO;
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


    public Date getDateTraitement() {
        return dateTraitement;
    }

    public void setDateTraitement(Date dateTraitement) {
        this.dateTraitement = dateTraitement;
    }

    public Date getDateEnregistrement() {
        return dateEnregistrement;
    }

    public void setDateEnregistrement(Date dateEnregistrement) {
        this.dateEnregistrement = dateEnregistrement;
    }

    public Date getDateValidation() {
        return dateValidation;
    }

    public void setDateValidation(Date dateValidation) {
        this.dateValidation = dateValidation;
    }

    public SolutionsHebergementDTO getSolutionsHebergementDTO() {
        return solutionsHebergementDTO;
    }

    public void setSolutionsHebergementDTO(SolutionsHebergementDTO solutionsHebergementDTO) {
        this.solutionsHebergementDTO = solutionsHebergementDTO;
    }
}
