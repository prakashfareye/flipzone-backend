package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping(path = "/orders")
    public List<Order> getorders() throws Exception
    {
        return orderService.getAllorders();
    }

    @PostMapping(path = "/order")
    public Order addorder(Order order) throws Exception
    {
        return orderService.addorders(order);
    }


}
