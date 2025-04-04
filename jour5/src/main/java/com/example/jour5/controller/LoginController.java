package com.example.jour5.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String loginPage() {
        // Si l'utilisateur est déjà authentifié, redirige vers /persons
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {
            return "redirect:/persons";
        }
        return "login"; // Affiche la page de login
    }

    @GetMapping("/")
    public String homePage() {
        return "home"; // Affiche la page d'accueil
    }
}
