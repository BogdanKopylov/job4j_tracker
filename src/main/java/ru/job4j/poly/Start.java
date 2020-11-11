package ru.job4j.poly;

public class Start {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle train = new Train();
        Vehicle airplane = new Airplane();

        Vehicle[] vehicles = new Vehicle[]{car, train, airplane};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
        }
    }
}
