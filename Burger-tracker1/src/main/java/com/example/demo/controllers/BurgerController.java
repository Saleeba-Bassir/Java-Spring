package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

import com.example.demo.models.Burger;
import com.example.demo.services.BurgerService;

@Controller
public class BurgerController {
    @Autowired
    private BurgerService burgerService;

    @GetMapping("/burger")
    public String newBurger(@ModelAttribute("burger") Burger burger,Model model) {
    	List<Burger> burgers = burgerService.allBurgers();
        model.addAttribute("burg", burgers);
    	return "index.jsp";
    }

    @PostMapping("/burger")
    public String create(@Valid @ModelAttribute("burger") Burger burger, BindingResult result) {
        if (result.hasErrors()) {
            return "index.jsp";
        } else {
            burgerService.createBurger(burger);
           
            return "redirect:/burger";
        }
    }
}
