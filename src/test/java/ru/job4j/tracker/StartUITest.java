package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new ConsoleOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1", "New item name", "1"}
        );
        UserAction[] actions = {
                new ReplaceItemAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new DeleteItemAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllAction() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item(1));
        Item item2 = tracker.add(new Item(2));
        Item[] items = {item1, item2};
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        UserAction[] actions = {
                new ShowAllItemsAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll(), is(items));
    }

    @Test
    public void whenFindByNameAction() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("My Item"));
        Item[] items = {item};
        Input in = new StubInput(
                new String[] {"0", "My Item", "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findByName("My Item"), is(items));
    }

    @Test
    public void whenFindByIDAction() {
        Output output = new ConsoleOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("My Item"));
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        UserAction[] actions = {
                new FindItemByNameAction(output),
                new ExitProgramAction(output)
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(1), is(item));
    }
}