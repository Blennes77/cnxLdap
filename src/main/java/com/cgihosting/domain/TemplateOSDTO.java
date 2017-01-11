package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 07/01/2017.
 */

@Entity
@Table(name="templates_OS")
public class TemplateOSDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="TEO_ID")
    private Integer id;

    @Column(name="TEO_CODE_TEMPLATE")
    private String codeTemplate;

    @Column(name="TEO_LIBELLE_TEMPLATE")
    private String libelleTemplate;

    @Column(name="TEO_DESCRIPTION_TEMPLATE")
    private String descriptionTemplate;

    @Column(name="TEO_ID_HEBERGEUR")
    private Integer idHebergeur;

    @Column(name="TEO_ID_CREATEUR")
    private Integer idCreateur;

    @Column(name="TEO_ID_MODIFICATEUR")
    private Integer idModificateur;

    @Column(name="TEO_MINRAM")
    private Integer minRam;

    @Column(name="TEO_MINCPU")
    private Integer minCpu;

    @Column(name="TEO_MINDISQUE")
    private Integer minDisque;

    @Column(name="TEO_ID_OS")
    private Integer idOS;
    /**
	`TEO_DATE_CREATION` DATETIME NULL DEFAULT NULL,
	`TEO_DATE_FIN_ACTIF` DATETIME NULL DEFAULT NULL,
	`TEO_IND_ACTIF` TINYINT(4) NULL DEFAULT NULL,
     **/



    @OneToOne
    @JoinColumn(name="TEO_ID_CREATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurCreateurDTO;


    @OneToOne
    @JoinColumn(name="TEO_ID_MODIFICATEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurModificateurDTO;

    @OneToOne
    @JoinColumn(name="TEO_ID_HEBERGEUR",  insertable = false, updatable = false)
    private HebergeurDTO hebergeurDTO;


    @OneToOne
    @JoinColumn(name="TEO_ID_OS", insertable = false, updatable = false)
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
}
