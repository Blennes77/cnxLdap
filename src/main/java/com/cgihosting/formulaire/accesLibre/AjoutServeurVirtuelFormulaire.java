package com.cgihosting.formulaire.accesLibre;

import com.cgihosting.domain.application.ProjetDTO;
import com.cgihosting.domain.application.ServeurVirtuelDTO;
import com.cgihosting.domain.application.TemplateOSDTO;
import com.cgihosting.formulaire.RacineFormulaire;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by marinib on 07/01/2017.
 */
public class AjoutServeurVirtuelFormulaire extends RacineFormulaire {

    @Valid
    private ServeurVirtuelDTO serveurVirtuelDTO;

    private List<TemplateOSDTO> templateOSDTOListe;

    private List<ProjetDTO> projetDTOListe;

    private String champRechercheProjet = "";

    @NotNull
    private String name;

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

    public String getChampRechercheProjet() {
        return champRechercheProjet;
    }

    public void setChampRechercheProjet(String champRechercheProjet) {
        this.champRechercheProjet = champRechercheProjet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
