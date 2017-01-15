package com.cgihosting.controller.adminFonctionnel.referentielVirtualisation;

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


    @RequestMapping("/admin/afficherReferentielVirtualisation")
    String afficherVirtualisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherVirtualisation(page, ligneParPage));
        return "admin/referentielVirtualisation/afficherReferentielVirtualisation";
    }

    @RequestMapping(value = "/admin/afficherDetailsReferentielVirtualisation", method = RequestMethod.POST)
    String affichageDetailsVirtualisation(int identifiantVirtualisationSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsVirtualisation(identifiantVirtualisationSelect));
        return "admin/referentielVirtualisation/detailsReferentielVirtualisation";
    }


    @RequestMapping(value = "/admin/modifierReferentielVirtualisation", method = RequestMethod.POST)

    String creerVirtualisation(@Valid DetailsReferentielVirtualisationFormulaire detailsReferentielVirtualisationFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;
        ReferentielVirtualisationDTO referentielVirtualisationDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/referentielVirtualisation/detailsReferentielVirtualisation";
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



                return  "redirect:/admin/afficherReferentielVirtualisation";

            }

        }

        else {

            return  "redirect:/admin/afficherReferentielVirtualisation";

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


        afficherReferentielVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_VIRTUALISATION_TITRE);
        afficherReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_VIRTUALISATION);



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

            detailsReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_OS);
        }
        else {

            referentielVirtualisationDTO.setId(0);
            detailsReferentielVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_VIRTUALISATION);
        }



        detailsReferentielVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_VIRTUALISATION_TITRE);
        detailsReferentielVirtualisationFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_LISTE_VIRTUALISATION);

        detailsReferentielVirtualisationFormulaire.setReferentielVirtualisationDTO(referentielVirtualisationDTO);


        return detailsReferentielVirtualisationFormulaire;
    }


}
