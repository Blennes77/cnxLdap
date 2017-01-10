package com.cgihosting.formulaire.monCGIHosting.mesInfosPerso;

import com.cgihosting.domain.ProjetDTO;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.admin.RacineFormulaire;

import java.util.List;

/**
 * Created by marinib on 09/12/2016.
 */
public class AfficherMesInfosPersoFormulaire extends RacineFormulaire {

    private UtilisateurDTO utilisateurDTO;

    private List<ProjetDTO> projetDTODPList;

    public UtilisateurDTO getUtilisateurDTO() {
        return utilisateurDTO;
    }

    public void setUtilisateurDTO(UtilisateurDTO utilisateurDTO) {
        this.utilisateurDTO = utilisateurDTO;
    }

    public List<ProjetDTO> getProjetDTODPList() {
        return projetDTODPList;
    }

    public void setProjetDTODPList(List<ProjetDTO> projetDTODPList) {
        this.projetDTODPList = projetDTODPList;
    }
}
