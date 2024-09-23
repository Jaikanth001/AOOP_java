package com.genericpriorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueue<T> {
    private ArrayList<T> heap;
    private Comparator<? super T> comparator;

    public PriorityQueue(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.comparator = comparator;
    }

    public void enqueue(T item) {
        heap.add(item);
        heapifyUp(heap.size() - 1);
    }

    public T dequeue() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        T result = heap.get(0);
        T lastItem = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, lastItem);
            heapifyDown(0);
        }
        return result;
    }

    public T peek() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    private void heapifyUp(int index) {
        T item = heap.get(index);
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parent = heap.get(parentIndex);
            if (comparator.compare(item, parent) >= 0) {
                break;
            }
            heap.set(index, parent);
            index = parentIndex;
        }
        heap.set(index, item);
    }

    private void heapifyDown(int index) {
        int size = heap.size();
        T item = heap.get(index);

        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestChildIndex = index;

            if (leftChildIndex < size && comparator.compare(heap.get(leftChildIndex), item) < 0) {
                smallestChildIndex = leftChildIndex;
            }

            if (rightChildIndex < size && comparator.compare(heap.get(rightChildIndex), heap.get(smallestChildIndex)) < 0) {
                smallestChildIndex = rightChildIndex;
            }

            if (smallestChildIndex == index) {
                break;
            }

            heap.set(index, heap.get(smallestChildIndex));
            index = smallestChildIndex;
        }
        heap.set(index, item);
    }
}
