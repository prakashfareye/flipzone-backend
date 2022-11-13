package com.fareye.flipzone.service;


import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.repository.OrderRepository;
import com.fareye.flipzone.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    @Autowired
    TransactionRepository transactionRepository;

    public List<Transaction> getAllTransaction() {

        List<Transaction> Transactions= transactionRepository.findAll();
        System.out.println(Transactions);
        return Transactions;
    }


}
