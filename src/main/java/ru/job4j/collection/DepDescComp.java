package ru.job4j.collection;

import java.util.Comparator;
public class DepDescComp implements Comparator<String>{
    @Override
    public int compare(String o1, String o2) {
        String[] o11 = o1.split("/");
        String[] o22 = o2.split("/");
        int rsl = o22[0].compareTo(o11[0]);
        if (rsl == 0) {
            rsl = o1.compareTo(o2);
        }
        return rsl;
    }
}
