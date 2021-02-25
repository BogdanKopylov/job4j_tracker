package ru.job4j.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : left.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.computeIfPresent(ch, (a, b) -> b + 1);
        }
        for(char ch : right.toCharArray()) {
            map.putIfAbsent(ch, 0);
            map.computeIfPresent(ch, (a, b) -> b - 1);
        }
        return map.values().stream().allMatch(i -> i == 0);
    }
}
