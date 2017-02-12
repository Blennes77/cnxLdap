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


    @Column(name="SVI_IND_SERVEUREXISTANT")
    private Integer indServeurExistant;

    @Column(name="SVI_MESSAGE_ERREUR")
    private String messageErreur;

    @Column(name="SVI_IND_CUSTOMISATION")
    private Integer indCustomisation;

    @Lob
    @Column(columnDefinition="TEXT", name="SVI_LOG_CUSTOMISATION")
    private String logCustomisation;

    @Column(name="SVI_ID_PHPIPAM")
    private Integer idPhpipam;


    @Column(name="SVI_IND_SAUVEGARDE")
    private Integer indSauvegarde;


    @Column(name="SVI_IND_REVERSEPROXY")
    private Integer indReverseProxy;

    @Column(name="SVI_IND_AUTHRADIUS")
    private Integer indAuthRadius;

    @Column(name="SVI_IND_RESEAUISOLE")
    private Integer indReseauIsole;

    @Column(name="SVI_IND_INTERNETDIRECT")
    private Integer indInternetDirect;

    @Column(name="SVI_IND_ENVOIMAIL")
    private Integer indEnvoiMail;


    @Column(name="SVI_WORKFLOWEXECUTION_ID")
    private String idWorkflowExecution;

    @Column(name="SVI_NOM_DOMAINECGI")
    private String nomDomaineCgi;

    @Column(name="SVI_ID_COMMANDE")
    private Integer idCommande;


    @Column(name="SVI_IND_RESERVATIONADRESSE")
    private Integer indReservationAdresse;

    @Column(name="SVI_LOG_RESERVATIONADRESSE")
    private String logReservationAdresse;


    @OneToOne
    @JoinColumn(name="SVI_ID_TEMPLATE", insertable = false, updatable = false)
    private TemplateOSDTO templateOSDTO ;



    @OneToOne
    @JoinColumn(name="SVI_ID_SOLUTION_HEBERGEMENT", insertable = false, updatable = false)
    private SolutionsHebergementDTO solutionsHebergementDTO ;

    @OneToMany
    @JoinColumn(name = "SAT_SVI_ID", insertable = false, updatable = false)
    private List<TraitementServeurVirtuelDTO> traitementServeurVirtuelDTOListe;


    @OneToOne
    @JoinColumn(name="SVI_ID_COMMANDE", insertable = false, updatable = false)
    private CommandeDTO commandeDTO ;





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

    public Integer getIndSauvegarde() {
        return indSauvegarde;
    }

    public void setIndSauvegarde(Integer indSauvegarde) {
        this.indSauvegarde = indSauvegarde;
    }

    public Integer getIndReverseProxy() {
        return indReverseProxy;
    }

    public void setIndReverseProxy(Integer indReverseProxy) {
        this.indReverseProxy = indReverseProxy;
    }

    public Integer getIndAuthRadius() {
        return indAuthRadius;
    }

    public void setIndAuthRadius(Integer indAuthRadius) {
        this.indAuthRadius = indAuthRadius;
    }

    public Integer getIndReseauIsole() {
        return indReseauIsole;
    }

    public void setIndReseauIsole(Integer indReseauIsole) {
        this.indReseauIsole = indReseauIsole;
    }

    public Integer getIndInternetDirect() {
        return indInternetDirect;
    }

    public void setIndInternetDirect(Integer indInternetDirect) {
        this.indInternetDirect = indInternetDirect;
    }

    public Integer getIndEnvoiMail() {
        return indEnvoiMail;
    }

    public void setIndEnvoiMail(Integer indEnvoiMail) {
        this.indEnvoiMail = indEnvoiMail;
    }

    public Integer getIndServeurExistant() {
        return indServeurExistant;
    }

    public void setIndServeurExistant(Integer indServeurExistant) {
        this.indServeurExistant = indServeurExistant;
    }

    public String getLogCustomisation() {
        return logCustomisation;
    }

    public void setLogCustomisation(String logCustomisation) {
        this.logCustomisation = logCustomisation;
    }

    public String getIdWorkflowExecution() {
        return idWorkflowExecution;
    }

    public void setIdWorkflowExecution(String idWorkflowExecution) {
        this.idWorkflowExecution = idWorkflowExecution;
    }

    public String getNomDomaineCgi() {
        return nomDomaineCgi;
    }

    public void setNomDomaineCgi(String nomDomaineCgi) {
        this.nomDomaineCgi = nomDomaineCgi;
    }

    public Integer getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Integer idCommande) {
        this.idCommande = idCommande;
    }

    public CommandeDTO getCommandeDTO() {
        return commandeDTO;
    }

    public void setCommandeDTO(CommandeDTO commandeDTO) {
        this.commandeDTO = commandeDTO;
    }

    public Integer getIndReservationAdresse() {
        return indReservationAdresse;
    }

    public void setIndReservationAdresse(Integer indReservationAdresse) {
        this.indReservationAdresse = indReservationAdresse;
    }

    public String getLogReservationAdresse() {
        return logReservationAdresse;
    }

    public void setLogReservationAdresse(String logReservationAdresse) {
        this.logReservationAdresse = logReservationAdresse;
    }



}
