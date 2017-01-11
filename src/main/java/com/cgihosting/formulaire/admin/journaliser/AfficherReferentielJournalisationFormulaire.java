package com.cgihosting.formulaire.admin.journaliser;

import com.cgihosting.domain.TypeJournalisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

/**
 * Created by marinib on 08/01/2017.
 */
public class AfficherReferentielJournalisationFormulaire extends RacineFormulaire {


    Page<TypeJournalisationDTO> typeJournalisationDTOPage;

    public Page<TypeJournalisationDTO> getTypeJournalisationDTOPage() {
        return typeJournalisationDTOPage;
    }

    public void setTypeJournalisationDTOPage(Page<TypeJournalisationDTO> typeJournalisationDTOPage) {
        this.typeJournalisationDTOPage = typeJournalisationDTOPage;
    }
}
