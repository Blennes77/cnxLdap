package com.cgihosting.controller.admin;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.formulaire.admin.hebergeur.AfficherHebergeurFormulaire;
import com.cgihosting.formulaire.admin.hebergeur.DetailsHebergeurFormulaire;
import com.cgihosting.service.admin.GererHebergeurService;
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

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherHebergeurs());
        return "admin/hebergeurs/afficherHebergeurs";
    }



    @RequestMapping("/admin/afficherDetailHebergeur")
    String affichageDetailHebergeurs(Model model){

       model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsHebergeur());
        return "admin/hebergeurs/detailsHebergeur";
    }


    @RequestMapping(value = "/admin/creerHebergeur", method = RequestMethod.POST)

    String creerHebergeur(@Valid DetailsHebergeurFormulaire detailsHebergeurFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){


        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/hebergeurs/detailsHebergeur";
            }
            else{

                gererHebergeurService.creerHebergeur(detailsHebergeurFormulaire.getHebergeurDTO());


                return  "redirect:/admin/afficherHebergeurs";

            }

        }

        else {

                    return  "redirect:/admin/afficherHebergeurs";

        }


    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherHebergeurFormulaire recupererFormulaireAfficherHebergeurs() {


        AfficherHebergeurFormulaire afficherHebergeurFormulaire = new AfficherHebergeurFormulaire();

        afficherHebergeurFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_HEBGERGEURS_TITRE);
        afficherHebergeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_AJOUTER_HEBERGEUR);
        afficherHebergeurFormulaire.setHebergeurDTOListe(gererHebergeurService.recupererHebergeurs());

        return afficherHebergeurFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsHebergeurFormulaire recupererFormulaireDetailsHebergeur() {


        DetailsHebergeurFormulaire detailsHebergeurFormulaire = new DetailsHebergeurFormulaire();


        HebergeurDTO hebergeurDTO = new HebergeurDTO();

        hebergeurDTO.setNom("blabla");

        hebergeurDTO.setDescription("ttdtsqtdts");

        detailsHebergeurFormulaire.setHebergeurDTO(hebergeurDTO);

        detailsHebergeurFormulaire.setTitrePage(ConstantesPage.DETAIL_HEBGERGEURS_TITRE);
        detailsHebergeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_CREER_HEBERGEUR);
        detailsHebergeurFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_HEBERGEUR);


        return detailsHebergeurFormulaire;
    }


}
