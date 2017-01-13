package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib on 07/01/2017.
 */

@Entity
@Table(name="ref_templates_OS")
public class TemplateOSDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="RTO_ID")
    private Integer id;

    @Column(name="RTO_CODE_TEMPLATE")
    private String codeTemplate;

    @Column(name="RTO_LIBELLE_TEMPLATE")
    private String libelleTemplate;

    @Column(name="RTO_DESCRIPTION_TEMPLATE")
    private String descriptionTemplate;

    @Column(name="RTO_ID_HEBERGEUR")
    private Integer idHebergeur;

    @Column(name="RTO_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="RTO_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="RTO_MINRAM")
    private Integer minRam;

    @Column(name="RTO_MINCPU")
    private Integer minCpu;

    @Column(name="RTO_MINDISQUE")
    private Integer minDisque;

    @Column(name="RTO_ID_OS")
    private Integer idOS;

    @Column(name="RTO_DATE_CREATION")
    private Date dateCreation;

    @Column(name="RTO_DATE_MODIFICATION")
    private Date dateModification;

    @Column(name="RTO_DATE_FIN_ACTIF")
    private Date dateFinActif;




    @OneToOne
    @JoinColumn(name="RTO_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO;


    @OneToOne
    @JoinColumn(name="RTO_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO;

    @OneToOne
    @JoinColumn(name="RTO_ID_HEBERGEUR",  insertable = false, updatable = false)
    private HebergeurDTO hebergeurDTO;


    @OneToOne
    @JoinColumn(name="RTO_ID_OS", insertable = false, updatable = false)
    private TypeOSDTO typeOSDTO;



    /**
     *
     * Constructeurs
     */

    public TemplateOSDTO() {


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeTemplate() {
        return codeTemplate;
    }

    public void setCodeTemplate(String codeTemplate) {
        this.codeTemplate = codeTemplate;
    }

    public String getLibelleTemplate() {
        return libelleTemplate;
    }

    public void setLibelleTemplate(String libelleTemplate) {
        this.libelleTemplate = libelleTemplate;
    }

    public String getDescriptionTemplate() {
        return descriptionTemplate;
    }

    public void setDescriptionTemplate(String descriptionTemplate) {
        this.descriptionTemplate = descriptionTemplate;
    }

    public Integer getIdHebergeur() {
        return idHebergeur;
    }

    public void setIdHebergeur(Integer idHebergeur) {
        this.idHebergeur = idHebergeur;
    }

    public Integer getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(Integer idCreateur) {
        this.idCreateur = idCreateur;
    }

    public Integer getIdModificateur() {
        return idModificateur;
    }

    public void setIdModificateur(Integer idModificateur) {
        this.idModificateur = idModificateur;
    }

    public Integer getMinRam() {
        return minRam;
    }

    public void setMinRam(Integer minRam) {
        this.minRam = minRam;
    }

    public Integer getMinCpu() {
        return minCpu;
    }

    public void setMinCpu(Integer minCpu) {
        this.minCpu = minCpu;
    }

    public Integer getMinDisque() {
        return minDisque;
    }

    public void setMinDisque(Integer minDisque) {
        this.minDisque = minDisque;
    }

    public Integer getIdOS() {
        return idOS;
    }

    public void setIdOS(Integer idOS) {
        this.idOS = idOS;
    }

    public UtilisateurDTO getUtilisateurCreateurDTO() {
        return utilisateurCreateurDTO;
    }

    public void setUtilisateurCreateurDTO(UtilisateurDTO utilisateurCreateurDTO) {
        this.utilisateurCreateurDTO = utilisateurCreateurDTO;
    }

    public UtilisateurDTO getUtilisateurModificateurDTO() {
        return utilisateurModificateurDTO;
    }

    public void setUtilisateurModificateurDTO(UtilisateurDTO utilisateurModificateurDTO) {
        this.utilisateurModificateurDTO = utilisateurModificateurDTO;
    }

    public HebergeurDTO getHebergeurDTO() {
        return hebergeurDTO;
    }

    public void setHebergeurDTO(HebergeurDTO hebergeurDTO) {
        this.hebergeurDTO = hebergeurDTO;
    }

    public TypeOSDTO getTypeOSDTO() {
        return typeOSDTO;
    }

    public void setTypeOSDTO(TypeOSDTO typeOSDTO) {
        this.typeOSDTO = typeOSDTO;
    }


    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateFinActif() {
        return dateFinActif;
    }

    public void setDateFinActif(Date dateFinActif) {
        this.dateFinActif = dateFinActif;
    }

    public Date getDateModification() {
        return dateModification;
    }

    public void setDateModification(Date dateModification) {
        this.dateModification = dateModification;
    }
}
