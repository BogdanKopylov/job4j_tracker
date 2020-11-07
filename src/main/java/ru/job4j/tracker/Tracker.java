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

    public Item[] findAll() {
        Item[] withoutNull = new Item[items.length];
        int index = 0;
        for (Item item : items) {
            if (item != null) {
                withoutNull[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(withoutNull, index);
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }

    public Item[] findByName(String key) {
        Item[] equalsKey = new Item[items.length];
        int index = 0;
        for (Item item : items) {
            if (item != null && key.equals(item.getName())) {
                equalsKey[index] = item;
                index++;
            }
        }
        return Arrays.copyOf(equalsKey, index);
    }
}