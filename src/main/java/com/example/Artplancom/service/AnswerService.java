package com.example.Artplancom.service;

import com.example.Artplancom.entity.Animal;
import com.example.Artplancom.model.AnswerAnimalModel;
import com.example.Artplancom.model.AnswerModel;
import com.example.Artplancom.model.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    public AnswerModel toJsonString(Status status, String message) {
        AnswerModel answer = new AnswerModel();

        switch (status) {
            case Success:
                answer.setStatus("Success");
                answer.setMessage(message);
                break;
            case Exception:
                answer.setStatus("Exception");
                answer.setMessage(message);
                break;
        }

        return answer;
    }

    public AnswerModel toJsonStringWithAnimalList(String message, List<Animal> animals) {
        AnswerAnimalModel model = new AnswerAnimalModel();
        model.setStatus("Success");
        model.setMessage(message);
        model.setAnimals(animals);
        return model;
    }
}
