package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class StreamAPI {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(0, 2, -5, 7, -33, 8, 901, -4));
        List<Integer> positive = list.stream().
                                filter(x -> x > 0).
                                collect(Collectors.toList());
    }
}
