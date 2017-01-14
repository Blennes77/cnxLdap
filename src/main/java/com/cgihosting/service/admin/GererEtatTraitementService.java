package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * Created by marinib on 14/01/2017.
 */

public interface GererEtatTraitementService extends Serializable{


    public Page<ReferentielEtatTraitementServeurDTO> recupererReferentielEtatTraitement(Integer page, Integer ligneParPage);

    public Long nombreTotalReferentielEtatTraitement();

    public int modifierReferentielEtatTraitement(ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO);


    public ReferentielEtatTraitementServeurDTO recupererReferentielEtatTraitementById(int identifiant);








}
