package ru.job4j.oop;

public class Cat {
    private String name;

    private String food;

    public void show() {
        System.out.println(this.food + this.name);
    }

    public void eat(String meat) {
        this.food = meat;
    }

    public void giveNick(String nick) {
        this.name = nick;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.giveNick("Gav");
        gav.eat("kotleta - ");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.giveNick("Murka");
        black.eat("fish - ");
        black.show();
    }
}
