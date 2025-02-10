package org.example;


import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayIndexFinder {

    // find out the array index positions for the elements which are
    // perfect subset of any other element in the array
    static int[][] arr = {{1,2,3}, {2,3}, {4,6}, {6}};

    public static void main(String[] args) {
        // Convert each array into a Set<Integer>
        List<Set<Integer>> listOfSets = Arrays.stream(arr)
                .map(set -> Arrays.stream(set).boxed().collect(Collectors.toSet()))
                .toList();
        // Find indices where one set is a subset of another
        List<Integer> subsetIndices = IntStream.range(0, listOfSets.size())
                .filter(i -> IntStream.range(0, listOfSets.size())
                        .anyMatch(j -> i != j && listOfSets.get(j).containsAll(listOfSets.get(i))))
                .boxed()
                .toList();

        System.out.println("Subset Indices: " + subsetIndices);
    }
}
