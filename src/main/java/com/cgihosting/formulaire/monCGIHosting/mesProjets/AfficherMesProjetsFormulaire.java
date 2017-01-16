package com.cgihosting.formulaire.monCGIHosting.mesProjets;

import com.cgihosting.domain.application.ProjetDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import java.util.List;

/**
 * Created by garnons on 12/01/2017.
 */
public class AfficherMesProjetsFormulaire extends RacineFormulaire {
    private List<ProjetDTO> projetDTODPList;

    public List<ProjetDTO> getProjetDTODPList() {
        return projetDTODPList;
    }

    public void setProjetDTODPList(List<ProjetDTO> projetDTODPList) {
        this.projetDTODPList = projetDTODPList;
    }
}
