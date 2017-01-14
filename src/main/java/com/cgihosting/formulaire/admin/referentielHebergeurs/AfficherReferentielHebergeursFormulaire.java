package com.cgihosting.formulaire.admin.referentielHebergeurs;

import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherReferentielHebergeursFormulaire extends RacineFormulaire {


    private List<ReferentielHebergeurDTO> referentielHebergeurDTOListe;


    private Page<ReferentielHebergeurDTO> referentielHebergeurDTOPage;

    public List<ReferentielHebergeurDTO> getReferentielHebergeurDTOListe() {
        return referentielHebergeurDTOListe;
    }

    public void setReferentielHebergeurDTOListe(List<ReferentielHebergeurDTO> referentielHebergeurDTOListe) {
        this.referentielHebergeurDTOListe = referentielHebergeurDTOListe;
    }

    public Page<ReferentielHebergeurDTO> getReferentielHebergeurDTOPage() {
        return referentielHebergeurDTOPage;
    }

    public void setReferentielHebergeurDTOPage(Page<ReferentielHebergeurDTO> referentielHebergeurDTOPage) {
        this.referentielHebergeurDTOPage = referentielHebergeurDTOPage;
    }
}
