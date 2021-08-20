package ru.job4j.tracker;

import java.util.List;

public class SearchByNameAction implements UserAction {
    private final Output out;

    public SearchByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Поиск по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Поиск по имени");
        String name = input.askStr("Введите имя: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
