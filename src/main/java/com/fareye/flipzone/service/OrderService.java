package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllorders();

    Order addorders(Order order);

    Order updateorder(Long id,Order order);
    void deleteorder(Long id);

    List<Order> getOrderByid(Long id);

    Order getOrderByOrderid(Long id);
}
