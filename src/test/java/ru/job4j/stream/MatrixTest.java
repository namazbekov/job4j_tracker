package ru.job4j.stream;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import java.util.List;

public class MatrixTest {

    @Test
    public void thanTrue() {
        Integer[][] matrix = {
                {1, 2},
                {3, 4},
        };
        List<Integer> rsl = Matrix.matrix(matrix);
        List<Integer> expected = List.of(1, 2, 3, 4);
        assertThat(rsl, is(expected));
    }
}