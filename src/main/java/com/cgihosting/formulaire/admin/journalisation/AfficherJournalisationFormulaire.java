package com.cgihosting.formulaire.admin.journalisation;

import com.cgihosting.domain.JournalDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherJournalisationFormulaire extends RacineFormulaire {

    private List<JournalDTO> journalDTOListe ;

    public List<JournalDTO> getJournalDTOListe() {
        return journalDTOListe;
    }

    public void setJournalDTOListe(List<JournalDTO> journalDTOListe) {
        this.journalDTOListe = journalDTOListe;
    }

    Page<JournalDTO> journalDTOPage;

    public Page<JournalDTO> getJournalDTOPage() {
        return journalDTOPage;
    }

    public void setJournalDTOPage(Page<JournalDTO> journalDTOPage) {
        this.journalDTOPage = journalDTOPage;
    }
}
