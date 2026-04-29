package com.example.service.impl;

import org.springframework.stereotype.Component;

import com.example.service.GreetingService;

@Component("russianGreeting")
public class RussianGreetingService implements GreetingService {

    @Override
    public String greet(String name) { return "Привет, " + name + "!"; }

    @Override
    public String getLanguage() { return "Russian"; }
}