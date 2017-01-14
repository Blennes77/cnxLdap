package com.cgihosting.formulaire.admin.referentielEtatTraitementServeur;

import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 14/01/2017.
 */
public class AfficherReferentielEtatTraitementServeurFormulaire extends RacineFormulaire {




    private Page<ReferentielEtatTraitementServeurDTO> referentielEtatTraitementServeurDTOPage;

    public Page<ReferentielEtatTraitementServeurDTO> getReferentielEtatTraitementServeurDTOPage() {
        return referentielEtatTraitementServeurDTOPage;
    }

    public void setReferentielEtatTraitementServeurDTOPage(Page<ReferentielEtatTraitementServeurDTO> referentielEtatTraitementServeurDTOPage) {
        this.referentielEtatTraitementServeurDTOPage = referentielEtatTraitementServeurDTOPage;
    }
}
