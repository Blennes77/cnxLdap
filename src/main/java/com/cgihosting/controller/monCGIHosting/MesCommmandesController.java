package com.cgihosting.controller.monCGIHosting;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.monCGIHosting.mesCommandes.AfficherMesCommandesFormulaire;
import com.cgihosting.formulaire.monCGIHosting.mesCommandes.DetailsMesCommandeFormulaire;
import com.cgihosting.service.admin.GererProjetsService;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.GererWorkflowsService;
import com.cgihosting.service.admin.JournaliserService;
import com.cgihosting.service.exploit.GererCommandeService;
import com.cgihosting.service.exploit.GererServeursVirtuelsService;
import com.cgihosting.service.exploit.GererTemplateOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by marinib on 06/01/2017.
 */
@Controller
public class MesCommmandesController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */


    @Autowired
    private GererCommandeService gererCommandeService;

    @Autowired
    private GererTemplateOSService gererTemplateOSService;

    @Autowired
    private GererServeursVirtuelsService gererServeursVirtuelsService;

    @Autowired
    private JournaliserService journaliserService;

    @Autowired
    private GererProjetsService gererProjetsService;

    @Autowired
    private GererUtilisateurService gererUtilisateurService;


    @Autowired
    private GererWorkflowsService gererWorkflowsService;

    @Autowired
    private Environment env;


    @RequestMapping(ConstantesPage.AFFICHAGE_LISTE_MESCOMMANDES_ACTION_ENTREE)
    String afficherCommandes(Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireCommandes());
        return ConstantesPage.AFFICHAGE_LISTE_MESCOMMANDES_PAGE_HTML;
    }


    @RequestMapping(value = ConstantesPage.DETAILS_MESCOMMANDES_ACTION_ENTREE, method = RequestMethod.POST)
    String affichageDetailsCommande(int identifiantCommandeSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsCommande(identifiantCommandeSelect));
        return ConstantesPage.DETAILS_MESCOMMANDES_PAGE_HTML;
    }


    @RequestMapping(value = ConstantesPage.DETAILS_MESCOMMANDES_ACTION_MODIFIER, method = RequestMethod.POST)
    String quitterCommande(Model model, BindingResult bindingResult, @RequestParam String action) {


        return "redirect:" + ConstantesPage.AFFICHAGE_LISTE_MESCOMMANDES_ACTION_ENTREE;


    }


    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherMesCommandesFormulaire recupererFormulaireCommandes() {

        int identifiant = 1;

        AfficherMesCommandesFormulaire afficherMesCommandesFormulaire = new AfficherMesCommandesFormulaire();

        afficherMesCommandesFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_LISTE_MESCOMMANDES_TITRE);

        afficherMesCommandesFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_MESCOMMANDES_ACTION_ENTREE);


        afficherMesCommandesFormulaire.setCommandeDTOUtilisateurNonDPListe(gererCommandeService.recupererCommandesNonDPById(5));


        afficherMesCommandesFormulaire.setCommandeDTOUtilisateurDPListe(gererCommandeService.recupererCommandesDPById(5));

        return afficherMesCommandesFormulaire;
    }


    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsMesCommandeFormulaire recupererFormulaireDetailsCommande(int identifiantCommandeSelect) {


        DetailsMesCommandeFormulaire detailsMesCommandeFormulaire = new DetailsMesCommandeFormulaire();


        detailsMesCommandeFormulaire.setCommandeDTO(gererCommandeService.recupererCommandeById(identifiantCommandeSelect));
        detailsMesCommandeFormulaire.setTitrePage(ConstantesPage.DETAILS_MESCOMMANDES_TITRE);
        detailsMesCommandeFormulaire.setBoutonRetourLabel(ConstantesPage.DETAILS_MESCOMMANDES_BOUTON_RETOUR);

        detailsMesCommandeFormulaire.setUrlActionSortie(ConstantesPage.DETAILS_MESCOMMANDES_ACTION_MODIFIER);


        return detailsMesCommandeFormulaire;
    }

}
