package com.genericclass;

interface MinMax<T extends Comparable<T>> {
    T findMin(T[] arr);
    T findMax(T[] arr);
}

