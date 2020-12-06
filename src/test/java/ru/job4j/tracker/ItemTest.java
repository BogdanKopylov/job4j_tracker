package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void lowToHigh() {
        List<Item> list = Arrays.asList(
                new Item("Third"),
                new Item("First"),
                new Item("Second")
        );
        list.sort(new ItemLowToHigh());
        assertThat(list.get(0).getName(), is("First"));

    }

    @Test
    public void highToLow() {
        List<Item> list = Arrays.asList(
                new Item("Third"),
                new Item("First"),
                new Item("Second")
        );
        list.sort(new ItemHighToLow());
        assertThat(list.get(2).getName(), is("First"));

    }

}