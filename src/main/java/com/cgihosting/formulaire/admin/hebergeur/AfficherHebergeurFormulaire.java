package com.cgihosting.formulaire.admin.hebergeur;

import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.formulaire.admin.ModeleFormulaire;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherHebergeurFormulaire extends ModeleFormulaire {

    private List<HebergeurDTO> hebergeurDTOListe;

    public List<HebergeurDTO> getHebergeurDTOListe() {
        return hebergeurDTOListe;
    }

    public void setHebergeurDTOListe(List<HebergeurDTO> hebergeurDTOListe) {
        this.hebergeurDTOListe = hebergeurDTOListe;
    }
}
