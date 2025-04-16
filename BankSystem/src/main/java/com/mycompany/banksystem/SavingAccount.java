package com.mycompany.banksystem;

public class SavingAccount extends Account {
    public SavingAccount(String accountNumber, String holderName) {
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

    public void calculateInterest() {
        double interest = balance * 0.03;  // 3% interest
        balance += interest;
        transactions.add(new Transaction("Interest", interest));
        System.out.println("Interest applied: $" + interest);
    }
}

