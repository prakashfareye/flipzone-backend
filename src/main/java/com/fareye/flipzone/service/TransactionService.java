package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    List<Transaction> getAllTransaction();

    List<Transaction> getAllTransactionById();
}
