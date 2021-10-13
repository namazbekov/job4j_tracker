package ru.job4j.stream;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {

    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(str -> str.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(str -> new Tuple(str.getName(), str.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0)))
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(str -> str.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject :: getName, LinkedHashMap::new
                        , Collectors.averagingDouble(Subject :: getScore)))
                .entrySet()
                .stream()
                .map(str -> new Tuple(str.getKey(), str.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(str -> new Tuple(str.getName(), str.getSubjects()
                .stream()
                .mapToInt(Subject::getScore).sum())).max(Tuple::compareTo).orElse(new Tuple(" ", 0))
                ;
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(str -> str.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject :: getName
                        , Collectors.summingDouble(Subject :: getScore)))
                .entrySet()
                .stream()
                .map(str -> new Tuple(str.getKey(), str.getValue()))
                .max(Tuple::compareTo)
                .orElse(new Tuple(" ", 0));
    }
}