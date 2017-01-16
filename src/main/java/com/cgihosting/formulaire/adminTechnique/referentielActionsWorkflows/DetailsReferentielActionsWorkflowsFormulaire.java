package com.cgihosting.formulaire.adminTechnique.referentielActionsWorkflows;

import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;

/**
 * Created by marinib on 02/01/2017
 */
public class DetailsReferentielActionsWorkflowsFormulaire extends RacineFormulaire {

    @Valid
    private ReferentielActionsWorkflowDTO referentielActionsWorkflowsDTO;

    public ReferentielActionsWorkflowDTO getReferentielActionsWorkflowsDTO() {
        return referentielActionsWorkflowsDTO;
    }

    public void setReferentielActionsWorkflowsDTO(ReferentielActionsWorkflowDTO referentielActionsWorkflowsDTO) {
        this.referentielActionsWorkflowsDTO = referentielActionsWorkflowsDTO;
    }
}
