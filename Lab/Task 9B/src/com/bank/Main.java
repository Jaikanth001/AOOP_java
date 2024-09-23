package com.bank;

public class Main {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(1000); // Initial balance of 1000

        // Creating Runnable tasks for deposit and withdraw
        Runnable depositTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.deposit(100);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable withdrawTask = () -> {
            for (int i = 0; i < 5; i++) {
                account.withdraw(50);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        // Creating threads for deposit and withdraw operations
        Thread user1 = new Thread(depositTask, "User1");
        Thread user2 = new Thread(withdrawTask, "User2");

        // Starting the threads
        user1.start();
        user2.start();

        // Waiting for threads to finish
        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Display the final balance
        System.out.println("Final balance: " + account.getBalance());
    }
}

