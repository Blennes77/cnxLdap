package com.cgihosting.controller.admin.parametres;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.JournalDTO;
import com.cgihosting.formulaire.admin.parametres.ParametrerAppliFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.JournaliserService;
import com.cgihosting.service.admin.ParametrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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


    @Autowired
    private JournaliserService journaliserService;


    @Autowired
    private Environment env;


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
     * Méthode permettant l'enregistrement des paramètres appli
     * @param model
     * @return
     */
    @RequestMapping(value = "/admin/modifierParametresAppli", method = RequestMethod.POST)

    String modifierParametresAppli(@Valid ParametrerAppliFormulaire parametrerAppliFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (!bindingResult.hasErrors()) {

                // On enregistre les paramètres

                identifiantDonneeTraitee = parametrerService.mettreAJourParametresAppli(parametrerAppliFormulaire.getParametresAppliDTO());

                // Journalisation
                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_PARAMETRESAPPLI,
                                                        identifiantDonneeTraitee,  Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);

            }


        }

        else {



        }

        return  "redirect:/admin/afficherParametresAppli";


    }






    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private ParametrerAppliFormulaire recupererFormulaireParametrageAppli() {

        ParametrerAppliFormulaire parametrerAppliFormulaire = new ParametrerAppliFormulaire();

        parametrerAppliFormulaire.setTitrePage(ConstantesPage.ADMIN_PARAMETRAGE_APPLI_TITRE);
        parametrerAppliFormulaire.setParametresAppliDTO(parametrerService.recupererParametresAppli(env.getRequiredProperty("nom.environnement")));
        parametrerAppliFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_SAUVEGARDER_PARAMETRES_APPLI);

        return parametrerAppliFormulaire;
    }








}
