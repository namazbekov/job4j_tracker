package ru.job4j.condition;

import static org.hamcrest.core.Is.is;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest  {

    @Test
    public void Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        assertThat(dist, is(2.0));
    }
    @Test
    public void Then() {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        Point c = new Point(0, 2);
        double dis = a.distance(b, c);
        assertThat(dis, is(8.0));
    }
}