package com.example.jour4.controller;

import com.example.jour4.model.Person;
import com.example.jour4.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @GetMapping("/initpersons")
    public String initPersons() {
        personService.initPersons();
        return "redirect:/persons";
    }

    // Affiche la liste des personnes
    @GetMapping("/persons")
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return "persons"; // référence à templates/persons.html
    }

    // Affiche le formulaire de modification pour une personne donnée
    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, Model model) {
        Optional<Person> personOpt = personService.getPersonById(id);
        if (personOpt.isPresent()) {
            model.addAttribute("person", personOpt.get());
            return "person-form"; // référence à templates/person-form.html
        }
        return "redirect:/persons";
    }

    // Traite la soumission du formulaire de mise à jour
    @PostMapping("/person/edit/{id}")
    public String updatePerson(@PathVariable("id") Long id, @ModelAttribute("person") Person person) {
        person.setId(id);
        personService.savePerson(person);
        return "redirect:/persons";
    }

    // Supprime une personne par son id
    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personService.deletePerson(id);
        return "redirect:/persons";
    }
    
    // Affiche le formulaire pour ajouter une nouvelle personne
    @GetMapping("/person/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person-form-new"; // référence à un template pour créer une personne
    }

    // Traite la soumission du formulaire pour créer une nouvelle personne
    @PostMapping("/person/new")
    public String createPerson(@ModelAttribute("person") Person person) {
        personService.savePerson(person);
        return "redirect:/persons";
    }
}
