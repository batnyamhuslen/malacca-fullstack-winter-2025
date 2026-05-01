package com.example.ordermanagement.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.ordermanagement.model.Customer;

import jakarta.annotation.PostConstruct;

@Repository
public class CustomerRepository {

    private final Map<Long, Customer> customers = new HashMap<>();

    @PostConstruct
    public void init() {
        save(new Customer(1L, "Bat", "bat@email.com", "99001122"));
        save(new Customer(2L, "Bold", "bold@email.com", "99112233"));
        save(new Customer(3L, "Sarnai", "sarnai@email.com", "99223344"));

        System.out.println("[CustomerRepository] " + customers.size() + " customers loaded");
    }

    public Customer save(Customer customer) {
        customers.put(customer.getId(), customer);
        return customer;
    }

    public Optional<Customer> findById(Long id) {
        return Optional.ofNullable(customers.get(id));
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customers.values());
    }
}
