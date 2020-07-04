package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatmapStream {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2}, {3, 4, 5}};
        List<Integer> listOfInteger = helper(matrix);
        System.out.println(listOfInteger);
    }

    public static List<Integer> helper(Integer[][] matrix) {
        return Stream.of(matrix)
                .flatMap(Stream::of)
                .collect(Collectors.toList());
    }
}
