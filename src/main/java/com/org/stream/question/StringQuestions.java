package com.org.stream.question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StringQuestions {
    public static void main(String[] args) {

//        occurrenceOfEachWord();
//        find2ndHighest();
        findWordsWithRespectToVowel();

    }

    // Given a sentence, find the words with a specified number of vowels
    public static void findWordsWithRespectToVowel(){
        String s = "Given a sentence, find the words with a specified number of vowels";
        int vowels = 2;
        Arrays.stream(s.split(" "))
                .filter(x-> x.replaceAll("[^aeiouAEIOU]", "").length() == vowels)
                .forEach(System.out::println);

    }

    // Find the occurrence of each word
    public static void occurrenceOfEachWord(){
        String s = "word of each occurrence Find the occurrence of each word";
        Arrays.stream(s.split(" "))
                .collect(Collectors.groupingBy(
                        word -> word,
//                        word -> word.length()
                        Collectors.counting()
                ))
                .forEach((word, count)-> System.out.println(word + " " + count));
//        Map<String, Integer> map = new HashMap<>();
//        for(String word : s.split(" ")){
//            map.put(word, map.getOrDefault(word, 0)+1);
//        }
//        for(Map.Entry<String, Integer> e: map.entrySet())
//            System.out.println(e.getKey()+ " "+ e.getValue());
    }

    // Find the 2nd highest length word in a sentence
    public static void find2ndHighest(){
        String s = "Find the 2nd highest length word in a sentence";

        String string = ",";
        Arrays.stream(s.split(" "))
                        .sorted((w1, w2)-> Integer.compare(w2.length(), w1.length()))
                        .forEach(word -> System.out.print(word + " "));

        System.out.println();
        int secondHighest = Arrays.stream(s.split(" "))
                .map(String :: length)
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
