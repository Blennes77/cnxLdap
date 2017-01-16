package com.cgihosting.controller;

import com.cgihosting.constantes.ConstantesGenerales;
import com.cgihosting.constantes.ConstantesPage;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by garnons on 16/01/2017.
 */
@Controller
public class TestController {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showForm(Model model) {
       PersonForm personForm = new PersonForm();

        model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, personForm);
        return "form";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String checkPersonInfo(@Valid @ModelAttribute(ConstantesPage.NOM_FORMULAIRE_HTML) PersonForm personForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute(ConstantesPage.NOM_FORMULAIRE_HTML, personForm);
            return "form";
        }

        return "redirect:/results";
    }
}
