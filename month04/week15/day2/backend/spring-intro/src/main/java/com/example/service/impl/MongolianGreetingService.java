package com.example.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.service.GreetingService;

@Component("mongolianGreeting")
@Primary                              // ← Default bean
public class MongolianGreetingService implements GreetingService {

    @Override
    public String greet(String name) { return "Сайн байна уу, " + name + "!"; }

    @Override
    public String getLanguage() { return "Mongolian"; }
}
