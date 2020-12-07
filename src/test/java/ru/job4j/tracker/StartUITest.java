package ru.job4j.tracker;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("0");
        strings.add("Item name");
        strings.add("1");
        Input in = new StubInput(strings);
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(output));
                actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                Arrays.asList("0", "1", "New item name", "1"));
        List<UserAction> actions = new ArrayList<>();
            actions.add(new ReplaceItemAction(output));
            actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(Arrays.asList("0", "1", "1"));
        List<UserAction> actions = new ArrayList<>();
                actions.add(new DeleteItemAction(output));
                actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item(1));
        Item item2 = tracker.add(new Item(2));
        Input in = new StubInput(Arrays.asList("0", "1"));
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ShowAllItemsAction(output));
                actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu." + ln + "0. === Show all items ====" + ln
                + "1. === Exit Program ====" + ln + item1.toString() + ln
                + item2.toString() + ln + "Menu." + ln
                + "0. === Show all items ====" + ln + "1. === Exit Program ===="
                + ln + "Программа завершена." + ln));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("My Item"));
        Input in = new StubInput(Arrays.asList("0", "My Item", "1"));
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindItemByNameAction(output));
                actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu." + ln + "0. === Find items by name ===="
                + ln + "1. === Exit Program ====" + ln + item.toString() + ln
                + "Menu." + ln + "0. === Find items by name ===="
                + ln + "1. === Exit Program ====" + ln + "Программа завершена." + ln));
    }

    @Test
    public void whenFindByIDAction() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("My Item"));
        Input in = new StubInput(Arrays.asList("0", "1", "1"));
        List<UserAction> actions = new ArrayList<>();
                actions.add(new FindItemByNameAction(output));
                actions.add(new ExitProgramAction(output));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is("Menu." + ln
                + "0. === Find items by name ====" + ln
                + "1. === Exit Program ====" + ln
                + "Заявки с таким именем не найдены." + ln
                + "Menu." + ln
                + "0. === Find items by name ====" + ln
                + "1. === Exit Program ====" + ln
                + "Программа завершена." + ln));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new ValidateInput(out, new StubInput(Arrays.asList("8", "0")));
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new ExitProgramAction(out));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. === Exit Program ====" + ln
                        + "Wrong input, you can select: 0 .. " + (actions.size() - 1) + ln
                        + "Menu." + ln
                        + "0. === Exit Program ====" + ln
                        + "Программа завершена." + ln
        ));
    }

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(Arrays.asList("one", "1"));
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }
}