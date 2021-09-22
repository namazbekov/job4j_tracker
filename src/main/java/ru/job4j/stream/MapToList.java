package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
    public static Map<String, Integer> convert(List<Student> students) {
        Map<String, Integer> result = students
                .stream()
                .collect(Collectors
                        .toMap(Student::getSurname, Student::getScore,
                                (first, last) -> first != null ? first : last)
                );
        return result;
    }
}
