package com.org.stream.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayQuestion {
    public static void main(String[] args) {

        // divideArrayWithEvenAndOddElement();
        // arrangeInGroup();
        // arrangeInGroupUsingStream();
        containsOnlyInteger();

    }

    //Given a list of integer find the product of first two integer
    public static void productOfFirstTwoInteger(){
        int [] arr = {11,22,3,4,5};
        IntStream list = Arrays.stream(arr).limit(2);
        
    }
    // Given a list of strings, ceate a list that contains only integer
    public static void containsOnlyInteger() {
        String[] s = { "abc", "123", "23", "axv", "433", "abx" };
        List<Integer> list = Arrays.stream(s)
                .filter(str -> str.matches("[0-9]+"))
                .map(Integer::valueOf)
                .toList();
        System.out.println("list of integer "+ list);//list of integer [123, 23, 433]
    }

    // Given an array of integers, group the number by range in which they belong
    /*
     * I/P : int []arr = {2,3,10,14,20,22}
     * O/P : {0=[2,3], 10=[10,14], 20=[20,22]}
     * 0 - All numbers thats are between 0 To 9 comes in this group
     * 10 - All numbers that's are b/w 10 To 19 comes in this group
     */

    public static void arrangeInGroupUsingStream() {
        int[] arr = { 2, 2, 14, 3, 4, 14, 17, 10, 20, 22, 32, 11, 25 };

        Map<Integer, List<Integer>> map = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(
                        val -> (val / 10) * 10,
                        Collectors.toList()));
        System.out.println("Map :: " + map);// Map :: {0=[2, 2, 3, 4], 20=[20, 22, 25], 10=[14, 14, 17, 10, 11], 30=[32]}

        HashMap<Integer, List<Integer>> hashMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(
                        val -> (val / 10) * 10,
                        HashMap::new,
                        Collectors.toList()));
        System.out.println("hash map = " + hashMap); // hash map = {0=[2, 2, 3, 4], 20=[20, 22, 25], 10=[14, 14, 17, 10, 11], 30=[32]}

        TreeMap<Integer, List<Integer>> treeMap = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(
                        val -> (val / 10) * 10,
                        TreeMap::new,
                        Collectors.toList()));

        System.out.println("tree map = " + treeMap); // tree map = {0=[2, 2, 3, 4], 10=[14, 14, 17, 10, 11], 20=[20, 22, 25], 30=[32]}

        LinkedHashMap<Integer, Set<Integer>> linkedHashMap = Arrays.stream(arr).boxed()
                .collect(Collectors.groupingBy(
                        val -> (val / 10) * 10,
                        LinkedHashMap::new,
                        Collectors.toSet()));
        System.out.println("linked hash map = " + linkedHashMap);// linked hash map = {0=[2, 3, 4], 10=[17, 10, 11, 14], 20=[20, 22, 25], 30=[32]}
    }

    public static void arrangeInGroup() {
        int[] arr = { 2, 3, 4, 14, 17, 10, 20, 22, 32 };
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int val : arr) {
            int key = (val / 10) * 10;
            // if (map.containsKey(key)) {
            // List<Integer> list = map.get(key);
            // list.add(val);
            // map.put(key, list);
            // } else {
            // List<Integer> list = new ArrayList<>();
            // list.add(val);
            // map.put(key, list);
            // }
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(val);
        }
        System.out.println(map);
    }

    // Given a list of integers, divide it into two arrays having an even number and
    // other have odd number
    public static void divideArrayWithEvenAndOddElement() {
        // {1,2,3,4,5,6,7,8,9,10}
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        // We can convert it into List<Integer>
        List<Integer> list = Arrays.stream(arr)
                .boxed()
                .toList();

        // Using a way to convert arrays into 2 part even and odd
        // So I'm converting it into Map key = true for even and false for odd

        Map<Boolean, List<Integer>> mapList = list.stream()
                .collect(Collectors.groupingBy(x -> x % 2 == 0, Collectors.toList()));
        // We can use partitioningBy as well
        Map<Boolean, List<Integer>> mapListUsingPartitioningByMethod = list.stream()
                .collect(Collectors.partitioningBy(x -> x % 2 == 0, Collectors.toList()));
        System.out.println(mapList);
        System.out.println(mapListUsingPartitioningByMethod);
        // {false=[1, 3, 5, 7, 9], true=[2, 4, 6, 8, 10]}

        // Now we need only list not in map
        List<List<Integer>> listOfOddAndEven = mapList.entrySet()
                .stream()
                .map(x -> x.getValue())
                .toList();

        System.out.println(listOfOddAndEven);

        List<List<Integer>> listOfOddAndEven1 = mapList.values()
                .stream()
                .toList();
    }
}
