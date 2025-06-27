package com.example.twopc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired OrderRepository orderRepository;
    @Transactional
    public Order createOrder(String name) {
        return orderRepository.save(new Order(name));
    }
} 