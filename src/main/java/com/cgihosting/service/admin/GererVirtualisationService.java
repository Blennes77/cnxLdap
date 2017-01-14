package com.cgihosting.service.admin;

import com.cgihosting.domain.referentiel.ReferentielVirtualisationDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib 12/01/2017.
 */

public interface GererVirtualisationService extends Serializable{

    public List<ReferentielVirtualisationDTO> recupererReferentielVirtualisation();

    public ReferentielVirtualisationDTO recupererReferentielVirtualisationById(int identifiant);


    public int modifierReferentielVirtualisation(ReferentielVirtualisationDTO referentielVirtualisationDTO);


    public Long nombreTotalVirtualisation();

    public Page<ReferentielVirtualisationDTO> searchAllReferentielVirtualisationDTOPageByPage(Integer page, Integer ligneParPage);





}
