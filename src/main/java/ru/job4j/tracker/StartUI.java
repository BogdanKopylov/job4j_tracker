package ru.job4j.tracker;

import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class StartUI {
    public static void main(String[] args) {
        Item time = new Item(1444, "Mmmmm");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        System.out.println(time.getCreated().format(formatter));
        System.out.println(time);

        Item time1 = new Item(45452, "Nnnnnn");
        Tracker tracker = new Tracker();
        tracker.add(time);
        tracker.add(time1);
        System.out.println(tracker.findById(2));
        System.out.println(Arrays.toString(tracker.findAll()));
        System.out.println(Arrays.toString(tracker.findByName("Mmmmm")));
    }
}
