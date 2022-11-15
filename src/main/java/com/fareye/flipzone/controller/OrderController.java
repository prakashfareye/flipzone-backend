package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.service.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderServiceImpl orderService;

    @GetMapping
    public List<Order> getorders() throws Exception
    {
        return orderService.getAllorders();
    }

    @PostMapping
    public Order addorder(@RequestBody  Order order) throws Exception
    {
        return orderService.addorders(order);
    }
    @PutMapping(path = "/u/{id}")
    public Order updateorder(@PathVariable Long id,@RequestBody  Order order) throws Exception
    {
        return orderService.updateorder(id,order);
    }
    @DeleteMapping(path = "/u/{id}")
    public String deleterorder(@PathVariable  Long id) throws Exception
    {
         orderService.deleteorder(id);

         return "Order Deleted Succesfully";
    }

    @GetMapping(path = "/u/{id}")
    public List<Order> getordersByUserid(@PathVariable Long id) throws Exception
    {
        return orderService.getOrderByid(id);
    }
    @GetMapping(path = "/o/{id}")
    public Order getordersByOrderid(@PathVariable Long id) throws Exception
    {
        return orderService.getOrderByOrderid(id);
    }


}
