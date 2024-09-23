package com.genericclass;

public class Main {
    public static void main(String[] args) {
        // Integer Array
        Integer[] intArr = {3, 5, 7, 2, 8};
        ArrayOperations<Integer> intOps = new ArrayOperations<>();
        System.out.println("Integer Array - Min: " + intOps.findMin(intArr) + ", Max: " + intOps.findMax(intArr));

        // Float Array
        Float[] floatArr = {3.5f, 7.2f, 1.9f, 8.4f};
        ArrayOperations<Float> floatOps = new ArrayOperations<>();
        System.out.println("Float Array - Min: " + floatOps.findMin(floatArr) + ", Max: " + floatOps.findMax(floatArr));

        // String Array
        String[] strArr = {"apple", "orange", "banana", "pear"};
        ArrayOperations<String> strOps = new ArrayOperations<>();
        System.out.println("String Array - Min: " + strOps.findMin(strArr) + ", Max: " + strOps.findMax(strArr));

        // Character Array
        Character[] charArr = {'a', 'd', 'b', 'z', 'e'};
        ArrayOperations<Character> charOps = new ArrayOperations<>();
        System.out.println("Character Array - Min: " + charOps.findMin(charArr) + ", Max: " + charOps.findMax(charArr));
    }
}
