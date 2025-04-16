/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.banksystem;

/**
 *
 * @author User
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner scanner = new Scanner(System.in);

        // Register Admin
        bank.registerUser("admin", "admin123", User.Role.ADMIN);
        bank.registerUser("customer1", "customer123", User.Role.CUSTOMER);

        while (true) {
            System.out.println("==== Welcome Bank System ===");
            System.out.print("Username: ");
            String username = scanner.next();
            System.out.print("Password: ");
            String password = scanner.next();

            User user = bank.login(username, password);
            if (user == null) {
                System.out.println("Invalid login.");
                continue;
            }

            if (user.getRole() == User.Role.ADMIN) {
                adminMenu(scanner, bank);
            } else {
                customerMenu(scanner, bank, username);
            }
        }
    }

    static void adminMenu(Scanner sc, Bank bank) {
        while (true) {
            System.out.println("\n==== Admin Menu ====");
            System.out.println("1. Register User\n2. Create Account\n3. View All Accounts\n4. Total Bank Funds\n5. Logout");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.print("New username: ");
                    String u = sc.next();
                    System.out.print("Password: ");
                    String p = sc.next();
                    System.out.print("Role ( ADMIN or CUSTOMER): ");
                    User.Role role = User.Role.valueOf(sc.next().toUpperCase());
                    bank.registerUser(u, p, role);
                }
                case 2 -> {
                    System.out.print("Account number: ");
                    String accNum = sc.next();
                    System.out.print("Holder name: ");
                    String name = sc.next();
                    System.out.print("Account type (S for Saving, C for Checking): ");
                    String type = sc.next();
                    bank.createAccount(accNum, name, type);
                }
                case 3 -> bank.viewAllAccounts();
                case 4 -> System.out.println("Total Bank Funds: $" + bank.calculateTotalBankFunds());
                case 5 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    static void customerMenu(Scanner sc, Bank bank, String username) {
        while (true) {
            System.out.println("\n[Customer Menu]");
            System.out.println("1. My Accounts\n2. Deposit\n3. Withdraw\n4. Check Balance\n5. View Transactions\n6. Apply Interest\n7. Logout");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> bank.getUserAccounts(username)
                        .forEach(acc -> System.out.println(acc.getAccountNumber() + " - " + acc.getHolderName()));
                case 2 -> {
                    System.out.print("Account number: ");
                    String accNum = sc.next();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    Account acc = bank.getAccount(accNum);
                    acc.deposit(amt);
                }
                case 3 -> {
                    System.out.print("Account number: ");
                    String accNum = sc.next();
                    System.out.print("Amount: ");
                    double amt = sc.nextDouble();
                    Account acc = bank.getAccount(accNum);
                    try {
                        acc.withdraw(amt);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Account number: ");
                    String accNum = sc.next();
                    bank.getAccount(accNum).displayBalance();
                }
                case 5 -> {
                    System.out.print("Account number: ");
                    String accNum = sc.next();
                    bank.getAccount(accNum).showTransactionHistory();
                }
                case 6 -> {
                    System.out.print("Account number: ");
                    String accNum = sc.next();
                    Account acc = bank.getAccount(accNum);
                    if (acc instanceof SavingAccount) {
                        ((SavingAccount) acc).calculateInterest();
                    } else {
                        System.out.println("Interest can only be applied to Saving Accounts.");
                    }
                }
                case 7 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
