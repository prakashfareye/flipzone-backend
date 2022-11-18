package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.OrderItemRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderItemServiceImplTest {

    @Mock
    OrderItemRepository orderItemRepository;

    @InjectMocks
    OrderServiceImpl orderService;

    @InjectMocks
    OrderItemServiceImpl orderItemService;

    private Order order;
    private OrderItem orderItem;
    private User user;
    private Transaction transaction;

    List<OrderItem> orderItems=new ArrayList<>();

    List<Transaction>TransactionList=new ArrayList<>();

    @BeforeEach
    public void setup(){

        transaction=Transaction.builder()
                .paymentId("-")
                .mode("Google Pay")
                .userId(1L)
                .Status("Done")
                .build();

        order=Order.builder().orderId(1L)
                .status("on The Way")
                .total(4000.0)
                .addressId(1L)
                .user(user)
                .orderItems(orderItems)
                .transactions(TransactionList)
                .build();

        orderItem=OrderItem.builder()
//                .productId(1L)
                .quantity(2)
                .total(4000.0)
                .order(order)
                .build();

        orderItems.add(orderItem);
    }

    @DisplayName("Junit For Get AllUser")
    @Test
    void getAllorderItems() {

        List<OrderItem> orderItemList=new ArrayList<>();
        orderItemList.add(orderItem);
        when(orderItemRepository.findAll()).thenReturn(orderItemList);
        assertEquals(1,orderItemService.getAllorderItems().size());
    }

    @Test
    void getAllorderItemsById() {


    }

    @Test
    void addorderItem() {

        when(orderItemRepository.save(orderItem)).thenReturn(orderItem);
        assertEquals(orderItem, orderItemService.addorderItem(orderItem));

    }

    @Test
    void deleteOrderItem() {
//        Long orderItemid=31L;
//        orderItemService.deleteOrderItem(orderItemid);
//        verify(orderItemRepository,times(1)).deleteById(orderItemid);

    }
}