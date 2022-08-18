package ru.job4j.tracker;


import org.junit.Test;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemIdComparatorTest {

    @Test
    public void comparable() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(4, "bmv", localDateTime );
        Item item2 = new Item(2, "mazda", localDateTime);
        Item item3 = new Item(6, "mercedes", localDateTime);
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