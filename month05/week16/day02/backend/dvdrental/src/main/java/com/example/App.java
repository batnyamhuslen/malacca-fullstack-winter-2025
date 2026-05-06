package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // ← THIS was missing
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}