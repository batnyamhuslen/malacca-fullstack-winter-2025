package com.example.service.impl;

import org.springframework.stereotype.Component;

import com.example.service.GreetingService;

import jakarta.annotation.PostConstruct;

@Component("englishGreeting")
public class EnglishGreetingService implements GreetingService {

    @PostConstruct
    public void init(){
        System.out.println("[Bean created] EnglishGreetingService");
    }

    @Override
    public String greet(String name) { return "Hello, " + name + "!"; }

    @Override
    public String getLanguage() { return "English"; }
}