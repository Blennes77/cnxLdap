package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;

/**
 * Created by marinib on 10/02/2017.
 */

public interface GererEtatCommandeService extends Serializable{


    public Page<ReferentielEtatCommandeDTO> recupererReferentielEtatCommande(Integer page, Integer ligneParPage);

    public Long nombreTotalReferentielEtatCommande();

    public int modifierReferentielEtatCommande(ReferentielEtatCommandeDTO referentielEtatCommandeDTO);


    public ReferentielEtatCommandeDTO recupererReferentielEtatCommandeById(int identifiant);








}
