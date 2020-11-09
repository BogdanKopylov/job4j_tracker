package ru.job4j.io;

public class Matches {
    public static void main(String[] args) {
        Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        System.out.println("Игра вот-вот начнется.");
        player1.greeting();
        player2.greeting();
        System.out.println(player1.getName() + " и " + player2.getName() + "! Смысл игры в следующем. " +
                "На столе лежат 11 спичек. Каждый из вас по очереди берет от 1 до 3 спичек. " +
                "Выигрывает тот, кто забрал последние спички." + System.lineSeparator() + "Поехали!");
        int matches = 11;
        while (matches > 0) {
            int input = player1.takeMatches();
            boolean check = player1.from1to3(input, matches);
            if (check) {
                matches = player1.overOrNot(input, matches);
            }
            if (matches == 0) break;
            input = player2.takeMatches();
            check = player2.from1to3(input, matches);
            if (check) {
                matches = player2.overOrNot(input, matches);
            }
        }
    }
}
