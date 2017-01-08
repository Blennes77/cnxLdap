package com.cgihosting.formulaire.admin.projets;

import com.cgihosting.domain.ProjetDTO;
import com.cgihosting.formulaire.admin.RacineFormulaire;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by marinib on 08/01/2017.
 */
public class AfficherProjetsFormulaire extends RacineFormulaire {


    List<ProjetDTO> projetDTOListe;
    Page<ProjetDTO> projetDTOPage;

    public List<ProjetDTO> getProjetDTOListe() {
        return projetDTOListe;
    }

    public void setProjetDTOListe(List<ProjetDTO> projetDTOListe) {
        this.projetDTOListe = projetDTOListe;
    }

    public Page<ProjetDTO> getProjetDTOPage() {
        return projetDTOPage;
    }

    public void setProjetDTOPage(Page<ProjetDTO> projetDTOPage) {
        this.projetDTOPage = projetDTOPage;
    }
}
