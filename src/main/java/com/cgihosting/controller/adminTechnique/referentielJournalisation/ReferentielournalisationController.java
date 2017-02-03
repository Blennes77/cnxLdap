package com.cgihosting.controller.adminTechnique.referentielJournalisation;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielJournalisationDTO;
import com.cgihosting.formulaire.adminTechnique.referentielJournalisation.AfficherReferentielJournalisationFormulaire;
import com.cgihosting.formulaire.adminTechnique.referentielJournalisation.DetailsReferentielJournalisationFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
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
public class ReferentielournalisationController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private JournaliserService journaliserService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;



    @RequestMapping(ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_ACTION_ENTREE)
    String afficherReferentielJournalisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielJournalisation(page, ligneParPage));
        return ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_PAHE_HTML;
    }


    @RequestMapping(ConstantesPage.DETAILS_JOURNALISATION_ACTION_ENTREE)
    String affichageDetailsReferentielJournalisation(int identifiantReferentielJournalisationSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielJournalisation(identifiantReferentielJournalisationSelect));
        return ConstantesPage.DETAILS_JOURNALISATION_PAGE_HTML;
    }


    @RequestMapping(value = ConstantesPage.DETAILS_JOURNALISATION_ACTION_MODIFIER, method = RequestMethod.POST)

    String creerJournalisation(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML) DetailsReferentielJournalisationFormulaire detailsReferentielJournalisationFormulaire , BindingResult bindingResult, Model model,  @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielJournalisationDTO referentielJournalisationDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {
                detailsReferentielJournalisationFormulaire.setTitrePage(ConstantesPage.DETAILS_JOURNALISATION_TITRE);
                detailsReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_JOURNALISATION_BOUTON_MODIFIER);
                detailsReferentielJournalisationFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_JOURNALISATION_BOUTON_RETOUR);
                model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielJournalisationFormulaire);


                return ConstantesPage.DETAILS_JOURNALISATION_PAGE_HTML;
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielJournalisationDTO = detailsReferentielJournalisationFormulaire.getReferentielJournalisationDTO();

                referentielJournalisationDTO.setDateCreation(Dates.aujourdhui());
                referentielJournalisationDTO.setDateModification(Dates.aujourdhui());
                referentielJournalisationDTO.setIdCreateur(utilisateurDTO.getId());
                referentielJournalisationDTO.setIdModificateur(utilisateurDTO.getId());

                identifiantDonneeTraitee = journaliserService.creerReferentielJournalisation(referentielJournalisationDTO);




                return  "redirect:" + ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_ACTION_ENTREE;

            }

        }

        else {

            return  "redirect:" + ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_ACTION_ENTREE;

        }


    }





    private AfficherReferentielJournalisationFormulaire recupererFormulaireAfficherReferentielJournalisation(int pageCourante, int numLigneAfficheParPage) {


        AfficherReferentielJournalisationFormulaire afficherReferentielJournalisationFormulaire = new AfficherReferentielJournalisationFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, journaliserService.nombreTotalReferentielJournalisation());
        afficherReferentielJournalisationFormulaire.setPaginationObjet(paginationObjet);


        afficherReferentielJournalisationFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_TITRE);
        afficherReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_BOUTON_AJOUTER);

        afficherReferentielJournalisationFormulaire.setReferentielJournalisationDTOPage(journaliserService.searchAllReferentielJournalisationDTOPageByPage(pageCourante, numLigneAfficheParPage));

        afficherReferentielJournalisationFormulaire.setUrlActionEntree(ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_ACTION_ENTREE);
        afficherReferentielJournalisationFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_JOURNALISATION_ACTION_ENTREE);

        return afficherReferentielJournalisationFormulaire;
    }


    private DetailsReferentielJournalisationFormulaire recupererFormulaireDetailsReferentielJournalisation(int identifiantReferentielJournalisationSelect) {


        DetailsReferentielJournalisationFormulaire detailsReferentielJournalisationFormulaire = new DetailsReferentielJournalisationFormulaire();
        ReferentielJournalisationDTO referentielJournalisationDTO =  new ReferentielJournalisationDTO();


        if (identifiantReferentielJournalisationSelect != 0) {
            referentielJournalisationDTO = journaliserService.recupererReferentielJournalisationById(identifiantReferentielJournalisationSelect);

            detailsReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_JOURNALISATION_BOUTON_MODIFIER);
        }
        else {

            detailsReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_JOURNALISATION_BOUTON_AJOUTER);
        }




        detailsReferentielJournalisationFormulaire.setReferentielJournalisationDTO(referentielJournalisationDTO);

        detailsReferentielJournalisationFormulaire.setTitrePage(ConstantesPage.DETAILS_JOURNALISATION_TITRE);
        detailsReferentielJournalisationFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_JOURNALISATION_BOUTON_RETOUR);
        detailsReferentielJournalisationFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_JOURNALISATION_ACTION_MODIFIER);


        return detailsReferentielJournalisationFormulaire;
    }





}
