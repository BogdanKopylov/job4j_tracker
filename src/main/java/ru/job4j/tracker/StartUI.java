package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберите пункт меню: ");
            if (select == 0) {
                String name = input.askStr("=== Create a new Item ====" + System.lineSeparator() +
                        "Enter name: ");
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
                int id = input.askInt("Введите номер заявки, которую хотите изменить: ");
                String name = input.askStr("Введите имя новой заявки: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Под номером " + item.getId() + " теперь находится заявка " +
                            item.getName() +".");
                } else {
                    System.out.println("Заявка не изменена!");
                }
                } else if (select == 3) {
                    int id = input.askInt("Введите номер заявки, которую хотите удалить: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка под номером " + id + " удалена.");
                } else {
                    System.out.println("Заявка не удалена!");
                }
                } else if (select == 4) {
                    int id = input.askInt("Введите номер заявки, которую хотите найти: ");
                    Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item.toString());
                } else {
                    System.out.println("Заявка с таким id не найдена.");
                }
                } else if (select == 5) {
                String name = input.askStr("Введите имя заявки, которую хотите найти: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item.toString());
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены.");
                }
                } else if (select == 6) {
                    System.out.println("Программа завершена.");
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
                "6. Exit Program");

    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
