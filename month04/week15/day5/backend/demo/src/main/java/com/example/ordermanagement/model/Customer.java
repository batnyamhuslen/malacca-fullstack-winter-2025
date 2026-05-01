package com.example.ordermanagement.model;

public class Customer {
    private Long id;
    private String name;
    private String email;
    private String phone;

    public Customer(Long id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    @Override
    public String toString() {
        return String.format("Customer{id=%d, name='%s', email='%s'}", id, name, email);
    }
}
