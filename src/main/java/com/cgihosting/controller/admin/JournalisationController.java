package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.admin.journaliser.AfficherJournalisationFormulaire;
import com.cgihosting.service.admin.JournaliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/admin/afficherJournalisation")
    String afficherJournalisation(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherJournalisation());
        return "admin/journalisation/afficherJournalisation";
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherJournalisationFormulaire recupererFormulaireAfficherJournalisation() {


        AfficherJournalisationFormulaire afficherJournalisationFormulaire = new AfficherJournalisationFormulaire();

        afficherJournalisationFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_JOURNALISATION_TITRE);
        afficherJournalisationFormulaire.setJournalDTOListe(journaliserService.recupererJournalisation());

        return afficherJournalisationFormulaire;
    }




}
