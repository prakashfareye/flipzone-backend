package com.fareye.flipzone.service;

import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.repository.OrderItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService{

    @Autowired
    OrderItemRepository orderItemRepository;
    @Override
    public List<OrderItem> getAllorderItems() {
         List<OrderItem> orderItems= orderItemRepository.findAll();
        return orderItems;
    }

    @Override
    public List<OrderItem> getAllorderItemsById() throws FileSystemNotFoundException{
          return (List<OrderItem>) orderItemRepository.findById(1L).orElseThrow(
                  () -> new FileSystemNotFoundException("OrderItem Not Found"));
    }
    @Override
    public OrderItem addorderItem(OrderItem orderitem) {
        OrderItem orderItemAdded= orderItemRepository.save(orderitem);
        return orderitem;
    }
    @Override
    public void deleteOrderItem(Long id) throws FileSystemNotFoundException{
        orderItemRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("OrderItem Not Found"));
        orderItemRepository.deleteById(id);
    }

}
