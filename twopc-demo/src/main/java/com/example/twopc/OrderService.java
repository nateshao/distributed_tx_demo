package com.example.twopc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @Autowired OrderRepository orderRepository;
    @Transactional
    public Order createOrder(String name) {
        try {
            Order order = orderRepository.save(new Order(name));
            log.info("订单创建成功: {}", order.getId());
            return order;
        } catch (Exception e) {
            log.error("订单创建失败", e);
            throw e;
        }
    }
} 