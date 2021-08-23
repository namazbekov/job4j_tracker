package ru.job4j.tracker;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemIdComparatorTest {

    @Test
    public void Comparable() {
        List<Integer> list = Arrays.asList(5, 3, 4, 1, 2);
        list.sort(Collections.reverseOrder());
        List<Integer> expected = Arrays.asList(5,4,3,2,1);
        assertThat(list, is(expected));


    }
}