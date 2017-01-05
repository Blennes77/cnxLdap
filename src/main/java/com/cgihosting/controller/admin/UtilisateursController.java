package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.RoleUtilisateurDTO;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.admin.gererRole.AfficherUtilisateursFormulaire;
import com.cgihosting.formulaire.admin.gererRole.DetailsUtilisateurFormulaire;
import com.cgihosting.repository.UserRoleRepository;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static com.cgihosting.constantes.ConstantesAdmin.*;

/**
 * Created by garnons on 07/12/2016.
 */
@Controller
public class UtilisateursController {
    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    private AfficherUtilisateursFormulaire afficherUtilisateursFormulaire;
    private DetailsUtilisateurFormulaire detailsUtilisateurFormulaire;

    @RequestMapping(value = "/admin/afficherUtilisateurs", method = RequestMethod.GET)
    String afficherUtilisateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,
                                Model model)
    {

        //BEST CODE: model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs(page, ligneParPage));
        recupererFormulaireAfficherUtilisateurs(page, ligneParPage);
        model.addAttribute("formulaire", afficherUtilisateursFormulaire);
        return "admin/utilisateurs/afficherUtilisateurs";
    }

    @RequestMapping(value = "/admin/afficherDetailsUtilisateur", method = RequestMethod.GET)
    String detailsUtilisateur(@RequestParam("id") int id, Model model){

        recupererFormulaireDetailsUtilisateur(id);
        model.addAttribute("formulaire", detailsUtilisateurFormulaire);
        return "admin/utilisateurs/detailsUtilisateur";
    }

    @RequestMapping(value = "/admin/modifierDetailsUtilisateur", method = RequestMethod.POST)
    String submitRole(int id, boolean roleUser, boolean roleDP, boolean roleExploit, boolean roleAdmin, String action){

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {
            gererUtilisateurService.mettreAJourRolesUtilisateur(id, roleUser, roleDP, roleExploit, roleAdmin);
        }
        else {
            // DO NOTHING

        }

        return "redirect:/admin/afficherUtilisateurs";
    }


    private void recupererFormulaireAfficherUtilisateurs(int page, int ligneParPage){

        Long numTotalUsers;
        int numLigneAfficheParPage;


        // Création du formulaire afficherUtilisateurFormulaire
        // page : affiche la page demandé si le nombre d'utilisateurs ramenés est trop conséquent
        // ligneParPage : définie le nombre d'utilisateur que l'on affiche sur chaque page
        // gererRoleService : référence du bean GererRoleService

        afficherUtilisateursFormulaire = new AfficherUtilisateursFormulaire();
        afficherUtilisateursFormulaire.setNumTotalUsers(gererUtilisateurService.totalUsers());
        afficherUtilisateursFormulaire.setNumPageCourante(page);
        afficherUtilisateursFormulaire.setNbLigneAfficheParPage(ligneParPage);
        numTotalUsers = afficherUtilisateursFormulaire.getNumTotalUsers();
        numLigneAfficheParPage = afficherUtilisateursFormulaire.getNbLigneAfficheParPage();
        afficherUtilisateursFormulaire.setNumPageTotal((int) Math.ceil((double) numTotalUsers / (double) numLigneAfficheParPage));

        // Recherche des utilisateurs en fonction de la page et du nombre de ligne par page
        afficherUtilisateursFormulaire.setUtilisateurDTOPage(gererUtilisateurService.searchAllUsersByPage(page, ligneParPage));

    }

    private void recupererFormulaireDetailsUtilisateur(int id){

        detailsUtilisateurFormulaire = new DetailsUtilisateurFormulaire();
        detailsUtilisateurFormulaire.setUtilisateurDTO(gererUtilisateurService.searchUserById(id));

        detailsUtilisateurFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_MODIFIER_ROLE_UTILISATEUR);
        detailsUtilisateurFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_AFFICHER_UTILISATEURS);

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
    }
}



