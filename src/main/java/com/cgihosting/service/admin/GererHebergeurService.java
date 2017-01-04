package com.cgihosting.service.admin;

import com.cgihosting.domain.HebergeurDTO;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface GererHebergeurService extends Serializable{

    List<HebergeurDTO> recupererHebergeurs();

    boolean creerHebergeur(HebergeurDTO hebergeurDTO);


}
