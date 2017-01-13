package com.cgihosting.formulaire.admin.referentielJournalisation;

import com.cgihosting.domain.ReferentielJournalisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 08/01/2017.
 */
public class AfficherReferentielJournalisationFormulaire extends RacineFormulaire {


    Page<ReferentielJournalisationDTO> referentielJournalisationDTOPage;

    public Page<ReferentielJournalisationDTO> getReferentielJournalisationDTOPage() {
        return referentielJournalisationDTOPage;
    }

    public void setReferentielJournalisationDTOPage(Page<ReferentielJournalisationDTO> referentielJournalisationDTOPage) {
        this.referentielJournalisationDTOPage = referentielJournalisationDTOPage;
    }
}
