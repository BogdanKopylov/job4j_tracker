package ru.job4j.stream;

public class Car {
    private String make;
    private String model;
    private int year;
    private double engineVolume;
    private double maxSpeed;
    private String color;

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", engineVolume=" + engineVolume +
                ", maxSpeed=" + maxSpeed +
                ", color='" + color + '\'' +
                '}';
    }

    static class Builder {
        private String make;
        private String model;
        private int year;
        private double engineVolume;
        private double maxSpeed;
        private String color;

        Builder buildMake(String make) {
            this.make = make;
            return this;
        }

        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildYear(int year) {
            this.year = year;
            return this;
        }

        Builder buildEngineVolume(double engineVolume) {
            this.engineVolume = engineVolume;
            return this;
        }

        Builder buildMaxSpeed(double maxSpeed) {
            this.maxSpeed = maxSpeed;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Car build() {
            Car car = new Car();
            car.make = make;
            car.model = model;
            car.year = year;
            car.engineVolume = engineVolume;
            car.maxSpeed = maxSpeed;
            car.color = color;
            return car;
        }
    }

    public static void main(String[] args) {
        Car car = new Builder()
                .buildMake("Kia")
                .buildModel("Rio")
                .buildYear(2020)
                .buildEngineVolume(1.6)
                .buildMaxSpeed(210)
                .buildColor("black")
                .build();
        System.out.println(car);
    }
}
