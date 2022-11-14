package com.fareye.flipzone.service;

import com.fareye.flipzone.model.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderItemService {
    List<OrderItem> getAllorderItems();

    List<OrderItem> getAllorderItemsById();

    OrderItem addorderItem(OrderItem orderitem);

    void deleteOrderItem(Long id);

}
