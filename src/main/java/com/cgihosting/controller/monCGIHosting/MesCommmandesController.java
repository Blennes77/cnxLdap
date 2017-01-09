package com.cgihosting.controller.monCGIHosting;

import com.cgihosting.constantes.ConstantesAdmin;
import com.cgihosting.constantes.ConstantesGenerales;
import com.cgihosting.constantes.ConstantesMonCGIHosting;
import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.domain.JournalDTO;
import com.cgihosting.domain.ServeurVirtuelDTO;
import com.cgihosting.formulaire.monCGIHosting.mesCommandes.AfficherCommandesFormulaire;
import com.cgihosting.formulaire.monCGIHosting.mesCommandes.AjoutServeurVirtuelFormulaire;
import com.cgihosting.formulaire.monCGIHosting.mesCommandes.DetailsCommandeFormulaire;
import com.cgihosting.objets.UtilisateurSession;
import com.cgihosting.service.admin.GererCommandeService;
import com.cgihosting.service.admin.GererProjetsService;
import com.cgihosting.service.admin.GererUtilisateurService;
import com.cgihosting.service.admin.JournaliserService;
import com.cgihosting.service.exploit.GererServeursVirtuelsService;
import com.cgihosting.service.exploit.GererTemplateOSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

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

    @RequestMapping("/monCGIHosting/ajouterServeurVirtuel")
    String afficherEcranAjoutServeurVirtuel(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireAjoutServeurVirtuel());
        return "monCGIHosting/mesCommandes/ajoutServeurVirtuel";
    }


    @RequestMapping("/monCGIHosting/afficherCommandes")
    String afficherCommandes(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireCommandes());
        return "monCGIHosting/mesCommandes/afficherCommandes";
    }


    @RequestMapping(value = "/monCGIHosting/afficherDetailCommande", method = RequestMethod.POST)
    String affichageDetailsCommande(int identifiantCommandeSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsCommande(identifiantCommandeSelect));
        return "monCGIHosting/mesCommandes/detailsCommande";
    }


    @RequestMapping(value = "/monCGIHosting/quitterCommande", method = RequestMethod.POST)

    String quitterCommande( Model model, BindingResult bindingResult, @RequestParam String action){




            return  "redirect:/monCGIHosting/afficherCommandes";



    }


    @RequestMapping(value = "/monCGIHosting/enregistrerServeurVirtuel", method = RequestMethod.POST)

    String creerServeurVirtuel(@Valid AjoutServeurVirtuelFormulaire ajoutServeurVirtuelFormulaire, Model model, BindingResult bindingResult, @RequestParam String action){

        int identifiantDonneeTraitee = 0;
        ServeurVirtuelDTO serveurVirtuelDTO = new ServeurVirtuelDTO();

        if (action.equals(ConstantesPage.ACTION_SAUVEGARDER)) {

            if (bindingResult.hasErrors()) {


                return "monCGIHosting/mesCommandes/ajoutServeurVirtuel";
            }
            else{

                serveurVirtuelDTO = ajoutServeurVirtuelFormulaire.getServeurVirtuelDTO();
                serveurVirtuelDTO.setIndTraitement(ConstantesGenerales.ETAT_SERVEUR_VIRTUEL_ENREGISTRE);

                serveurVirtuelDTO.setIdEnregistreur(gererUtilisateurService.searchUserByLogonName(UtilisateurSession.getLogin()).getId());



                identifiantDonneeTraitee = gererServeursVirtuelsService.creerServeurVirtuel(serveurVirtuelDTO);

                JournalDTO journalDTO = new JournalDTO(UtilisateurSession.getLogin(), ConstantesAdmin.JOURNAL_AJOUT_SERVEUR_VIRTUEL, identifiantDonneeTraitee);

                journaliserService.enregistrerJournalisation(journalDTO);




                return  "redirect:/monCGIHosting/afficherCommandes";

            }

        }

        else {

            return  "redirect:/monCGIHosting/afficherCommandes";

        }


    }





    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AfficherCommandesFormulaire recupererFormulaireCommandes() {

        int identifiant = 1;

        AfficherCommandesFormulaire afficherCommandesFormulaire = new AfficherCommandesFormulaire();

        afficherCommandesFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_COMMANDES_TITRE);
        afficherCommandesFormulaire.setCommandeDTOListe(gererCommandeService.recupererCommandesUtilisateur(identifiant));

        return afficherCommandesFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsCommandeFormulaire recupererFormulaireDetailsCommande(int identifiantCommandeSelect) {


        DetailsCommandeFormulaire detailsCommandeFormulaire = new DetailsCommandeFormulaire();



        detailsCommandeFormulaire.setCommandeDTO(gererCommandeService.recupererCommandeById(identifiantCommandeSelect));
        detailsCommandeFormulaire.setTitrePage(ConstantesPage.DETAILS_COMMANDE_TITRE);
        detailsCommandeFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_LISTE_COMMANDES);


        return detailsCommandeFormulaire;
    }

    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private AjoutServeurVirtuelFormulaire recupererFormulaireAjoutServeurVirtuel() {

        ServeurVirtuelDTO serveurVirtuelDTO = new ServeurVirtuelDTO();

        // Régle de gestion : attribution du nom d'admin

        serveurVirtuelDTO.setNomAdmin(ConstantesMonCGIHosting.SERVEUR_VIRTUEL_NOMADMIN);

        AjoutServeurVirtuelFormulaire ajoutServeurVirtuelFormulaire = new AjoutServeurVirtuelFormulaire();

        ajoutServeurVirtuelFormulaire.setServeurVirtuelDTO(serveurVirtuelDTO);

        ajoutServeurVirtuelFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_COMMANDES_TITRE);
        ajoutServeurVirtuelFormulaire.setTemplateOSDTOListe(gererTemplateOSService.recupererTemplateOSActifs());

        ajoutServeurVirtuelFormulaire.setProjetDTOListe(gererProjetsService.recupererProjets());

        ajoutServeurVirtuelFormulaire.setBoutonSoumissionLabel(ConstantesPage.BOUTON_AJOUT_SERVEUR_ENREGISTRER);

        ajoutServeurVirtuelFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_AJOUT_SERVEUR);

        return ajoutServeurVirtuelFormulaire;
    }


}
