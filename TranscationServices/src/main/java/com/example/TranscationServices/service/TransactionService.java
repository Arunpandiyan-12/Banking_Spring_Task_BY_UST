package com.example.TranscationServices.service;

import com.example.TranscationServices.entity.Transactions;
import com.example.TranscationServices.repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
   @Autowired
   TransactionRepository transactionsRepository;
    // Create a new transaction
    public Transactions createTransaction(Transactions transaction) {
        return transactionsRepository.save(transaction);
    }

    // Get all transactions
    public List<Transactions> getAllTransactions() {
        return transactionsRepository.findAll();
    }

    // Get transactions by account number (custom query, if needed)
    public List<Transactions> getTransactionsByAccountNumber(String accountNumber) {

         return transactionsRepository.findByAccountNumber(accountNumber);

    }



}
