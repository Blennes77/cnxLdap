package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 06/01/2017.
 */

@Entity
@Table(name="messages_utilisateur")
public class MessageDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MUT_ID")
    private int id;

    @Column(name = "MUT_SUJET")
    private String sujet;

    @Column(name = "MUT_CONTENU")
    private String contenu;

    @Column(name = "MUT_ID_DEST")
    private int idDest;

    @Column(name = "MUT_ID_EXP")
    private int idExp;


   /*
	`MUT_IND_LU` INT(11) NULL DEFAULT NULL,
	`MUT_DATE_ENVOI` DATE NULL DEFAULT NULL,
	`MUT_DATE_LECTURE`
	*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public int getIdDest() {
        return idDest;
    }

    public void setIdDest(int idDest) {
        this.idDest = idDest;
    }

    public int getIdExp() {
        return idExp;
    }

    public void setIdExp(int idExp) {
        this.idExp = idExp;
    }
}
