package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.service.OrderItemServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderItemController
{
    @Autowired
    OrderItemServiceImpl orderItemService;

    @GetMapping(path = "/orderitems")
    public List<OrderItem> getorderitems() throws Exception
    {
        return orderItemService.getAllorderItems();
    }

    @PostMapping(path = "/orderitem")
    public OrderItem addorderitems(@RequestBody OrderItem orderItem) throws Exception
    {
        return orderItemService.addorderItem(orderItem);
    }
    @PutMapping(path = "/orderitem")
    public OrderItem updateorderitems(@RequestBody OrderItem orderItem) throws Exception
    {
        return orderItemService.addorderItem(orderItem);
    }
    @DeleteMapping(path = "/orderitem")
    public String deleteorderitems(@RequestBody OrderItem orderItem) throws Exception
    {
         orderItemService.deleteOrderItem(1L);

         return "OrderItemDeleted SuccesFully";
    }

}
