package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Diapason {

    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> rangeList = new ArrayList<>();
        for (int i = start; i < end; i++) {
            double dbl = func.apply((double) i);
            rangeList.add(dbl);
        }
        return rangeList;
    }
}
