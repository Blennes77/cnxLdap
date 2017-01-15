package com.cgihosting.formulaire.adminFonctionnel.solutionsHebergement;

import com.cgihosting.domain.application.SolutionsHebergementDTO;
import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import com.cgihosting.domain.referentiel.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import java.util.List;

/**
 * Created by marinib on 14/01/2017
 */
public class DetailsSolutionsHebergementFormulaire extends RacineFormulaire {

    private SolutionsHebergementDTO solutionsHebergementDTO;

    private List<ReferentielHebergeurDTO> referentielHebergeurDTOListe;

    private List<ReferentielVirtualisationDTO> referentielVirtualisationDTOListe;


    public SolutionsHebergementDTO getSolutionsHebergementDTO() {
        return solutionsHebergementDTO;
    }

    public void setSolutionsHebergementDTO(SolutionsHebergementDTO solutionsHebergementDTO) {
        this.solutionsHebergementDTO = solutionsHebergementDTO;
    }


    public List<ReferentielHebergeurDTO> getReferentielHebergeurDTOListe() {
        return referentielHebergeurDTOListe;
    }

    public void setReferentielHebergeurDTOListe(List<ReferentielHebergeurDTO> referentielHebergeurDTOListe) {
        this.referentielHebergeurDTOListe = referentielHebergeurDTOListe;
    }

    public List<ReferentielVirtualisationDTO> getReferentielVirtualisationDTOListe() {
        return referentielVirtualisationDTOListe;
    }

    public void setReferentielVirtualisationDTOListe(List<ReferentielVirtualisationDTO> referentielVirtualisationDTOListe) {
        this.referentielVirtualisationDTOListe = referentielVirtualisationDTOListe;
    }
}
