package ru.job4j.tracker;

import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Item firstItem = new Item();
        Item secondItem = new Item();
        Item thirdItem = new Item();
        firstItem.setId(1);
        firstItem.setName("first");
        secondItem.setId(2);
        secondItem.setName("second");
        thirdItem.setId(3);
        thirdItem.setName("third");
        Tracker tracker = new Tracker();
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        System.out.println(tracker.findById(2).getName());
        System.out.println(tracker.findByName("second"));
    }
}
