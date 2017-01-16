package com.cgihosting.controller.adminFonctionnel.solutionsHebergement;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.SolutionsHebergementDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.formulaire.adminFonctionnel.solutionsHebergement.AfficherSolutionsHebergementFormulaire;
import com.cgihosting.formulaire.adminFonctionnel.solutionsHebergement.DetailsSolutionsHebergementFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererHebergeurService;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.GererVirtualisationService;
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
public class SolutionsHebergementController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private JournaliserService journaliserService;


    @Autowired
    private GererHebergeurService gererHebergeurService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @Autowired
    private GererVirtualisationService gererVirtualisationService;


    @RequestMapping("/adminFonctionnel/afficherSolutionsHebergement")
    String afficherSolutionsHebergement(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherSolutionsHebergement(page, ligneParPage));
        return "adminFonctionnel/solutionsHebergement/afficherSolutionsHebergement";
    }

    @RequestMapping(value = "/adminFonctionnel/afficherDetailsSolutionsHebergement", method = RequestMethod.POST)
    String affichageDetailsSolutionsHebergement(int identifiantSolutionHebergementSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsSolutionsHebergement(identifiantSolutionHebergementSelect));
        return "adminFonctionnel/solutionsHebergement/detailsSolutionsHebergement";
    }


    @RequestMapping(value = "/adminFonctionnel/modifierSolutionsHebergement", method = RequestMethod.POST)

    String modifierSolutionsHebergement(@Valid DetailsSolutionsHebergementFormulaire detailsSolutionsHebergementFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        SolutionsHebergementDTO solutionsHebergementDTO;
        UtilisateurDTO utilisateurDTO;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "adminFonctionnel/solutionsHebergement/detailsSolutionsHebergement";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                solutionsHebergementDTO = detailsSolutionsHebergementFormulaire.getSolutionsHebergementDTO();

                solutionsHebergementDTO.setIdCreateur(utilisateurDTO.getId());
                solutionsHebergementDTO.setIdModificateur(utilisateurDTO.getId());
                solutionsHebergementDTO.setDateCreation(Dates.aujourdhui());
                solutionsHebergementDTO.setDateModification(Dates.aujourdhui());

              identifiantDonneeTraitee =  gererHebergeurService.modifierSolutionsHebergement(detailsSolutionsHebergementFormulaire.getSolutionsHebergementDTO());


                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_OS,
                                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);



                return  "redirect:/adminFonctionnel/afficherSolutionsHebergement";

            }

        }

        else {

            return  "redirect:/adminFonctionnel/afficherSolutionsHebergement";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherSolutionsHebergementFormulaire recupererFormulaireAfficherSolutionsHebergement(int pageCourante, int numLigneAfficheParPage)  {


        AfficherSolutionsHebergementFormulaire afficherSolutionsHebergementFormulaire = new AfficherSolutionsHebergementFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererHebergeurService.nombreTotalSolutionshebergement());
        afficherSolutionsHebergementFormulaire.setPaginationObjet(paginationObjet);

        afficherSolutionsHebergementFormulaire.setSolutionsHebergementDTOPage(gererHebergeurService.searchAllSolutionsHebergementDtoPageByPage(pageCourante, numLigneAfficheParPage));


        afficherSolutionsHebergementFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_REFERENTIEL_ACTIONS_WORKFLOWS_TITRE);

        afficherSolutionsHebergementFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_REFERENTIEL_ACTIONS_WORKFLOWS);



        return afficherSolutionsHebergementFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsSolutionsHebergementFormulaire recupererFormulaireDetailsSolutionsHebergement(int identifiantSolutionsHebergement) {


        /** Attributs**/
        DetailsSolutionsHebergementFormulaire detailsSolutionsHebergementFormulaire = new DetailsSolutionsHebergementFormulaire();
        SolutionsHebergementDTO solutionsHebergementDTO = new SolutionsHebergementDTO();

        if (identifiantSolutionsHebergement != 0) {
            solutionsHebergementDTO = gererHebergeurService.recupererSolutionsHebergementById(identifiantSolutionsHebergement);

            detailsSolutionsHebergementFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_OS);
        }
        else {

            detailsSolutionsHebergementFormulaire.setBoutonSoumissionLabel(ConstantesPage.EXPLOIT_BOUTON_AJOUTER_TEMPLATE_OS);
        }



        detailsSolutionsHebergementFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_OS_TITRE);
        detailsSolutionsHebergementFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_LISTE_OS);

        detailsSolutionsHebergementFormulaire.setReferentielHebergeurDTOListe(gererHebergeurService.recupererReferentielHebergeurs());
        detailsSolutionsHebergementFormulaire.setReferentielVirtualisationDTOListe(gererVirtualisationService.recupererReferentielVirtualisation());
        detailsSolutionsHebergementFormulaire.setSolutionsHebergementDTO(solutionsHebergementDTO);


        return detailsSolutionsHebergementFormulaire;
    }


}