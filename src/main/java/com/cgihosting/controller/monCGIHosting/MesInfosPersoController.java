package com.cgihosting.controller.monCGIHosting;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.monCGIHosting.mesInfosPerso.AfficherMesInfosPersoFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.service.admin.GererProjetsService;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marinib on 09/12/2016.
 */
@Controller
public class MesInfosPersoController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private GererUtilisateurService gererUtilisateurService;

    @Autowired
    private GererProjetsService gererProjetsService;

    @RequestMapping("/monCGIHosting/afficherMesInfosPerso")
    String afficherMesInfosPerso(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireMesInfosPerso());
        return "monCGIHosting/mesInfosPerso/afficherMesInfosPerso";
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherMesInfosPersoFormulaire recupererFormulaireMesInfosPerso() {


        AfficherMesInfosPersoFormulaire afficherMesInfosPersoFormulaire = new AfficherMesInfosPersoFormulaire();

        afficherMesInfosPersoFormulaire.setTitrePage(ConstantesPage.MONCGIHOSTING_AFFICHAGE_MESINFOS_PERSO_TITRE);

        afficherMesInfosPersoFormulaire.setUtilisateurDTO(gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin()));

        return afficherMesInfosPersoFormulaire;
    }




}
