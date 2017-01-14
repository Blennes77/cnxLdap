package com.cgihosting.formulaire.admin.referentielHebergeurs;

import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 02/01/2017
 */
public class DetailsReferentielHebergeursFormulaire extends RacineFormulaire {

    private ReferentielHebergeurDTO referentielHebergeurDTO;

    public ReferentielHebergeurDTO getReferentielHebergeurDTO() {
        return referentielHebergeurDTO;
    }

    public void setReferentielHebergeurDTO(ReferentielHebergeurDTO referentielHebergeurDTO) {
        this.referentielHebergeurDTO = referentielHebergeurDTO;
    }
}
