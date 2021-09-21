package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapToList {
    public static Map<String, Integer> convert(List<Student> students) {
        Map<String, Integer> result = students
                .stream()
                .distinct()
                .collect(Collectors.toMap(Student::getSurname, Student::getScore));
        return result;
    }
}
