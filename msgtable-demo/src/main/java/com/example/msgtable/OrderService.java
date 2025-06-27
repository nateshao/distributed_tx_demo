package com.example.msgtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    @Autowired OrderRepository orderRepository;
    @Autowired MessageRepository messageRepository;
    @Transactional
    public void createOrder(String name) {
        try {
            Order order = orderRepository.save(new Order(name));
            messageRepository.save(new Message("order_created:" + order.getId()));
            log.info("订单创建成功: {}", order.getId());
        } catch (Exception e) {
            log.error("订单创建失败", e);
            throw e;
        }
    }
} 