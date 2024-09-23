package com.lambdaexpression;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortStringsDescending {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("Banana");
        strings.add("cherry");
        strings.add("Date");

        // Sorting the list in descending order (case-sensitive)
        strings.sort((s1, s2) -> s2.compareTo(s1));
        System.out.println("Case-sensitive descending order:");
        System.out.println(strings);

        // Sorting the list in descending order (case-insensitive)
        strings.sort((s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println("Case-insensitive descending order:");
        System.out.println(strings);

        // Using streams to sort in descending order and collect the result
        List<String> sortedList = strings.stream()
                                         .sorted(Comparator.reverseOrder())
                                         .collect(Collectors.toList());
        System.out.println("Descending order using streams:");
        System.out.println(sortedList);

        // Using streams with a custom comparator (case-insensitive)
        List<String> sortedListIgnoreCase = strings.stream()
                                                   .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                                                   .collect(Collectors.toList());
        System.out.println("Case-insensitive descending order using streams:");
        System.out.println(sortedListIgnoreCase);
    }
}
