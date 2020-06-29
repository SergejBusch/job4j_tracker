package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> persons = new HashMap<>();
        persons.put("a@a.com", "Fedor Mihaylowich Gwosdenuk");
        for (String key : persons.keySet()) {
            String value = persons.get(key);
            System.out.println(key + " " + value);
        }
    }
}
