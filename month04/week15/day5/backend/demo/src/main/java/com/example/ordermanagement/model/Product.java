package com.example.ordermanagement.model;

public class Product {
    private Long id;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(Long id, String name, double price, int stockQuantity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int quantity) { this.stockQuantity = quantity; }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', price=%.2f, stock=%d}",
            id, name, price, stockQuantity);
    }
}

