package com.org.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("anuj", "kumar","mishra");
        System.out.println(
                list.stream()
                        .collect(Collectors.joining(", ", "[","]"))
        );
    }
}
