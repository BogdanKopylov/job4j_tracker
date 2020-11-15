package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessThen0() {
        Fact test = new Fact();
        test.calc(-2);
    }

    @Test
    public void whenNGreaterThen0() {
        Fact test = new Fact();
        int sum = test.calc(0);
        assertThat(sum, is(1));
    }
}