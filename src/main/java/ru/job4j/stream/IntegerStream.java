package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerStream {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            integerList.add(i);
        }
        integerList = integerList.stream().filter(i -> i > 0).collect(Collectors.toList());
        System.out.println(integerList);
    }
}
