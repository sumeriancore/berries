package com.by.blue.berries.main.controller;

import com.by.blue.berries.domain.User;
import com.by.blue.berries.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationPageController {

    @Autowired
    private UserRepository userRepo;

    @PostMapping("/registration")
    public String createUser(@RequestParam String userEmail, @RequestParam String userPassword){

        User user = new User(userEmail, userPassword);
        userRepo.save(user);

        return "main";
    }

    @GetMapping("/registration")
    public String registrationPage(){
        return "registration";
    }
}
