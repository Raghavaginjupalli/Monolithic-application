package com.project.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
	return "Hey!";
    }
    
    @GetMapping("/greate")
    public String grete() {
	return "Hey, How are you..!";
    }

}