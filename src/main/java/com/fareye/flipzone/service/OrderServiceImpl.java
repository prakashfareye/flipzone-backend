package com.fareye.flipzone.service;


import com.fareye.flipzone.dto.OrderDto;
import com.fareye.flipzone.dto.OrderItemDto;
import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.Product;
import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.repository.OrderItemRepository;
import com.fareye.flipzone.repository.OrderRepository;
import com.fareye.flipzone.repository.ProductRepository;
import com.fareye.flipzone.repository.TransactionRepository;
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
    TransactionRepository transactionRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    @Autowired
    OrderItemRepository orderItemRepository;

    @Override
    public List<Order> getAllorders(){

        List<Order> orders= orderRepository.findAll();
        return orders;
    }

    @Override
    public Order addorders(Order order) {

         Order orderAdded= orderRepository.save(order);
         List<OrderItem> orderItemList = orderAdded.getOrderItems();
         for (OrderItem oi : orderItemList){
             long productId = oi.getProduct().getProductId();
             int quantity = oi.getQuantity();
             productService.updateProductQuantity(productId, quantity);
         }
         return orderAdded;
    }

    @Override
    public Order updateorder(Long id, Order order) throws FileSystemNotFoundException{
        Order oldOrder= orderRepository.findById(id).orElseThrow(()->new FileSystemNotFoundException("Order Not Found"));
        oldOrder.setOrderItems(order.getOrderItems());
        oldOrder.setStatus(order.getStatus());
        oldOrder.setTotal(order.getTotal());
        oldOrder.setAddressId(order.getAddressId());
        oldOrder =orderRepository.save(oldOrder);
        return oldOrder;
    }
    @Override
    public void deleteorder(Long id) throws FileSystemNotFoundException {

        orderRepository.findById(id).orElseThrow(() -> new FileSystemNotFoundException("Order Not Found"));

        orderRepository.deleteById(id);
    }
    @Override
    public List<Order> getOrderByid(Long id){
        List<Order> orders = orderRepository.findByUser_userId(id);
      for(Order o:orders) {
      List<Transaction> transactions=transactionRepository.findByOrder_OrderId(o.getOrderId());
      System.out.println(transactions);
      List<OrderItem> orderItemss=orderItemRepository.findByOrder_OrderId(o.getOrderId());
      o.setTransactions(transactions);
      o.setOrderItems(orderItemss);
      }
      return orders;
    }

    @Override
    public Order getOrderByOrderid(Long id) throws  FileSystemNotFoundException{

        return  orderRepository.findById(id).orElseThrow(()->new FileSystemNotFoundException("Order Not Found"));

    }

}
