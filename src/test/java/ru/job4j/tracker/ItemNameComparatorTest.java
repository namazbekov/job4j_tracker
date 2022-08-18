package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.FullSearch;
import ru.job4j.collection.Task;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemNameComparatorTest {
    @Test
    public void toNameTest() {
        long millis = System.currentTimeMillis();
        Timestamp timestamp = new Timestamp(millis);
        LocalDateTime localDateTime = timestamp.toLocalDateTime();
        List<Item> list = new ArrayList<>();
        Item item1 = new Item(4, "bmv", localDateTime);
        Item item2 = new Item(2, "mazda", localDateTime);
        Item item3 = new Item(6, "mercedes", localDateTime);
        list.add(item1);
        list.add(item2);
        list.add(item3);
        Collections.sort(list, new ItemNameComparator());
        List<Item> expected = new ArrayList<>();
        expected.add(item3);
        expected.add(item2);
        expected.add(item1);
        assertThat(list, is(expected));
    }
}