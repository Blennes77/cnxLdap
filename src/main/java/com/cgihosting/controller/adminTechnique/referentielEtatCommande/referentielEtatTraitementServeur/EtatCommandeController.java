package com.cgihosting.controller.adminTechnique.referentielEtatCommande.referentielEtatTraitementServeur;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielEtatCommandeDTO;
import com.cgihosting.formulaire.adminTechnique.referentielEtatCommande.AfficherReferentielEtatCommandeFormulaire;
import com.cgihosting.formulaire.adminTechnique.referentielEtatCommande.DetailsReferentielEtatCommandeFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererEtatCommandeService;
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
 * Created by marinib on 10/02/2017.
 */
@Controller
public class EtatCommandeController {


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
    private GererEtatCommandeService gererEtatCommandeService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping(ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_ACTION_ENTREE)

    String afficherReferentielEtatCommande(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielEtatCommandeServeur(page, ligneParPage));
        return ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_PAGE_HTML;
    }

    @RequestMapping(value = ConstantesPage.DETAILS_ETATCOMMANDE_ACTION_ENTREE, method = RequestMethod.POST)
    String affichageDetailsReferentielEtatTraitement(int identifiantEtatCommandeSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielEtatCommandeServeur(identifiantEtatCommandeSelect));
        return ConstantesPage.DETAILS_ETATCOMMANDE_PAGE_HTML;
    }


    @RequestMapping(value = ConstantesPage.DETAILS_ETATCOMMANDE_ACTION_MODIFIER, method = RequestMethod.POST)

    String creerEtattraitementServeur(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML)DetailsReferentielEtatCommandeFormulaire detailsReferentielEtatCommandeFormulaire, BindingResult bindingResult, Model model, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielEtatCommandeDTO referentielEtatCommandeDTO;


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {

                detailsReferentielEtatCommandeFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ETATCOMMANDE_BOUTON_MODIFIER);

                detailsReferentielEtatCommandeFormulaire.setTitrePage(ConstantesPage.DETAILS_ETATCOMMANDE_TITRE);
                detailsReferentielEtatCommandeFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_ETATCOMMANDE_BOUTON_RETOUR);


            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielEtatCommandeFormulaire);

                return ConstantesPage.DETAILS_ETATCOMMANDE_PAGE_HTML;
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielEtatCommandeDTO = detailsReferentielEtatCommandeFormulaire.getReferentielEtatCommandeDTO();
                referentielEtatCommandeDTO.setIdCreateur(utilisateurDTO.getId());
                referentielEtatCommandeDTO.setIdModificateur(utilisateurDTO.getId());
                referentielEtatCommandeDTO.setDateModification(Dates.aujourdhui());
                referentielEtatCommandeDTO.setDateCreation(Dates.aujourdhui());

                identifiantDonneeTraitee =  gererEtatCommandeService.modifierReferentielEtatCommande(referentielEtatCommandeDTO);




                return  "redirect:" + ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_ACTION_ENTREE;

            }

        }

        else {

            return  "redirect:" + ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_ACTION_ENTREE;

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherReferentielEtatCommandeFormulaire recupererFormulaireAfficherReferentielEtatCommandeServeur(int pageCourante, int numLigneAfficheParPage)  {


        AfficherReferentielEtatCommandeFormulaire afficherReferentielEtatCommandeFormulaire = new AfficherReferentielEtatCommandeFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererEtatCommandeService.nombreTotalReferentielEtatCommande());
        afficherReferentielEtatCommandeFormulaire.setPaginationObjet(paginationObjet);

        afficherReferentielEtatCommandeFormulaire.setReferentielEtatCommandeDTOPage(gererEtatCommandeService.recupererReferentielEtatCommande(pageCourante, numLigneAfficheParPage));


        afficherReferentielEtatCommandeFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_TITRE);

        afficherReferentielEtatCommandeFormulaire.setBoutonSoumissionLabel(ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_BOUTON_AJOUTER);

        afficherReferentielEtatCommandeFormulaire.setUrlActionEntree(ConstantesPage.AFFICHAGE_LISTE_ETATCOMMANDE_ACTION_ENTREE);
        afficherReferentielEtatCommandeFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_ETATCOMMANDE_ACTION_ENTREE);



        return afficherReferentielEtatCommandeFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsReferentielEtatCommandeFormulaire recupererFormulaireDetailsReferentielEtatCommandeServeur(int identifiantEtatCommandeSelect) {


        /** Attributs**/
        DetailsReferentielEtatCommandeFormulaire detailsReferentielEtatCommandeFormulaire = new DetailsReferentielEtatCommandeFormulaire();
        ReferentielEtatCommandeDTO referentielEtatCommandeDTO = new ReferentielEtatCommandeDTO();

        if (identifiantEtatCommandeSelect != 0) {
            referentielEtatCommandeDTO = gererEtatCommandeService.recupererReferentielEtatCommandeById(identifiantEtatCommandeSelect);

            detailsReferentielEtatCommandeFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ETATCOMMANDE_BOUTON_MODIFIER);
        }
        else {

            detailsReferentielEtatCommandeFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ETATCOMMANDE_BOUTON_AJOUTER);
        }



        detailsReferentielEtatCommandeFormulaire.setTitrePage(ConstantesPage.DETAILS_ETATCOMMANDE_TITRE);
        detailsReferentielEtatCommandeFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_ETATCOMMANDE_BOUTON_RETOUR);


        detailsReferentielEtatCommandeFormulaire.setReferentielEtatCommandeDTO(referentielEtatCommandeDTO);

        detailsReferentielEtatCommandeFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_ETATCOMMANDE_ACTION_MODIFIER);


        return detailsReferentielEtatCommandeFormulaire;
    }


}
