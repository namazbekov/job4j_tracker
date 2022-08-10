package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Замена заявки";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("Замена заявки");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            out.println("Успешно изменено");
        } else {
            out.println("Нет параметра, введите занова:");
        }
        return true;
    }
}
