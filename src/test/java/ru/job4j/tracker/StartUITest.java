package ru.job4j.tracker;

import org.junit.Test;
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
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator() +
                        "0. Выход" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item item = new Item("GGGG");
        tracker.add(item);
        UserAction[] actions = {
                new ShowAllItemsAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator() + "0. Посмотреть все заявки" +
                System.lineSeparator() + "1. Выход" + System.lineSeparator()
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
        Tracker tracker = new Tracker();
        Item item = new Item("Big");
        tracker.add(item);
        UserAction[] actions = {
                new SearchByNameAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator() + "0. Поиск по имени" + System.lineSeparator()
                + "1. Выход" + System.lineSeparator() + "Поиск по имени"
                + System.lineSeparator() + item + System.lineSeparator() + "Menu:" + System.lineSeparator()
                + "0. Поиск по имени" + System.lineSeparator() + "1. Выход" + System.lineSeparator()
        ));
    }
    @Test
    public void whenFindByIdAction() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = new Item("Frog");
        tracker.add(item);
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new SearchByIdAction(out), new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu:" + System.lineSeparator() + "0. Поиск по id" + System.lineSeparator()
                + "1. Выход" + System.lineSeparator() + " Поиск по id"
                + System.lineSeparator() + item + System.lineSeparator() + "Menu:" + System.lineSeparator()
                + "0. Поиск по id" + System.lineSeparator() + "1. Выход" + System.lineSeparator()
        ));
    }
}