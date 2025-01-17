package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Matrix {
    public static List<Integer> matrix(Integer[][] list) {
        return Stream.of(list)
                .flatMap(Stream ::of)
                .collect(Collectors.toList());
    }
}
