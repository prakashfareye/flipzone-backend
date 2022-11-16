package com.fareye.flipzone.service;


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
    public List<Transaction> getAllTransactionById() throws FileSystemNotFoundException{

        return (List<Transaction>) transactionRepository.findById(1L).orElseThrow(
                () -> new FileSystemNotFoundException("No Transaction For Given User"));

    }

    @Override
    public List<Transaction> getAllTransactionByOrderId(Long orderId) {
        List<Transaction> list;
        list= (List<Transaction>) transactionRepository.findByOrder_OrderId(orderId);
       return list;
    }

    @Override
    public List<Transaction> getAllTransactionByUserId(Long userId){
        List<Transaction> list;
        list=transactionRepository.findByUserId(userId);
        return list;
    }
    
}
