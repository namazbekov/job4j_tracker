package ru.job4j.poly;
public class Bus implements Transport {

    @Override
    public String go() {
        System.out.println("Машина едет");
        return null;
    }

    @Override
    public int passengers() {
        return 0;
    }


    @Override
    public Double refuel(double refuel) {
        return refuel * 49;
    }
}