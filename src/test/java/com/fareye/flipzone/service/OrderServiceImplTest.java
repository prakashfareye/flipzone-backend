package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.OrderItemRepository;
import com.fareye.flipzone.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import java.util.Optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

   @Mock
   private OrderRepository orderRepository;

   @InjectMocks
   OrderServiceImpl orderService;

   private  Order order;
   private Transaction transaction;

   private OrderItem  orderItem;
   private User user;

   List<OrderItem>orderItems=new ArrayList<>();

   List<Transaction>TransactionList=new ArrayList<>();

    @BeforeEach
    public void setup(){
         transaction=Transaction.builder()
                 .paymentId("-")
                 .mode("Google Pay")
                 .userId(1L)
                 .Status("Done")
                 .build();

        TransactionList.add(transaction);

         user=User.builder().userEmailId("tusharbansal@gmail.com")
                 .userName("Sohil Lamba")
                 .password("1234")
                 .role("USER")
                 .build();

         orderItem=OrderItem.builder()
                 .productId(1L)
                 .quantity(2)
                 .total(4000.0)
                 .build();

         orderItems.add(orderItem);

         order=Order.builder().orderId(1L)
                 .status("on The Way")
                 .total(4000.0)
                 .addressId(1L)
                 .user(user)
                 .orderItems(orderItems)
                 .transactions(TransactionList)
                 .build();
    }

    @DisplayName("Junit For Get AllOrders")
    @Test
    void getAllorders() {
       List<Order> orderList=new ArrayList<>();
       orderList.add(order);
       when(orderRepository.findAll()).thenReturn(orderList);
       assertEquals(1,orderService.getAllorders().size());
    }

    @DisplayName("Junit For Add Order")
    @Test
    void addordersTest() {

      when(orderRepository.save(order)).thenReturn(order);
      assertEquals(order, orderService.addorders(order));

    }

    @Test
    void updateorder() {
        order.setStatus("Delivered");
        Long orderId=18L;

    }

    @DisplayName("Junit For Deleting Order By User Id")
    @Test
    void deleteorder() {
        Long orderid=31L;
        orderService.deleteorder(orderid);
        verify(orderRepository,times(1)).deleteById(orderid);
    }

    @DisplayName("Junit For Finding Order By User Id")
    @Test
    void getOrderByid() {
        List<Order> orderList=new ArrayList<>();
        orderList.add(order);

        Long userId=18L;
        when(orderRepository.findByUser_userId(userId)).thenReturn(orderList);
        assertEquals(1,orderService.getOrderByid(userId).size());

    }


    @DisplayName("Junit For Finding Order By Order Id")
    @Test
    void getOrderByOrderid() {
        Long orderId=18L;
        when(orderRepository.findById(orderId)).thenReturn(Optional.ofNullable(order));
        assertEquals(order,orderService.getOrderByOrderid(orderId));
    }
}