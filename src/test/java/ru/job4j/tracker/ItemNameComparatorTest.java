package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.collection.FullSearch;
import ru.job4j.collection.Task;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemNameComparatorTest{
    @Test
    public void toNameTest() {
        List<Item> items = new ArrayList<>();
        Item item1 = new Item(1,"own");
        Item item2 = new Item(4,"two");
        Item item3 = new Item(2,"three");
        Item item4 = new Item(3,"thor");
        items.add(item4);
        items.add(item1);
        items.add(item2);
        items.add(item3);
        Collections.sort(items);
        List<Item> right = new ArrayList<>();
        Item it1 = new Item(1,"own");
        Item it2 = new Item(3,"thor");
        Item it3 = new Item(2,"three");
        Item it4 = new Item(4,"two");
        right.add(it1);
        right.add(it2);
        right.add(it3);
        right.add(it4);
        assertThat(items, is(right));
    }
}