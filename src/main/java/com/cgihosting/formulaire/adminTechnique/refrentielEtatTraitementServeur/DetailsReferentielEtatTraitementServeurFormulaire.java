package com.cgihosting.formulaire.adminTechnique.refrentielEtatTraitementServeur;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 14/01/2017
 */
public class DetailsReferentielEtatTraitementServeurFormulaire extends RacineFormulaire {

    @Valid
    private ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO;

    public ReferentielEtatTraitementServeurDTO getReferentielEtatTraitementServeurDTO() {
        return referentielEtatTraitementServeurDTO;
    }

    public void setReferentielEtatTraitementServeurDTO(ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO) {
        this.referentielEtatTraitementServeurDTO = referentielEtatTraitementServeurDTO;
    }
}
