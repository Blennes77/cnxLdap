package com.cgihosting.formulaire.monCGIHosting.mesCommandes;

import com.cgihosting.domain.ProjetDTO;
import com.cgihosting.domain.ServeurVirtuelDTO;
import com.cgihosting.domain.TemplateOSDTO;
import com.cgihosting.formulaire.admin.RacineFormulaire;

import java.util.List;

/**
 * Created by marinib on 07/01/2017.
 */
public class AjoutServeurVirtuelFormulaire extends RacineFormulaire {

    private ServeurVirtuelDTO serveurVirtuelDTO;

    private List<TemplateOSDTO> templateOSDTOListe;

    private List<ProjetDTO> projetDTOListe;


    public ServeurVirtuelDTO getServeurVirtuelDTO() {
        return serveurVirtuelDTO;
    }

    public void setServeurVirtuelDTO(ServeurVirtuelDTO serveurVirtuelDTO) {
        this.serveurVirtuelDTO = serveurVirtuelDTO;
    }

    public List<TemplateOSDTO> getTemplateOSDTOListe() {
        return templateOSDTOListe;
    }

    public void setTemplateOSDTOListe(List<TemplateOSDTO> templateOSDTOListe) {
        this.templateOSDTOListe = templateOSDTOListe;
    }

    public List<ProjetDTO> getProjetDTOListe() {
        return projetDTOListe;
    }

    public void setProjetDTOListe(List<ProjetDTO> projetDTOListe) {
        this.projetDTOListe = projetDTOListe;
    }
}
