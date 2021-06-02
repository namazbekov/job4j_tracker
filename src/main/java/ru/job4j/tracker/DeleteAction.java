package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    private final Output out;
    public DeleteAction(Output out) {
        this.out = out;
    }


    @Override
    public String name() {
        return "Удалить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("Удалить заявку");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            out.println("Заявка удалена");
        } else {
            out.println("Заявка не найдена");
        }
        return true;
    }
}
