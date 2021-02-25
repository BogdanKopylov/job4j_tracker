package ru.job4j.collection;

import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.toLowerCase();
        line = line.toLowerCase();
        origin = origin.replaceAll("[^a-zA-Z]", "");
        Set<String> originSet = new HashSet<>();
        for (String str : origin.split(" ")) {
            originSet.add(str);
        }
        int size = originSet.size();
        for (String str : line.split(" ")) {
            originSet.add(str);
        }
        int size2 = originSet.size();
        return size == size2;
    }
}
