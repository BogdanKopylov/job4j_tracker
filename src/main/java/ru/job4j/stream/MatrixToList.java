package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MatrixToList {
    public static void main(String[] args) {
        Integer[][] array = {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                                };
        List<Integer> list = Arrays.stream(array)
                            .flatMap(Arrays::stream)
                            .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}
