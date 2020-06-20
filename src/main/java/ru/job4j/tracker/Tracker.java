package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);

    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int foundIndex = 0;
        for (int i = 0 ; i < size; i++) {
            if (items[i].getName().equals(key)) {
                rsl[foundIndex++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, foundIndex);
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if(index >= 0) {
            items[index] = item;
            items[index].setId(id);
            return true;
        }
        return false;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        int start = index + 1;
        int newSize = size - index;
        System.arraycopy(items, start, items, index, newSize);
        items[size - 1] = null;
        size--;
        return true;
    }
}