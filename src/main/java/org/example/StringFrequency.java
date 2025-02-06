package org.example;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

public class StringFrequency {

    public static void main(String[] args){
        String str = "aaabccccddddddddffffeeeeee";
        calculateStringFrequency(str);
    }

    private static void calculateStringFrequency(String str) {
        String output = str.chars().mapToObj(c -> (char) c + "")
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new,Collectors.counting()))
                .entrySet().stream().map(entry -> {
                    if (entry.getValue() == 1L)
                        return entry.getKey();
                    else
                        return entry.getKey() + entry.getValue();
                }).collect(Collectors.joining());
        System.out.println(output);
    }
}
