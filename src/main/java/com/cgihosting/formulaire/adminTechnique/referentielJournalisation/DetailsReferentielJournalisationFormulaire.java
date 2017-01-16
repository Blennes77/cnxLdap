package com.cgihosting.formulaire.adminTechnique.referentielJournalisation;

import com.cgihosting.domain.referentiel.ReferentielJournalisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 08/01/2017
 */
public class DetailsReferentielJournalisationFormulaire extends RacineFormulaire {

    @Valid
    private ReferentielJournalisationDTO referentielJournalisationDTO;

    public ReferentielJournalisationDTO getReferentielJournalisationDTO() {
        return referentielJournalisationDTO;
    }

    public void setReferentielJournalisationDTO(ReferentielJournalisationDTO referentielJournalisationDTO) {
        this.referentielJournalisationDTO = referentielJournalisationDTO;
    }
}
