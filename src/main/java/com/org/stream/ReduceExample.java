package com.org.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        Optional<Integer> result = numbers.stream()
                .reduce((a,b) -> a * b);

        System.out.println(result.get());

    }
}
