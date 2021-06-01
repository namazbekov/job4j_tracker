package ru.job4j.tracker;

public class SearchByNameAction implements UserAction {

    @Override
    public String name() {
        return "Поиск по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Поиск по имени");
        String name = input.askStr("Введите имя: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}
