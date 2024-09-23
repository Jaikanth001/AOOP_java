package com.genericclass;

class ArrayOperations<T extends Comparable<T>> implements MinMax<T> {

    @Override
    public T findMin(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        T min = arr[0];
        for (T element : arr) {
            if (element.compareTo(min) < 0) {
                min = element;
            }
        }
        return min;
    }

    @Override
    public T findMax(T[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        T max = arr[0];
        for (T element : arr) {
            if (element.compareTo(max) > 0) {
                max = element;
            }
        }
        return max;
    }
}

