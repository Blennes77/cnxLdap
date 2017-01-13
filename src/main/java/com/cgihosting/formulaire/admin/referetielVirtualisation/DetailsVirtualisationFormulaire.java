package com.cgihosting.formulaire.admin.referetielVirtualisation;

import com.cgihosting.domain.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 12/01/2017
 */
public class DetailsVirtualisationFormulaire extends RacineFormulaire {

    private ReferentielVirtualisationDTO referentielVirtualisationDTO;


       ;

    public ReferentielVirtualisationDTO getReferentielVirtualisationDTO() {
        return referentielVirtualisationDTO;
    }

    public void setReferentielVirtualisationDTO(ReferentielVirtualisationDTO referentielVirtualisationDTO) {
        this.referentielVirtualisationDTO = referentielVirtualisationDTO;
    }
}
