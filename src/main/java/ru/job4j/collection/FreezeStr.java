package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : left.toCharArray()) {
            map.computeIfPresent(ch, (a, b) -> b + 1);
            map.putIfAbsent(ch, 1);
        }
        for(char ch : right.toCharArray()) {
            map.computeIfPresent(ch, (a, b) -> b - 1);
            map.putIfAbsent(ch, 1);
            if (map.get(ch) == 0) {
                map.remove(ch);
            }
        }
        return map.isEmpty();
    }
}