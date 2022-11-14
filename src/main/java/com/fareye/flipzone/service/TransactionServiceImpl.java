package com.fareye.flipzone.service;


import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    TransactionRepository transactionRepository;

    @Override
    public List<Transaction> getAllTransaction() {

        List<Transaction> Transactions= transactionRepository.findAll();
        return Transactions;
    }

    @Override
    public List<Transaction> getAllTransactionById() {

        return (List<Transaction>) transactionRepository.findById(1L).orElseThrow(
                () -> new FileSystemNotFoundException("OrderItem Not Found"));

    }


}
