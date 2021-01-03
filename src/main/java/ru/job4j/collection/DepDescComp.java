package ru.job4j.collection;

import java.util.Comparator;
public class DepDescComp implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        String[] o11 = o1.split("/", 2);
        String[] o22 = o2.split("/", 2);
        int rsl = o22[0].compareTo(o11[0]);
        if (rsl == 0 && o11.length > 1 && o22.length > 1) {
            rsl = o11[1].compareTo(o22[1]);
        } else if (rsl == 0) {
            rsl = o11.length - o22.length;
        }
        return rsl;
    }
}
