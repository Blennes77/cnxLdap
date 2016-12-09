package com.cgihosting.controller;

import com.cgihosting.domain.User;
import com.cgihosting.formulaire.AfficherUtilisateursFormulaire;
import com.cgihosting.formulaire.DetailsUtilisateurFormulaire;
import com.cgihosting.service.GererRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by garnons on 07/12/2016.
 */
@Controller
public class AdminController {
    @Autowired
    private GererRoleService gererRoleService;

    @RequestMapping("/admin/afficherUtilisateurs")
    String afficherUtilisateurs(Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherUtilisateurs());
        return "admin/afficherUtilisateurs";
    }

    @RequestMapping("/admin/detailsUtilisateur")
    String detailsUtilisateur(@RequestParam("id") String id, Model model){

        model.addAttribute("formulaire", recupererFormulaireDetailsUtilisateur(id));
        return "admin/detailsUtilisateur";
    }

    private AfficherUtilisateursFormulaire recupererFormulaireAfficherUtilisateurs(){
        List<User> userList;

        AfficherUtilisateursFormulaire afficherUtilisateursFormulaire = new AfficherUtilisateursFormulaire();
        afficherUtilisateursFormulaire.setUserList(gererRoleService.searchAllUsers());

        afficherUtilisateursFormulaire.setNumPageTotal(10);
        return afficherUtilisateursFormulaire;
    }

    private DetailsUtilisateurFormulaire recupererFormulaireDetailsUtilisateur(String id){
        User user;
        int idInt;

        idInt = Integer.parseInt(id);

        DetailsUtilisateurFormulaire detailsUtilisateurFormulaire = new DetailsUtilisateurFormulaire();
        detailsUtilisateurFormulaire.setUser(gererRoleService.searchUserById(idInt));

        return detailsUtilisateurFormulaire;
    }
}
