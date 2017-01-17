package com.cgihosting.controller.adminFonctionnel.projets;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.adminFonctionnel.projets.AfficherProjetsFormulaire;
import com.cgihosting.objets.PaginationObjet;
import com.cgihosting.service.admin.GererProjetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by marinib on 08/01/2017.
 */
@Controller
public class ProjetsController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */


    @Autowired
    private GererProjetsService gererProjetsService;


    @RequestMapping("/adminFonctionnel/afficherReferentielProjets")
    String afficherProjets(@RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @RequestParam(value = "ligneParPage", required = false, defaultValue = "250") int ligneParPage, Model model) {

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAfficherProjets(page, ligneParPage));
        return "adminFonctionnel/projets/afficherProjets";
    }


    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherProjetsFormulaire recupererFormulaireAfficherProjets(int pageCourante, int numLigneAfficheParPage) {


        AfficherProjetsFormulaire afficherProjetsFormulaire = new AfficherProjetsFormulaire();

        afficherProjetsFormulaire.setTitrePage(ConstantesPage.EXPLOIT_AFFICHAGE_LISTE_PROJETS_TITRE);
        afficherProjetsFormulaire.setProjetDTOPage(gererProjetsService.searchAllProjetDTOPageByPage(pageCourante, numLigneAfficheParPage));

        PaginationObjet paginationObjet;
        paginationObjet = new PaginationObjet(numLigneAfficheParPage, pageCourante, gererProjetsService.nombreTotalProjets());
        afficherProjetsFormulaire.setPaginationObjet(paginationObjet);


        return afficherProjetsFormulaire;


    }
}
