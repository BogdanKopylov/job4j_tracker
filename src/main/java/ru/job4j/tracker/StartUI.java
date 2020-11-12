package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя новой заявки: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Заявка " + item.getName() + " добавлена. " +
                "Номер Вашей заявки - " + item.getId() + ".");
    }

    public static void showAllItems(Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item item : items) {
            System.out.println(item.toString());
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки, которую хотите изменить: ");
        String name = input.askStr("Введите имя новой заявки: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Под номером " + item.getId() + " теперь находится заявка " +
                    item.getName() + ".");
        } else {
            System.out.println("Заявка не изменена!");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки, которую хотите удалить: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка под номером " + id + " удалена.");
        } else {
            System.out.println("Заявка не удалена!");
        }
    }

    public static void findItemByID(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки, которую хотите найти: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item.toString());
        } else {
            System.out.println("Заявка с таким id не найдена.");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя заявки, которую хотите найти: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item.toString());
            }
        } else {
            System.out.println("Заявки с таким именем не найдены.");
        }
    }

    public static boolean exitProgram() {
        System.out.println("Программа завершена.");
        return false;
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберите пункт меню: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(tracker);
            } else if (select == 2) {
                 StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemByID(input, tracker);
            } else if (select == 5) {
                StartUI.findItemByName(input, tracker);
            } else if (select == 6) {
                run = StartUI.exitProgram();
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
