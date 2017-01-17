package com.cgihosting.controller.adminTechnique.referentielVirtualisation;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.adminTechnique.referentielVirtualisation.AfficherReferentielVirtualisationFormulaire;
import com.cgihosting.formulaire.adminTechnique.referentielVirtualisation.DetailsReferentielVirtualisationFormulaire;
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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

/**
 * Created by marinib on 12/01/2017.
 */
@Controller
public class VirtualisationController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private GererVirtualisationService gererVirtualisationService;

    @Autowired
    private JournaliserService journaliserService;


    @Autowired
    private GererHebergeurService gererHebergeurService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping("/adminTechnique/afficherReferentielVirtualisation")
    String afficherVirtualisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherVirtualisation(page, ligneParPage));
        return "adminTechnique/referentielVirtualisation/afficherReferentielVirtualisation";
    }

    @RequestMapping(value = "/adminTechnique/afficherDetailsReferentielVirtualisation", method = RequestMethod.POST)
    String affichageDetailsVirtualisation(int identifiantVirtualisationSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsVirtualisation(identifiantVirtualisationSelect));
        return "adminTechnique/referentielVirtualisation/detailsReferentielVirtualisation";
    }


    @RequestMapping(value = "/adminTechnique/modifierReferentielVirtualisation", method = RequestMethod.POST)

    String creerVirtualisation(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML)DetailsReferentielVirtualisationFormulaire detailsReferentielVirtualisationFormulaire, BindingResult bindingResult, Model model,  @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;
        ReferentielVirtualisationDTO referentielVirtualisationDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {

            detailsReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_BOUTON_MODIFIER);

            detailsReferentielVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_TITRE);
            detailsReferentielVirtualisationFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_BOUTON_RETOUR);

            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielVirtualisationFormulaire);

                return "adminTechnique/referentielVirtualisation/detailsReferentielVirtualisation";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielVirtualisationDTO = detailsReferentielVirtualisationFormulaire.getReferentielVirtualisationDTO();
                referentielVirtualisationDTO.setIdModificateur(utilisateurDTO.getId());
                referentielVirtualisationDTO.setIdCreateur(utilisateurDTO.getId());
                referentielVirtualisationDTO.setDateCreation(Dates.aujourdhui());
                referentielVirtualisationDTO.setDateModification(Dates.aujourdhui());

                identifiantDonneeTraitee =  gererVirtualisationService.modifierReferentielVirtualisation(referentielVirtualisationDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_VIRTUALISATION,
                                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);



                return  "redirect:/adminTechnique/afficherReferentielVirtualisation";

            }

        }

        else {

            return  "redirect:/adminTechnique/afficherReferentielVirtualisation";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherReferentielVirtualisationFormulaire recupererFormulaireAfficherVirtualisation(int pageCourante, int numLigneAfficheParPage)  {


        AfficherReferentielVirtualisationFormulaire afficherReferentielVirtualisationFormulaire = new AfficherReferentielVirtualisationFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererVirtualisationService.nombreTotalVirtualisation());
        afficherReferentielVirtualisationFormulaire.setPaginationObjet(paginationObjet);

        afficherReferentielVirtualisationFormulaire.setReferentielVirtualisationDTOPage(gererVirtualisationService.searchAllReferentielVirtualisationDTOPageByPage(pageCourante, numLigneAfficheParPage));


        afficherReferentielVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_AFFICHAGE_LISTE_VIRTUALISATION_TITRE);
        afficherReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_AFFICHAGE_LISTE_VIRTUALISATION_BOUTON_AJOUTER);



        return afficherReferentielVirtualisationFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsReferentielVirtualisationFormulaire recupererFormulaireDetailsVirtualisation(int identifiantVirtualisationSelect) {


        /** Attributs**/
        DetailsReferentielVirtualisationFormulaire detailsReferentielVirtualisationFormulaire = new DetailsReferentielVirtualisationFormulaire();
        ReferentielVirtualisationDTO referentielVirtualisationDTO = new ReferentielVirtualisationDTO();

        if (identifiantVirtualisationSelect != 0) {
            referentielVirtualisationDTO = gererVirtualisationService.recupererReferentielVirtualisationById(identifiantVirtualisationSelect);

            detailsReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_BOUTON_MODIFIER);
        }
        else {

            referentielVirtualisationDTO.setId(0);
            detailsReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_BOUTON_AJOUTER);
        }



        detailsReferentielVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_TITRE);
        detailsReferentielVirtualisationFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_VIRTUALISATION_BOUTON_RETOUR);

        detailsReferentielVirtualisationFormulaire.setReferentielVirtualisationDTO(referentielVirtualisationDTO);


        return detailsReferentielVirtualisationFormulaire;
    }


}
