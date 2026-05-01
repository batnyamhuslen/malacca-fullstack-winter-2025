package com.example.ordermanagement;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.ordermanagement.app.OrderManagementApp;

@SpringBootApplication
public class OrderManagementApplication implements CommandLineRunner {

    private final OrderManagementApp orderManagementApp;

    public OrderManagementApplication(OrderManagementApp orderManagementApp) {
        this.orderManagementApp = orderManagementApp;
    }

    public static void main(String[] args) {
        SpringApplication.run(OrderManagementApplication.class, args);
    }

    @Override
    public void run(String... args) {
        orderManagementApp.run();
    }
}
