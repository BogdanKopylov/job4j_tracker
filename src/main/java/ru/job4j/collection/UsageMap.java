package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("fio@google.com", "fio");
        for (String key : map.keySet()) {
            String fio = map.get(key);
            System.out.println(key + " = " + fio);
        }
    }
}
