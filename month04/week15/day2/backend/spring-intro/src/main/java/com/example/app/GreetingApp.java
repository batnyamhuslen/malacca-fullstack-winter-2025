package com.example.app;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;  
import org.springframework.stereotype.Component;

import com.example.service.GreetingService;

@Component
public class GreetingApp {

    private final GreetingService primaryGreeting;
    private final GreetingService englishGreeting;
    private final GreetingService japaneseGreeting;
    private final GreetingService russianGreeting;
    private final List<GreetingService> allGreetings;

    @Value("${app.default.name:Friend}")      
    private String defaultName;

    @Autowired
    public GreetingApp(
            GreetingService primaryGreeting,
            @Qualifier("englishGreeting")  GreetingService englishGreeting,
            @Qualifier("japaneseGreeting") GreetingService japaneseGreeting,
            @Qualifier("russianGreeting")  GreetingService russianGreeting,
            List<GreetingService> allGreetings) {
        this.primaryGreeting  = primaryGreeting;
        this.englishGreeting  = englishGreeting;
        this.japaneseGreeting = japaneseGreeting;
        this.russianGreeting  = russianGreeting;
        this.allGreetings     = allGreetings;
    }

    public void run() {
        String name = "Student";
        System.out.println("Primary (" + primaryGreeting.getLanguage() + "): "
            + primaryGreeting.greet(name));
        System.out.println("English: "  + englishGreeting.greet(name));
        System.out.println("Japanese: " + japaneseGreeting.greet(name));
        System.out.println("Russian: "  + russianGreeting.greet(name));

        System.out.println("\n--- All languages ---");
        allGreetings.forEach(g ->
            System.out.println(g.getLanguage() + ": " + g.greet("World")));

        System.out.println("\n--- Default name greeting ---");
        System.out.println(primaryGreeting.greet(defaultName));
    }
}