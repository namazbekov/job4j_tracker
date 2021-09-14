package ru.job4j.lambda;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = Diapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunction() {
        List<Double> result = Diapason.diapason(1, 3, x -> 2 * x * x + 1);
        List<Double> expected = Arrays.asList(3D, 9D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenExponentialFunction() {
        List<Double> result = Diapason.diapason(1, 3, x -> Math.pow(x, x) + 1);
        List<Double> expected = Arrays.asList(2D, 5D);
        assertThat(result, is(expected));
    }

}