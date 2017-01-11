package com.cgihosting.formulaire.admin.hebergeur;

import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.formulaire.RacineFormulaire;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherHebergeurFormulaire extends RacineFormulaire {

    private int identifiantHebergeurSelect;

    private List<HebergeurDTO> hebergeurDTOListe;


    private Page<HebergeurDTO> hebergeurDTOPage;


    public int getIdentifiantHebergeurSelect() {
        return identifiantHebergeurSelect;
    }

    public void setIdentifiantHebergeurSelect(int identifiantHebergeurSelect) {
        this.identifiantHebergeurSelect = identifiantHebergeurSelect;
    }

    public List<HebergeurDTO> getHebergeurDTOListe() {
        return hebergeurDTOListe;
    }

    public void setHebergeurDTOListe(List<HebergeurDTO> hebergeurDTOListe) {
        this.hebergeurDTOListe = hebergeurDTOListe;
    }

    public Page<HebergeurDTO> getHebergeurDTOPage() {
        return hebergeurDTOPage;
    }

    public void setHebergeurDTOPage(Page<HebergeurDTO> hebergeurDTOPage) {
        this.hebergeurDTOPage = hebergeurDTOPage;
    }
}
