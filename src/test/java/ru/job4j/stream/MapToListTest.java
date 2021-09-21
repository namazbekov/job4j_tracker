package ru.job4j.stream;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MapToListTest {

    @Test
    public void thanToDubl() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(10, "Surname1"),
                new Student(40, "Surname4"),
                new Student(50, "Surname5"),
                new Student(50, "Surname5"),
                new Student(70, "Surname7"),
                new Student(90, "Surname9")
        );
        Map<String, Integer> rsl = MapToList.convert(students);
        Map<String, Integer> expected = new HashMap<String, Integer>();
                expected.put("Surname1", 10);
                expected.put("Surname4", 40);
                expected.put("Surname5", 50);
                expected.put("Surname7", 70);
                expected.put("Surname9", 90);
        assertThat(rsl, is(expected));
    }

}