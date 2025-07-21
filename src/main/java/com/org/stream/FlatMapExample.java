package com.org.stream;


import java.util.*;
import java.util.stream.Collectors;

/**
 * flatMap is an intermediate operation that transforms each element of a stream into zero or more elements of a new stream, and then concatenates those resulting streams into a single, flattened stream.
 *
 * */

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("book", "pen", "Pencil","Paper"),
                Arrays.asList("Computer", "Laptop", "Mouse", "Keyboard")
        );

        List<String> listOfItems = convertListOfListIntoSingleList(listOfList);
        System.out.println(listOfItems);


        Set<List<String>> setOfList = new HashSet<>();
        setOfList.add(Arrays.asList("Book", "Pen", "Pencil"));
        setOfList.add(Arrays.asList("Computer", "Laptop", "Mouse", "Keyboard"));

        Set<String> setOfItems = convertSetOfListIntoSingleSet(setOfList);
        System.out.println(setOfItems);


    }

    private static Set<String> convertSetOfListIntoSingleSet(Set<List<String>> setOfList) {
        return setOfList.stream()
                .flatMap(List::stream)
                .collect(Collectors.toSet());
    }

    private static List<String> convertListOfListIntoSingleList(List<List<String>> listOfList) {
//        List<String> ans  = new ArrayList<>();
//        for(List<String> list : listOfList){
//            ans.addAll(list);
//        }
//        return ans;

        return listOfList.stream()
                .flatMap(List::stream)
                .toList();
    }
}
