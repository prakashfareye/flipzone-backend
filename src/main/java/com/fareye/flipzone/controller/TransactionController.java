package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Transaction;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.TransactionRepository;
import com.fareye.flipzone.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @GetMapping(path = "/transactions")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Transaction> getusers() throws Exception
    {
        return transactionService.getAllTransaction();
    }

}
