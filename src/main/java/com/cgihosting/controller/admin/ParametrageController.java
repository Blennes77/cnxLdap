package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.admin.parametres.ParametrerAppliFormulaire;
import com.cgihosting.formulaire.admin.parametres.ParametrerVCOFormulaire;
import com.cgihosting.service.admin.ParametrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marinib on 09/12/2016.
 */
@Controller
public class ParametrageController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private ParametrerService parametrerService;


    @RequestMapping("/admin/afficherParametresAppli")
    String afficherParametresOrchestrator(Model model){

        model.addAttribute("formulaire", recupererFormulaireParametrageAppli());
        return "admin/parametres/afficherParametresAppli";
    }

    @RequestMapping("/admin/afficherParametresVCO")
    String afficherParametresVCO(Model model){

        model.addAttribute("formulaire", recupererFormulaireParametrageVCO());
        return "admin/parametres/afficherParametresVCO";
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private ParametrerAppliFormulaire recupererFormulaireParametrageAppli() {


        ParametrerAppliFormulaire parametrerAppliFormulaire = new ParametrerAppliFormulaire();

        parametrerAppliFormulaire.setTitrePage(ConstantesPage.PARAMETRAGE_APPLI_TITRE);
        parametrerAppliFormulaire.setParametresAppliDTO(parametrerService.recupererParametresAppli());

        return parametrerAppliFormulaire;
    }


    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private ParametrerVCOFormulaire recupererFormulaireParametrageVCO() {


        ParametrerVCOFormulaire parametrerVCOFormulaire = new ParametrerVCOFormulaire();

        parametrerVCOFormulaire.setTitrePage(ConstantesPage.PARAMETRAGE_VCO_TITRE);
        parametrerVCOFormulaire.setParametresVCODTO(parametrerService.recupererParametresVCO());

        return parametrerVCOFormulaire;
    }




}
