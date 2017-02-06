package com.cgihosting.domain.application;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="serveurs_virtuels")
public class ServeurVirtuelDTO implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="SVI_ID")
    private int id;

    @Column(name="SVI_ID_ITEM_COMMANDE")
    private Integer itemCommandeId;

    @Column(name="SVI_NOM_SERVEUR")
    private String nomServeur;

    @NotNull
    @Column(name="SVI_RAM")
    private Integer ram;

    @NotNull
    @Column(name="SVI_CPUS")
    private Integer cpus;

    @NotNull
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

    @Column(name="SVI_MASQUECICDR")
    private Integer masqueCICDR;

    @Column(name="SVI_ID_PROJET")
    private Integer idProjet;

    @Column(name="SVI_MESSAGE_ERREUR")
    private String messageErreur;


    @Column(name="SVI_IND_CUSTOMISATION")
    private Integer indCustomisation;

    @Column(name="SVI_ID_PHPIPAM")
    private Integer idPhpipam;



    @OneToOne
    @JoinColumn(name="SVI_ID_TEMPLATE", insertable = false, updatable = false)
    private TemplateOSDTO templateOSDTO ;

    @OneToOne
    @JoinColumn(name="SVI_ID_PROJET", insertable = false, updatable = false)
    private ProjetDTO projetDTO ;


    @OneToOne
    @JoinColumn(name="SVI_ID_SOLUTION_HEBERGEMENT", insertable = false, updatable = false)
    private SolutionsHebergementDTO solutionsHebergementDTO ;

    @OneToMany
    @JoinColumn(name = "SAT_SVI_ID", insertable = false, updatable = false)
    private List<TraitementServeurVirtuelDTO> traitementServeurVirtuelDTOListe;



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

    public void setItemCommandeId(Integer itemCommandeId) {
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



    public Integer getMasqueCICDR() {
        return masqueCICDR;
    }

    public void setMasqueCICDR(Integer masqueCICDR) {
        this.masqueCICDR = masqueCICDR;
    }

    public Integer getIdProjet() {
        return idProjet;
    }

    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
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


    public SolutionsHebergementDTO getSolutionsHebergementDTO() {
        return solutionsHebergementDTO;
    }

    public void setSolutionsHebergementDTO(SolutionsHebergementDTO solutionsHebergementDTO) {
        this.solutionsHebergementDTO = solutionsHebergementDTO;
    }

    public List<TraitementServeurVirtuelDTO> getTraitementServeurVirtuelDTOListe() {
        return traitementServeurVirtuelDTOListe;
    }

    public void setTraitementServeurVirtuelDTOListe(List<TraitementServeurVirtuelDTO> traitementServeurVirtuelDTOListe) {
        this.traitementServeurVirtuelDTOListe = traitementServeurVirtuelDTOListe;
    }
}
