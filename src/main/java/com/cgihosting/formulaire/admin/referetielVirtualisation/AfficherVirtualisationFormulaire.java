package com.cgihosting.formulaire.admin.referetielVirtualisation;

import com.cgihosting.domain.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 12/01/2017.
 */
public class AfficherVirtualisationFormulaire extends RacineFormulaire {


    private Page<ReferentielVirtualisationDTO> referentielVirtualisationDTOPage;

    public Page<ReferentielVirtualisationDTO> getReferentielVirtualisationDTOPage() {
        return referentielVirtualisationDTOPage;
    }

    public void setReferentielVirtualisationDTOPage(Page<ReferentielVirtualisationDTO> referentielVirtualisationDTOPage) {
        this.referentielVirtualisationDTOPage = referentielVirtualisationDTOPage;
    }
}
