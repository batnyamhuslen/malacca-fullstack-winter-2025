package com.example.ordermanagement.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.ordermanagement.model.Customer;
import com.example.ordermanagement.model.Order;
import com.example.ordermanagement.model.Product;
import com.example.ordermanagement.repository.CustomerRepository;
import com.example.ordermanagement.repository.OrderRepository;
import com.example.ordermanagement.repository.ProductRepository;
import com.example.ordermanagement.service.NotificationService;
import com.example.ordermanagement.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository    orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository  productRepository;
    private final NotificationService primaryNotification;  // @Primary → SMS
    private final NotificationService emailNotification;    // @Qualifier → Email

    @Autowired
    public OrderServiceImpl(
            OrderRepository orderRepository,
            CustomerRepository customerRepository,
            ProductRepository productRepository,
            NotificationService primaryNotification,
            @Qualifier("emailNotification") NotificationService emailNotification) {
        this.orderRepository      = orderRepository;
        this.customerRepository   = customerRepository;
        this.productRepository    = productRepository;
        this.primaryNotification  = primaryNotification;
        this.emailNotification    = emailNotification;
    }

    @Override
    public Order createOrder(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
            .orElseThrow(() -> new RuntimeException("Customer not found: " + customerId));
        Order order = new Order(orderRepository.count() + 1, customer);
        return orderRepository.save(order);
    }

    @Override
    public Order addItem(Long orderId, Long productId, int quantity) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        Product product = productRepository.findById(productId)
            .orElseThrow(() -> new RuntimeException("Product not found: " + productId));

        if (product.getStockQuantity() < quantity) {
            throw new RuntimeException("Insufficient stock: " + product.getName());
        }
        order.addItem(product, quantity);
        product.setStockQuantity(product.getStockQuantity() - quantity);
        return order;
    }

    @Override
    public Order processOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        order.setStatus("CONFIRMED");
        primaryNotification.sendOrderConfirmation(order);   // SMS (primary)
        emailNotification.sendOrderConfirmation(order);     // Email (qualifier)
        return order;
    }

    @Override
    public Order shipOrder(Long orderId) {
        Order order = orderRepository.findById(orderId)
            .orElseThrow(() -> new RuntimeException("Order not found: " + orderId));
        order.setStatus("SHIPPED");
        primaryNotification.sendShippingNotification(order);
        return order;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}
