package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.UtilisateurDTO;
import com.cgihosting.formulaire.AfficherUtilisateursFormulaire;
import com.cgihosting.formulaire.admin.gererRole.DetailsUtilisateurFormulaire;
import com.cgihosting.service.admin.GererUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */
@Controller
public class UtilisateursController {

    /**
     * Déclaration  des services
     * Le tag @autowired est indispensable
     */
    @Autowired
    private GererUtilisateurService gererRoleService;


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */

    @RequestMapping("/admin/afficherUtilisateurs")
    String afficherUtilisateurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                                @RequestParam(value = "ligneParPage", required = false, defaultValue = "3") int ligneParPage,
                                Model model)
    {

        int i =0;
        model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs(page, ligneParPage));
        return "admin/utilisateurs/afficherUtilisateurs";
    }
    @RequestMapping("/admin/detailsUtilisateur")
    String detailsUtilisateur(@RequestParam("id") String id, Model model){

        model.addAttribute("formulaire", recupererFormulaireDetailsUtilisateur(id));
        return "admin/utilisateurs/detailsUtilisateur";
    }

    private AfficherUtilisateursFormulaire recupererFormulaireAfficherUtilisateurs(int page, int ligneParPage){
        List<UtilisateurDTO> utilisateurDTOListe;
        Page<UtilisateurDTO> userPage;

        //TODO : Nb d'utilisateurs Total

        AfficherUtilisateursFormulaire afficherUtilisateursFormulaire = new AfficherUtilisateursFormulaire(page, ligneParPage);

        afficherUtilisateursFormulaire.setNumTotalUsers(gererRoleService.totalUsers());


        //TODO : Recherche des utilisateurs en fonction de la page et du nombre de ligne par page
        userPage = gererRoleService.searchAllUsersByPage(afficherUtilisateursFormulaire.getNumPageCourante(), afficherUtilisateursFormulaire.getNbLigneAfficheParPage());

        afficherUtilisateursFormulaire.setUtilisateurDTOListeAffiches(userPage.getContent());
        afficherUtilisateursFormulaire.setNumPageTotal((int) Math.ceil((double) afficherUtilisateursFormulaire.getNumPageTotal() / (double) afficherUtilisateursFormulaire.getNbLigneAfficheParPage()));
        //afficherUtilisateursFormulaire.setUserList(gererRoleService.searchAllUsers());

       // afficherUtilisateursFormulaire.setNumPageTotal(10);
        return afficherUtilisateursFormulaire;
    }

    private DetailsUtilisateurFormulaire recupererFormulaireDetailsUtilisateur(String id){
        UtilisateurDTO utilisateurDTO;
        int idInt;

        idInt = Integer.parseInt(id);

        DetailsUtilisateurFormulaire detailsUtilisateurFormulaire = new DetailsUtilisateurFormulaire();
        detailsUtilisateurFormulaire.setUtilisateurDTO(gererRoleService.searchUserById(idInt));

        detailsUtilisateurFormulaire.setTitrePage(ConstantesPage.DETAIL_UTILISATEUR_TITRE);

        return detailsUtilisateurFormulaire;
    }
}
