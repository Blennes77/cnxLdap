package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.admin.parametres.ParametrerAppliFormulaire;
import com.cgihosting.formulaire.admin.parametres.ParametrerVCOFormulaire;
import com.cgihosting.service.admin.ParametrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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


    /**
     * Méthode permettant l'affichage des paramètres appli
     * @param model
     * @return
     */

    @RequestMapping("/admin/afficherParametresAppli")
    String afficherParametresAppli(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireParametrageAppli());
        return "admin/parametres/afficherParametresAppli";
    }

    /**
     * Méthode permettant l'affichage des paramètres VCO
     * @param model
     * @return
     */
    @RequestMapping("/admin/afficherParametresVCO")
    String afficherParametresVCO(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireParametrageVCO());
        return "admin/parametres/afficherParametresVCO";
    }


       /**
     * Méthode permettant l'enregistrement des paramètres appli
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/modifierParametresAppli", method = RequestMethod.POST)

    String modifierParametresAppli(@Valid ParametrerAppliFormulaire parametrerAppliFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (!bindingResult.hasErrors()) {

                // On enregistre les paramètres

                parametrerService.mettreAJourParametresAppli(parametrerAppliFormulaire.getParametresAppliDTO());


            }


        }

        else {



        }

        return  "redirect:/admin/afficherParametresAppli";


    }


    /**
     * Méthode permettant l'enregistrement des paramètres VCO
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/modifierParametresVCO", method = RequestMethod.POST)

    String modifierParametresVCO(@Valid ParametrerVCOFormulaire parametrerVCOFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (!bindingResult.hasErrors()) {

                // On enregistre les paramètres

                parametrerService.mettreAJourParametresVCO(parametrerVCOFormulaire.getParametresVCODTO());
            }


        }

        else {



        }

        return  "redirect:/admin/afficherParametresVCO";


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
        parametrerAppliFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_SAUVEGARDER_PARAMETRES_APPLI);

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
        parametrerVCOFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_SAUVEGARDER_PARAMETRES_VCO);

        return parametrerVCOFormulaire;
    }




}
