package com.cgihosting.formulaire.adminTechnique.referentielRolesUtilisateur;

import com.cgihosting.domain.referentiel.ReferentielRolesDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 16/01/2017
 */
public class DetailsReferentielRolesUtilisateurFormulaire extends RacineFormulaire {

    private ReferentielRolesDTO referentielRolesDTO;

    public ReferentielRolesDTO getReferentielRolesDTO() {
        return referentielRolesDTO;
    }

    public void setReferentielRolesDTO(ReferentielRolesDTO referentielRolesDTO) {
        this.referentielRolesDTO = referentielRolesDTO;
    }
}
