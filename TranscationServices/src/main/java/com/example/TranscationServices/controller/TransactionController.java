package com.example.TranscationServices.controller;

import com.example.TranscationServices.entity.Transactions;
import com.example.TranscationServices.service.TransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionsService;

    // Create a new transaction
    @PostMapping("/addtransaction")
    public Transactions createTransaction(@RequestBody Transactions transaction) {
        return transactionsService.createTransaction(transaction);
    }

    // Get all transactions
    @GetMapping("/getall")
    public List<Transactions> getAllTransactions() {
        return transactionsService.getAllTransactions();
    }


    // Get transactions by account number (example of custom query)
    @GetMapping("{accountNumber}")
    public List<Transactions> getTransactionsByAccountNumber(@PathVariable("accountNumber") String accountNumber) {
        return transactionsService.getTransactionsByAccountNumber(accountNumber);
    }


}
