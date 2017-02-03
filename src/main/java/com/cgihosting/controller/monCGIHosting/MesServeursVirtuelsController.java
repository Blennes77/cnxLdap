package com.cgihosting.controller.monCGIHosting;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.exploit.serveursVirtuels.AfficherServeursVirtuelsFormulaire;
import com.cgihosting.formulaire.monCGIHosting.mesServeursVirtuels.DetailsMonServeurVirtuelFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.JournaliserService;
import com.cgihosting.service.exploit.GererServeursVirtuelsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by marinib on 06/01/2017.
 */
@Controller
public class MesServeursVirtuelsController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */


    @Autowired
    private GererServeursVirtuelsService gererServeursVirtuelsService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;

    @Autowired
    private JournaliserService journaliserService;


    @RequestMapping("/monCGIHosting/afficherMesServeursVirtuels")
    String afficherMesServeursVirtuels(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherServeursVirtuels(page, ligneParPage));
        return "monCGIHosting/mesServeursVirtuels/afficherMesServeursVirtuels";
    }


    @RequestMapping("/monCGIHosting/afficherDetailsMonServeurVirtuel")
    String affichageDetailMonServeurVirtuel(int identifiantServeurSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsMonServeurVirtuel(identifiantServeurSelect));
        return "monCGIHosting/mesServeursVirtuels/detailsMonServeurVirtuel";
    }




    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherServeursVirtuelsFormulaire recupererFormulaireAfficherServeursVirtuels(int pageCourante, int numLigneAfficheParPage) {


        AfficherServeursVirtuelsFormulaire afficherServeursVirtuelsFormulaire = new AfficherServeursVirtuelsFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererServeursVirtuelsService.nombreTotalServeursVirtuels());
        afficherServeursVirtuelsFormulaire.setPaginationObjet(paginationObjet);

        afficherServeursVirtuelsFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_SERVEURS_VIRTUELS_TITRE);
        afficherServeursVirtuelsFormulaire.setServeurVirtuelDTOListe(gererServeursVirtuelsService.recupererServeursVirtuels());

        afficherServeursVirtuelsFormulaire.setServeurVirtuelDTOPage(gererServeursVirtuelsService.searchAllServeurVirtuelDTOPageByPageByUser(
                                                                        pageCourante, numLigneAfficheParPage,
                                                                   gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin()).getId()));



        return afficherServeursVirtuelsFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsMonServeurVirtuelFormulaire recupererFormulaireDetailsMonServeurVirtuel(int identifiantServeurSelect) {


        DetailsMonServeurVirtuelFormulaire detailsMonServeurVirtuelFormulaire = new DetailsMonServeurVirtuelFormulaire();



        detailsMonServeurVirtuelFormulaire.setServeurVirtuelDTO(gererServeursVirtuelsService.recupererServeurVirtuelById(identifiantServeurSelect));
        detailsMonServeurVirtuelFormulaire.setTitrePage(ConstantesPage.DETAIL_SERVEUR_VIRTUEL_TITRE);
        detailsMonServeurVirtuelFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_MODIFIER_SERVEUR_VIRTUEL);
        detailsMonServeurVirtuelFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_LISTE_SERVEURS_VIRTUELS);


        return detailsMonServeurVirtuelFormulaire;
    }



}




