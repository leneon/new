 package com.example.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/login")
    public String login(){
        return "index";
    }
    @GetMapping("/clients")
    public String clients(){
        return "clients";
    }
    @GetMapping("/agences")
    public String agences(){
        return "agences";
    }
    @GetMapping("/utilisateurs")
    public String utilisateurs(){
        return "utilisateurs";
    }
    @GetMapping("/parametres")
    public String parametres(){
        return "parametres";
    }
    @GetMapping("/abattements")
    public String abattements(){
        return "abattements";
    }
    @GetMapping("/abattement")
    public String abattement(){
        return "abattement";
    }
    @GetMapping("/garanties")
    public String garanties(){
        return "garanties";
    }
}
