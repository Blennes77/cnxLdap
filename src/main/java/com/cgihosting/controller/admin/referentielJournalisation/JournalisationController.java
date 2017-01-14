package com.cgihosting.controller.admin.referentielJournalisation;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielJournalisationDTO;
import com.cgihosting.formulaire.admin.journalisation.AfficherJournalisationFormulaire;
import com.cgihosting.formulaire.admin.referentielJournalisation.AfficherReferentielJournalisationFormulaire;
import com.cgihosting.formulaire.admin.referentielJournalisation.DetailsReferentielJournalisationFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererUtilisateurService;
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
public class JournalisationController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private JournaliserService journaliserService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping("/admin/afficherJournalisation")
    String afficherJournalisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherJournalisation(page, ligneParPage));
        return "admin/journalisation/afficherJournalisation";
    }


    @RequestMapping("/admin/afficherReferentielJournalisation")
    String afficherReferentielJournalisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielJournalisation(page, ligneParPage));
        return "admin/journalisation/afficherReferentielJournalisation";
    }


    @RequestMapping("/admin/afficherDetailsReferentielJournalisation")
    String affichageDetailsReferentielJournalisation(int identifiantReferentielJournalisationSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielJournalisation(identifiantReferentielJournalisationSelect));
        return "admin/journalisation/detailsReferentielJournalisation";
    }


    @RequestMapping(value = "/admin/enregistrerReferentielJournalisation", method = RequestMethod.POST)

    String creerHebergeur(@Valid DetailsReferentielJournalisationFormulaire detailsReferentielJournalisationFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielJournalisationDTO referentielJournalisationDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/hebergeurs/detailsReferentielJournalisation";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielJournalisationDTO = detailsReferentielJournalisationFormulaire.getReferentielJournalisationDTO();

                referentielJournalisationDTO.setDateCreation(Dates.aujourdhui());
                referentielJournalisationDTO.setDateModification(Dates.aujourdhui());
                referentielJournalisationDTO.setIdCreateur(utilisateurDTO.getId());
                referentielJournalisationDTO.setIdModificateur(utilisateurDTO.getId());

                identifiantDonneeTraitee = journaliserService.creerReferentielJournalisation(referentielJournalisationDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_AJOUT_REF_JOURNAL,
                                                        identifiantDonneeTraitee,  Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);




                return  "redirect:/admin/afficherReferentielJournalisation";

            }

        }

        else {

            return  "redirect:/admin/afficherReferentielJournalisation";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherJournalisationFormulaire recupererFormulaireAfficherJournalisation(int pageCourante, int numLigneAfficheParPage) {


        AfficherJournalisationFormulaire afficherJournalisationFormulaire = new AfficherJournalisationFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, journaliserService.nombreTotalJournalisation());
        afficherJournalisationFormulaire.setPaginationObjet(paginationObjet);


        afficherJournalisationFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_JOURNALISATION_TITRE);
        //  afficherJournalisationFormulaire.setJournalDTOListe(journaliserService.recupererJournalisation());

        afficherJournalisationFormulaire.setJournalDTOPage(journaliserService.searchAllJournalDTOPageByPage(pageCourante, numLigneAfficheParPage));


        return afficherJournalisationFormulaire;
    }


    private AfficherReferentielJournalisationFormulaire recupererFormulaireAfficherReferentielJournalisation(int pageCourante, int numLigneAfficheParPage) {


        AfficherReferentielJournalisationFormulaire afficherReferentielJournalisationFormulaire = new AfficherReferentielJournalisationFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, journaliserService.nombreTotalReferentielJournalisation());
        afficherReferentielJournalisationFormulaire.setPaginationObjet(paginationObjet);


        afficherReferentielJournalisationFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_REFERENTIEL_JOURNALISATION_TITRE);
        afficherReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_REFERENTIEL_JOURNALISATIOn);

        afficherReferentielJournalisationFormulaire.setReferentielJournalisationDTOPage(journaliserService.searchAllReferentielJournalisationDTOPageByPage(pageCourante, numLigneAfficheParPage));


        return afficherReferentielJournalisationFormulaire;
    }


    private DetailsReferentielJournalisationFormulaire recupererFormulaireDetailsReferentielJournalisation(int identifiantReferentielJournalisationSelect) {


        DetailsReferentielJournalisationFormulaire detailsReferentielJournalisationFormulaire = new DetailsReferentielJournalisationFormulaire();
        ReferentielJournalisationDTO referentielJournalisationDTO =  new ReferentielJournalisationDTO();


        if (identifiantReferentielJournalisationSelect != 0) {
            referentielJournalisationDTO = journaliserService.recupererReferentielJournalisationById(identifiantReferentielJournalisationSelect);

            detailsReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_REFERENTIEL_JOURNALISATION);
        }
        else {

            detailsReferentielJournalisationFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_REFERENTIEL_JOURNALISATIOn);
        }




        detailsReferentielJournalisationFormulaire.setReferentielJournalisationDTO(referentielJournalisationDTO);

        detailsReferentielJournalisationFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAILS_REFERENTIEL_JOURNALISATION_TITRE);
        detailsReferentielJournalisationFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_REFERENTIEL_JOURNALISATION);


        return detailsReferentielJournalisationFormulaire;
    }





}
