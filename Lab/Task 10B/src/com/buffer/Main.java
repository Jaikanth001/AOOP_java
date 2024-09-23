package com.buffer;

public class Main {
    public static void main(String[] args) {
        // Create a bounded buffer with a maximum capacity of 10 items
        BoundedBuffer buffer = new BoundedBuffer(10);

        // Create and start producer and consumer threads
        Thread producerThread = new Thread(new Producer(buffer, 20));
        Thread consumerThread = new Thread(new Consumer(buffer));

        producerThread.start();
        consumerThread.start();

        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
