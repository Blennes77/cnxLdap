package com.cgihosting.controller.adminTechnique.referentielActionsWorkflows;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielActionsWorkflowDTO;
import com.cgihosting.formulaire.adminTechnique.referentielActionsWorkflows.AfficherReferentielActionsWorkflowsFormulaire;
import com.cgihosting.formulaire.adminTechnique.referentielActionsWorkflows.DetailsReferentielActionsWorkflowsFormulaire;
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
import org.springframework.web.bind.annotation.ModelAttribute;
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


    @RequestMapping(ConstantesPage.ADMINTECHNIQUE_AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_ACTION_ENTREE)
    String afficherOS(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielActionsWorkflows(page, ligneParPage));
        return ConstantesPage.ADMINTECHNIQUE_AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_PAGE_HTML;
    }

    @RequestMapping(value = ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_ACTION_ENTREE, method = RequestMethod.POST)
    String affichageDetailsReferentielWorkflowd(int identifiantWorkflowSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielActionsWorkflows(identifiantWorkflowSelect));
        return ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_PAGE_HTML;
    }


    @RequestMapping(value = ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_ACTION_MODIFIER, method = RequestMethod.POST)

    String creerOS(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML)DetailsReferentielActionsWorkflowsFormulaire detailsReferentielActionsWorkflowsFormulaire,BindingResult bindingResult, Model model,  @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielActionsWorkflowDTO referentielActionsWorkflowDTO;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {

            detailsReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_BOUTON_MODIFIER);

            detailsReferentielActionsWorkflowsFormulaire.setTitrePage(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_TITRE);
            detailsReferentielActionsWorkflowsFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_BOUTON_RETOUR);

            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielActionsWorkflowsFormulaire);


                return ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_PAGE_HTML;
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



                return  "redirect:" + ConstantesPage.ADMINTECHNIQUE_AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_ACTION_ENTREE;

            }

        }

        else {

            return  "redirect:" + ConstantesPage.ADMINTECHNIQUE_AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_ACTION_ENTREE;

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


        afficherReferentielActionsWorkflowsFormulaire.setTitrePage(ConstantesPage.ADMINTECHNIQUE_AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_TITRE);

        afficherReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINTECHNIQUE_AFFICHAGE_LISTE_ACTIONS_WORKFLOWS_BOUTON_AJOUTER);



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

            detailsReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_BOUTON_MODIFIER);
        }
        else {

            detailsReferentielActionsWorkflowsFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_BOUTON_AJOUTER);
        }



        detailsReferentielActionsWorkflowsFormulaire.setTitrePage(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_TITRE);
        detailsReferentielActionsWorkflowsFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINTECHNIQUE_DETAILS_ACTIONS_WORKFLOWS_BOUTON_RETOUR);


        detailsReferentielActionsWorkflowsFormulaire.setReferentielActionsWorkflowsDTO(referentielActionsWorkflowDTO);


        return detailsReferentielActionsWorkflowsFormulaire;
    }


}
