package com.org.stream.question;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class StreamMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("null", "Anuj", "Rahul", "Kaju","Suraj");
        
        List<List<String>> listOfList = Arrays.asList(
            Arrays.asList("Kumar","Mishra"),
            Arrays.asList("Pihu","Pujara","Pratik"),
            Arrays.asList("Kajal", "Kaju","Komal","Kumari")
        );
        // 1. stream() - converts a collection into a stream
        Stream<String> stream = names.stream();

        // 2. filter() - filters based on a predicate
        List<String> filteredNameStartWithA = names.stream()
        .filter(name->name.startsWith("A")).toList();
        System.out.println(filteredNameStartWithA);

        // 3. map() - transforms each element into another form
        List<Integer> sizeOfEachName = names.stream()
        .map(name -> name.length())
        .toList();
        System.out.println(sizeOfEachName);

        // 4. flatMap() - flattens nested structure into a single stream
        //flatMap() is for when one element produces a stream of multiple elements.So instead of ending up with a stream of streams, flatMap() “flattens” them into a single stream.
        List<String> flatMapList = listOfList.stream()
        .flatMap(List::stream)
        .toList();
        System.out.println(listOfList);
    }
}
