package ru.job4j.collection;
import java.util.HashSet;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        origin = origin.toLowerCase();
        line = line.toLowerCase();
        origin = origin.replaceAll("\\p{Punct}", "");
        Set<String> originSet = new HashSet<>();
        boolean correct = true;
        for (String str : origin.split(" ")) {
            originSet.add(str);
        }

        for (String str : line.split(" ")) {
            if (!originSet.contains(str)) {
                correct = false;
                break;
            }
        }
        return correct;
    }
}
