package ru.job4j.tracker;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Введите имя новой заявки: ");
        Item item = new Item(name);
        tracker.add(item);
        out.println("Заявка " + item.getName() + " добавлена. " +
                "Номер Вашей заявки - " + item.getId() + ".");
        return true;
    }
}
