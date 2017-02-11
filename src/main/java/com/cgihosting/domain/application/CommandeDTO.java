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


    @OneToOne
    @JoinColumn(name="COH_ID_PROJET", insertable = false, updatable = false)
    private ProjetDTO projetDTO ;


    @OneToMany
    @JoinColumn(name = "CAT_COH_ID", insertable = false, updatable = false)
    private List<TraitementCommandeDTO> traitementCommandeDTOListe;



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
}
