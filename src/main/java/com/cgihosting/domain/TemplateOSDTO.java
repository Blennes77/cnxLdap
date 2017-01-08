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
    private int id;

    @Column(name="TEO_CODE_TEMPLATE")
    private String codeTemplate;

    @Column(name="TEO_LIBELLE_TEMPLATE")
    private String libelleTemplate;

    @Column(name="TEO_DESCRIPTION_TEMPLATE")
    private String descriptionTemplate;

    @Column(name="TEO_ID_HEBERGEUR")
    private int idHebergeur;

    @Column(name="TEO_ID_CREATEUR")
    private int idCreateur;

    @Column(name="TEO_ID_MODIFICATEUR")
    private int idModificateur;

    @Column(name="TEO_MINRAM")
    private int minRam;

    @Column(name="TEO_MINCPU")
    private int minCpu;

    @Column(name="TEO_MINDISQUE")
    private int minDisque;

    @Column(name="TEO_ID_OS")
    private int idOS;
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


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public int getIdHebergeur() {
        return idHebergeur;
    }

    public void setIdHebergeur(int idHebergeur) {
        this.idHebergeur = idHebergeur;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public int getIdModificateur() {
        return idModificateur;
    }

    public void setIdModificateur(int idModificateur) {
        this.idModificateur = idModificateur;
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

    public int getMinRam() {
        return minRam;
    }

    public void setMinRam(int minRam) {
        this.minRam = minRam;
    }

    public int getMinCpu() {
        return minCpu;
    }

    public void setMinCpu(int minCpu) {
        this.minCpu = minCpu;
    }


    public TypeOSDTO getTypeOSDTO() {
        return typeOSDTO;
    }

    public void setTypeOSDTO(TypeOSDTO typeOSDTO) {
        this.typeOSDTO = typeOSDTO;
    }

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public int getMinDisque() {
        return minDisque;
    }

    public void setMinDisque(int minDisque) {
        this.minDisque = minDisque;
    }
}
