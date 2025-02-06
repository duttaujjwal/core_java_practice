package org.example;

import java.util.HashSet;
import java.util.Set;

public class TwoSumEfficient {

    // find two numbers that can sum up to target value

    public static void main(String[] args){
        int[] a = {2,4,6,8,10,12,15};
        int target = 8;

        Set<Integer> seenNumbers = new HashSet<>();
        for (int num : a){
            int complement = target - num;
            if (seenNumbers.contains(complement)){
                System.out.println("The two numbers are : " + complement + " and " + num);
                return;
            }
            seenNumbers.add(num);
        }
        System.out.println("No match found");
    }


}
