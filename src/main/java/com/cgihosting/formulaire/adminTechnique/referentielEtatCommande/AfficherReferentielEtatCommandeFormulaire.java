package com.cgihosting.formulaire.adminTechnique.referentielEtatCommande;

import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 10/02/2017.
 */
public class AfficherReferentielEtatCommandeFormulaire extends RacineFormulaire {




    private Page<ReferentielEtatCommandeDTO> referentielEtatCommandeDTOPage;

    public Page<ReferentielEtatCommandeDTO> getReferentielEtatCommandeDTOPage() {
        return referentielEtatCommandeDTOPage;
    }

    public void setReferentielEtatCommandeDTOPage(Page<ReferentielEtatCommandeDTO> referentielEtatCommandeDTOPage) {
        this.referentielEtatCommandeDTOPage = referentielEtatCommandeDTOPage;
    }
}
