package com.mycompany.banksystem;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public abstract class Account {
    protected String accountNumber;
    protected String holderName;
    protected double balance;
    protected List<Transaction> transactions = new ArrayList<>();

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientFundsException;

    public void displayBalance() {
        System.out.println("Balance for " + accountNumber + ": $" + balance);
    }

    public void showTransactionHistory() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found.");
        } else {
            transactions.forEach(transaction -> System.out.println(transaction));
        }
    }

    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
}

