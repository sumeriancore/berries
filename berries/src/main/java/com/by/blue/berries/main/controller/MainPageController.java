package com.by.blue.berries.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainPageController {


    @GetMapping("/main")
    public String mainPage(){
        return "main";
    }
}
