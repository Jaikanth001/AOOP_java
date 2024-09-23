package com.genericpriorityqueue;

import java.util.Comparator;

public class TestPriorityQueue {
    public static void main(String[] args) {
        // Test with Integer
        PriorityQueue<Integer> intQueue = new PriorityQueue<>(Comparator.naturalOrder());
        intQueue.enqueue(5);
        intQueue.enqueue(1);
        intQueue.enqueue(3);
        System.out.println("Integer Priority Queue:");
        while (!intQueue.isEmpty()) {
            System.out.println(intQueue.dequeue());
        }

        // Test with Double
        PriorityQueue<Double> doubleQueue = new PriorityQueue<>(Comparator.naturalOrder());
        doubleQueue.enqueue(5.5);
        doubleQueue.enqueue(1.1);
        doubleQueue.enqueue(3.3);
        System.out.println("Double Priority Queue:");
        while (!doubleQueue.isEmpty()) {
            System.out.println(doubleQueue.dequeue());
        }

        // Test with String
        PriorityQueue<String> stringQueue = new PriorityQueue<>(Comparator.naturalOrder());
        stringQueue.enqueue("apple");
        stringQueue.enqueue("banana");
        stringQueue.enqueue("cherry");
        System.out.println("String Priority Queue:");
        while (!stringQueue.isEmpty()) {
            System.out.println(stringQueue.dequeue());
        }
    }
}

