package com.org.stream.question;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ArrayQuestion {
        public static void main(String[] args) {

                // divideArrayWithEvenAndOddElement();
                // arrangeInGroup();
                // arrangeInGroupUsingStream();
                // containsOnlyInteger();
                // productOfFirstTwoInteger();
                // groupOfAnagram();
                // multiplyAlternativeNumber();
                // multiplyFirstLastAndSoOn();
                // moveZeroToBeginningAtArray();
                // findDistinctValue();
                // findSumOfArrayElement();
                // squares();
                // findDistinctOddNumbers();
                // findOddNumbersOccursMoreThanOne();
                // unionOfTwoList();
                // intersectionOfTwoList();
                // kthSmallestElement();
                // calculateAverageOfNumber();
                //  generateFibonacciNumber();
                multipleArrayElement();
        }

        // Multiple array element
        public static void multipleArrayElement(){
                Integer [] arr = {1,2,3,4,5};
                Optional<Integer> multiple = Arrays.stream(arr)
                .reduce((e1,e2) -> (e1*e2));
                if(multiple.isPresent()) System.out.println(multiple.get());
        }

        // Generate the first 10 Numbers of the Fibonacci Sequence
        public static void generateFibonacciNumber(){
                // 0, 1, 1, 2, 3, 5, 8, 13
                Stream.iterate(new int[]{0,1}, function ->new int []{
                        function[1], function[0]+function[1]
                        }
                )
                .limit(10)
                .forEach(arr -> System.out.printf(Arrays.toString(arr) + " "));;

                System.out.println();
                Stream.iterate(new int[]{0,1}, f-> new int[]{f[1], f[0]+f[1]})
                .limit(10)
                .map(f-> f[0])
                .forEach(arr -> System.out.print(arr + " "));

                int a = 0, b = 1;
                // System.out.print(a + " ");
                for(int i=1;i<10;i++){
                        // if(i==9) System.out.print(b);
                        // else System.out.print(b + " ");
                        int temp = b;
                        b = a+b;
                        a = temp;
                }
                
        }

        // Calculate the average of all the numbers.
        public static void calculateAverageOfNumber(){
                List<Integer> list = Arrays.asList(1,2,3,4,56,6);
                OptionalDouble optionalDouble = list.stream()
                .mapToInt(x->x)
                .average();
                System.out.println(optionalDouble.getAsDouble());
        }

        // Find the Kth smallest element in a list of integer
        public static void kthSmallestElement(){
                List<Integer> list = Arrays.asList(1,11,4,33,567,0,6,4,3,8,9,5,2);
                int k = 1;
                int kthSmallestElement = list.stream()
                .sorted()
                .skip(k-1)
                .findFirst().get();
                System.out.println(kthSmallestElement);
        }

        //Find the intersection of two lists using Java Stream
        public static void intersectionOfTwoList(){
                List<Integer> list1 = Arrays.asList(1,2,3,4);
                List<Integer> list2 = Arrays.asList(1,7,543,2345,3,234,3);

                List<Integer> ans = list1.stream()
                .filter(list2::contains)
                .toList();
                System.out.println(ans);
        }
        // Find the union of two lists (combine both list)
        public static void unionOfTwoList(){
                List<Integer> list1 = Arrays.asList(1,2,3,4);
                List<Integer> list2 = Arrays.asList(6,7,543,2345,3,234,3);

                List<Integer> concatedList = Stream.concat(list1.stream(), list2.stream())
                .toList();
                System.out.println(concatedList);
        }

        // Find odd number that occurs more than once
        public static void findOddNumbersOccursMoreThanOne(){
                List<Integer> list = Arrays.asList(7,1,2,3,3,4,5,5,6,7);
                Map<Integer,Long> freqMap = list.stream()
                .filter(x->x%2!=0)
                .collect(Collectors.groupingBy(
                        x->x,
                        LinkedHashMap::new,
                        Collectors.counting())
                );
                System.out.println("freqMap "+ freqMap);
                
                List<Integer> duplicatesNumber = freqMap.entrySet().stream()
                .filter(e->e.getValue()>1)
                .map(Map.Entry::getKey)
                .toList();
                System.out.println(duplicatesNumber);

                int firstDuplicate = duplicatesNumber.isEmpty() ? -1: duplicatesNumber.get(0);
                System.out.println(firstDuplicate);
        }

        // Find and print the distinct odd numbers.
        public static void findDistinctOddNumbers() {
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 5, 6, 7);
                List<Integer> distinctList = list.stream()
                                .filter(x -> x % 2 != 0)
                                .distinct()
                                .toList();

                System.out.println(distinctList);
        }

        // Convert the list of integer into its square
        public static void squares() {
                int arr[] = { 1, 2, 3, 4, 5 };
                List<Integer> list = Arrays.stream(arr)
                                .boxed().map(x -> x * x).collect(Collectors.toList());
                System.out.println(list);
        }

        // Find the sum of all the elements in a list
        public static void findSumOfArrayElement() {
                List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
                int sum = list.stream().mapToInt(x -> x).sum();
                System.out.println(sum);
        }

        // Given an array of integer, return true if it contains distinct values and
        // false otherwise.
        public static void findDistinctValue() {
                int[] arr = { 5, 0, 1, 2, 8 };
                // Set<Integer> set = new HashSet<>();
                // for(int i=0;i<arr.length;i++){
                // if(set.contains(arr[i])){
                // System.out.println(false);
                // break;
                // }
                // set.add(arr[i]);
                // }
                // System.out.println(true);

                // Converting arr -> List<Integer>
                List<Integer> list = Arrays.stream(arr).boxed().toList();
                // Making Map with key value pair. Map<Integer,Long> map
                Map<Integer, Long> map = list.stream()
                                .collect(Collectors.groupingBy(x -> x, Collectors.counting()));

                // Take all values from the map
                Collection<Long> values = map.values();

                // noneMatch(take predicate) and return boolean
                boolean distinctChecker = values.stream().noneMatch(x -> x > 1);
                System.out.println(distinctChecker);

        }

        // Move all zero's to beginning of array int[]
        public static void moveZeroToBeginningAtArray() {
                int[] arr = { 5, 0, 1, 2, 0, 5, 0, 8, 0 };
                // int j =arr.length-1;
                // for(int i=arr.length-1;i>=0;i--){
                // if(arr[i]!=0) arr[j--] = arr[i];
                // }
                // while(j>=0){
                // arr[j--] = 0;
                // }
                // System.out.println(Arrays.toString(arr));

                /**
                 * First approach
                 * First create a zeors list
                 * Second create a nonZeros list
                 * zeros list + nonZeros list
                 */
                List<Integer> list = Arrays.stream(arr)
                                .boxed()
                                .toList();
                // zeros list
                List<Integer> zeros = list.stream()
                                .filter(x -> x == 0)
                                .toList();
                // non zeros list
                List<Integer> nonZeros = list.stream()
                                .filter(x -> x != 0)
                                .toList();

                List<Integer> finaList = new ArrayList<>();
                // finaList.addAll(zeros);
                // finaList.addAll(nonZeros);
                // System.out.println(finaList);

                Map<Boolean, List<Integer>> partitioned = list.stream()
                                .collect(Collectors.partitioningBy(x -> x != 0));
                System.out.println(partitioned);
                finaList.addAll(partitioned.get(false));
                finaList.addAll(partitioned.get(true));
                System.out.println(finaList);
        }

        // Multiply 1st and last element, 2nd and 2nd last element, 3rd and 3rd last
        // element and so on in an array.
        public static void multiplyFirstLastAndSoOn() {
                int arr[] = { 3, 2, 4, 5, 9, 4, 5, 6 };
                // int i=0,j= arr.length-1, ans = 0;
                // while (i<=j) {
                // System.out.println(arr[i]*arr[j]);
                // i++;j--;
                // }
                IntStream.range(0, arr.length / 2)
                                .map(x -> arr[x] * arr[arr.length - x - 1])
                                .forEach(System.out::println);
        }

        // Multiply alternative numbers in an array.
        public static void multiplyAlternativeNumber() {
                int[] arr = { 4, 5, 3, 2, 3, 5, 6 };
                int ans = IntStream.range(0, arr.length)
                                .filter(x -> x % 2 == 0)
                                .map(x -> arr[x])
                                .reduce(1, (a, b) -> a * b);

                System.out.println(ans);
        }

        // Group of anagram
        public static void groupOfAnagram() {
                String[] arr = { "act", "god", "cat", "dog", "tac" };
                /*
                 * if we sort two strings which are anagrams of each other, then the sorted
                 * strings will always be the same. So, we can maintain a hash map with the
                 * sorted strings as keys and the index of the anagram group in the result array
                 * as the value.
                 * Time Complexity: O(n * k * log(k)), where n is the number of words and k is
                 * the maximum length of a word.
                 * Auxiliary Space: O(n * k), to store the result.
                 */
                List<List<String>> ans = new ArrayList<>();
                Map<String, Integer> map = new HashMap<>();
                for (int i = 0; i < arr.length; i++) {
                        String s = arr[i];
                        char[] charArr = s.toCharArray();
                        Arrays.sort(charArr);
                        s = new String(charArr);

                        if (!map.containsKey(s)) {
                                map.put(s, ans.size());
                                ans.add(new ArrayList<>());
                        }
                        ans.get(map.get(s)).add(arr[i]);
                }
                System.out.println(ans);

                // Group Anagram with the help of Stream

                List<List<String>> list = Arrays.stream(arr)
                                .collect(Collectors.groupingBy(s -> {
                                        char[] chars = s.toCharArray();
                                        Arrays.sort(chars);
                                        return new String(chars);
                                }))
                                .values()
                                .stream()
                                .toList();
                System.out.println("Group of anagram using Stream " + list);
        }

        // Given a list of integer find the product of first two integer
        public static void productOfFirstTwoInteger() {
                int[] arr = { 11, 22, 3, 4, 5 };
                int product = Arrays.stream(arr)
                                .limit(2)
                                .reduce(1, (a, b) -> a * b);
                System.out.println(product);
        }

        // Given a list of strings, create a list that contains only integer
        public static void containsOnlyInteger() {
                String[] s = { "abc", "123", "23", "axv", "433", "abx" };
                List<Integer> list = Arrays.stream(s)
                                .filter(str -> str.matches("[0-9]+"))
                                .map(Integer::valueOf)
                                .toList();
                System.out.println("list of integer " + list);// list of integer [123, 23, 433]
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
                System.out.println("Map :: " + map);// Map :: {0=[2, 2, 3, 4], 20=[20, 22, 25], 10=[14, 14, 17, 10, 11],
                                                    // 30=[32]}

                HashMap<Integer, List<Integer>> hashMap = Arrays.stream(arr).boxed()
                                .collect(Collectors.groupingBy(
                                                val -> (val / 10) * 10,
                                                HashMap::new,
                                                Collectors.toList()));
                System.out.println("hash map = " + hashMap); // hash map = {0=[2, 2, 3, 4], 20=[20, 22, 25], 10=[14, 14,
                                                             // 17, 10,
                                                             // 11], 30=[32]}

                TreeMap<Integer, List<Integer>> treeMap = Arrays.stream(arr)
                                .boxed()
                                .collect(Collectors.groupingBy(
                                                val -> (val / 10) * 10,
                                                TreeMap::new,
                                                Collectors.toList()));

                System.out.println("tree map = " + treeMap); // tree map = {0=[2, 2, 3, 4], 10=[14, 14, 17, 10, 11],
                                                             // 20=[20, 22,
                                                             // 25], 30=[32]}

                LinkedHashMap<Integer, Set<Integer>> linkedHashMap = Arrays.stream(arr).boxed()
                                .collect(Collectors.groupingBy(
                                                val -> (val / 10) * 10,
                                                LinkedHashMap::new,
                                                Collectors.toSet()));
                System.out.println("linked hash map = " + linkedHashMap);// linked hash map = {0=[2, 3, 4], 10=[17, 10,
                                                                         // 11, 14],
                                                                         // 20=[20, 22, 25], 30=[32]}
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
