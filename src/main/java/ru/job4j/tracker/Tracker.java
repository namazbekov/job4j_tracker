package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>(100);
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        return item;
    }
    public Item[] findAll() {
        List<Item> result = new ArrayList<>();
        for (Item item : items) {
            result.add(item);
            System.out.println(result);
        }
        return null;
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (Item name : items) {
            name.getName().contains(key);
                rsl[count++] = name;
        }
        return Arrays.copyOf(rsl, count);
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int searchId = indexOf(id);
        if(searchId == -1) {
            return false;
        }
            item.setId(id);
            items.set(searchId, item);
            return true;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            int start = index + 1;
            int length = size - index -1;
            System.arraycopy(items, start, items, index, length);
            items.set(size - 1, null);
            size--;
        }
        return rsl;
    }
}