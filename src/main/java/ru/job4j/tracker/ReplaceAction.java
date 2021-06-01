package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    @Override
    public String name() {
        return "Замена заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("Змена заявки");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Успешно изменено");
        } else {
            System.out.println("Нет параметра, введите занова:");
        }
        return true;
    }
}
