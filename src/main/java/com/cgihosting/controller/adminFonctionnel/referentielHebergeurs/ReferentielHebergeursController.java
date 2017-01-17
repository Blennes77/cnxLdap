package com.cgihosting.controller.adminFonctionnel.referentielHebergeurs;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielHebergeurDTO;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.formulaire.adminFonctionnel.referentielHebergeurs.AfficherReferentielHebergeursFormulaire;
import com.cgihosting.formulaire.adminFonctionnel.referentielHebergeurs.DetailsReferentielHebergeursFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererHebergeurService;
import com.cgihosting.service.admin.GererUtilisateurService;
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

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping("/adminFonctionnel/afficherReferentielHebergeurs")
    String afficherHebergeurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielHebergeurs(page, ligneParPage));
        return "adminFonctionnel/referentielHebergeurs/afficherReferentielHebergeurs";
    }



    @RequestMapping("/adminFonctionnel/afficherDetailsReferentielHebergeurs")
    String affichageDetailHebergeurs(int identifiantHebergeurSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielHebergeur(identifiantHebergeurSelect));
        return "adminFonctionnel/referentielHebergeurs/detailsReferentielHebergeur";
    }


    @RequestMapping(value = "/adminFonctionnel/enregistrerReferentielHebergeurs", method = RequestMethod.POST)

    String creerHebergeur(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML) DetailsReferentielHebergeursFormulaire detailsReferentielHebergeursFormulaire, BindingResult bindingResult, Model model,  @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielHebergeurDTO referentielHebergeurDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {

            detailsReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_BOUTON_AJOUTER);

            detailsReferentielHebergeursFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_TITRE);
            detailsReferentielHebergeursFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_BOUTON_RETOUR);


            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielHebergeursFormulaire);


                return "adminFonctionnel/referentielHebergeurs/detailsReferentielHebergeur";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());

                referentielHebergeurDTO = detailsReferentielHebergeursFormulaire.getReferentielHebergeurDTO();
                referentielHebergeurDTO.setIdModificateur(utilisateurDTO.getId());
                referentielHebergeurDTO.setIdCreateur(utilisateurDTO.getId());
                referentielHebergeurDTO.setDateCreation(Dates.aujourdhui());
                referentielHebergeurDTO.setDateModification(Dates.aujourdhui());

                identifiantDonneeTraitee = gererHebergeurService.creerReferentielHebergeur(referentielHebergeurDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_AJOUT_HEBERGEUR,
                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);




                return  "redirect:/adminFonctionnel/afficherReferentielHebergeurs";

            }

        }

        else {

                    return  "redirect:/adminFonctionnel/afficherReferentielHebergeurs";

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


        afficherReferentielHebergeursFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_AFFICHAGE_LISTE_HEBERGEURS_TITRE);
        afficherReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_AFFICHAGE_LISTE_HEBERGEURS_BOUTON_AJOUTER);


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

            detailsReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_BOUTON_MODIFIER);
        }
        else {

            detailsReferentielHebergeursFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_BOUTON_AJOUTER);
        }




        detailsReferentielHebergeursFormulaire.setReferentielHebergeurDTO(referentielHebergeurDTO);

        detailsReferentielHebergeursFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_TITRE);
        detailsReferentielHebergeursFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_HEBERGEURS_BOUTON_RETOUR);


        return detailsReferentielHebergeursFormulaire;
    }


}
