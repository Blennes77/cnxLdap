package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.admin.hebergeur.AfficherHebergeurFormulaire;
import com.cgihosting.service.admin.GererHebergeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marinib on 09/12/2016.
 */
@Controller
public class HebergeursController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private GererHebergeurService gererHebergeurService;


    @RequestMapping("/admin/afficherHebergeurs")
    String afficherHebergeurs(Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherHebergeurs());
        return "admin/hebergeurs/afficherHebergeurs";
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherHebergeurFormulaire recupererFormulaireAfficherHebergeurs() {


        AfficherHebergeurFormulaire afficherHebergeurFormulaire = new AfficherHebergeurFormulaire();

        afficherHebergeurFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_HEBGERGEURS_TITRE);
        afficherHebergeurFormulaire.setHebergeurDTOListe(gererHebergeurService.recupererHebergeurs());

        return afficherHebergeurFormulaire;
    }




}
