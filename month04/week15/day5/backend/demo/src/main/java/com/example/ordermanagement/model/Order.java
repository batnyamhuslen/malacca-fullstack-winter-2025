package com.example.ordermanagement.model;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class Order {
    private Long id;
    private Customer customer;
    private Map<Product, Integer> items = new LinkedHashMap<>();
    private LocalDateTime orderDate;
    private String status;

    public Order(Long id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.orderDate = LocalDateTime.now();
        this.status = "PENDING";
    }

    public void addItem(Product product, int quantity) {
        items.merge(product, quantity, Integer::sum);
    }

    public double getTotal() {
        return items.entrySet().stream()
            .mapToDouble(e -> e.getKey().getPrice() * e.getValue())
            .sum();
    }

    public Long getId() { return id; }
    public Customer getCustomer() { return customer; }
    public Map<Product, Integer> getItems() { return items; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return String.format("Order{id=%d, customer='%s', total=%.2f, status=%s}",
            id, customer.getName(), getTotal(), status);
    }
}
