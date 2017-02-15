package com.cgihosting.controller;

import com.cgihosting.constantes.ConstantesPage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by garnons on 20/11/2016.
 */

@Controller
public class LoginController {

    @RequestMapping(ConstantesPage.CONNEXION_ACTION)
    public String login(){
        return "login";
    }
}
