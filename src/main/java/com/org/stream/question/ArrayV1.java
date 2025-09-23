package com.org.stream.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArrayV1 {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10};
        Map<Boolean, List<Integer>> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(x->x%2==0, Collectors.toList()));
        System.out.println(map);

//        System.out.println(map.entrySet().stream().toList());
        int size = -1;
        map.forEach((key, value)->{
            System.out.println(key +" "+ value);
        });

        List<List<Integer>> mapList = map.entrySet().stream()
                .map(Map.Entry::getValue)
                .toList();
//        System.out.println(mapList);

        List<List<Integer>> mapWithValue = map.entrySet().stream()
                .map(x -> x.getValue())
                .toList();
//        System.out.println(mapWithValue);

        List<List<Integer>> mapValueMethod = map.values().stream().toList();
//        System.out.println(mapValueMethod);
    }
}
