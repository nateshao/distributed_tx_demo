package com.example.twopc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
    @Autowired OrderService orderService;
    @PostMapping("/create")
    public Order create(@RequestParam @NotBlank(message = "订单名不能为空") String name) {
        return orderService.createOrder(name);
    }
} 