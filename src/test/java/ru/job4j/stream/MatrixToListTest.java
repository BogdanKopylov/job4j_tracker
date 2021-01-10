package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class MatrixToListTest {

    @Test
    public void integerToList() {
        Integer[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        assertThat(MatrixToList.matrixToList(matrix), is(expected));
    }

    @Test
    public void stringToList() {
        String[][] matrix = {
                {"a", "b"},
                {"c", "d"},
                {"e", "f", null}
        };
        List<String> expected = Arrays.asList("a", "b", "c", "d", "e", "f", null);
        assertThat(MatrixToList.matrixToList(matrix), is(expected));
    }
}