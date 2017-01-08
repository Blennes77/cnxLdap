package com.cgihosting.controller.admin;

import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.JournalDTO;
import com.cgihosting.domain.RoleUtilisateurDTO;
import com.cgihosting.formulaire.admin.utilisateurs.AfficherUtilisateursFormulaire;
import com.cgihosting.formulaire.admin.utilisateurs.DetailsUtilisateurFormulaire;
import com.cgihosting.objets.UtilisateurSession;
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



    @RequestMapping(value = "/admin/afficherUtilisateurs", method = RequestMethod.GET)
    String afficherUtilisateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                                Model model)
    {

        model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs(page, ligneParPage, 0));
        return "admin/utilisateurs/afficherUtilisateurs";
    }

    @RequestMapping(value = "/admin/afficherExploitants", method = RequestMethod.GET)
    String afficherExploitants(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                                Model model)
    {

        model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs(page, ligneParPage, ConstantesAdmin.ROLE_EXPLOITANT));
        return "admin/utilisateurs/afficherResponsables";
    }

    @RequestMapping(value = "/admin/afficherAdministrateurs", method = RequestMethod.GET)
    String afficherAdministrateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                               @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                               Model model)
    {

        model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs(page, ligneParPage, ConstantesAdmin.ROLE_ADMIN));
        return "admin/utilisateurs/afficherResponsables";
    }

    @RequestMapping(value = "/admin/afficherDetailsUtilisateur", method = RequestMethod.POST)
    String detailsUtilisateur(@RequestParam("identifiantUtilisateurSelect") int id, Model model){

        model.addAttribute("formulaire", recupererFormulaireDetailsUtilisateur(id));
        return "admin/utilisateurs/detailsUtilisateur";
    }

    @RequestMapping(value = "/admin/modifierDetailsUtilisateur", method = RequestMethod.POST)
    String submitRole(int id, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdmin, String action){

        int identifiantDonneeTraitee = 0;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {
             gererUtilisateurService.mettreAJourRolesUtilisateur(id, roleUser, roleDP, roleExploit, roleAdmin);

            JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_ROLES_UTILISATEUR, 0);
            journaliserService.enregistrerJournalisation(journalDTO);

        }
        else {
            // DO NOTHING

        }

        return "redirect:/admin/afficherUtilisateurs";
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

        afficherUtilisateursFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_UTILISATEURS_TITRE);

        // Recherche des utilisateurs en fonction de la page et du nombre de ligne par page
        afficherUtilisateursFormulaire.setUtilisateurDTOPage(gererUtilisateurService.searchAllUsersByPage(pageCourante, numLigneAfficheParPage));

        return afficherUtilisateursFormulaire;

    }

    private DetailsUtilisateurFormulaire recupererFormulaireDetailsUtilisateur(int id){

        DetailsUtilisateurFormulaire detailsUtilisateurFormulaire = new DetailsUtilisateurFormulaire();
        detailsUtilisateurFormulaire.setUtilisateurDTO(gererUtilisateurService.searchUserById(id));

        detailsUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_MODIFIER_ROLE_UTILISATEUR);
        detailsUtilisateurFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_AFFICHER_UTILISATEURS);

        detailsUtilisateurFormulaire.setTitrePage(ConstantesPage.DETAIL_UTILISATEUR_TITRE);

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
                case ROLE_ADMIN:
                    detailsUtilisateurFormulaire.setRoleAdmin(true);
                    break;
            }
        }

        return detailsUtilisateurFormulaire;
    }
}



