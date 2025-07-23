package com.org.stream.question;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MaxLengthOfString {
    public static void main(String[] args) {
        String s = "I am learning Stream API In Java";
//        findMaxLengthOfAWord(s);
        System.out.println(removeDuplicatesFromStringAndReturnInSameOrder("dabcadefg"));

        System.out.println(findStringOfNthHighest(s));

    }

    private static String findStringOfNthHighest(String s) {

        return null;
    }

    // Remove duplicates from the String and return in the same order.
    private static String removeDuplicatesFromStringAndReturnInSameOrder(String s) {
        Stream<String> stringStream =  Arrays.stream(s.split(""))
                        .distinct();
        String result  = stringStream.collect(Collectors.joining());
        return result;
//      Arrays.stream(s.split(""))
//                        .distinct().forEach(System.out::print);


//        System.out.println(" Another way");
//        s.chars()
//                 .distinct()
//                 .mapToObj(c ->(char) c)
//                 .forEach(System.out::print);
////         return "";
//        System.out.println();


//        StringBuilder sb = new StringBuilder();
//         boolean [] arr = new boolean[256];
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             if(!arr[ch]){
//                 arr[ch] = true;
//                 sb.append(ch);
//             }
//         }
//         return new String(sb);
    }



    // Given a sentence, find the word that has the highest length
    /**
     * String s = "I am learning";
     * In the below findMaxLengthOfWord() methods
     * first we convert String to Stream<String> with the help of Arrays.stream
     * After that we are using max() method
     * max() used Comparator.comparingInt(String :: length) it's return Optional<String> whose length is greater
     * at last I'm using orElse("") if no string is present it return empty not error.
     *
     * */
    private static void findMaxLengthOfAWord(String s) {
        int maxLength = 0;
        String ans = "";

        ans = Arrays.stream(s.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");

//        String [] words = s.split(" ");
//
//        for(String word: words){
//            if(ans.length() < word.length()) {
//                ans = word;
//                maxLength = word.length();
//            }
//        }
        System.out.println(ans + " :: " + maxLength);


    }

    public  static void deepDivefindMaxLengthOfWord(String s){

        int maxLength = 0;
        String ans = "";

        maxLength = Arrays.stream(s.split(" "))
                .mapToInt(String :: length)
                .max()
                .orElse(0);

//        Stream<String> streamString= Arrays.stream(s.split(" "));
//        Optional<String> maxLengthString = streamString
//                .max(Comparator.comparing(String :: length));
//        if(maxLengthString.isPresent()) ans = maxLengthString.get();

        System.out.println(ans + " :: " + maxLength);

        IntStream integerIntStream = Arrays.stream(s.split(" "))
                .mapToInt(String :: length);
        System.out.println(Arrays.toString(integerIntStream.toArray()));
    }

}
