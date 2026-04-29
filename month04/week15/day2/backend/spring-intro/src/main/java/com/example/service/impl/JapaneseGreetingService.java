package com.example.service.impl;

import org.springframework.stereotype.Component;

import com.example.service.GreetingService;

import jakarta.annotation.PostConstruct;       

@Component("japaneseGreeting")
public class JapaneseGreetingService implements GreetingService {

    @PostConstruct                           
    public void init() {
        System.out.println("[Bean created] JapaneseGreetingService");
    }

    @Override
    public String greet(String name) { return "こんにちは, " + name + "!"; }

    @Override
    public String getLanguage() { return "Japanese"; }
}