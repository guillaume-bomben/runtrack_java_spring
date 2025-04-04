package com.example.jour5.service;

import com.example.jour5.model.Person;
import com.example.jour5.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void initPersons() {
        if (personRepository.count() == 0) {
            Person p1 = new Person();
            p1.setName("Alice");
            p1.setAge(30);
            personRepository.save(p1);

            Person p2 = new Person();
            p2.setName("Bob");
            p2.setAge(25);
            personRepository.save(p2);
        }
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Optional<Person> getPersonById(Long id) {
        return personRepository.findById(id);
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}