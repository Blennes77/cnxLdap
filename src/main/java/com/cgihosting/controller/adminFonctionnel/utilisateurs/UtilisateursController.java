package com.cgihosting.controller.adminFonctionnel.utilisateurs;

import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.domain.application.RoleUtilisateurDTO;
import com.cgihosting.formulaire.adminFonctionnel.utilisateurs.AfficherUtilisateursFormulaire;
import com.cgihosting.formulaire.adminFonctionnel.utilisateurs.DetailsUtilisateurFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.JournaliserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static com.cgihosting.constantes.ConstantesAdmin.*;

/**
 * Created by garnons on 07/12/2016.
 */
@Controller
public class UtilisateursController {
    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @Autowired
    private JournaliserService journaliserService;



    @RequestMapping(value = ConstantesPage.AFFICHAGE_LISTE_UTILISATEURS_ACTION_ENTREE, method = RequestMethod.GET)
    String afficherUtilisateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                                Model model)
    {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherUtilisateurs(page, ligneParPage, 0));
        return ConstantesPage.AFFICHAGE_LISTE_UTILISATEURS_PAGE_HTML;
    }

    @RequestMapping(value = "/adminFonctionnel/afficherExploitants", method = RequestMethod.GET)
    String afficherExploitants(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                                Model model)
    {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherUtilisateurs(page, ligneParPage, ConstantesAdmin.ROLE_EXPLOITANT));
        return "adminFonctionnel/utilisateurs/afficherResponsables";
    }

    @RequestMapping(value = "/adminFonctionnel/afficherAdministrateurs", method = RequestMethod.GET)
    String afficherAdministrateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                               @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                               Model model)
    {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherUtilisateurs(page, ligneParPage, ConstantesAdmin.ROLE_ADMIN_FONCTIONNEL));
        return "adminFonctionnel/utilisateurs/afficherResponsables";
    }

    @RequestMapping(value = ConstantesPage.DETAILS_ROLES_ACTION_ENTREE, method = RequestMethod.POST)
    String detailsUtilisateur(@RequestParam("identifiantUtilisateurSelect") int id, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsUtilisateur(id));
        return ConstantesPage.DETAILS_ROLES_PAGE_HTML;
    }

    @RequestMapping(value = ConstantesPage.DETAILS_ROLES_ACTION_MODIFIER, method = RequestMethod.POST)
    String submitRole(int id, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdminTechnique, boolean roleAdminFonctionnel, String action){

        int identifiantDonneeTraitee = 0;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {
             gererUtilisateurService.mettreAJourRolesUtilisateur(id, roleUser, roleDP, roleExploit, roleAdminTechnique, roleAdminFonctionnel);

            JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_ROLES_UTILISATEUR,
                        null, Dates.aujourdhui());
            journaliserService.enregistrerJournalisation(journalDTO);

        }
        else {
            // DO NOTHING

        }

        return "redirect:" + ConstantesPage.AFFICHAGE_LISTE_UTILISATEURS_ACTION_ENTREE;
    }


    private AfficherUtilisateursFormulaire recupererFormulaireAfficherUtilisateurs(int pageCourante, int numLigneAfficheParPage, int roleUtilisateur){

        Long numTotalLignes;


        // Création du formulaire afficherUtilisateurFormulaire
        // page : affiche la page demandé si le nombre d'utilisateurs ramenés est trop conséquent
        // ligneParPage : définie le nombre d'utilisateur que l'on affiche sur chaque page
        // gererRoleService : référence du bean GererRoleService

        AfficherUtilisateursFormulaire afficherUtilisateursFormulaire = new AfficherUtilisateursFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererUtilisateurService.nombreTotalUtilisateurs(roleUtilisateur));
        afficherUtilisateursFormulaire.setPaginationObjet(paginationObjet);

        afficherUtilisateursFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_UTILISATEURS_TITRE);

        // Recherche des utilisateurs en fonction de la page et du nombre de ligne par page
        afficherUtilisateursFormulaire.setUtilisateurDTOPage(gererUtilisateurService.searchAllUsersByPage(pageCourante, numLigneAfficheParPage));

        afficherUtilisateursFormulaire.setUrlActionEntree(ConstantesPage.AFFICHAGE_LISTE_UTILISATEURS_ACTION_ENTREE);
        afficherUtilisateursFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_ROLES_ACTION_ENTREE);


        return afficherUtilisateursFormulaire;

    }

    private DetailsUtilisateurFormulaire recupererFormulaireDetailsUtilisateur(int id){

        DetailsUtilisateurFormulaire detailsUtilisateurFormulaire = new DetailsUtilisateurFormulaire();
        detailsUtilisateurFormulaire.setUtilisateurDTO(gererUtilisateurService.searchUserById(id));

        detailsUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.DETAILS_ROLES_BOUTON_MODIFIER);
        detailsUtilisateurFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_ROLES_BOUTON_RETOUR);

        detailsUtilisateurFormulaire.setTitrePage(ConstantesPage.DETAILS_ROLES_TITRE);

        detailsUtilisateurFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_ROLES_ACTION_MODIFIER);


        List<RoleUtilisateurDTO> listRolesUtilisateurDTO = gererUtilisateurService.recupererRolesUtilisateur(id);
        for(int i = 0; i<listRolesUtilisateurDTO.size();i++){
            switch (listRolesUtilisateurDTO.get(i).getIdRole()){
                case ROLE_USER:
                    detailsUtilisateurFormulaire.setRoleUser(true);
                    break;
                case ROLE_EXPLOITANT:
                    detailsUtilisateurFormulaire.setRoleExploit(true);
                    break;
                case ROLE_DP:
                    detailsUtilisateurFormulaire.setRoleDp(true);
                    break;
                case ROLE_ADMIN_TECHNIQUE:
                    detailsUtilisateurFormulaire.setRoleAdmin(true);
                    break;
                case ROLE_ADMIN_FONCTIONNEL:
                    detailsUtilisateurFormulaire.setRoleAdmin(true);
                    break;
            }
        }

        return detailsUtilisateurFormulaire;
    }
}



