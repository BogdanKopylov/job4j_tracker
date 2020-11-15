package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact test = new Fact();
        System.out.println(test.calc(-2));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число n должно быть >= 0");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
