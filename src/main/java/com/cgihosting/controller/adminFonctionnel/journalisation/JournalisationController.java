package com.cgihosting.controller.adminFonctionnel.journalisation;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.adminFonctionnel.journalisation.AfficherJournalisationFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.JournaliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by marinib on 09/12/2016.
 */
@Controller
public class JournalisationController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private JournaliserService journaliserService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping(ConstantesPage.AFFICHAGE_LISTE_EVENEMENT_ACTION_ENTREE)
    String afficherJournalisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherJournalisation(page, ligneParPage));
        return "adminFonctionnel/journalisation/afficherJournalisation";
    }





    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherJournalisationFormulaire recupererFormulaireAfficherJournalisation(int pageCourante, int numLigneAfficheParPage) {


        AfficherJournalisationFormulaire afficherJournalisationFormulaire = new AfficherJournalisationFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, journaliserService.nombreTotalJournalisation());
        afficherJournalisationFormulaire.setPaginationObjet(paginationObjet);


        afficherJournalisationFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_EVENEMENT_TITRE);

        //  afficherJournalisationFormulaire.setJournalDTOListe(journaliserService.recupererJournalisation());

        afficherJournalisationFormulaire.setJournalDTOPage(journaliserService.searchAllJournalDTOPageByPage(pageCourante, numLigneAfficheParPage));
        afficherJournalisationFormulaire.setUrlActionEntree(ConstantesPage.AFFICHAGE_LISTE_EVENEMENT_ACTION_ENTREE);

       // afficherJournalisationFormulaire.setUrlActionEntree();


        return afficherJournalisationFormulaire;
    }






}
