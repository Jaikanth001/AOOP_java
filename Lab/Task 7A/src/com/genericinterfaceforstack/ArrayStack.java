package com.genericinterfaceforstack;

import java.util.Arrays;

class ArrayStack<T> implements Stack<T> {
    private T[] array;
    private int top;

    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity) {
        array = (T[]) new Object[capacity];
        top = -1;
    }

    @Override
    public void push(T element) {
        if (top == array.length - 1) {
            resize();
        }
        array[++top] = element;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top--];
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return array[top];
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        array = Arrays.copyOf(array, array.length * 2);
    }
}
