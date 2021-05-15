package ru.job4j.condition;

import junit.framework.TestCase;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PointTest extends TestCase {

    public void testDistance3d() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 2);
        double dis = a.distance(b);
        assertThat(dis, is(8.0));
    }
}
