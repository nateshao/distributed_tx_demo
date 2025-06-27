package com.example.msgtable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.constraints.NotBlank;
import javax.validation.Valid;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/order")
@Validated
public class OrderController {
    @Autowired OrderService orderService;
    @PostMapping("/create")
    public String create(@RequestParam @NotBlank(message = "订单名不能为空") String name) {
        orderService.createOrder(name);
        return "ok";
    }
} 