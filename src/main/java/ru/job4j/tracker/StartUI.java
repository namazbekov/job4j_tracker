package ru.job4j.tracker;

public class StartUI {


    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Выберете: ");
            if (select == 0) {
                System.out.println("=== Создать новую заявку ====");
                String name = input.askStr("Введите имя: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);

            } else if (select == 1) {
                System.out.println("=== Посмотреть все заявки ====");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("Змена заявки");
                int id = input.askInt("Введите id: ");
                String name = input.askStr("Введите имя: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Успешно изменено");
                } else {
                    System.out.println("Нет параметра, введите занова:");
                }
            } else if (select == 3) {
                System.out.println("Удалить заявку");
                int id = input.askInt("Введите id: ");
                if (tracker.delete(id)) {
                    System.out.println("Заявка удалена");
                } else {
                    System.out.println("Заявка не найдена");
                }
            } else if (select == 4) {
                System.out.println(" Поиск по id");
                int id = input.askInt("Введите id: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
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

            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Создать новую заявку", "Посмотреть все заявки", "Редактировать заявку",
                "Удалить заявку", "Найти заявку по Id", "Найти заявки по имени",
                "Выход"
        };
        System.out.println("Menu:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}