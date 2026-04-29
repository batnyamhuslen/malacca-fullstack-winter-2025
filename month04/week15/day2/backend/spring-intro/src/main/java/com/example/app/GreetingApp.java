package com.example.app;

import com.example.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GreetingApp {

    private final GreetingService primaryGreeting;
    private final GreetingService englishGreeting;

    @Autowired                                              // ← нөхөх
    public GreetingApp(
            GreetingService primaryGreeting,
            @Qualifier("englishGreeting") GreetingService englishGreeting) {
        this.primaryGreeting = primaryGreeting;
        this.englishGreeting = englishGreeting;
    }

    public void run() {
        String name = "Student";
        System.out.println("Primary (" + primaryGreeting.getLanguage() + "): "
            + primaryGreeting.greet(name));
        System.out.println("English: " + englishGreeting.greet(name));
    }
}


