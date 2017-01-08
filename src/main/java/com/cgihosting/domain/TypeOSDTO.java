package com.cgihosting.domain;

import javax.persistence.*;

/**
 * Created by marinib on 08/01/2017.
 */

@Entity
@Table(name="ref_os")
public class TypeOSDTO {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="REO_ID")
    private int id;

    @Column(name="REO_NOMOS")
    private String nomOS = "";

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomOS() {
        return nomOS;
    }

    public void setNomOS(String nomOS) {
        this.nomOS = nomOS;
    }
}
