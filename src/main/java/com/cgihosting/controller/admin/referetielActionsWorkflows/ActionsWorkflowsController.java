package com.cgihosting.controller.admin.referetielActionsWorkflows;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.formulaire.admin.referentielActionsWorkflows.AfficherReferentielActionsWorkflowsFormulaire;
import com.cgihosting.formulaire.admin.referentielActionsWorkflows.DetailsReferentielActionsWorkflowsFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererOSService;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.GererWorkflowsService;
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
    private GererWorkflowsService gererWorkflowsService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping("/admin/afficherReferentielActionsWorkflows")
    String afficherOS(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherReferentielActionsWorkflows(page, ligneParPage));
        return "admin/referentielActionsWorkflows/afficherReferentielActionsWorkflows";
    }

    @RequestMapping(value = "/admin/afficherDetailsReferentielActionsWorkflows", method = RequestMethod.POST)
    String affichageDetailsReferentielWorkflowd(int identifiantWorkflowSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielActionsWorkflows(identifiantWorkflowSelect));
        return "admin/referentielActionsWorkflows/detailsReferentielActionsWorkflows";
    }


    @RequestMapping(value = "/admin/modifierReferentielActionsWorkflows", method = RequestMethod.POST)

    String creerOS(@Valid DetailsReferentielActionsWorkflowsFormulaire detailsReferentielActionsWorkflowsFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielActionsWorkflowDTO referentielActionsWorkflowDTO;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/referentielActionsWorkflows/detailsReferentielActionsWorkflows";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielActionsWorkflowDTO = detailsReferentielActionsWorkflowsFormulaire.getReferentielActionsWorkflowsDTO();
                referentielActionsWorkflowDTO.setIdCreateur(utilisateurDTO.getId());
                referentielActionsWorkflowDTO.setIdModificateur(utilisateurDTO.getId());
                referentielActionsWorkflowDTO.setDateModification(Dates.aujourdhui());
                referentielActionsWorkflowDTO.setDateCreation(Dates.aujourdhui());

                identifiantDonneeTraitee =  gererWorkflowsService.modifierReferentielActionsWorkflows(referentielActionsWorkflowDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_OS,
                                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);



                return  "redirect:/admin/afficherReferentielActionsWorkflows";

            }

        }

        else {

            return  "redirect:/admin/afficherReferentielActionsWorkflows";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherReferentielActionsWorkflowsFormulaire recupererFormulaireAfficherReferentielActionsWorkflows(int pageCourante, int numLigneAfficheParPage)  {


        AfficherReferentielActionsWorkflowsFormulaire afficherReferentielActionsWorkflowsFormulaire = new AfficherReferentielActionsWorkflowsFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererWorkflowsService.nombreTotalReferentielActionsWorkflows());
        afficherReferentielActionsWorkflowsFormulaire.setPaginationObjet(paginationObjet);

        afficherReferentielActionsWorkflowsFormulaire.setReferentielActionsWorkflowDTOPage(gererWorkflowsService.recupererReferentielActionsWorkflows(pageCourante, numLigneAfficheParPage));


        afficherReferentielActionsWorkflowsFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_REFERENTIEL_ACTIONS_WORKFLOWS_TITRE);

        afficherReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_REFERENTIEL_ACTIONS_WORKFLOWS);



        return afficherReferentielActionsWorkflowsFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsReferentielActionsWorkflowsFormulaire recupererFormulaireDetailsReferentielActionsWorkflows(int identifiantWorkflowSelect) {


        /** Attributs**/
        DetailsReferentielActionsWorkflowsFormulaire detailsReferentielActionsWorkflowsFormulaire = new DetailsReferentielActionsWorkflowsFormulaire();
        ReferentielActionsWorkflowDTO referentielActionsWorkflowDTO = new ReferentielActionsWorkflowDTO();

        if (identifiantWorkflowSelect != 0) {
            referentielActionsWorkflowDTO = gererWorkflowsService.recupererReferentielActionsWorkflowsById(identifiantWorkflowSelect);

            detailsReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_OS);
        }
        else {

            detailsReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.EXPLOIT_BOUTON_AJOUTER_TEMPLATE_OS);
        }



        detailsReferentielActionsWorkflowsFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_OS_TITRE);
        detailsReferentielActionsWorkflowsFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_LISTE_OS);


        detailsReferentielActionsWorkflowsFormulaire.setReferentielActionsWorkflowsDTO(referentielActionsWorkflowDTO);


        return detailsReferentielActionsWorkflowsFormulaire;
    }


}
