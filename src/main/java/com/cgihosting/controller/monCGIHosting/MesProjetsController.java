package com.cgihosting.controller.monCGIHosting;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.formulaire.monCGIHosting.mesProjets.AfficherMesProjetsFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.service.admin.GererProjetsService;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by garnons on 12/01/2017.
 */
@Controller
public class MesProjetsController {

    @Autowired
    private GererUtilisateurService gererUtilisateurService;

    @Autowired
    private GererProjetsService gererProjetsService;

    @RequestMapping("/monCGIHosting/afficherMesProjets")
    String afficherMesProjets(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireMesProjets());
        return "monCGIHosting/mesProjets/afficherMesProjets";
    }

    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les formulaires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherMesProjetsFormulaire recupererFormulaireMesProjets() {
        UtilisateurDTO utilisateurDTO;

        utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());

        AfficherMesProjetsFormulaire afficherMesProjetsFormulaire = new AfficherMesProjetsFormulaire();

        afficherMesProjetsFormulaire.setTitrePage(ConstantesPage.MONCGIHOSTING_AFFICHAGE_MESPROJETS);
        afficherMesProjetsFormulaire.setProjetDTODPList(gererProjetsService.recupererProjetsDP(utilisateurDTO.getId()));

        return afficherMesProjetsFormulaire;
    }
}
