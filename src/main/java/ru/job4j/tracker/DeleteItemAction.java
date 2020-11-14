package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;

    public DeleteItemAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Введите номер заявки, которую хотите удалить: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка под номером " + id + " удалена.");
        } else {
            System.out.println("Заявка не удалена!");
        }
        return true;
    }
}
