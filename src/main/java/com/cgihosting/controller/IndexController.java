package com.cgihosting.controller;

/**
 * Created by garnons on 20/11/2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    public String  getHomeLocal(){
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "index";
    }


    @RequestMapping("/portailhosting/")
    public String  getHomEExterieur(){
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "index";
    }
}
