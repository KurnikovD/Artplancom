package com.example.Artplancom.controller;

import com.example.Artplancom.entity.Animal;
import com.example.Artplancom.entity.User;
import com.example.Artplancom.message.AnimalMessage;
import com.example.Artplancom.model.AnswerModel;
import com.example.Artplancom.model.Status;
import com.example.Artplancom.service.AnimalService;
import com.example.Artplancom.service.AnswerService;
import com.example.Artplancom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
public class AnimalController {

    @Autowired
    UserService userService;
    @Autowired
    AnimalService animalService;
    @Autowired
    AnswerService answerService;

    @PostMapping("/animal/get/{id}")
    public AnswerModel getAnimalById(Long id) {
        Animal animal = animalService.findAnimalById(id);
        if (animal == null) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.animalNotFound);
        }
        return answerService.toJsonStringWithAnimalList(AnimalMessage.success, Collections.singletonList(animal));
    }

    @PostMapping("/animal/add")
    public AnswerModel addNewAnimal(@RequestBody Animal animal) {
        return animalService.saveNewAnimal(animal);
    }

    @PostMapping("/animal/delete")
    public AnswerModel deleteAnimal(@RequestBody Animal animal) {
        return animalService.deleteAnimal(animal);
    }

    @PostMapping("animal/edit")
    public AnswerModel editAnimal(@RequestBody Animal animal) {
        return animalService.editAnimal(animal);
    }

    @PostMapping("/animal")
    public AnswerModel animalList() {
        List<Animal> allAnimals = animalService.findAllAnimals();

        if (allAnimals.isEmpty()) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.emptyList);
        }

        return answerService.toJsonStringWithAnimalList(AnimalMessage.success, allAnimals);

    }

    @PostMapping("/my_animal")
    public AnswerModel animalUserList(@RequestBody User user) {

        List<Animal> allAnimals = animalService.findAnimalsByUserId(user.getId());

        if (allAnimals.isEmpty()) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.emptyUserList);
        }

        return answerService.toJsonStringWithAnimalList(AnimalMessage.emptyUserList, allAnimals);

    }
}
