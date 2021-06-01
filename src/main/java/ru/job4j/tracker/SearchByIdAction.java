package ru.job4j.tracker;

public class SearchByIdAction implements UserAction {
    @Override
    public String name() {
        return "Поиск по Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println(" Поиск по id");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
