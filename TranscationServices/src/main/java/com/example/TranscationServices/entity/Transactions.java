package com.example.TranscationServices.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
public class Transactions {

    @Id

    private Long id;



    private double amount;
    private String transactionType; // 'DEPOSIT' or 'WITHDRAW'
    private LocalDateTime transactionTime;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    private String accountNumber;

    public Transactions(Long id, double amount, String transactionType, String accountNumber, LocalDateTime transactionTime) {
        this.id = id;
        this.amount = amount;
        this.transactionType = transactionType;
        this.accountNumber = accountNumber;
        this.transactionTime = transactionTime;
    }

    public Transactions() {
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
