package com.cgihosting.formulaire.admin.journaliser;

import com.cgihosting.domain.JournalDTO;
import com.cgihosting.formulaire.admin.ModeleFormulaire;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherJournalisationFormulaire extends ModeleFormulaire {

    private List<JournalDTO> journalDTOListe ;

    public List<JournalDTO> getJournalDTOListe() {
        return journalDTOListe;
    }

    public void setJournalDTOListe(List<JournalDTO> journalDTOListe) {
        this.journalDTOListe = journalDTOListe;
    }
}
