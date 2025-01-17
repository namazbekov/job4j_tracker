package ru.job4j.tracker;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {

    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[]{"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, Arrays.asList(actions));
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Выход" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        MemTracker tracker = new MemTracker();
        Item item = new Item("GGGG");
        tracker.add(item);
        UserAction[] actions = {
                new ShowAllItemsAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu:" + System.lineSeparator() + "0. Посмотреть все заявки"
                + System.lineSeparator() + "1. Выход" + System.lineSeparator()
                + "Посмотреть все заявки" + System.lineSeparator() + item + System.lineSeparator()
                + "Menu:" + System.lineSeparator() + "0. Посмотреть все заявки"
                + System.lineSeparator() + "1. Выход" + System.lineSeparator()
        ));

    }

    @Test
    public void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Big", "1"}
        );
        MemTracker tracker = new MemTracker();
        Item item = new Item("Big");
        tracker.add(item);
        UserAction[] actions = {new SearchByNameAction(out), new ExitAction()};
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu:" + System.lineSeparator() + "0. Поиск по имени"
                + System.lineSeparator() + "1. Выход" + System.lineSeparator() + "Поиск по имени"
                + System.lineSeparator() + item + System.lineSeparator() + "Menu:"
                + System.lineSeparator()
                + "0. Поиск по имени" + System.lineSeparator() + "1. Выход" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("Frog");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new SearchByIdAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        assertThat(out.toString(), is("Menu:" + System.lineSeparator()
                + "0. Поиск по id" + System.lineSeparator()
                + "1. Выход" + System.lineSeparator() + " Поиск по id"
                + System.lineSeparator() + item + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Поиск по id" + System.lineSeparator() + "1. Выход"
                + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"6", "0"}
        );
        MemTracker tracker = new MemTracker();
        UserAction[] actions = new UserAction[]{
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, Arrays.asList(actions));
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu:" + ln
                        + "0. Выход" + ln
                        + "Wrong input, you can select: 0 .. 0" + ln
                        + "Menu:" + ln
                        + "0. Выход" + ln
                )
        );
    }
}