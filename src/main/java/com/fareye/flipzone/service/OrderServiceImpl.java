package com.fareye.flipzone.service;


import com.fareye.flipzone.dto.OrderDto;
import com.fareye.flipzone.dto.OrderItemDto;
import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.Product;
import com.fareye.flipzone.repository.OrderRepository;
import com.fareye.flipzone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ProductRepository productRepository;

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
    public Order updateorder(Long id, Order order) {
        Order oldOrder= orderRepository.findById(id).orElseThrow(()->new RuntimeException("Order Not Found"));
        oldOrder.setOrderItems(order.getOrderItems());
        oldOrder =orderRepository.save(oldOrder);
        return oldOrder;
    }
    @Override
    public void deleteorder(Long id) {
        orderRepository.deleteById(id);

    }
    @Override
    public List<Order> getOrderByid(Long id) {

        List<Order> orders = orderRepository.findByUser_userId(id);
        List<OrderDto>orderDtos=new ArrayList<>();
        return orders;
    }

    @Override
    public Order getOrderByOrderid(Long id) {

        return  orderRepository.findById(id).orElseThrow(()->new FileSystemNotFoundException("Order Not Found"));

    }

}
