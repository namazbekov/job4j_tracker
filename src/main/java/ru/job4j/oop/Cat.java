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
    public void setName(String nickname) {
        this.name = nickname;
    }

    public static void main(String[] args) {
        System.out.println("There are gav's food.");
        Cat gav = new Cat();
        gav.setName("Gavrila");
        gav.eat("kotleta -");
        gav.show();
        System.out.println("There are black's food.");
        Cat black = new Cat();
        black.setName("Murka");
        black.eat("fish -");
        black.show();
    }
    public void giveNick(String nick){

    }

}
