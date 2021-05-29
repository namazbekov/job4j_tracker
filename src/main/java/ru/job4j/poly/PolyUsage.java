package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Plane plan = new Plane();
        Vehicle pla = plan;
        Bus bus = new Bus();
        Vehicle bu = bus;
        Train train = new Train();
        Vehicle tra = train;
        Vehicle[] vehicle = new Vehicle[]{plan, bus , train} ;
        for (Vehicle v : vehicle) {
            v.move();
        }
    }
}
