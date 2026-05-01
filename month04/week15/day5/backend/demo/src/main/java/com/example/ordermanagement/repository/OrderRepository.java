package com.example.ordermanagement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.example.ordermanagement.model.Order;

@Repository
public class OrderRepository {

    private final Map<Long, Order> orders = new HashMap<>();

    public Order save(Order order) {
        orders.put(order.getId(), order);
        return order;
    }

    public Optional<Order> findById(Long id) {
        return Optional.ofNullable(orders.get(id));
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders.values());
    }

    public long count() {
        return orders.size();
    }

    public List<Order> findByCustomerId(Long customerId) {
        return orders.values()
                .stream()
                .filter(order -> Objects.equals(order.getCustomer().getId(), customerId))
                .collect(Collectors.toList());
    }
}