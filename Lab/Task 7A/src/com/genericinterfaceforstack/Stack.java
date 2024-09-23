package com.genericinterfaceforstack;

interface Stack<T> {
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
}

