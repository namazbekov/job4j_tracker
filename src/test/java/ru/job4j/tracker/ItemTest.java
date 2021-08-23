package ru.job4j.tracker;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {

    @Test
    public void Comparable() {
        List<Integer> list = Arrays.asList();

        Integer item = Integer.valueOf("A",1);
        Integer item1 = Integer.valueOf("B",2);
        Integer item2 = Integer.valueOf("C",3);
        list.sort(Collections.reverseOrder());
        list.add(item);
        list.add(item1);
        list.add(item2);
        List<Integer> expected = Arrays.asList(5,4,3,2,1);
        assertThat(list, is(expected));


    }
}