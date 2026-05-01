package com.example.ordermanagement.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.service.OrderService;
import com.example.ordermanagement.service.ProductService;

@Component
public class OrderManagementApp {

    private final OrderService   orderService;
    private final ProductService productService;

    @Value("${shop.name:My Shop}")
    private String shopName;

    @Autowired
    public OrderManagementApp(OrderService orderService, ProductService productService) {
        this.orderService   = orderService;
        this.productService = productService;
    }

    public void run() {
        System.out.println("=== " + shopName + " ===\n");

        System.out.println("Available Products:");
        productService.findAll().forEach(p -> System.out.println("  " + p));

        System.out.println("\n--- Creating Order for customer #1 ---");
        Order order = orderService.createOrder(1L);
        System.out.println("Created: " + order);

        System.out.println("\n--- Adding Items ---");
        order = orderService.addItem(order.getId(), 1L, 1);  // 1 Laptop
        order = orderService.addItem(order.getId(), 3L, 2);  // 2 Headphones
        System.out.printf("Total: $%.2f%n", order.getTotal());

        System.out.println("\n--- Processing Order ---");
        order = orderService.processOrder(order.getId());
        System.out.println("Status: " + order.getStatus());

        System.out.println("\n--- Shipping Order ---");
        order = orderService.shipOrder(order.getId());
        System.out.println("Status: " + order.getStatus());

        System.out.println("\n--- Stock After Order ---");
        productService.findAll().forEach(p -> System.out.println("  " + p));
    }
}
