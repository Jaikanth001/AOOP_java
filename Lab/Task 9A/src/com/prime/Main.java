package com.prime;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 15; i++) {
            final int number = i;

            executor.submit(() -> printTwo(number));
            executor.submit(() -> printThree(number));
            executor.submit(() -> printFour(number));
            executor.submit(() -> printFive(number));
            executor.submit(() -> printNumber(number));
        }
        executor.shutdown();
    }

    public static void printTwo(int n) {
        if (n % 2 == 0 && n % 3 != 0 && n % 4 != 0 && n % 5 != 0) {
            System.out.println("Divisible by 2: " + n);
        }
    }

    public static void printThree(int n) {
        if (n % 3 == 0 && n % 2 != 0 && n % 4 != 0 && n % 5 != 0) {
            System.out.println("Divisible by 3: " + n);
        }
    }

    public static void printFour(int n) {
        if (n % 4 == 0 && n % 2 != 0 && n % 3 != 0 && n % 5 != 0) {
            System.out.println("Divisible by 4: " + n);
        }
    }

    public static void printFive(int n) {
        if (n % 5 == 0 && n % 2 != 0 && n % 3 != 0 && n % 4 != 0) {
            System.out.println("Divisible by 5: " + n);
        }
    }

    public static void printNumber(int n) {
        if (n % 2 != 0 && n % 3 != 0 && n % 4 != 0 && n % 5 != 0) {
            System.out.println("Number: " + n);
        }
    }
}
