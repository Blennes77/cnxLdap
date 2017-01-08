package com.cgihosting.service.admin;

import com.cgihosting.domain.HebergeurDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface GererHebergeurService extends Serializable{

    public List<HebergeurDTO> recupererHebergeurs();

    public HebergeurDTO recupererHebergeurById(int identifiant);


    public  int creerHebergeur(HebergeurDTO hebergeurDTO);

    public Long nombreTotalHebergeurs();

    public Page<HebergeurDTO> searchAllHebergeurDtoPageByPage(Integer page, Integer ligneParPage);



}
