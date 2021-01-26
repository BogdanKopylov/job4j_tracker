package ru.job4j.collection;

import java.util.Arrays;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftIn = 0;
        int rightIn = 0;
        for (int i = 0; i < rsl.length; i++) {
                if (rightIn == right.length) {
                    rsl[i] = left[leftIn];
                    leftIn++;
                } else if (leftIn == left.length) {
                    rsl[i] = right[rightIn];
                    rightIn++;
                } else if (left[leftIn] <= right[rightIn]) {
                    rsl[i] = left[leftIn];
                    leftIn++;
                } else {
                    rsl[i] = right[rightIn];
                    rightIn++;
                }
        }
        return rsl;
    }
}
