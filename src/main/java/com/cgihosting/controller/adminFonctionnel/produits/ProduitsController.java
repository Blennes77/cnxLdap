package com.cgihosting.controller.adminFonctionnel.produits;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.adminFonctionnel.produits.AfficherProduitsFormulaire;
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


    @RequestMapping("/adminFonctionnel/afficherProduits")
    String afficherProduits(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherProduits());
        return "adminFonctionnel/referentielProduits/afficherProduits";
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherProduitsFormulaire recupererFormulaireAfficherProduits() {


        AfficherProduitsFormulaire afficherProduitsFormulaire = new AfficherProduitsFormulaire();

        afficherProduitsFormulaire.setTitrePage(ConstantesPage.EXPLOIT_AFFICHAGE_LISTE_PRODUITS_TITRE);
        afficherProduitsFormulaire.setProduitDTOListe(gererProduitService.recupererProduits());

        return afficherProduitsFormulaire;
    }




}
