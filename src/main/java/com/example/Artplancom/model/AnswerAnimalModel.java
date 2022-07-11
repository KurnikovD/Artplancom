package com.example.Artplancom.model;

import com.example.Artplancom.entity.Animal;

import java.util.List;

public class AnswerAnimalModel extends AnswerModel{
    private List<Animal> animals;

    public List<Animal> getAnimals() {
        return animals;
    }
    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
