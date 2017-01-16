package com.cgihosting.domain.application;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name="COH_ID_UTI_CREATEUR")
    private int idCreateur;

    @Column(name="COH_ID_UTI_VALIDEUR")
    private int idValideur;



/*
	`COH_DATE_CREATION` DATE NULL DEFAULT NULL,
	`COH_DATE_ACHAT` DATE NULL DEFAULT NULL,
	`COH_IND_ACHAT
	*/


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCreateur() {
        return idCreateur;
    }

    public void setIdCreateur(int idCreateur) {
        this.idCreateur = idCreateur;
    }

    public int getIdValideur() {
        return idValideur;
    }

    public void setIdValideur(int idValideur) {
        this.idValideur = idValideur;
    }
}
