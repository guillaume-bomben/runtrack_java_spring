package com.example.jour2.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class WelcomeForm {

    @NotBlank(message = "Le nom est obligatoire")
    private String name;

    @NotNull(message = "L'âge est obligatoire")
    @Min(value = 18, message = "Vous devez avoir au moins 18 ans")
    private Integer age;

    // Getters et Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
