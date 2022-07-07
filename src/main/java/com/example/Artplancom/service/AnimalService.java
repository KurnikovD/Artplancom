package com.example.Artplancom.service;

import com.example.Artplancom.entity.Animal;
import com.example.Artplancom.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;

    public Animal findAnimalById(Long id){
        Optional<Animal> animal = animalRepository.findById(id);
        return animal.orElse(null);
    }
}
