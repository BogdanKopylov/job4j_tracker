package ru.job4j.tracker;

public class ReplaceItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки, которую хотите изменить: ");
        String name = input.askStr("Введите имя новой заявки: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Под номером " + item.getId() + " теперь находится заявка " +
                    item.getName() + ".");
        } else {
            System.out.println("Заявка не изменена!");
        }
        return true;
    }
}
