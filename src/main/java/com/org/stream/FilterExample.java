package com.org.stream;

import java.util.Arrays;
import java.util.List;

public class FilterExample {
    /**
     *      filter is an intermediate function that that filter the collection based on Predicate (Given boolean condition).
     *      And the result of the filter is same number of element that are present in stream or lesser
     * */
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,11,12);

//        List<Integer> filteredElement = filterElementIsGreaterThan5(list);
//        System.out.println(filteredElement);

        List<Integer> findEvenFromList = findEvenNumber(list);
        System.out.println(findEvenFromList);



    }

    /*
     *  Fetch all numbers from a list that are greater than 5;
     *  list -> 1,2,3,4,5,6,7,8,9,11,12
     * */

    private static List<Integer> filterElementIsGreaterThan5(List<Integer> list) {
        List<Integer> ans =  list.stream()
                .filter(n -> n>5)
                .toList();
        return ans;
    }

    private static List<Integer> findEvenNumber(List<Integer> list){
        return list.stream()
                .filter(n -> n%2==0)
                .toList();
    }

}
