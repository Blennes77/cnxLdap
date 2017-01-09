package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/01/2017.
 */

@Entity
@Table(name="ref_workflows_noms")
public class WorkflowNomDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="RWN_ID")
    private int id;

    @Column(name="RWN_NOM_WORKFLOW")
    private String nomWorkflow = "";

    @Column(name="RWN_DESCRIPTION_WORKFLOW")
    private String descriptiondWorkflow = "";

    @Column(name="RWN_ID_HEBERGEUR")
    private int typeHebergeur;

    @OneToOne
    @JoinColumn(name="RWN_ID_HEBERGEUR", insertable = false, updatable = false)
    private HebergeurDTO hebergeurDTO ;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomWorkflow() {
        return nomWorkflow;
    }

    public void setNomWorkflow(String nomWorkflow) {
        this.nomWorkflow = nomWorkflow;
    }

    public String getDescriptiondWorkflow() {
        return descriptiondWorkflow;
    }

    public void setDescriptiondWorkflow(String descriptiondWorkflow) {
        this.descriptiondWorkflow = descriptiondWorkflow;
    }

    public int getTypeHebergeur() {
        return typeHebergeur;
    }

    public void setTypeHebergeur(int typeHebergeur) {
        this.typeHebergeur = typeHebergeur;
    }

    public HebergeurDTO getHebergeurDTO() {
        return hebergeurDTO;
    }

    public void setHebergeurDTO(HebergeurDTO hebergeurDTO) {
        this.hebergeurDTO = hebergeurDTO;
    }
}
