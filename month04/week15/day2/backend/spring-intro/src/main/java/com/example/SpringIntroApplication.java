package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.app.GreetingApp;

@SpringBootApplication                                           // ← нөхөх
public class SpringIntroApplication implements CommandLineRunner {  // ← нөхөх

    private final GreetingApp greetingApp;

    public SpringIntroApplication(GreetingApp greetingApp) {  // ← нөхөх (constructor injection)
        this.greetingApp = greetingApp;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringIntroApplication.class, args);  // ← нөхөх
        // greetingApp = "override";
    }

    @Override
    public void run(String... args) {
        greetingApp.run();
    }
}
