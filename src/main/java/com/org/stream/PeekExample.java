package com.org.stream;

import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,122,1,23,1,2,334,5,112,2,3,11,2,3,3,4,4,86,45,90);

        System.out.println(
                list.stream()
                        .peek( num -> {
                            System.out.print(num + ", ");
                        })
                        .sorted().toList()
        );
    }
}
