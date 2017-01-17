package com.cgihosting.controller.adminTechnique.referentielRoles;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.UtilisateurDTO;
import com.cgihosting.domain.referentiel.ReferentielRolesDTO;
import com.cgihosting.formulaire.adminTechnique.referentielRolesUtilisateur.AfficherReferentielRolesUtilisateurFormulaire;
import com.cgihosting.formulaire.adminTechnique.referentielRolesUtilisateur.DetailsReferentielRolesUtilisateurFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
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
 * Created by marinib on 16/01/2017.
 */
@Controller
public class RolesController {


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
    private GererUtilisateurService gererUtilisateurService;


    @RequestMapping("/adminTechnique/afficherReferentielRolesUtilisateur")
    String afficherRolesUtilisateur(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherReferentielRolesUtilisateur(page, ligneParPage));
        return "adminTechnique/referentielRolesutilisateur/afficherReferentielRolesUtilisateur";
    }

    @RequestMapping(value = "/adminTechnique/afficherDetailsReferentielRolesUtilisateur", method = RequestMethod.POST)
    String affichageDetailsRolesUtilisateur(int identifiantRolesUtilisateurSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsReferentielRoles(identifiantRolesUtilisateurSelect));
        return "adminTechnique/referentielRolesUtilisateur/detailsReferentielRolesUtilisateur";
    }


    @RequestMapping(value = "/adminTechnique/modifierReferentielRolesUtilisateur", method = RequestMethod.POST)

    String creerRoleUtilisateur(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML)DetailsReferentielRolesUtilisateurFormulaire detailsReferentielRolesUtilisateurFormulaire, BindingResult bindingResult, Model model,  @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        UtilisateurDTO utilisateurDTO;
        ReferentielRolesDTO referentielRolesDTO;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {

            detailsReferentielRolesUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_BOUTON_AJOUTER);

            detailsReferentielRolesUtilisateurFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_TITRE);
            detailsReferentielRolesUtilisateurFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_BOUTON_RETOUR);

            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, detailsReferentielRolesUtilisateurFormulaire);
                return "adminTechnique/referentielRolesUtilisateur/detailsReferentielRolesutilisateur";
            }
            else{

                utilisateurDTO = gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin());
                referentielRolesDTO = detailsReferentielRolesUtilisateurFormulaire.getReferentielRolesDTO();
                referentielRolesDTO.setIdModificateur(utilisateurDTO.getId());
                referentielRolesDTO.setIdCreateur(utilisateurDTO.getId());
                referentielRolesDTO.setDateCreation(Dates.aujourdhui());
                referentielRolesDTO.setDateModification(Dates.aujourdhui());

                identifiantDonneeTraitee =  gererUtilisateurService.modifierReferentielRolesUtilisateur(referentielRolesDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_VIRTUALISATION,
                                                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);



                return  "redirect:/adminTechnique/afficherReferentielRolesUtilisateur";

            }

        }

        else {

            return  "redirect:/adminTechnique/afficherReferentielRolesUtilisateur";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherReferentielRolesUtilisateurFormulaire recupererFormulaireAfficherReferentielRolesUtilisateur(int pageCourante, int numLigneAfficheParPage)  {


        AfficherReferentielRolesUtilisateurFormulaire afficherReferentielRolesUtilisateurFormulaire = new AfficherReferentielRolesUtilisateurFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererVirtualisationService.nombreTotalVirtualisation());
        afficherReferentielRolesUtilisateurFormulaire.setPaginationObjet(paginationObjet);

        afficherReferentielRolesUtilisateurFormulaire.setReferentielRolesDTOPage(gererUtilisateurService.searchAllReferentielRolesUtilisateurDTOPageByPage(pageCourante, numLigneAfficheParPage));


        afficherReferentielRolesUtilisateurFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_AFFICHAGE_LISTE_ROLES_UTILISATEUR_TITRE);
        afficherReferentielRolesUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_AFFICHAGE_LISTE_ROLES_UTILISATEUR_BOUTON_AJOUTER);



        return afficherReferentielRolesUtilisateurFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsReferentielRolesUtilisateurFormulaire recupererFormulaireDetailsReferentielRoles(int identifiantReferentielRolesSelect) {


        /** Attributs**/
        DetailsReferentielRolesUtilisateurFormulaire detailsReferentielRolesUtilisateurFormulaire = new DetailsReferentielRolesUtilisateurFormulaire();
        ReferentielRolesDTO referentielRolesDTO = new ReferentielRolesDTO();

        if (identifiantReferentielRolesSelect != 0) {
            referentielRolesDTO = gererUtilisateurService.recupererReferentielRolesUtilisateurById(identifiantReferentielRolesSelect);

            detailsReferentielRolesUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_BOUTON_MODIFIER);
        }
        else {

            referentielRolesDTO.setId(0);
            detailsReferentielRolesUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_BOUTON_AJOUTER);
        }



        detailsReferentielRolesUtilisateurFormulaire.setTitrePage(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_TITRE);
        detailsReferentielRolesUtilisateurFormulaire.setBoutonRetourLabel(ConstantesPage.ADMINFONCTIONNEL_DETAILS_ROLES_UTILISATEUR_BOUTON_RETOUR);

        detailsReferentielRolesUtilisateurFormulaire.setReferentielRolesDTO(referentielRolesDTO);


        return detailsReferentielRolesUtilisateurFormulaire;
    }


}
