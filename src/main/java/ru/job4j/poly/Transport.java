package ru.job4j.poly;

public interface Transport {
    void go();

    void addPassengers(int passengers);

    double fill(double fuel);
}
