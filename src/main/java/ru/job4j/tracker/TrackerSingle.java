package ru.job4j.tracker;

public class TrackerSingle {
    private static TrackerSingle instance;

    private TrackerSingle() {
    }

    public static TrackerSingle getInstance() {
        if (instance == null) {
            instance = new TrackerSingle();
        }
        return instance;
    }

    public Item add(Item model) {
        return model;
    }
}
