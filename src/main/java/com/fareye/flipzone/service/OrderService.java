package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllorders();

    Order addorders(Order order);

    Order updateorder(Order order);

    Order deleteorder(Order order);

    List<Order> getOrderByid();
}
