package com.cgihosting.formulaire.admin.journaliser;

import com.cgihosting.domain.TypeJournalisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 08/01/2017
 */
public class DetailsReferentielJournalisationFormulaire extends RacineFormulaire {

    private TypeJournalisationDTO typeJournalisationDTO;


    public TypeJournalisationDTO getTypeJournalisationDTO() {
        return typeJournalisationDTO;
    }

    public void setTypeJournalisationDTO(TypeJournalisationDTO typeJournalisationDTO) {
        this.typeJournalisationDTO = typeJournalisationDTO;
    }
}
