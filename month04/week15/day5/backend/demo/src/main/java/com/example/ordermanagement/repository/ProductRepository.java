package com.example.ordermanagement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.ordermanagement.model.Product;

import jakarta.annotation.PostConstruct;

@Repository
public class ProductRepository {
    private final Map<Long, Product> products = new HashMap<>();

    @PostConstruct
    public void init() {
        save(new Product(1L, "Laptop",     999.99,  50));
        save(new Product(2L, "Phone",      599.99, 100));
        save(new Product(3L, "Headphones", 149.99, 200));
        save(new Product(4L, "Keyboard",    79.99, 150));
        System.out.println("[ProductRepository] " + products.size() + " product loaded");
    }

    public Product save(Product product) {
        products.put(product.getId(), product);
        return product;
    }

    public Optional<Product> findById(Long id) {
        return Optional.ofNullable(products.get(id));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public List<Product> findByStockLessThan(int threshold) {
        return products.values().stream()
            .filter(p -> p.getStockQuantity() < threshold)
            .toList();
    }
}
