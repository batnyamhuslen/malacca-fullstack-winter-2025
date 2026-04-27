package com.example.service.impl;

import com.example.service.MessageService;
import org.springframework.stereotype.Component;

@Component                               // Spring Bean болгох annotation
public class HelloMessageService implements MessageService {

    @Override
    public String getMessage() {
        return "Hello, Spring!";
    }

    @Override
    public String getLanguage() {
        return "English";
    }
}