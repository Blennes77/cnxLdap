package com.cgihosting.controller.adminFonctionnel.parametresApplication;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.application.JournalDTO;
import com.cgihosting.formulaire.adminFonctionnel.parametres.ParametrerAppliFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.outils.Dates;
import com.cgihosting.service.admin.JournaliserService;
import com.cgihosting.service.admin.ParametrerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @RequestMapping(ConstantesPage.AFFICHAGE_PARAMETRAGE_ACTION_ENTREE)
    String afficherParametresAppli(Model model){

        ParametrerAppliFormulaire parametrerAppliFormulaire = new ParametrerAppliFormulaire();

        configurationConstantesPagesParametrageAppli(parametrerAppliFormulaire);

        initialisationParametresParametrageAppli(parametrerAppliFormulaire);


        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, parametrerAppliFormulaire);
        return ConstantesPage.AFFICHAGE_PARAMETRAGE_PAGE_HTML;
    }



       /**
     * Méthode permettant la modification des paramètres applicatifs
     * @param model
     * @return
     */
    @RequestMapping(value = ConstantesPage.AFFICHAGE_PARAMETRAGE_ACTION_MODIFIER, method = RequestMethod.POST)

    String modifierParametresAppli(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML)  ParametrerAppliFormulaire parametrerAppliFormulaire, BindingResult bindingResult, Model model, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (!bindingResult.hasErrors()) {

                // On enregistre les paramètres

                identifiantDonneeTraitee = parametrerService.mettreAJourParametresAppli(parametrerAppliFormulaire.getParametresAppliDTO());

                // Journalisation
                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_MODIFICATION_PARAMETRESAPPLI,
                        identifiantDonneeTraitee, Dates.aujourdhui());
                journaliserService.enregistrerJournalisation(journalDTO);

                return "redirect:" + ConstantesPage.AFFICHAGE_PARAMETRAGE_ACTION_ENTREE;

            } else {

                parametrerAppliFormulaire.setBoutonSoumissionLabel(ConstantesPage.AFFICHAGE_PARAMETRAGE_BOUTON_ENREGISTRER);

                configurationConstantesPagesParametrageAppli(parametrerAppliFormulaire);

                model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, parametrerAppliFormulaire);


            }
        }

        return  ConstantesPage.AFFICHAGE_PARAMETRAGE_PAGE_HTML;


    }






    /**
     * Méthodes privée permettant de récupérer les constantes pages
     */

    private void configurationConstantesPagesParametrageAppli(ParametrerAppliFormulaire parametrerAppliFormulaire) {


        parametrerAppliFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_PARAMETRAGE_TITRE);
        parametrerAppliFormulaire.setMessageErreur((ConstantesPage.AFFICHAGE_PARAMETRAGE_MESSAGE_ERREUR));
        parametrerAppliFormulaire.setBoutonSoumissionLabel(ConstantesPage.AFFICHAGE_PARAMETRAGE_BOUTON_ENREGISTRER);
        parametrerAppliFormulaire.setUrlActionSortie(ConstantesPage.AFFICHAGE_PARAMETRAGE_ACTION_MODIFIER);

       }


    /**
     * Méthodes privée permettant de récupérer les constantes pages
     */

    private void initialisationParametresParametrageAppli(ParametrerAppliFormulaire parametrerAppliFormulaire) {

        parametrerAppliFormulaire.setParametresAppliDTO(parametrerService.recupererParametresAppli(env.getRequiredProperty("nom.environnement")));

    }






}
