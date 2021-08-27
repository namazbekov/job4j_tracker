package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

    public class PointTest {
        @Test
        public void wen000to002Then2() {
            Point a = new Point(0, 0, 0);
            Point b = new Point(0, 0, 2);
            double rsl = a.distance3d(b);
            assertThat(rsl, is(2.0));
        }

        @Test
        public void wen022to220Then28() {
            Point a = new Point(0, 0, 0);
            Point b = new Point(0, 0, 1);
            double rsl = a.distance3d(b);
            assertThat(rsl, is(1.0));
        }
    }
