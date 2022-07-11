package com.example.Artplancom.controller;

import com.example.Artplancom.entity.User;
import com.example.Artplancom.message.LoginMessage;
import com.example.Artplancom.model.AnswerModel;
import com.example.Artplancom.model.Status;
import com.example.Artplancom.service.AnswerService;
import com.example.Artplancom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;
    @Autowired
    AnswerService answerService;

    @PostMapping("/login")
    public AnswerModel login(@RequestBody User user){
        Long userId = userService.userLogin(user);

        if (userId == null){
            return answerService.toJsonString(Status.Exception, LoginMessage.wrongLoginOrPassword);

        }
        return answerService.toJsonString(Status.Success, LoginMessage.success);
    }
}
