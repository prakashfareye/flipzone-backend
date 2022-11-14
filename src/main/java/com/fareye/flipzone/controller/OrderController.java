package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping(path = "/orders")
    public List<Order> getorders() throws Exception
    {
        return orderService.getAllorders();
    }

    @PostMapping(path = "/order")
    public Order addorder(@RequestBody  Order order) throws Exception
    {
        return orderService.addorders(order);
    }
    @PutMapping(path = "/order")
    public Order updateorder(@RequestBody  Order order) throws Exception
    {
        return orderService.updateorder(order);
    }
    @DeleteMapping(path = "/order")
    public Order deleterorder(@RequestBody  Order order) throws Exception
    {
        return orderService.deleteorder(order);
    }

    @GetMapping(path = "/orderbyid")
    public List<Order> getordersByid() throws Exception
    {
        return orderService.getOrderByid();
    }

}
