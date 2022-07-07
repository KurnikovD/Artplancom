package com.example.Artplancom.controller;

import com.example.Artplancom.entity.Animal;
import com.example.Artplancom.entity.User;
import com.example.Artplancom.service.AnimalService;
import com.example.Artplancom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AnimalController {

    @Autowired
    UserService userService;
    @Autowired
    AnimalService animalService;

    @GetMapping("/animal")
    public String animalList(Model model){
        List<Animal> allAnimals = animalService.findAllAnimals();

        if (allAnimals.isEmpty()){
            model.addAttribute("EmptyList", "Список пуст");
        }else {
            model.addAttribute("animalsList", allAnimals);
        }

        return "animals";

    }

    @GetMapping("/my_animal")
    public String animalUserList(Model model, User user){

        List<Animal> allAnimals = animalService.findAnimalsByUserId(user.getId());

        if (allAnimals.isEmpty()){
            model.addAttribute("EmptyList", "Ваш список пуст");
        }else {
            model.addAttribute("animalsList", allAnimals);
        }

        return "animals";

    }
}
