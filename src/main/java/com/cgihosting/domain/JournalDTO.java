package com.cgihosting.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by marinib on 09/12/2016.
 */

@Entity
@Table(name="journalisation_evenements")
public class JournalDTO implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="JEV_ID")
    private int id;

    @Column(name="JEV_LOGIN_NAME")
    private String login;

    @Column(name="JEV_TYPEACTION_ID")
    private int typeActionId;

    /*
    @Column(name="JEV_DATE_EVENEMENT) " +
    private Date dateEvenement;
    */

    /**
     *
     * Constructeurs
     */

    public JournalDTO() {


    }

    public JournalDTO(String login, int typeActionId ) {

        this.login = login;
        this.typeActionId = typeActionId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getTypeActionId() {
        return typeActionId;
    }

    public void setTypeActionId(int typeActionId) {
        this.typeActionId = typeActionId;
    }
}
