package com.example.Artplancom.service;

import com.example.Artplancom.entity.Animal;
import com.example.Artplancom.entity.AnimalJson;
import com.example.Artplancom.entity.User;
import com.example.Artplancom.entity.UserJson;
import com.example.Artplancom.message.AnimalMessage;
import com.example.Artplancom.model.AnswerModel;
import com.example.Artplancom.model.Status;
import com.example.Artplancom.repository.AnimalRepository;
import com.example.Artplancom.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class AnimalService {

    @Autowired
    AnimalRepository animalRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AnswerService answerService;

    public AnimalJson findAnimalById(Long id) {
        Animal animal = animalRepository.findById(id).orElse(null);

        if (animal == null) {
            return null;
        }

        UserJson userJson = new UserJson(animal.getUser().getId(), animal.getUser().getUsername());

        return new AnimalJson(animal.getId(), animal.getNickName(), animal.getSex(), animal.getBirthday(), userJson, animal.getAnimalType());
    }

    public List<AnimalJson> findAllAnimals() {
        ArrayList<AnimalJson> animalJson = new ArrayList<>();

        for (Animal animal : animalRepository.findAll()) {
            UserJson userJson = new UserJson(animal.getUser().getId(), animal.getUser().getUsername());
            animalJson.add(new AnimalJson(animal.getId(), animal.getNickName(), animal.getSex(), animal.getBirthday(), userJson, animal.getAnimalType()));
        }
        return animalJson;
    }

    public List<AnimalJson> findAnimalsByUserId(Long userId) {
        ArrayList<AnimalJson> animalJson = new ArrayList<>();

        for (Animal animal : animalRepository.findByUser_Id(userId)) {
            UserJson userJson = new UserJson(animal.getUser().getId(), animal.getUser().getUsername());
            animalJson.add(new AnimalJson(animal.getId(), animal.getNickName(), animal.getSex(), animal.getBirthday(), userJson, animal.getAnimalType()));
        }

        return animalJson;
    }

    public AnswerModel saveNewAnimal(Animal animal) {
        Animal animalFromDB = animalRepository.findByNickName(animal.getNickName());

        if (animalFromDB != null) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.alreadyExist);
        }

        User user = userRepository.findById(animal.getUser().getId()).orElse(null);
        if (user == null) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.userNotFound);
        }

        animal.setUser(user);
        animalRepository.save(animal);

        return answerService.toJsonString(Status.Success, AnimalMessage.success);

    }

    public AnswerModel deleteAnimal(Animal animal) {
        Animal animalFromDB = animalRepository.findByNickName(animal.getNickName());

        if (animalFromDB == null) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.animalNotFound);
        }
        if (!Objects.equals(animalFromDB.getUser().getId(), animal.getUser().getId())) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.userHasNotPermission);
        }

        return answerService.toJsonString(Status.Success, AnimalMessage.success);
    }

    public AnswerModel editAnimal(Animal animal) {
        Animal animalFromDB = animalRepository.findById(animal.getId()).orElse(null);

        if (animalFromDB == null) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.animalNotFound);
        }
        if (!Objects.equals(animalFromDB.getUser().getId(), animal.getUser().getId())) {
            return answerService.toJsonString(Status.Exception, AnimalMessage.userHasNotPermission);
        }

        animal.setUser(animalFromDB.getUser());
        animalRepository.save(animal);

        return answerService.toJsonString(Status.Success, AnimalMessage.success);
    }
}
