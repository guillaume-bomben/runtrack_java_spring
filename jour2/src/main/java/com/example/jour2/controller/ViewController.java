package com.example.jour2.controller;

import com.example.jour2.model.WelcomeForm;
import java.util.Arrays;
import java.util.List;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ViewController {

    @GetMapping("/view")
    public String view(Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");
        model.addAttribute("message", "Bienvenue sur Thymeleaf!");
        model.addAttribute("items", items);
        model.addAttribute("welcomeForm", new WelcomeForm());
        return "view"; // référence à templates/view.html
    }

    @PostMapping("/welcome")
    public String welcome(@Valid @ModelAttribute("welcomeForm") WelcomeForm welcomeForm,
                          BindingResult result, Model model) {
        List<String> items = Arrays.asList("Item 1", "Item 2", "Item 3");

        if (result.hasErrors()) {
            model.addAttribute("message", "Veuillez corriger les erreurs");
            model.addAttribute("items", items);
            return "view";
        }
        model.addAttribute("message", "Bienvenue " + welcomeForm.getName() + "!");
        model.addAttribute("items", items);
        return "view";
    }
}