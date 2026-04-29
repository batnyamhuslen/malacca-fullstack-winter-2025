package com.example.service.impl;

import com.example.service.GreetingService;
import org.springframework.stereotype.Component;

@Component("englishGreeting")
public class EnglishGreetingService implements GreetingService {

    @Override
    public String greet(String name) { return "Hello, " + name + "!"; }

    @Override
    public String getLanguage() { return "English"; }
}