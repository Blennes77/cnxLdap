package com.cgihosting.service.admin;

import com.cgihosting.domain.application.SolutionsHebergementDTO;
import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */

public interface GererHebergeurService extends Serializable{

    public List<ReferentielHebergeurDTO> recupererReferentielHebergeurs();

    public ReferentielHebergeurDTO recupererHebergeurById(int identifiant);


    public  int creerReferentielHebergeur(ReferentielHebergeurDTO referentielHebergeurDTO);

    public Long nombreTotalReferentielHebergeurs();

    public Page<ReferentielHebergeurDTO> searchAllReferentielHebergeurDtoPageByPage(Integer page, Integer ligneParPage);


    public SolutionsHebergementDTO recupererSolutionsHebergementById(int identifiant);


    public  int modifierSolutionsHebergement(SolutionsHebergementDTO solutionsHebergementDTO);

    public Long nombreTotalSolutionshebergement();

    public Page<SolutionsHebergementDTO> searchAllSolutionsHebergementDtoPageByPage(Integer page, Integer ligneParPage);



}
