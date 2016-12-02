package com.example.controller;

/**
 * Created by garnons on 20/11/2016.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/")
    String index(){
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "index";
    }
}
