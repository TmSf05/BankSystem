package com.mycompany.banksystem;

public class CheckingAccount extends Account {
    public CheckingAccount(String accountNumber, String holderName) {
        super(accountNumber, holderName);
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Deposit", amount));
        }
    }

    @Override
    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal");
        }
        balance -= amount;
        transactions.add(new Transaction("Withdraw", amount));
    }
}

