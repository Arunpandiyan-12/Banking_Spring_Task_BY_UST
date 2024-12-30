package com.example.BankingServices.DTO;

import java.time.LocalDateTime;

public class TransactionDTO {

    private Long id;



    private double amount;
    private String transactionType; // 'DEPOSIT' or 'WITHDRAW'
    private LocalDateTime transactionTime;
    private String accountNumber;

    public TransactionDTO(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public TransactionDTO() {
        this.transactionTime = LocalDateTime.now();
    }

    public TransactionDTO(Long id, double amount, String transactionType, LocalDateTime transactionTime) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.transactionTime = transactionTime;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public LocalDateTime getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(LocalDateTime transactionTime) {
        this.transactionTime = transactionTime;
    }
}
