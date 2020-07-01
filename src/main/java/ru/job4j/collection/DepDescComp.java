package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String e1 = o1.split("/")[0];
        String e2 = o2.split("/")[0];
        if (e1.equals(e2)) {
            return o1.compareTo(o2);
        } else {
            return e2.compareTo(e1);
        }
    }
}