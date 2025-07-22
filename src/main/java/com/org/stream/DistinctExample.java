package com.org.stream;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *   distinct is used to remove duplicate items from the list.
 *   We can do this with the help of set but in set order of item may not be same as list.
 *   But distinct preserve the order of items.
 * */
public class DistinctExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,2,3,4,5,4,5,6,6,7,8);
        System.out.println(
                list.stream()
                        .distinct()
                        .toList()
        );
    }
}
