package com.bank;

class BankAccount {
    private double balance;

    // Constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    // Synchronized deposit method to ensure thread safety
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(Thread.currentThread().getName() + " deposited: " + amount + ", New balance: " + balance);
        }
    }

    // Synchronized withdraw method to ensure thread safety
    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName() + " withdrew: " + amount + ", New balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName() + " tried to withdraw: " + amount + ", Insufficient funds.");
        }
    }

    // Synchronized getBalance method to ensure thread safety
    public synchronized double getBalance() {
        return balance;
    }
}

