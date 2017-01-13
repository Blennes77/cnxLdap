package com.cgihosting.controller.admin.referentielVirtualisation;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.JournalDTO;
import com.cgihosting.domain.ReferentielVirtualisationDTO;
import com.cgihosting.formulaire.admin.referetielVirtualisation.AfficherVirtualisationFormulaire;
import com.cgihosting.formulaire.admin.referetielVirtualisation.DetailsVirtualisationFormulaire;
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


    @RequestMapping("/admin/afficherVirtualisation")
    String afficherVirtualisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherVirtualisation(page, ligneParPage));
        return "admin/virtualisation/afficherVirtualisation";
    }

    @RequestMapping(value = "/admin/afficherDetailsVirtualisation", method = RequestMethod.POST)
    String affichageDetailsVirtualisation(int identifiantVirtualisationSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsVirtualisation(identifiantVirtualisationSelect));
        return "admin/virtualisation/detailsVirtualisation";
    }


    @RequestMapping(value = "/admin/modifierVirtualisation", method = RequestMethod.POST)

    String creerVirtualisation(@Valid DetailsVirtualisationFormulaire detailsVirtualisationFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/virtualisation/detailsVirtualisation";
            }
            else{


                identifiantDonneeTraitee =  gererVirtualisationService.modifierReferentielVirtualisation(detailsVirtualisationFormulaire.getReferentielVirtualisationDTO());

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_VIRTUALISATION,
                                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);



                return  "redirect:/admin/afficherVirtualisation";

            }

        }

        else {

            return  "redirect:/admin/afficherVirtualisation";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherVirtualisationFormulaire recupererFormulaireAfficherVirtualisation(int pageCourante, int numLigneAfficheParPage)  {


        AfficherVirtualisationFormulaire afficherVirtualisationFormulaire = new AfficherVirtualisationFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererVirtualisationService.nombreTotalVirtualisation());
        afficherVirtualisationFormulaire.setPaginationObjet(paginationObjet);

        afficherVirtualisationFormulaire.setReferentielVirtualisationDTOPage(gererVirtualisationService.searchAllReferentielVirtualisationDTOPageByPage(pageCourante, numLigneAfficheParPage));


        afficherVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_VIRTUALISATION_TITRE);
        afficherVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_VIRTUALISATION);



        return afficherVirtualisationFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsVirtualisationFormulaire recupererFormulaireDetailsVirtualisation(int identifiantVirtualisationSelect) {


        /** Attributs**/
        DetailsVirtualisationFormulaire detailsVirtualisationFormulaire = new DetailsVirtualisationFormulaire();
        ReferentielVirtualisationDTO referentielVirtualisationDTO = new ReferentielVirtualisationDTO();

        if (identifiantVirtualisationSelect != 0) {
            referentielVirtualisationDTO = gererVirtualisationService.recupererReferentielVirtualisationById(identifiantVirtualisationSelect);

            detailsVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_OS);
        }
        else {

            referentielVirtualisationDTO.setId(0);
            detailsVirtualisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_VIRTUALISATION);
        }



        detailsVirtualisationFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_VIRTUALISATION_TITRE);
        detailsVirtualisationFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_LISTE_VIRTUALISATION);

        detailsVirtualisationFormulaire.setReferentielVirtualisationDTO(referentielVirtualisationDTO);


        return detailsVirtualisationFormulaire;
    }


}
