package com.cgihosting.formulaire.adminTechnique.referentielActionsWorkflows;

import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.formulaire.RacineFormulaire;

/**
 * Created by marinib on 02/01/2017
 */
public class DetailsReferentielActionsWorkflowsFormulaire extends RacineFormulaire {

    private ReferentielActionsWorkflowDTO referentielActionsWorkflowsDTO;

    public ReferentielActionsWorkflowDTO getReferentielActionsWorkflowsDTO() {
        return referentielActionsWorkflowsDTO;
    }

    public void setReferentielActionsWorkflowsDTO(ReferentielActionsWorkflowDTO referentielActionsWorkflowsDTO) {
        this.referentielActionsWorkflowsDTO = referentielActionsWorkflowsDTO;
    }
}
