package com.example.BankingServices.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "accounts")
public class Account {

    @Id
    private Long id;


    private String accountName;


    private String accountNumber;


    private double balance;

    // Constructors
    public Account() {}

    public Account(Long id, String accountName, String accountNumber, double balance) {
        this.id = id;
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}

