package com.org.stream.question;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArrayQuestion {
    public static void main(String[] args) {

        divideArrayWithEvenAndOddElement();
    }
    // Given a list of integers, divide it into two arrays having an even number and other have odd number
    public static void divideArrayWithEvenAndOddElement(){
        // {1,2,3,4,5,6,7,8,9,10}
        int []arr = {1,2,3,4,5,6,7,8,9,10};
        // We can convert it into List<Integer>
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .toList();

        //Using a way to convert arrays into 2 part even and odd
        //So I'm converting it into Map key = true for even and false for odd

        Map<Boolean, List<Integer>> mapList =  list.stream()
                .collect(Collectors.groupingBy(x->x%2==0,Collectors.toList()));
                    // We can use partitioningBy as well
        Map<Boolean, List<Integer>> mapListUsingPartitioningByMethod = list.stream().collect(Collectors.partitioningBy(x->x%2==0, Collectors.toList()));
        System.out.println(mapList);
        System.out.println(mapListUsingPartitioningByMethod);
        // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}

        // Now we need only list not in map
        List<List<Integer>> listOfOddAndEven = mapList.entrySet()
                .stream()
                .map(x->x.getValue())
                .toList();

        System.out.println(listOfOddAndEven);

        List<List<Integer>> listOfOddAndEven1 = mapList.values()
                .stream()
                .toList();
    }
}
