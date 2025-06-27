package com.example.reliablemsg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mq")
public class MQController {
    @Autowired OrderRepository orderRepository;
    @PostMapping("/send")
    public String send(@RequestParam String name) {
        orderRepository.save(new Order(name));
        // 这里应集成RocketMQ事务消息发送逻辑
        return "sent";
    }
} 