package com.mycompany.banksystem;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class Bank {
    private Map<String, User> users = new HashMap<>();
    private Map<String, Account> accounts = new HashMap<>();
    private Map<String, List<String>> userAccounts = new HashMap<>();

    // Register a new user
    public void registerUser(String username, String password, User.Role role) {
        if (users.containsKey(username)) {
            System.out.println("User already exists.");
            return;
        }
        users.put(username, new User(username, password, role));
        userAccounts.put(username, new ArrayList<>());
        System.out.println("User registered successfully.");
    }

    // User login
    public User login(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) return user;
        return null;
    }

    // Admin can view all accounts
    public void viewAllAccounts() {
        for (Account acc : accounts.values()) {
            System.out.println(acc.getAccountNumber() + " - " + acc.getHolderName());
        }
    }

    // Admin can calculate total funds in the bank
    public double calculateTotalBankFunds() {
        double total = 0;
        for (Account acc : accounts.values()) {
            total += acc.getBalance();
        }
        return total;
    }

    // Create a new account
    public void createAccount(String accountNumber, String holderName, String type) {
        Account newAccount;
        if (type.equals("S")) {
            newAccount = new SavingAccount(accountNumber, holderName);
        } else if (type.equals("C")) {
            newAccount = new CheckingAccount(accountNumber, holderName);
        } else {
            System.out.println("Invalid account type!");
            return;
        }
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully.");
    }

    // Get a specific account
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Get accounts for a specific user
    public List<Account> getUserAccounts(String username) {
        List<String> accNumbers = userAccounts.get(username);
        List<Account> userAccs = new ArrayList<>();
        for (String accNum : accNumbers) {
            userAccs.add(accounts.get(accNum));
        }
        return userAccs;
    }
}

