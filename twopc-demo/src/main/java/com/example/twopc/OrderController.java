package com.example.twopc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired OrderService orderService;
    @PostMapping("/create")
    public Order create(@RequestParam String name) {
        return orderService.createOrder(name);
    }
} 