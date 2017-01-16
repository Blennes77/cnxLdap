package com.cgihosting.formulaire.adminTechnique.referentielVirtualisation;

import com.cgihosting.domain.referentiel.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 12/01/2017
 */
public class DetailsReferentielVirtualisationFormulaire extends RacineFormulaire {

    @Valid
    private ReferentielVirtualisationDTO referentielVirtualisationDTO;


    public ReferentielVirtualisationDTO getReferentielVirtualisationDTO() {
        return referentielVirtualisationDTO;
    }

    public void setReferentielVirtualisationDTO(ReferentielVirtualisationDTO referentielVirtualisationDTO) {
        this.referentielVirtualisationDTO = referentielVirtualisationDTO;
    }
}
