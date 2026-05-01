package com.example.ordermanagement.service;

import java.util.List;
import java.util.Optional;

import com.example.ordermanagement.model.Product;

public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    List<Product> findLowStock(int threshold);  // stock нь threshold-аас бага
}
