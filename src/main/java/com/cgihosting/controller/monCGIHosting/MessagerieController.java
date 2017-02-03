package com.cgihosting.controller.monCGIHosting;

import com.cgihosting.constantes.ConstantesPage;
import com.cgihosting.formulaire.monCGIHosting.messages.DetailsMessageFormulaire;
import com.cgihosting.formulaire.monCGIHosting.messages.MessagerieFormulaire;
import com.cgihosting.service.admin.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by marinib on 09/12/2016.
 */
@Controller
public class MessagerieController {


    /**
     * Méthodes controller
     * Le tag @controller permet à spring boot d'interpréter les
     * méthodes comme des controleurs
     */



    @Autowired
    private MessageService messageService;


    @RequestMapping("/monCGIHosting/afficherMessages")
    String afficherMessages(Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireMessages());
        return "monCGIHosting/messages/afficherMessages";
    }


    @RequestMapping(value = "/exploit/afficherDetailsMessage", method = RequestMethod.POST)
    String affichageDetailHebergeurs(int identifiantMessageSelect, Model model){

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, recupererFormulaireDetailsMessage(identifiantMessageSelect));
        return "monCGIHosting/messages/detailsMessage";
    }


    @RequestMapping(value = "/monCGIHosting/quitterMessage", method = RequestMethod.POST)

    String quitterMessage( Model model, BindingResult bindingResult, @RequestParam String action){




            return  "redirect:/monCGIHosting/afficherMessages";



    }





    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private MessagerieFormulaire recupererFormulaireMessages() {

        int identifiant = 1;

        MessagerieFormulaire messagerieFormulaire = new MessagerieFormulaire();

        messagerieFormulaire.setTitrePage(ConstantesPage.AFFICHAGE_MESSAGES_TITRE);
        messagerieFormulaire.setMessageDTOListe(messageService.recupererMessagesUtilisateur(identifiant));

        return messagerieFormulaire;
    }



    /**
     * Méthodes privées appelées par les controleurs pour
     * remplir les forumalires associés aux pages web
     * méthodes comme des controleurs
     */

    private DetailsMessageFormulaire recupererFormulaireDetailsMessage(int identifiantServeurSelect) {


        DetailsMessageFormulaire detailsMessageFormulaire = new DetailsMessageFormulaire();



        detailsMessageFormulaire.setMessageDTO(messageService.recupererMessageById(identifiantServeurSelect));
        detailsMessageFormulaire.setTitrePage(ConstantesPage.DETAIL_SERVEUR_VIRTUEL_TITRE);
        detailsMessageFormulaire.setBoutonRetourLabel(ConstantesPage.BOUTON_RETOUR_LISTE_MESSAGES);


        return detailsMessageFormulaire;
    }


}
