package com.cgihosting.formulaire.adminTechnique.referentielEtatCommande;

import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 10/02/2017
 */
public class DetailsReferentielEtatCommandeFormulaire extends RacineFormulaire {

    @Valid
    private ReferentielEtatCommandeDTO referentielEtatCommandeDTO;

    public ReferentielEtatCommandeDTO getReferentielEtatCommandeDTO() {
        return referentielEtatCommandeDTO;
    }

    public void setReferentielEtatCommandeDTO(ReferentielEtatCommandeDTO referentielEtatCommandeDTO) {
        this.referentielEtatCommandeDTO = referentielEtatCommandeDTO;
    }
}
