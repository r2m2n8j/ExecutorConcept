package com.org.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortedExample {
    public static void main(String[] args) {
        List<Integer> number = Arrays.asList(2,1,23,4,4,5,677,53,2,43,32,21,12,2,455,6,77,88,88);
        System.out.println(sortInNaturalSortingOrder(number));

        System.out.println(sortInReverseSortingOrder(number));

//        System.out.println(operationOnComparator(number));
    }

//    private static long operationOnComparator(List<Integer> number) {
//        return number.stream()
//                .sorted(Comparator.comparing(integer -> integer));
//
//    }

    private static List<Integer> sortInReverseSortingOrder(List<Integer> number) {
        return number.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    private static List<Integer> sortInNaturalSortingOrder(List<Integer> number) {
        return number.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
