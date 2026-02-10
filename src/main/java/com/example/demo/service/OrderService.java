package com.example.demo.service;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order placeOrder(Order order) {
        order.setStatus("PLACED");
        return orderRepository.save(order);
    }
}
