package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    TransactionServiceImpl transactionService;

    @GetMapping
    public List<Transaction> getTransactions() throws Exception
    {
        return transactionService.getAllTransaction();
    }
    @PostMapping
    public List<Transaction> postTransactions() throws Exception
    {
        return transactionService.getAllTransaction();
    }

    @GetMapping(path = "/o/{OrderId}")
    public List<Transaction> GetTransactionsByOrderId(@PathVariable Long OrderId) throws Exception
    {
        return transactionService.getAllTransactionByOrderId(OrderId);
    }

    @GetMapping(path = "/u/{UserId}")
    public List<Transaction> GetTransactionsByUserId(@PathVariable Long UserId) throws Exception
    {
        return transactionService.getAllTransactionByUserId(UserId);
    }


}
