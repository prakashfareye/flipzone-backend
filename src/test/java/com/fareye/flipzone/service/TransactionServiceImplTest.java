package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.OrderRepository;
import com.fareye.flipzone.repository.TransactionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    TransactionServiceImpl transactionService;
    private Order order;
    private Transaction transaction;

    private OrderItem orderItem;
    private User user;

    List<OrderItem> orderItems=new ArrayList<>();

    List<Transaction>TransactionList=new ArrayList<>();

    @BeforeEach
    public void setup(){

        order=Order.builder().orderId(1L)
                .status("on The Way")
                .total(4000.0)
                .addressId(1L)
                .user(user)
                .orderItems(orderItems)
                .transactions(TransactionList)
                .build();

        transaction=Transaction.builder()
                .Transaction_Id(1L)
                .paymentId("-")
                .mode("Google Pay")
                .userId(1L)
                .Status("Done")
                .order(order)
                .build();

        TransactionList.add(transaction);

        user=User.builder().userEmailId("tusharbansal@gmail.com")
                .userName("Sohil Lamba")
                .password("1234")
                .role("USER")
                .build();

        orderItem=OrderItem.builder()
//                .productId(1L)
                .quantity(2)
                .total(4000.0)
                .build();

        orderItems.add(orderItem);

    }


    @Test
    void getAllTransaction() {
        List<Transaction> transactionList=new ArrayList<>();
        transactionList.add(transaction);
        when(transactionRepository.findAll()).thenReturn(transactionList);
        assertEquals(1,transactionService.getAllTransaction().size());
    }

    @Test
    void getAllTransactionById() {
//         Long transactionId=1L;
//        when(transactionRepository.findById(transactionId)).thenReturn(Optional.ofNullable(transaction));
//        assertEquals(transaction,transactionService.getAllTransactionById());
    }

    @Test
    void getAllTransactionByOrderId() {
        Long order_Id=1L;
        List<Transaction> transactionList=new ArrayList<>();
        transactionList.add(transaction);
        when(transactionRepository.findByOrder_OrderId(order_Id)).thenReturn(transactionList);
        assertEquals(1,transactionRepository.findByOrder_OrderId(order_Id).size());
    }

    @Test
    void getAllTransactionByUserId() {


    }
}