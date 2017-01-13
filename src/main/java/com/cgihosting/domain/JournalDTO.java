package com.cgihosting.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="journalisation_evenements")
public class JournalDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="JEV_ID")
    private Integer id;

    @Column(name="JEV_LOGIN_NAME")
    private String login;

    @Column(name="JEV_TYPEACTION_ID")
    private Integer typeActionId;

    @Column(name="JEV_ID_DONNEE")
    private Integer idDonnee;


    @OneToOne
    @JoinColumn(name="JEV_LOGIN_NAME", referencedColumnName = "UTI_LOGON_NAME", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurDTO;


    @OneToOne
    @JoinColumn(name="JEV_TYPEACTION_ID",  insertable = false, updatable = false)
    private TypeJournalisationDTO typeJournalisationDTO;


    @Column(name="JEV_DATE_EVENEMENT")
    @NotNull
    private Date dateEvenement;


    /**
     *
     * Constructeurs
     */

    public JournalDTO() {


    }

    public JournalDTO(String login, Integer typeActionId, Integer idDonnee, Date dateEvenement ) {

        this.login = login;
        this.typeActionId = typeActionId;
        this.idDonnee = idDonnee;
        this.dateEvenement = dateEvenement;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getTypeActionId() {
        return typeActionId;
    }

    public void setTypeActionId(Integer typeActionId) {
        this.typeActionId = typeActionId;
    }

    public Integer getIdDonnee() {
        return idDonnee;
    }

    public void setIdDonnee(Integer idDonnee) {
        this.idDonnee = idDonnee;
    }

    public UtilisateurDTO getUtilisateurDTO() {
        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
        this.utilisateurDTO = utilisateurDTO;
    }

    public TypeJournalisationDTO getTypeJournalisationDTO() {
        return typeJournalisationDTO;
    }

    public void setTypeJournalisationDTO(TypeJournalisationDTO typeJournalisationDTO) {
        this.typeJournalisationDTO = typeJournalisationDTO;
    }

    public Date getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(Date dateEvenement) {
        this.dateEvenement = dateEvenement;
    }



}
