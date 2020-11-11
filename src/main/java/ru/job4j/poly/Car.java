package ru.job4j.poly;

public class Car implements Vehicle {
    @Override
    public void move() {
        System.out.println("Еду по дороге");
    }
}
