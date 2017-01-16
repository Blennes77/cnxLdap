package com.cgihosting.formulaire.adminTechnique.referentielRolesUtilisateur;

import com.cgihosting.domain.referentiel.ReferentielRolesDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 16/01/2017
 */
public class DetailsReferentielRolesUtilisateurFormulaire extends RacineFormulaire {

    @Valid
    private ReferentielRolesDTO referentielRolesDTO;

    public ReferentielRolesDTO getReferentielRolesDTO() {
        return referentielRolesDTO;
    }

    public void setReferentielRolesDTO(ReferentielRolesDTO referentielRolesDTO) {
        this.referentielRolesDTO = referentielRolesDTO;
    }
}
