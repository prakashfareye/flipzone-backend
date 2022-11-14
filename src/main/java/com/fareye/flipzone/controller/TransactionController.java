package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping(path = "/transactions")
    public List<Transaction> getTransactions() throws Exception
    {
        return transactionService.getAllTransaction();
    }
    @PostMapping(path = "/transactions")
    public List<Transaction> postTransactions() throws Exception
    {
        return transactionService.getAllTransaction();
    }


}
