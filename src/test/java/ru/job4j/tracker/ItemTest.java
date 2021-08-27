package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void comparable() {
        List<String> actual = Arrays.asList("a", "c", "b");
        Collections.sort(actual);
        List<String> expected = Arrays.asList("a", "b", "c");

        assertThat(actual, is(expected));
    }
}