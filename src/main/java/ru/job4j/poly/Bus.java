package ru.job4j.poly;
public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - Двигается по дороге");
    }
}