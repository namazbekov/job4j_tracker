package ru.job4j.filter;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class Filter {
    public static void main(String[] args) {
        ArrayList<Integer> number = new ArrayList<>();
        number.add(1);
        number.add(2);
        number.add(8);
        number.add(-1);
        ArrayList<Integer> find = (ArrayList<Integer>) number.stream().filter(integer
                -> integer > 0).collect(Collectors.toList());
        for (Integer fin : find) {
            System.out.println(fin);
        }

    }
}
