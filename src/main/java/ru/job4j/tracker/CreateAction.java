package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "Создать новую заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Создать новую заявку");
        String name = input.askStr("Введите имя : ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Создано :" + item);
        return true;
    }
}
