package com.fareye.flipzone.service;


import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    public List<Order> getAllorders() {

        List<Order> orders= orderRepository.findAll();
        System.out.println(orders);
        return orders;
    }

    public Order addorders(Order order) {

        System.out.println("Before Adding Order"+order);
         Order orderAdded= orderRepository.save(order);
        System.out.println("After Adding The Order"+orderAdded);
        return orderAdded;
    }

}
