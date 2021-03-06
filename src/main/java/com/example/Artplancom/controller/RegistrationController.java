package com.example.Artplancom.controller;

import com.example.Artplancom.entity.User;
import com.example.Artplancom.message.RegistrationMessage;
import com.example.Artplancom.model.AnswerModel;
import com.example.Artplancom.model.Status;
import com.example.Artplancom.service.AnswerService;
import com.example.Artplancom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    UserService userService;
    @Autowired
    AnswerService answerService;

    @PostMapping("/registration")
    public AnswerModel addUser(@RequestBody User userModel) {

        if (!userModel.getPassword().equals(userModel.getPasswordConfirm())) {
            return answerService.toJsonString(Status.Exception, RegistrationMessage.differentPassword);
        }
        if (!userService.saveUser(userModel)) {
            return answerService.toJsonString(Status.Exception, RegistrationMessage.alreadyExist);
        }

        return answerService.toJsonString(Status.Success, RegistrationMessage.success);

    }
}
