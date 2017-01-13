package com.cgihosting.service.admin;

import com.cgihosting.domain.ReferentielOSDTO;
import org.springframework.data.domain.Page;

import java.io.Serializable;
import java.util.List;

/**
 * Created by marinib 12/01/2017.
 */

public interface GererOSService extends Serializable{

    public List<ReferentielOSDTO> recupererReferentielOS();

    public ReferentielOSDTO recupererReferentielOSById(int identifiant);


    public int modifierReferentielOS(ReferentielOSDTO referentielOSDTO);


    public Long nombreTotalOS();

    public Page<ReferentielOSDTO> searchAllReferentielOSDTOPageByPage(Integer page, Integer ligneParPage);





}
