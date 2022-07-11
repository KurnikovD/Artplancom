package com.example.Artplancom.model;

import com.example.Artplancom.entity.AnimalJson;

import java.util.List;

public class AnswerAnimalModel extends AnswerModel{
    private List<AnimalJson> animals;

    public List<AnimalJson> getAnimals() {
        return animals;
    }
    public void setAnimals(List<AnimalJson> animals) {
        this.animals = animals;
    }
}
