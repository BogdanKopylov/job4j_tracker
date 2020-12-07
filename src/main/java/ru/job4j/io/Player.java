package ru.job4j.io;

import java.util.Scanner;

public class Player {
    private String name;

    private String[] matchNames = {"спичек",
            "спичка", "спички", "спички",
            "спички", "спичек", "спичек",
            "спичек", "спичек", "спичек",
            "спичек", "спичек"};

    private String[] matchNamesDav = {"спичек",
            "спичку", "спички", "спички",
            "спички", "спичек", "спичек",
            "спичек", "спичек", "спичек",
            "спичек", "спичек"};

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void greeting() {
        System.out.println("Введите, пожалуйста, имя для игрока: " + this.name);
        Scanner input = new Scanner(System.in);
        this.name = input.nextLine();
        System.out.println(this.name + ", приветствуем Вас в игре!");
    }

    public int takeMatches() {
        System.out.println(this.name + ", выберите количество спичек от 1 до 3.");
        Scanner input = new Scanner(System.in);
        int matches = Integer.valueOf(input.nextLine());
        System.out.println(this.name + " хочет взять такое количество спичек: " + matches);
        return matches;
    }

    public boolean from1to3(int input, int matches) {
        boolean check = true;
        if (input < 1 || input > 3) {
            check = false;
            System.out.println(this.name + ", сожалению, вы ввели недопустимое количество. "
                    + "Ход передается следующему игроку.");
            System.out.println("На столе осталось " + matches + " " + matchNames[matches]);
        }
        return check;
    }

    public int overOrNot(int input, int matches) {
        if (input > matches && matches > 0) {
            System.out.println("К сожалению, спичек на столе не хватает. "
                    + this.name + " забирает " + " "
                    + matches + " " + matchNamesDav[matches] + " и побеждает");
            matches = 0;
            System.out.println("На столе осталось " + matches + " " + matchNames[matches]);
        } else if (input == matches) {
            System.out.println(this.name + " забирает "
                    + input + " " + matchNamesDav[input] + " и побеждает");
            matches = 0;
            System.out.println("На столе осталось " + matches + " " + matchNames[matches]);
        } else {
            System.out.println(this.name + " забирает "
                    + input + " " + matchNamesDav[input]);
            matches -= input;
            System.out.println("На столе осталось " + matches + " " + matchNames[matches]);
        }
        return matches;
    }
}
