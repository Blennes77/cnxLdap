package com.cgihosting.controller.admin.referetielActionsWorkflows;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.JournalDTO;
import com.cgihosting.domain.ReferentielOSDTO;
import com.cgihosting.formulaire.admin.referentielSystemesExploitation.AfficherOSFormulaire;
import com.cgihosting.formulaire.admin.referentielSystemesExploitation.DetailsOSFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererHebergeurService;
import com.cgihosting.service.admin.GererOSService;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.JournaliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by marinib on 12/01/2017.
 */
@Controller
public class ActionsWorkflowsController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private GererOSService gererOSService;

    @Autowired
    private JournaliserService journaliserService;


    @Autowired
    private GererHebergeurService gererHebergeurService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping("/admin/afficherReferentielWorkflows")
    String afficherOS(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherOS(page, ligneParPage));
        return "admin/referentielWorkflowd/afficherReferentielWrokflows";
    }

    @RequestMapping(value = "/admin/afficherDetailsReferentielWorkflows", method = RequestMethod.POST)
    String affichageDetailsOS(int identifiantOSSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsOS(identifiantOSSelect));
        return "admin/referentielWorkflowd/detailsReferentielWrorkflowd";
    }


    @RequestMapping(value = "/admin/modifierReferentielWorkflows", method = RequestMethod.POST)

    String creerOS(@Valid DetailsOSFormulaire detailsOSFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/systemesExploitation/detailsOS";
            }
            else{


                identifiantDonneeTraitee =  gererOSService.modifierReferentielOS(detailsOSFormulaire.getReferentielOSDTO());

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_OS,
                                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);



                return  "redirect:/admin/afficherReferentielWorkflowd";

            }

        }

        else {

            return  "redirect:/admin/afficherReferentielWorkflows";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherOSFormulaire recupererFormulaireAfficherOS(int pageCourante, int numLigneAfficheParPage)  {


        AfficherOSFormulaire afficherOSFormulaire = new AfficherOSFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererOSService.nombreTotalOS());
        afficherOSFormulaire.setPaginationObjet(paginationObjet);

        afficherOSFormulaire.setReferentielOSDTOPage(gererOSService.searchAllReferentielOSDTOPageByPage(pageCourante, numLigneAfficheParPage));


        afficherOSFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_OS_TITRE);
        afficherOSFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_OS);



        return afficherOSFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsOSFormulaire recupererFormulaireDetailsOS(int identifiantOSSelect) {


        /** Attributs**/
        DetailsOSFormulaire detailsOSFormulaire = new DetailsOSFormulaire();
        ReferentielOSDTO referentielOSDTO = new ReferentielOSDTO();

        if (identifiantOSSelect != 0) {
            referentielOSDTO = gererOSService.recupererReferentielOSById(identifiantOSSelect);

            detailsOSFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_OS);
        }
        else {

            detailsOSFormulaire.setBoutonSoumissionLabel(ConstantesPage.EXPLOIT_BOUTON_AJOUTER_TEMPLATE_OS);
        }



        detailsOSFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_OS_TITRE);
        detailsOSFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_LISTE_OS);


        detailsOSFormulaire.setReferentielOSDTO(referentielOSDTO);


        return detailsOSFormulaire;
    }


}
