package ru.job4j.tracker;

import java.util.Comparator;

public class ItemIdComparator implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        Integer id1 = o1.getId();
        Integer id2 = o2.getId();
        return o1.compareTo(o2);
    }
}
