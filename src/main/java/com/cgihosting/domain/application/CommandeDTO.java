package com.cgihosting.domain.application;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 06/01/2017.
 */


@Entity
@Table(name="commandes_hosting")
public class CommandeDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="COH_ID")
    private int id;

    @Column(name="COH_ID_PROJET")
    private Integer idProjet;

    @Column(name="COH_REFERENCE")
    private String reference;

    @Column(name="COH_UTI_ID_ENREGISTREUR")
    private Integer idEnregistreur;

    @Column(name="COH_UTI_ID_VALIDEUR")
    private Integer idValideur;


    @OneToOne
    @JoinColumn(name="COH_ID_PROJET", insertable = false, updatable = false)
    private ProjetDTO projetDTO ;


    @OneToMany
    @JoinColumn(name = "CAT_COH_ID", insertable = false, updatable = false)
    private List<TraitementCommandeDTO> traitementCommandeDTOListe;


    @OneToOne
    @JoinColumn(name="COH_UTI_ID_ENREGISTREUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurEnregistreurDTO ;


    @OneToOne
    @JoinColumn(name="COH_UTI_ID_VALIDEUR", insertable = false, updatable = false)
    private UtilisateurDTO utilisateurValideurDTO ;


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public Integer getIdProjet() {
        return idProjet;
    }


    public void setIdProjet(Integer idProjet) {
        this.idProjet = idProjet;
    }


    public String getReference() {
        return reference;
    }


    public void setReference(String reference) {
        this.reference = reference;
    }


    public ProjetDTO getProjetDTO() {
        return projetDTO;
    }


    public void setProjetDTO(ProjetDTO projetDTO) {
        this.projetDTO = projetDTO;
    }


    public List<TraitementCommandeDTO> getTraitementCommandeDTOListe() {
        return traitementCommandeDTOListe;
    }

    public void setTraitementCommandeDTOListe(List<TraitementCommandeDTO> traitementCommandeDTOListe) {
        this.traitementCommandeDTOListe = traitementCommandeDTOListe;
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
