package ru.job4j.oop;

public class Battery {
    private int load;

    Battery(int loadK) {
        this.load = loadK;
    }

    public void exchange(Battery another) {
        another.load += this.load;
        this.load = 0;
    }

    public static void main(String[] args) {
        Battery battery1 = new Battery(4);
        Battery battery2 = new Battery(5);
        battery1.exchange(battery2);
        System.out.println(battery1.load);
        System.out.println(battery2.load);
    }
}
