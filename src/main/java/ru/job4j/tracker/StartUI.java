package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.parseInt((scanner.nextLine()));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Заявка " + item.getName() + " добавлена. " +
                        "Номер Вашей заявки - " + item.getId() + ".");
            } else if (select == 1) {

                Item[] items = tracker.findAll();
                for (Item item : items) {
                    System.out.println(item.toString());
                }
                } else if (select == 2) {
                System.out.print("Введите номер заявки, которую хотите изменить: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите имя новой заявки: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Под номером " + item.getId() + " теперь находится заявка " +
                            item.getName() +".");
                } else {
                    System.out.println("Заявка не изменена!");
                }
                } else if (select == 3) {
                    System.out.print("Введите номер заявки, которую хотите удалить: ");
                    int id = Integer.parseInt(scanner.nextLine());
                if (tracker.delete(id)) {
                    System.out.println("Заявка под номером " + id + " удалена.");
                } else {
                    System.out.println("Заявка не удалена!");
                }
                } else if (select == 4) {
                    System.out.print("Введите номер заявки, которую хотите найти: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
                } else if (select == 5) {
                System.out.print("Введите имя заявки, которую хотите найти: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item.toString());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены.");
                }
                } else if (select == 6) {
                    run = false;
                } else {
                System.out.println("Такого пункта меню не существует.");
            }
            }
        }

    private void showMenu() {
        System.out.println("Menu." + System.lineSeparator() +
                "0. Add new Item" + System.lineSeparator() +
                "1. Show all items" + System.lineSeparator() +
                "2. Edit item" + System.lineSeparator() +
                "3. Delete item" + System.lineSeparator() +
                "4. Find item by Id" + System.lineSeparator() +
                "5. Find items by name" + System.lineSeparator() +
                "6. Exit Program" + System.lineSeparator() +
                "Select:");

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
