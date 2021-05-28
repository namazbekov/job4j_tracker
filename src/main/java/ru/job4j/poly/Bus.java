package ru.job4j.poly;
public class Bus implements Transport {

    @Override
    public String go() {
        System.out.println("Машина едет");
        return null;
    }

    @Override
    public String passengers(int passengers) {
        System.out.println("Колличество человек " + passengers );
        return null;
    }

    @Override
    public Double refuel(double refuel) {
        return refuel * 49;
    }
}