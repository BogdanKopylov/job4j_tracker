package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list;

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (int i : this.list) {
            list.add(fun.apply(i));
        }
        this.list = list;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (int i : this.list) {
            if(fun.test(i)) {
                list.add(i);
            }
        }
        this.list = list;
        return this;
    }

    public List<Integer> collect() {
        return this.list;
    }
}