package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {

    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        for (Task lis : list) {
            numbers.add(lis.getNumber());
            for (String num : numbers){
                System.out.println(num);
            }
        }
        return numbers;
    }
}