package com.example.msgtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired OrderService orderService;
    @PostMapping("/create")
    public String create(@RequestParam String name) {
        orderService.createOrder(name);
        return "ok";
    }
} 