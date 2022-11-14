package com.fareye.flipzone.service;


import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllorders() {

        List<Order> orders= orderRepository.findAll();
        System.out.println(orders);
        return orders;
    }

    @Override
    public Order addorders(Order order) {
         Order orderAdded= orderRepository.save(order);
         return orderAdded;
    }

    @Override
    public Order updateorder(Order order) {
        Order orderAdded= orderRepository.save(order);
        return orderAdded;
    }
    @Override
    public Order deleteorder(Order order) {
        Order orderAdded= orderRepository.save(order);
        return orderAdded;
    }

    @Override
    public List<Order> getOrderByid() {

        return (List<Order>) orderRepository.findById(1L).orElseThrow(
                () -> new FileSystemNotFoundException("Orders Not Found"));
    }

}
