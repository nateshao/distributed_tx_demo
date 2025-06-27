package com.example.msgtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired OrderRepository orderRepository;
    @Autowired MessageRepository messageRepository;
    @Transactional
    public void createOrder(String name) {
        Order order = orderRepository.save(new Order(name));
        messageRepository.save(new Message("order_created:" + order.getId()));
    }
} 