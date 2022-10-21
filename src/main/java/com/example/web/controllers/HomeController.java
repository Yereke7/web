package com.example.web.controllers;

import com.example.web.models.Person;
import com.example.web.models.Product;
import com.example.web.repositories.ProductRepo;
import com.example.web.security.PersonDetails;
import com.example.web.services.ProdService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller @RequiredArgsConstructor
public class HomeController {
    private final ProductRepo productRepo;
    private final ProdService prodService;

    @GetMapping
    public String homePage(Model model){
        model.addAttribute("isAuth", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("product", "Стул");
        return "index";
    }

    @GetMapping("/admin")
    public String adminPage(Model model){
        PersonDetails personDetails = (PersonDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (personDetails.getPerson().getRole().equals("ROLE_ADMIN")){
            model.addAttribute("p1", productRepo.findById(1));
            model.addAttribute("p2", productRepo.findById(2));
            model.addAttribute("p3", productRepo.findById(3));
            model.addAttribute("p4", productRepo.findById(4));
            return "admin";
        } else return "redirect:/";
    }

    @GetMapping("/newProduct")
    public String newProduct(@ModelAttribute Product product) {
        prodService.create(product);
        return "redirect:/admin";
    }
}
