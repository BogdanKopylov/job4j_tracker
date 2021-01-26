package ru.job4j.collection;

public class Merge {
    public static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int leftIn = 0;
        int rightIn = 0;
        for (int i = 0; i < rsl.length; i++) {
            while (leftIn < left.length || rightIn < right.length) {
                if (rightIn == right.length) {
                    rsl[i] = left[leftIn];
                    leftIn++;
                    break;
                } else if (leftIn == left.length) {
                    rsl[i] = right[rightIn];
                    rightIn++;
                    break;
                } else if (left[leftIn] <= right[rightIn]) {
                    rsl[i] = left[leftIn];
                    leftIn++;
                    break;
                } else if (left[leftIn] > right[rightIn]) {
                    rsl[i] = right[rightIn];
                    rightIn++;
                    break;
                }
            }
        }
        return rsl;
    }
}
