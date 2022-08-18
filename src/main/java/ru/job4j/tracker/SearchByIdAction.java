package ru.job4j.tracker;

public class SearchByIdAction implements UserAction {
    private final Output out;

    public SearchByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Поиск по id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println(" Поиск по id");
        int id = input.askInt("Введите id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
