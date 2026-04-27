package com.example.app;

import com.example.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component                              // Bean болгох
public class MessagePrinter {

    private final MessageService messageService;

    @Autowired                          // Constructor injection
    public MessagePrinter(MessageService messageService) {
        this.messageService = messageService;
    }

    public void print() {
        System.out.println("Language: " + messageService.getLanguage());
        System.out.println("Message:  " + messageService.getMessage());
    }
}

