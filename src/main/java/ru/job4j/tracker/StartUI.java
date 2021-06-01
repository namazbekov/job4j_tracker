package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("Создать новую заявку");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Создано :" + item);
    }
    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("Змена заявки");
        int id = input.askInt("Введите id: ");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Успешно изменено");
        } else {
            System.out.println("Нет параметра, введите занова:");
        }
    }
    public static void deleteItem (Input input, Tracker tracker) {
        System.out.println("Удалить заявку");
        int id = input.askInt("Введите id: ");
        if (tracker.delete(id)) {
            System.out.println("Заявка удалена");
        } else {
            System.out.println("Заявка не найдена");
        }
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Выберете: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }
    private void showMenu(UserAction[] actions) {
        System.out.println("Menu:");
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i + ". " + actions[i].name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(), new ShowAllItemsAction(), new ReplaceAction(), new DeleteAction(),
                new SearchByIdAction(), new SearchByNameAction(), new OutPutAction()
        };
        new StartUI().init(input, tracker, actions);
    }
}