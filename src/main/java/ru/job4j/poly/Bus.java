package ru.job4j.poly;
public class Bus implements Transport {

    @Override
    public void go() {
        System.out.println("Движется");
    }

    @Override
    public void passengers(int passengers) {
        System.out.println("Колличество пассажиров: " + passengers);
    }

    @Override
    public Double refuel(double refuel) {
        return refuel;
    }
}