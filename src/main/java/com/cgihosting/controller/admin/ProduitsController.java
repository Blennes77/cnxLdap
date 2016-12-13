package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.admin.gererProduits.AfficherProduitsFormulaire;
import com.cgihosting.service.admin.GererProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marinib on 09/12/2016.
 */
@Controller
public class ProduitsController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private GererProduitService gererProduitService;


    @RequestMapping("/admin/afficherProduits")
    String afficherProduits(Model model){

        model.addAttribute("formulaire", recupererFormulaireAfficherProduits());
        return "admin/produits/afficherProduits";
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherProduitsFormulaire recupererFormulaireAfficherProduits() {


        AfficherProduitsFormulaire afficherProduitsFormulaire = new AfficherProduitsFormulaire();

        afficherProduitsFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_PRODUITS_TITRE);
        afficherProduitsFormulaire.setProduitDTOListe(gererProduitService.recupererProduits());

        return afficherProduitsFormulaire;
    }




}