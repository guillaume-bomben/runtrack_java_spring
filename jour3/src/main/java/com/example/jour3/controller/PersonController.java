package com.example.jour3.controller;

import com.example.jour3.model.Person;
import com.example.jour3.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/initpersons")
    public String initPersons() {
        // Exemples de création de personnes
        if(personRepository.count() == 0) {
            Person p1 = new Person();
            p1.setName("Alice");
            p1.setAge(30);
            personRepository.save(p1);

            Person p2 = new Person();
            p2.setName("Bob");
            p2.setAge(25);
            personRepository.save(p2);
        }
        return "redirect:/persons";
    }

    // Affiche la liste des personnes
    @GetMapping("/persons")
    public String listPersons(Model model) {
        model.addAttribute("persons", personRepository.findAll());
        return "persons"; // référence à templates/persons.html
    }

    // Affiche le formulaire de modification pour une personne donnée
    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable("id") Long id, Model model) {
        Optional<Person> personOpt = personRepository.findById(id);
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
        personRepository.save(person);
        return "redirect:/persons";
    }

    // Supprime une personne par son id
    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        personRepository.deleteById(id);
        return "redirect:/persons";
    }
    
    // Affiche le formulaire pour ajouter une nouvelle personne
    @GetMapping("/person/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "person-form-new"; // référence à un nouveau template pour créer une personne
    }

    // Traite la soumission du formulaire pour créer une nouvelle personne
    @PostMapping("/person/new")
    public String createPerson(@ModelAttribute("person") Person person) {
        personRepository.save(person);
        return "redirect:/persons";
    }
}
