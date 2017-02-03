package com.cgihosting.controller.adminFonctionnel.journalisation;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielJournalisationDTO;
import com.cgihosting.formulaire.adminFonctionnel.journalisation.AfficherJournalisationFormulaire;
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


    @RequestMapping("/adminFonctionnel/afficherJournalisation")
    String afficherJournalisation(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                  @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherJournalisation(page, ligneParPage));
        return "adminFonctionnel/journalisation/afficherJournalisation";
    }



    @RequestMapping(value = "/adminFonctionnel/enregistrerReferentielJournalisation", method = RequestMethod.POST)

    String creerHebergeur(@Valid DetailsReferentielJournalisationFormulaire detailsReferentielJournalisationFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;

        ReferentielJournalisationDTO referentielJournalisationDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "adminFonctionnel/hebergeurs/detailsReferentielJournalisation";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielJournalisationDTO = detailsReferentielJournalisationFormulaire.getReferentielJournalisationDTO();

                referentielJournalisationDTO.setDateCreation(Dates.aujourdhui());
                referentielJournalisationDTO.setDateModification(Dates.aujourdhui());
                referentielJournalisationDTO.setIdCreateur(utilisateurDTO.getId());
                referentielJournalisationDTO.setIdModificateur(utilisateurDTO.getId());

                identifiantDonneeTraitee = journaliserService.creerReferentielJournalisation(referentielJournalisationDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_AJOUT_HEBERGEUR,
                                                        identifiantDonneeTraitee,  Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);




                return  "redirect:/adminFonctionnel/afficherReferentielJournalisation";

            }

        }

        else {

            return  "redirect:/adminFonctionnel/afficherReferentielJournalisation";

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


        afficherJournalisationFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_JOURNALISATION_TITRE);
        //  afficherJournalisationFormulaire.setJournalDTOListe(journaliserService.recupererJournalisation());

        afficherJournalisationFormulaire.setJournalDTOPage(journaliserService.searchAllJournalDTOPageByPage(pageCourante, numLigneAfficheParPage));


        return afficherJournalisationFormulaire;
    }






}
