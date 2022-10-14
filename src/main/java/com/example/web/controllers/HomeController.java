package com.example.web.controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String homePage(Model model){
        model.addAttribute("isAuth", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "index";
    }
}
