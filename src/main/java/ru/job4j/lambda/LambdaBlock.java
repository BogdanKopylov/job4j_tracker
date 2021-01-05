package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaBlock {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("1", "22", "333", "4444"));
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + left.length() + " : " + right.length());
            return right.length() - left.length();
        };
        list.sort(cmpDescSize);
    }
}
