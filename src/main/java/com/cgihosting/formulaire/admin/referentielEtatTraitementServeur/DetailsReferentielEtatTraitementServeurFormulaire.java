package com.cgihosting.formulaire.admin.referentielEtatTraitementServeur;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 14/01/2017
 */
public class DetailsReferentielEtatTraitementServeurFormulaire extends RacineFormulaire {

    private ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO;

    public ReferentielEtatTraitementServeurDTO getReferentielEtatTraitementServeurDTO() {
        return referentielEtatTraitementServeurDTO;
    }

    public void setReferentielEtatTraitementServeurDTO(ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO) {
        this.referentielEtatTraitementServeurDTO = referentielEtatTraitementServeurDTO;
    }
}
