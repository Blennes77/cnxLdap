package com.cgihosting.formulaire.adminTechnique.referentielActionsWorkflows;

import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherReferentielActionsWorkflowsFormulaire extends RacineFormulaire {




    private Page<ReferentielActionsWorkflowDTO> referentielActionsWorkflowDTOPage;

    public Page<ReferentielActionsWorkflowDTO> getReferentielActionsWorkflowDTOPage() {
        return referentielActionsWorkflowDTOPage;
    }

    public void setReferentielActionsWorkflowDTOPage(Page<ReferentielActionsWorkflowDTO> referentielActionsWorkflowDTOPage) {
        this.referentielActionsWorkflowDTOPage = referentielActionsWorkflowDTOPage;
    }
}
