package ru.job4j;

public class Calculator {
    public static double add(double first, double second) {
        return first > second ? first : second;
    }

    public double add(double first, double second, double third) {
        double result = first;
        if (second >= first && second >= third) {
            result = second;
        }
        if (third >= first && third >= second ) {
            result = third;
        }
    }
    public double add(double first, double second, double third, double fourth) {
        return add(first, add(second, third);
    }
}
