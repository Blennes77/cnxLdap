package com.cgihosting.controller.adminTechnique.referentielEtatTraitementServeur;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielEtatTraitementServeurDTO;
import com.cgihosting.formulaire.adminTechnique.refrentielEtatTraitementServeur.AfficherReferentielEtatTraitementServeurFormulaire;
import com.cgihosting.formulaire.adminTechnique.refrentielEtatTraitementServeur.DetailsReferentielEtatTraitementServeurFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererEtatTraitementService;
import com.cgihosting.service.admin.GererOSService;
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
 * Created by marinib on 14/01/2017.
 */
@Controller
public class EtatTraitementServeurController {


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
    private GererEtatTraitementService gererEtatTraitementService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping(ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_ACTION_ENTREE)

    String afficherReferentielEtatTraitement(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielEtatTraitementServeur(page, ligneParPage));
        return ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_PAGE_HTML;
    }

    @RequestMapping(value = ConstantesPage.DETAILS_ETATTRAITEMENT_ACTION_ENTREE, method = RequestMethod.POST)
    String affichageDetailsReferentielEtatTraitement(int identifiantEtatTraitementServeurSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielEtatTraitementServeur(identifiantEtatTraitementServeurSelect));
        return ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_PAGE_HTML;
    }


    @RequestMapping(value = ConstantesPage.DETAILS_ETATTRAITEMENT_ACTION_MODIFIER, method = RequestMethod.POST)

    String creerEtattraitementServeur(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML)DetailsReferentielEtatTraitementServeurFormulaire detailsReferentielEtatTraitementServeurFormulaire, BindingResult bindingResult, Model model, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {

            detailsReferentielEtatTraitementServeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_MODIFIER);

            detailsReferentielEtatTraitementServeurFormulaire.setTitrePage(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_TITRE);
            detailsReferentielEtatTraitementServeurFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_RETOUR);


            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielEtatTraitementServeurFormulaire);

                return ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_PAGE_HTML;
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielEtatTraitementServeurDTO = detailsReferentielEtatTraitementServeurFormulaire.getReferentielEtatTraitementServeurDTO();
                referentielEtatTraitementServeurDTO.setIdCreateur(utilisateurDTO.getId());
                referentielEtatTraitementServeurDTO.setIdModificateur(utilisateurDTO.getId());
                referentielEtatTraitementServeurDTO.setDateModification(Dates.aujourdhui());
                referentielEtatTraitementServeurDTO.setDateCreation(Dates.aujourdhui());

                identifiantDonneeTraitee =  gererEtatTraitementService.modifierReferentielEtatTraitement(referentielEtatTraitementServeurDTO);




                return  "redirect:" + ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_ACTION_ENTREE;

            }

        }

        else {

            return  "redirect:" + ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_ACTION_ENTREE;

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherReferentielEtatTraitementServeurFormulaire recupererFormulaireAfficherReferentielEtatTraitementServeur(int pageCourante, int numLigneAfficheParPage)  {


        AfficherReferentielEtatTraitementServeurFormulaire afficherReferentielEtatTraitementServeurFormulaire = new AfficherReferentielEtatTraitementServeurFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererEtatTraitementService.nombreTotalReferentielEtatTraitement());
        afficherReferentielEtatTraitementServeurFormulaire.setPaginationObjet(paginationObjet);

        afficherReferentielEtatTraitementServeurFormulaire.setReferentielEtatTraitementServeurDTOPage(gererEtatTraitementService.recupererReferentielEtatTraitement(pageCourante, numLigneAfficheParPage));


        afficherReferentielEtatTraitementServeurFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_TITRE);

        afficherReferentielEtatTraitementServeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_BOUTON_AJOUTER);

        afficherReferentielEtatTraitementServeurFormulaire.setUrlActionEntree(ConstantesPage.AFFICHAGE_LISTE_ETATTRAITEMENT_SERVEURS_ACTION_ENTREE);
        afficherReferentielEtatTraitementServeurFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_ETATTRAITEMENT_ACTION_ENTREE);



        return afficherReferentielEtatTraitementServeurFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsReferentielEtatTraitementServeurFormulaire recupererFormulaireDetailsReferentielEtatTraitementServeur(int identifiantEtattraitementServeurSelect) {


        /** Attributs**/
        DetailsReferentielEtatTraitementServeurFormulaire detailsReferentielEtatTraitementServeurFormulaire = new DetailsReferentielEtatTraitementServeurFormulaire();
        ReferentielEtatTraitementServeurDTO referentielEtatTraitementServeurDTO = new ReferentielEtatTraitementServeurDTO();

        if (identifiantEtattraitementServeurSelect != 0) {
            referentielEtatTraitementServeurDTO = gererEtatTraitementService.recupererReferentielEtatTraitementById(identifiantEtattraitementServeurSelect);

            detailsReferentielEtatTraitementServeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_MODIFIER);
        }
        else {

            detailsReferentielEtatTraitementServeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_AJOUTER);
        }



        detailsReferentielEtatTraitementServeurFormulaire.setTitrePage(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_TITRE);
        detailsReferentielEtatTraitementServeurFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_ETATTRAITEMENT_SERVEURS_BOUTON_RETOUR);


        detailsReferentielEtatTraitementServeurFormulaire.setReferentielEtatTraitementServeurDTO(referentielEtatTraitementServeurDTO);

        detailsReferentielEtatTraitementServeurFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_ETATTRAITEMENT_ACTION_MODIFIER);


        return detailsReferentielEtatTraitementServeurFormulaire;
    }


}
