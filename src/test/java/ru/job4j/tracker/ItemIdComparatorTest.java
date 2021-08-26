package ru.job4j.tracker;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemIdComparatorTest {

    @Test
    public void Comparable() {
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(4, "bmv");
        Item item2 = new Item(2,"mazda");
        Item item3 = new Item(6,"mercedes");
        list.add(item3);
        list.add(item2);
        list.add(item1);
        Collections.sort(list, new ItemIdComparator());
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        assertThat(list, is(expected));


    }
}