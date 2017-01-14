package com.cgihosting.formulaire.admin.referentielVirtualisation;

import com.cgihosting.domain.referentiel.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 12/01/2017.
 */
public class AfficherReferentielVirtualisationFormulaire extends RacineFormulaire {


    private Page<ReferentielVirtualisationDTO> referentielVirtualisationDTOPage;

    public Page<ReferentielVirtualisationDTO> getReferentielVirtualisationDTOPage() {
        return referentielVirtualisationDTOPage;
    }

    public void setReferentielVirtualisationDTOPage(Page<ReferentielVirtualisationDTO> referentielVirtualisationDTOPage) {
        this.referentielVirtualisationDTOPage = referentielVirtualisationDTOPage;
    }
}
