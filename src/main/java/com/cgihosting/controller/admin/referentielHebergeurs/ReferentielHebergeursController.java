package com.cgihosting.controller.admin.referentielHebergeurs;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.formulaire.admin.referentielHebergeurs.AfficherReferentielHebergeursFormulaire;
import com.cgihosting.formulaire.admin.referentielHebergeurs.DetailsReferentielHebergeursFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererHebergeurService;
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
 * Created by marinib on 09/12/2016.
 */
@Controller
public class ReferentielHebergeursController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private GererHebergeurService gererHebergeurService;

    @Autowired
    private JournaliserService journaliserService;


    @RequestMapping("/admin/afficherReferentielHebergeurs")
    String afficherHebergeurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielHebergeurs(page, ligneParPage));
        return "admin/referentielHebergeurs/afficherReferentielHebergeurs";
    }



    @RequestMapping("/admin/afficherDetailsReferentielHebergeurs")
    String affichageDetailHebergeurs(int identifiantHebergeurSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielHebergeur(identifiantHebergeurSelect));
        return "admin/referentielHebergeurs/detailsReferentielHebergeur";
    }


    @RequestMapping(value = "/admin/enregistrerReferentielHebergeurs", method = RequestMethod.POST)

    String creerHebergeur(@Valid DetailsReferentielHebergeursFormulaire detailsReferentielHebergeursFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/hebergeurs/detailsReferentielHebergeurs";
            }
            else{

                identifiantDonneeTraitee = gererHebergeurService.creerReferentielHebergeur(detailsReferentielHebergeursFormulaire.getReferentielHebergeurDTO());

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_AJOUT_HEBERGEUR,
                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);




                return  "redirect:/admin/afficherReferentielHebergeurs";

            }

        }

        else {

                    return  "redirect:/admin/afficherReferentielHebergeurs";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherReferentielHebergeursFormulaire recupererFormulaireAfficherReferentielHebergeurs(int pageCourante, int numLigneAfficheParPage) {


        AfficherReferentielHebergeursFormulaire afficherReferentielHebergeursFormulaire = new AfficherReferentielHebergeursFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererHebergeurService.nombreTotalReferentielHebergeurs());
        afficherReferentielHebergeursFormulaire.setPaginationObjet(paginationObjet);


        afficherReferentielHebergeursFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_HEBGERGEURS_TITRE);
        afficherReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_HEBERGEUR);


        //afficherHebergeurFormulaire.setHebergeurDTOListe(gererHebergeurService.recupererHebergeurs());

        afficherReferentielHebergeursFormulaire.setReferentielHebergeurDTOPage(gererHebergeurService.searchAllReferentielHebergeurDtoPageByPage(pageCourante, numLigneAfficheParPage));


        return afficherReferentielHebergeursFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsReferentielHebergeursFormulaire recupererFormulaireDetailsReferentielHebergeur(int identifiantHebergeurSelect) {


        DetailsReferentielHebergeursFormulaire detailsReferentielHebergeursFormulaire = new DetailsReferentielHebergeursFormulaire();
        ReferentielHebergeurDTO referentielHebergeurDTO =  new ReferentielHebergeurDTO();


        if (identifiantHebergeurSelect != 0) {
            referentielHebergeurDTO = gererHebergeurService.recupererHebergeurById(identifiantHebergeurSelect);

            detailsReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_HEBERGEUR);
        }
        else {

            detailsReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_HEBERGEUR);
        }




        detailsReferentielHebergeursFormulaire.setReferentielHebergeurDTO(referentielHebergeurDTO);

        detailsReferentielHebergeursFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_HEBGERGEURS_TITRE);
        detailsReferentielHebergeursFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_HEBERGEUR);


        return detailsReferentielHebergeursFormulaire;
    }


}
