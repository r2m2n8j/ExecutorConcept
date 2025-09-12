package com.org.stream.question;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringQuestions {
    public static void main(String[] args) {

        // occurrenceOfEachWord();
        // find2ndHighest();
        // findWordsWithRespectToVowel();
        // findFirstRepeatedCharacterWithStream();
        // findFirstNonRepeatedCharacterWithStream();
        // arrangeListOfStringInAscendingOrder();
        // arrangeListOfStringInAscendingOrderWithAlphabeticalOrder();
        // groupStringBasedOnMiddleCharacter();
        // sortListOfStringInAlphabeticalOrder();
        stringLength();
    
    }

    // convert a list of string a list of the length of the string
    public static void stringLength(){
        List<String> list = Arrays.asList("null","Ram","Rom","test");
        List<Integer> lengthOfList = list.stream().map(x-> x.length()).toList();
        System.out.println(lengthOfList);
    }

    // Sort a list of Strings in alphabetical order
    public static void sortListOfStringInAlphabeticalOrder(){
        List<String> str = Arrays.asList("Zudio","Puma", "Addidas", "MAC","H&M");
        List<String> sortedString = str.stream().sorted().toList();
        System.out.println(sortedString);
    }

    // given the string[] group the strings based on the middle character.
    public static void groupStringBasedOnMiddleCharacter(){
        // output {w = [ewe,kwk], h = [jhj, aha], j = [jji]}
        String [] str = {"ewewwwer", "jjrie", "jhjrre", "kwk", "aha"};
        Map<String, List<String>> map = Arrays.stream(str)
        .collect(Collectors.groupingBy(x -> x.substring(x.length()/2,x.length()/2+1)));

        System.out.println(map);
    }


    // List of String arrange the string into ascending order according to it's
    // length. If two of String has equal length arrange it with their alphabetically
    // order
    public static void arrangeListOfStringInAscendingOrderWithAlphabeticalOrder(){
        List<String> list = Arrays.asList("apple", "a", "kiwi", "fog", "frog","banana", "fig", "pineapple");
        List<String> sortedString = list.stream()
                .sorted(
                    Comparator.comparingInt((String s)-> s.length())
                    .thenComparing(Comparator.naturalOrder())
                )
                .toList();
                System.out.println(sortedString);
    }

    public static void arrangeListOfStringInAscendingOrder() {
        List<String> list = Arrays.asList("apple", "a", "kiwi", "banana", "fig", "pineapple");
        List<String> sortedString = list.stream()
                .sorted(Comparator.comparingInt(s -> s.length()))
                .toList();
        System.out.println(sortedString);
    }

    // Given a String, find the first non-repeated character
    public static void findFirstNonRepeatedCharacterWithStream() {
        String s = "Hello World He";
        /** O(n) */
        Optional<Character> findFirst = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> ch, // key = character
                        LinkedHashMap::new, // preserve order
                        Collectors.counting() // count occurrences
                ))
                .entrySet()
                .stream()
                .filter(e -> {
                    if (e.getKey() != ' ')
                        return e.getValue() == 1;
                    return false;
                }) // keep only repeated ones
                .map(Map.Entry::getKey) // get the character
                .findFirst(); // first in original order

        if (findFirst.isPresent())
            System.out.println("First non repeated char :: " + findFirst.get());

        /** O(n^2) */
        // Optional<Character> findNonRepeated = s.chars()
        // .mapToObj(c -> {
        // return (char)c;
        // })
        // .filter(ch -> {
        // List<Character> list = s.chars()
        // .mapToObj(c -> (char) c)
        // .toList();
        // int freq = 0;
        // if(ch!=' ')
        // freq = Collections.frequency(list, ch);

        // return freq==1;
        // })
        // .findFirst();
        // if(findNonRepeated.isPresent()){
        // System.out.println("First Non Repeated Character :: "+
        // findNonRepeated.get());
        // }
    }

    // Given a String, find the first repeated character
    public static void findFirstRepeatedCharacterWithStream() {
        String s = "Hello World";
        /** O(n) */
        Optional<Character> findFirst = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        ch -> ch, // key = character
                        LinkedHashMap::new, // preserve order
                        Collectors.counting() // count occurrences
                ))
                .entrySet()
                .stream()
                .filter(e -> e.getValue() > 1) // keep only repeated ones
                .map(Map.Entry::getKey) // get the character
                .findFirst(); // first in original order

        if (findFirst.isPresent())
            System.out.println("First non repeated char :: " + findFirst.get());

        /** O(n^2) */
        // Optional<Character> firstRepeated = s.chars() // IntStream of character codes
        // [72, 101, 108, 108, 111, 32, 87, 111, 114, 108, 100]
        // .mapToObj(c -> (char) c) // Convert to Character ['H', 'e', 'l', 'l', 'o', '
        // ', 'W', 'o', 'r', 'l', 'd']
        // .filter(ch ->{
        // List<Character> list = s.chars()
        // .mapToObj(c -> (char)c)
        // .toList();
        // // System.out.println(list); ['H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r',
        // 'l', 'd']
        // int freq = Collections.frequency(list, ch);
        // return freq > 1;
        // } ) // Keep only repeated characters
        // .findFirst(); // Get first one

        // if (firstRepeated.isPresent()) {
        // System.out.println("First Repeated Character :: " + firstRepeated.get());
        // } else {
        // System.out.println("All characters are unique");
        // }
    }

    public static void findFirstRepeatedCharacter() {
        String s = "Hello World";
        int arr[] = new int[256];
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i)] > 1) {
                System.out.println("First Repeated Character :: " + s.charAt(i));
                flag = true;
                break;
            }
        }
        if (!flag)
            System.out.println("All characters are unique");

    }

    // Given a sentence, find the words with a specified number of vowels
    public static void findWordsWithRespectToVowel() {
        String s = "Given a sentence, find the words with a specified number of vowels";
        int vowels = 2;
        Arrays.stream(s.split(" "))
                .filter(x -> x.replaceAll("[^aeiouAEIOU]", "").length() == vowels)
                .forEach(System.out::println);

    }

    // Find the occurrence of each word
    public static void occurrenceOfEachWord() {
        String s = "word of each occurrence Find the occurrence of each word";
        Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word,
                        // word -> word.length()
                        Collectors.counting()))
                .forEach((word, count) -> System.out.println(word + " " + count));
        // Map<String, Integer> map = new HashMap<>();
        // for(String word : s.split(" ")){
        // map.put(word, map.getOrDefault(word, 0)+1);
        // }
        // for(Map.Entry<String, Integer> e: map.entrySet())
        // System.out.println(e.getKey()+ " "+ e.getValue());
    }

    // Find the 2nd highest length word in a sentence
    public static void find2ndHighest() {
        String s = "Find the 2nd highest length word in a sentence";

        String string = ",";
        Arrays.stream(s.split(" "))
                .sorted((w1, w2) -> Integer.compare(w2.length(), w1.length()))
                .forEach(word -> System.out.print(word + " "));

        System.out.println();
        int secondHighest = Arrays.stream(s.split(" "))
                .map(String::length)
                .sorted(Comparator.reverseOrder())
                .skip(0)
                .findFirst()
                .get();

        System.out.println(secondHighest);
        String secondHighestString = Arrays.stream(s.split(" "))
                .sorted(Comparator.reverseOrder())
                .skip(0)
                .findFirst()
                .get();

        System.out.println(secondHighestString);
    }

}
