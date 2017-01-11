package com.cgihosting.formulaire.monCGIHosting.mesCommandes;

import com.cgihosting.domain.ProjetDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import java.util.List;

/**
 * Created by garnons on 11/01/2017.
 */
public class AjaxRecupererProjetFormulaire extends RacineFormulaire {
    private List<ProjetDTO> projetDTOList;

    public AjaxRecupererProjetFormulaire() {

    }

    public List<ProjetDTO> getProjetDTOList() {
        return projetDTOList;
    }

    public void setProjetDTOList(List<ProjetDTO> projetDTOList) {
        this.projetDTOList = projetDTOList;
    }
}
