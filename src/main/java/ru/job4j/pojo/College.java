package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student01 = new Student();
        student01.setFio("Копылов Богдан");
        student01.setGroup("\"Стажер\"");
        student01.setEntered(new Date());

        System.out.println("Студент " + student01.getFio() +
                " поступил в группу " + student01.getGroup() + " " +
                student01.getEntered());
    }
}
