package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
@CrossOrigin(origins = "http://localhost:5173")
public class OrderController {

    private final OrderService orderService;

    // ✅ constructor injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // ✅ PLACE ORDER
    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }
}
