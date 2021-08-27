package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.message = message;
        this.status = status;
        this.active = active;
    }

    public static void main(String[] args) {
        Error first = new Error(true, 1, "Где ты был?");
        first.printInfo();
        Error second = new Error();
        second.printInfo();
    }

    public void printInfo() {
        System.out.println("Активность : " + active);
        System.out.println("Сколько минут был онлайн : " + status + " минут");
        System.out.println("Сообщения : " + message);

    }
}
