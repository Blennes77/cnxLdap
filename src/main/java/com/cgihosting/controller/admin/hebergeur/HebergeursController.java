package com.cgihosting.controller.admin.hebergeur;

import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.HebergeurDTO;
import com.cgihosting.domain.JournalDTO;
import com.cgihosting.formulaire.admin.hebergeur.AfficherHebergeurFormulaire;
import com.cgihosting.formulaire.admin.hebergeur.DetailsHebergeurFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.service.admin.GererHebergeurService;
import com.cgihosting.service.admin.JournaliserService;
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

    @Autowired
    private JournaliserService journaliserService;


    @RequestMapping("/admin/afficherHebergeurs")
    String afficherHebergeurs(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                              @RequestParam(value = "ligneParPage", required = false, defaultValue = "5") int ligneParPage,Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherHebergeurs(page, ligneParPage));
        return "admin/referentielHebergeurs/afficherHebergeurs";
    }



    @RequestMapping("/admin/afficherDetailsHebergeur")
    String affichageDetailHebergeurs(int identifiantHebergeurSelect, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsHebergeur(identifiantHebergeurSelect));
        return "admin/referentielHebergeurs/detailsHebergeur";
    }


    @RequestMapping(value = "/admin/enregistrerHebergeur", method = RequestMethod.POST)

    String creerHebergeur(@Valid DetailsHebergeurFormulaire detailsHebergeurFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "admin/hebergeurs/detailsHebergeur";
            }
            else{

                identifiantDonneeTraitee = gererHebergeurService.creerHebergeur(detailsHebergeurFormulaire.getHebergeurDTO());

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_AJOUT_HEBERGEUR, identifiantDonneeTraitee);
                journaliserService.enregistrerJournalisation(journalDTO);




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

    private AfficherHebergeurFormulaire recupererFormulaireAfficherHebergeurs(int pageCourante, int numLigneAfficheParPage) {


        AfficherHebergeurFormulaire afficherHebergeurFormulaire = new AfficherHebergeurFormulaire();

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererHebergeurService.nombreTotalHebergeurs());
        afficherHebergeurFormulaire.setPaginationObjet(paginationObjet);


        afficherHebergeurFormulaire.setTitrePage(ConstantesPage.ADMIN_AFFICHAGE_HEBGERGEURS_TITRE);
        afficherHebergeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_HEBERGEUR);


        //afficherHebergeurFormulaire.setHebergeurDTOListe(gererHebergeurService.recupererHebergeurs());

        afficherHebergeurFormulaire.setHebergeurDTOPage(gererHebergeurService.searchAllHebergeurDtoPageByPage(pageCourante, numLigneAfficheParPage));


        return afficherHebergeurFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsHebergeurFormulaire recupererFormulaireDetailsHebergeur(int identifiantHebergeurSelect) {


        DetailsHebergeurFormulaire detailsHebergeurFormulaire = new DetailsHebergeurFormulaire();
        HebergeurDTO hebergeurDTO =  new HebergeurDTO();


        if (identifiantHebergeurSelect != 0) {
            hebergeurDTO = gererHebergeurService.recupererHebergeurById(identifiantHebergeurSelect);

            detailsHebergeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_MODIFIER_HEBERGEUR);
        }
        else {

            detailsHebergeurFormulaire.setBoutonSoumissionLabel(ConstantesPage.ADMIN_BOUTON_AJOUTER_HEBERGEUR);
        }




        detailsHebergeurFormulaire.setHebergeurDTO(hebergeurDTO);

        detailsHebergeurFormulaire.setTitrePage(ConstantesPage.ADMIN_DETAIL_HEBGERGEURS_TITRE);
        detailsHebergeurFormulaire.setBoutonRetourLabel(ConstantesPage.ADMIN_BOUTON_RETOUR_HEBERGEUR);


        return detailsHebergeurFormulaire;
    }


}
